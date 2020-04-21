package com.huaxing.account.pay.service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huaxing.account.pay.common.ResponseStatus;
import com.huaxing.account.pay.entity.ComPayRecord;
import com.huaxing.account.pay.entity.Company;
import com.huaxing.account.pay.entity.Contract;
import com.huaxing.account.pay.entity.dto.ComPayRecordDto;
import com.huaxing.account.pay.mapper.ComPayRecordMapper;
import com.huaxing.account.pay.mapper.CompanyMapper;
import com.huaxing.account.pay.mapper.dto.ComPayRecordMapperDto;
import com.huaxing.account.pay.utils.JsonUtils;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Name: com.huaxing.account.pay.service.ComPayRecord
 * ==================================
 * Author Dell Lisufer
 * Date 2020/4/18 2:18
 * Description: ComPayRecord
 * ==================================
 */
@Service
public class ComPayRecordService {

    @Autowired
    private ComPayRecordMapper comPayRecordMapper;
    @Autowired
    private CompanyMapper companyMapper;

    private ComPayRecordMapperDto mapper = Mappers.getMapper(ComPayRecordMapperDto.class);

    public List<ComPayRecordDto> selAllByCIdOrName(Integer cId, String name, Integer page, Integer limit, PageInfo info){
        List<ComPayRecordDto> lists = new ArrayList<>();
        Company company = null;
        if (cId != null){
            company = companyMapper.selectByPrimaryKey(cId);
        }else {
            company = companyMapper.selectByName(name);
            if (company == null)
                return lists;
            cId = company.getId();
        }
        ComPayRecordDto comPayRecordDto = null;
        List<ComPayRecord> comPayRecords = selAllByCId(cId, page, limit);
        if(comPayRecords instanceof Page){
            info.setTotal(((Page) comPayRecords).getTotal());
        } else {
            info.setTotal(comPayRecords.size());
        }
        for (ComPayRecord comPayRecord : comPayRecords) {
            comPayRecordDto = mapper.comPayRecordAndCompanyToComPayRecordDto(comPayRecord, company);
            lists.add(comPayRecordDto);
        }
        return lists;
    }

    public List<ComPayRecord> selAllByCId(Integer cId, Integer page, Integer limit){
        Example example = new Example(Contract.class);
        example.createCriteria().andEqualTo("cId", cId);
        PageHelper.startPage(page, limit);
        return comPayRecordMapper.selectByExample(example);
    }

    public JSONObject insert(ComPayRecordDto comPayRecordDto){
        String name = comPayRecordDto.getName();
        if (name == null) {
            return JsonUtils.common(ResponseStatus.notOk, "单位名称不能为空！");
        }
        Company company = companyMapper.selectByName(name);
        if (company == null) {
            return JsonUtils.common(ResponseStatus.notOk, "这家单位不存在！");
        }
        ComPayRecord comPayRecord = mapper.comPayRecordDtoAndCompanyToComPayRecord(comPayRecordDto, company);
        int insert = 0;
        try {
            insert = comPayRecordMapper.insert(comPayRecord);
        } catch (Exception e) {
            return JsonUtils.common(ResponseStatus.notOk, e.getMessage());
        }
        if (insert == 0){
            return JsonUtils.common(ResponseStatus.notOk, "插入失败！");
        }
        return JsonUtils.common(ResponseStatus.ok, "插入成功！");
    }

}
