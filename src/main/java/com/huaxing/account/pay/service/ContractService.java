package com.huaxing.account.pay.service;

import com.huaxing.account.pay.entity.Company;
import com.huaxing.account.pay.entity.Contract;
import com.huaxing.account.pay.entity.dto.ContractDto;
import com.huaxing.account.pay.mapper.CompanyMapper;
import com.huaxing.account.pay.mapper.ContractMapper;
import com.huaxing.account.pay.mapper.dto.ContractMapperDto;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
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

}
