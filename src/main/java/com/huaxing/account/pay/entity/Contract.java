package com.huaxing.account.pay.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.example.base.BaseEntity;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class Contract extends BaseEntity {

    /**
     * 合同号
     */
    private String no;

    /**
     * 签订时间
     */
    @Column(name = "q_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd" ,timezone = "GMT+8")
    private Date qTime;

    /**
     * 合同名称
     */
    @Column(name = "c_name")
    private String cName;

    /**
     * 合同签订方
     */
    @Column(name = "c_id")
    private Integer cId;

    /**
     * 合同金额
     */
    @Column(name = "c_money")
    private BigDecimal cMoney;

    /**
     * 付款、合同期限
     */
    @Column(name = "cl_time")
    private String clTime;

    /**
     * 备注
     */
    private String note;


}