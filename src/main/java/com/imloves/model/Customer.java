package com.imloves.model;

import jdk.nashorn.internal.ir.annotations.Ignore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by wujianchuan
 * 2017/8/17 21:26
 */
@Entity
public class Customer implements Serializable {

    private static final long serialVersionUID = 3491866028426887110L;
    @Id
    @GeneratedValue
    private Long customerId;
    private String openId;
    private String nickName;
    private String password;
    private String phone;
    private Integer sex;
    private String city;
    private Integer state;
    private String createTime;
    private String updateTime;
    @Transient
    private List<Role> roles;

    public Customer() {
    }

    public Customer(String nickName, String password, String openId, Integer sex, String city, Integer state) {
        this.nickName = nickName;
        this.password = password;
        this.openId = openId;
        this.sex = sex;
        this.city = city;
        this.state = state;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Integer getSex() {
        return sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", openId='" + openId + '\'' +
                ", nickName='" + nickName + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", sex=" + sex +
                ", city='" + city + '\'' +
                ", state=" + state +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", roles=" + roles +
                '}';
    }
}
