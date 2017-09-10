package com.imloves.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by wujianchuan
 * 2017/8/17 21:26
 */
@Entity
@Data
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
public class SysUser implements Serializable {

    private static final long serialVersionUID = 3491866028426887110L;
    @Id
    @GeneratedValue
    private Long id;
    private String openId;
    private String username;
    private String password;
    private String phone;
    private Integer sex;
    private String city;
    private Integer state;
    @Column(insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createTime;
    @Column(insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Date updateTime;
    @Transient
    private List<String> roles;
}
