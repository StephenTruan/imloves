package com.imloves.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@DynamicUpdate
@DynamicInsert
@Data
@NoArgsConstructor
public class SysUserRole implements Serializable {

    private static final long serialVersionUID = -3544132737674768913L;
    @Id
    @GeneratedValue
    private Long id;
    private Long userId;
    private Integer roleId;

    public SysUserRole(Long userId, Integer roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }
}
