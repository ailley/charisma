package com.w3cmart.entity.user;

import com.h.common.admin.superpage.BeanSuper;
import com.w3cmart.common.enums.StatusEnum;

@SuppressWarnings("serial")
public class User implements BeanSuper {
    private Long id;

    private String uid;

    private Long roleId;

    private String userName;

    private String password;

    private String name;

    private Integer type;

    private String head;

    private String qq;

    private String email;

    private Integer gender;

    private String note;

    private Long createTime;

    private Long updateTime;

    private StatusEnum status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head == null ? null : head.trim();
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

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
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
        bean.setId(getId());
        bean.setUid(getUid());
        bean.setRoleId(getRoleId());
        bean.setUserName(getUserName());
        bean.setPassword(getPassword());
        bean.setName(getName());
        bean.setType(getType());
        bean.setHead(getHead());
        bean.setQq(getQq());
        bean.setEmail(getEmail());
        bean.setGender(getGender());
        bean.setNote(getNote());
        bean.setCreateTime(getCreateTime());
        bean.setUpdateTime(getUpdateTime());
        bean.setStatus(getStatus());
        return bean;
    }

    /** 
     * 格式化显示
     */ 
    @Override
    public String toString() {
        return "{" + 
        	", id:" + getId() + 
        	", uid:" + getUid() + 
        	", roleId:" + getRoleId() + 
        	", userName:" + getUserName() + 
        	", password:" + getPassword() + 
        	", name:" + getName() + 
        	", type:" + getType() + 
        	", head:" + getHead() + 
        	", qq:" + getQq() + 
        	", email:" + getEmail() + 
        	", gender:" + getGender() + 
        	", note:" + getNote() + 
        	", createTime:" + getCreateTime() + 
        	", updateTime:" + getUpdateTime() + 
        	", status:" + getStatus() + 
        "}";
    }
}