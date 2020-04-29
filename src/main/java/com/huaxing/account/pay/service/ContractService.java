package com.huaxing.account.pay.service;

import com.alibaba.fastjson.JSONObject;
import com.huaxing.account.pay.common.ResponseStatus;
import com.huaxing.account.pay.entity.Company;
import com.huaxing.account.pay.entity.Contract;
import com.huaxing.account.pay.entity.dto.ContractDto;
import com.huaxing.account.pay.mapper.CompanyMapper;
import com.huaxing.account.pay.mapper.ContractMapper;
import com.huaxing.account.pay.mapper.dto.ContractMapperDto;
import com.huaxing.account.pay.utils.JsonUtils;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Class Name: com.huaxing.account.pay.service.ContractService
 * ==================================
 * Author Dell Lisufer
 * Date 2020/4/16 18:07
 * Description: ContractService
 * ==================================
 */
@Service
public class ContractService {

    @Autowired
    private ContractMapper contractMapper;
    @Autowired
    private CompanyMapper companyMapper;

    private ContractMapperDto mapper = Mappers.getMapper(ContractMapperDto.class);

    public List<ContractDto> selAllByCIdOrName(Integer cId, String name){
        List<ContractDto> lists = new ArrayList<>();
        Company company = null;
        if (cId != null){
            company = companyMapper.selectByPrimaryKey(cId);
        }else {
            company = companyMapper.selectByName(name);
            if (company == null)
                return lists;
            cId = company.getId();
        }
        ContractMapperDto mapper = Mappers.getMapper(ContractMapperDto.class);
        ContractDto contractDto = null;

        Example example = new Example(Contract.class);
        example.createCriteria().andEqualTo("cId", cId);
        List<Contract> list = contractMapper.selectByExample(example);
        for (Contract contract : list) {
            contractDto = mapper.contractAndCompanyToContractDto(contract, company);
            lists.add(contractDto);
        }
        return lists;
    }

    public JSONObject insert(ContractDto contractDto){
        String name = contractDto.getName();
        if (name == null) {
            return JsonUtils.common(ResponseStatus.notOk, "单位名称不能为空！");
        }
        Company company = companyMapper.selectByName(name);
        if (company == null) {
            return JsonUtils.common(ResponseStatus.notOk, "这家单位不存在！");
        }
        Contract contract = mapper.contractDtoAndCompanyToContract(contractDto, company);
        int insert = 0;
        try {
            if (contract.getQTime() == null)
                contract.setQTime(new Date());
            insert = contractMapper.insert(contract);
        } catch (Exception e) {
            return JsonUtils.common(ResponseStatus.notOk, e.getMessage());
        }
        if (insert == 0){
            return JsonUtils.common(ResponseStatus.notOk, "插入失败！");
        }
        return JsonUtils.common(ResponseStatus.ok, "插入成功！");
    }
    
    public Integer delete(Integer id){
        return contractMapper.deleteByPrimaryKey(id);
    }

    public Integer update(ContractDto contractDto){
        Company company = companyMapper.selectByName(contractDto.getName());
        Contract contract = mapper.contractDtoAndCompanyToContract(contractDto, company);
        return contractMapper.updateByPrimaryKeySelective(contract);
    }
}
