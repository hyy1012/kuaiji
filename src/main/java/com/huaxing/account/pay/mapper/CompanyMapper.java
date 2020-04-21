package com.huaxing.account.pay.mapper;

import com.huaxing.account.pay.MyMapper;
import com.huaxing.account.pay.entity.Company;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CompanyMapper extends MyMapper<Company> {

    @Select("select * from company where name = #{name}")
    Company selectByName(String name);

    @Select({"select name from company where name like #{name}"})
    List<String> selectNamesByName(String name);

}