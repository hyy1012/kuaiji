package com.huaxing.account.pay.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;
import org.example.base.BaseEntity;

@Table(name = "com_pay_record")
@Data
public class ComPayRecord extends BaseEntity {
    private static final long serialVersionUID = 4618763642682457186L;
    /**
     * 凭证号
     */
    private String no;

    /**
     * 付款日期
     */
    @Column(name = "p_time")
    private Date pTime;

    /**
     * 付款项目
     */
    @Column(name = "p_name")
    private String pName;

    /**
     * 受款单位
     */
    @Column(name = "c_id")
    private Integer cId;

    /**
     * 付款金额
     */
    @Column(name = "p_money")
    private BigDecimal pMoney;

    /**
     * 付款内容
     */
    private String content;

    /**
     * 收据或发票号
     */
    @Column(name = "r_no")
    private String rNo;
}