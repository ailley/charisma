package com.w3cmart.entity;

import com.h.common.admin.superpage.BeanSuper;
import com.w3cmart.common.enums.StatusEnum;

@SuppressWarnings("serial")
public class UserInfo implements BeanSuper {
    private Long uid;

    private String name;

    private String qq;

    private String email;

    private Boolean gender;

    private String head;

    private String note;

    private StatusEnum status;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head == null ? null : head.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
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
    public  <T extends UserInfo> T copy(T bean) {
        bean.setUid(getUid());
        bean.setName(getName());
        bean.setQq(getQq());
        bean.setEmail(getEmail());
        bean.setGender(getGender());
        bean.setHead(getHead());
        bean.setNote(getNote());
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
        	", name:" + getName() + 
        	", qq:" + getQq() + 
        	", email:" + getEmail() + 
        	", gender:" + getGender() + 
        	", head:" + getHead() + 
        	", note:" + getNote() + 
        	", status:" + getStatus() + 
        "}";
    }
}