package com.imloves.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class SysUserRole implements Serializable {

    private static final long serialVersionUID = -3544132737674768913L;
    @Id
    @GeneratedValue
    private Long id;
    private Long userId;
    private Integer roleId;

    public SysUserRole() {
    }

    public SysUserRole(Long userId, Integer roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
