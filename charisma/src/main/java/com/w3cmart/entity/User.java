package com.w3cmart.entity;

import com.h.common.admin.superpage.BeanSuper;
import com.w3cmart.common.enums.StatusEnum;

@SuppressWarnings("serial")
public class User implements BeanSuper {
    private Long uid;

    private String userName;

    private String password;

    private Boolean type;

    private StatusEnum status;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    /** 
     * 拷贝，将对象中的字段全部拷贝到子对象中
     * @param bean 接收对象的子类
     * @return 拷贝完成后的子类
     */ 
    public  <T extends User> T copy(T bean) {
        bean.setUid(getUid());
        bean.setUserName(getUserName());
        bean.setPassword(getPassword());
        bean.setType(getType());
        bean.setStatus(getStatus());
        return bean;
    }

    /** 
     * 格式化显示
     */ 
    @Override
    public String toString() {
        return "{" + 
        	", uid:" + getUid() + 
        	", userName:" + getUserName() + 
        	", password:" + getPassword() + 
        	", type:" + getType() + 
        	", status:" + getStatus() + 
        "}";
    }
}