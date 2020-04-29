package com.huaxing.account.pay.mapper.dto;

import com.huaxing.account.pay.entity.ComPayRecord;
import com.huaxing.account.pay.entity.Company;
import com.huaxing.account.pay.entity.dto.ComPayRecordDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Class Name: com.huaxing.account.pay.mapper.dto.ComPayRecordMapperDto
 * ==================================
 * Author Dell Lisufer
 * Date 2020/4/18 2:25
 * Description: ComPayRecordMapperDto
 * ==================================
 */
@Mapper
public interface ComPayRecordMapperDto {

    @Mapping(source = "comPayRecord.id", target = "id")
    ComPayRecordDto comPayRecordAndCompanyToComPayRecordDto(ComPayRecord comPayRecord, Company company);

    @Mapping(source = "company.id", target = "CId")
    @Mapping(source = "comPayRecordDto.id", target = "id")
//    @Mapping(target = "id", ignore = true)
    ComPayRecord comPayRecordDtoAndCompanyToComPayRecord(ComPayRecordDto comPayRecordDto, Company company);
}
