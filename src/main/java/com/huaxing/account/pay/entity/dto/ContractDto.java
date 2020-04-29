package com.huaxing.account.pay.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Class Name: com.huaxing.account.pay.entity.dto.ContractDto
 * ==================================
 * Author Dell Lisufer
 * Date 2020/4/17 23:20
 * Description: ContractDto
 * ==================================
 */
@Data
public class ContractDto {

    private Integer id;

    /**
     * 合同号
     */
    private String no;

    /**
     * 签订时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd" ,timezone = "GMT+8")
    private Date qTime;

    /**
     * 合同名称
     */
    private String cName;

    /**
     * 合同签订方
     */
    private String name;

    /**
     * 合同金额
     */
    private BigDecimal cMoney;

    /**
     * 付款、合同期限
     */
    private String clTime;

    /**
     * 备注
     */
    private String note;
}
