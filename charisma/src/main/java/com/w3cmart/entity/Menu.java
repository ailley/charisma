package com.w3cmart.entity;

import com.h.common.admin.superpage.BeanSuper;
import com.w3cmart.common.enums.StatusEnum;

@SuppressWarnings("serial")
public class Menu implements BeanSuper {
    private Long id;

    private String name;

    private Long parentId;

    private String url;

    private Long sort;

    private StatusEnum status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Long getSort() {
        return sort;
    }

    public void setSort(Long sort) {
        this.sort = sort;
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
    public  <T extends Menu> T copy(T bean) {
        bean.setId(getId());
        bean.setName(getName());
        bean.setParentId(getParentId());
        bean.setUrl(getUrl());
        bean.setSort(getSort());
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
        	", name:" + getName() + 
        	", parentId:" + getParentId() + 
        	", url:" + getUrl() + 
        	", sort:" + getSort() + 
        	", status:" + getStatus() + 
        "}";
    }
}