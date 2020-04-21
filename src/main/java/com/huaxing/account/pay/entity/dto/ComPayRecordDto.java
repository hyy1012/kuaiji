package com.huaxing.account.pay.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ComPayRecordDto {
    /**
     * 凭证号
     */
    private String no;

    /**
     * 付款日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd" ,timezone = "GMT+8")
    private Date pTime;

    /**
     * 付款项目
     */
    private String pName;

    /**
     * 受款单位
     */
    private String name;

    /**
     * 付款金额
     */
    private BigDecimal pMoney;

    /**
     * 付款内容
     */
    private String content;

    /**
     * 收据或发票号
     */
    private String rNo;
}