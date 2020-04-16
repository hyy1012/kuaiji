package com.huaxing.account.pay.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
public class Contract {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 合同号
     */
    private Integer no;

    /**
     * 签订时间
     */
    @Column(name = "q_time")
    private Date qTime;

    /**
     * 合同名称
     */
    @Column(name = "c_name")
    private String cName;

    /**
     * 合同签订方
     */
    @Column(name = "cq_name")
    private String cqName;

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

    /**
     * 创建人
     */
    @Column(name = "CREATED_BY")
    private String createdBy;

    /**
     * 创建时间
     */
    @Column(name = "CREATED_TIME")
    private Date createdTime;

    /**
     * 更新人
     */
    @Column(name = "UPDATED_BY")
    private String updatedBy;

    /**
     * 更新时间
     */
    @Column(name = "UPDATED_TIME")
    private Date updatedTime;
}