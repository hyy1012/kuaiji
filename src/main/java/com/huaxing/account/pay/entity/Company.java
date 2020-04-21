package com.huaxing.account.pay.entity;

import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
public class Company {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 英文简写
     */
    @Column(name = "e_name")
    private String eName;

    /**
     * 中文简写
     */
    @Column(name = "c_name")
    private String cName;

    /**
     * 公司全称
     */
    private String name;

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