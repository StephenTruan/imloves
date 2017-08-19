package com.imloves.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by wujianchuan
 * 2017/8/17 21:26
 */
@Entity
public class WxCustomer implements Serializable {

    @Id
    @GeneratedValue
    private Long uuid;
    private String nickName;
    private String password;
    private String openId;
    private Integer sex;
    private String city;
    private Integer state;
    private String createTime;
    private String updateTime;

    public WxCustomer() {
    }

    public WxCustomer(String nickName, String password, String openId, Integer sex, String city, Integer state) {
        this.nickName = nickName;
        this.password = password;
        this.openId = openId;
        this.sex = sex;
        this.city = city;
        this.state = state;
    }

    public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
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

    @Override
    public String toString() {
        return "WxCustomer{" +
                "uuid=" + uuid +
                ", nickName='" + nickName + '\'' +
                ", password='" + password + '\'' +
                ", openId='" + openId + '\'' +
                ", sex=" + sex +
                ", city='" + city + '\'' +
                ", state=" + state +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
