package com.huaxing.account.pay.mapper;

import com.huaxing.account.pay.MyMapper;
import com.huaxing.account.pay.entity.AcceptanceBill;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AcceptanceBillMapper extends MyMapper<AcceptanceBill> {

    @Select("select * from acceptance_bill where year(rz_time) = #{year}")
    List<AcceptanceBill> selAllByYear(String year);

    @Select("select max(no) from acceptance_bill where year(rz_time) = #{year}")
    Integer selMaxNo(Integer year);

}