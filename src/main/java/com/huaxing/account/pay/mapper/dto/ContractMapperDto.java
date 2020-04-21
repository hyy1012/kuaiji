package com.huaxing.account.pay.mapper.dto;

import com.huaxing.account.pay.entity.Company;
import com.huaxing.account.pay.entity.Contract;
import com.huaxing.account.pay.entity.dto.ContractDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Class Name: com.huaxing.account.pay.mapper.dto.Contract
 * ==================================
 * Author Dell Lisufer
 * Date 2020/4/17 23:19
 * Description: Contract
 * ==================================
 */
@Mapper
public interface ContractMapperDto {

    @Mapping(source = "contract.CName", target = "CName")
    @Mapping(source = "contract.note", target = "note")
    ContractDto contractAndCompanyToContractDto(Contract contract, Company company);

}
