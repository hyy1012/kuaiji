package com.huaxing.account.pay.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.example.base.BaseEntity;
import org.springframework.format.annotation.DateTimeFormat;

@Table(name = "acceptance_bill")
@Data
public class AcceptanceBill extends BaseEntity {
    /**
     * 编号
     */
    private Integer no;

    /**
     * 入账日期
     */
    @Column(name = "rz_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd" ,timezone = "GMT+8")
    private Date rzTime;

    /**
     * 号码
     */
    private String number;

    /**
     * 金额
     */
    private BigDecimal money;

    /**
     * 是否贴息 1.化纤已贴息
2.未贴息
3.自开
     */
    private Integer tiexi;

    /**
     * 付款单位
     */
    @Column(name = "in_name")
    private String inName;

    /**
     * 到期日期
     */
    @Column(name = "dq_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd" ,timezone = "GMT+8")
    private Date dqTime;

    /**
     * 付出单位
     */
    @Column(name = "out_name")
    private String outName;

    /**
     * 付出日期
     */
    @Column(name = "fc_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd" ,timezone = "GMT+8")
    private Date fcTime;

    /**
     * 承兑类型 1.电子承兑
     */
    @Column(name = "cd_type")
    private Integer cdType;

    /**
     * 承兑银行
     */
    @Column(name = "cd_bank")
    private String cdBank;

    /**
     * 备注
     */
    private String note;

    /**
     * 所在银行
     */
    @Column(name = "sz_bank")
    private String szBank;
}