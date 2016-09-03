package com.w3cmart.entity.menu;

import com.h.common.admin.superpage.BeanSuper;
import com.w3cmart.common.enums.StatusEnum;

import java.util.List;
import java.util.Map;

@SuppressWarnings("serial")
public class Menu implements BeanSuper {
    private Long id;

    private String text;

    private Long parentId;

    private String href;

    private String icon;

    private Long sort;

    private StatusEnum status;

    private List<Menu> nodes;

    private Map state;

    private Boolean selectable;

    public Boolean getSelectable() {
        return selectable;
    }

    public void setSelectable(Boolean selectable) {
        this.selectable = selectable;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href == null ? null : href.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
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

    public List<Menu> getNodes() {
        return nodes;
    }

    public void setNodes(List<Menu> nodes) {
        this.nodes = nodes;
    }

    public Map getState() {
        return state;
    }

    public void setState(Map state) {
        this.state = state;
    }

    /**
     * 拷贝，将对象中的字段全部拷贝到子对象中
     * @param bean 接收对象的子类
     * @return 拷贝完成后的子类
     */ 
    public  <T extends Menu> T copy(T bean) {
        bean.setId(getId());
        bean.setText(getText());
        bean.setParentId(getParentId());
        bean.setHref(getHref());
        bean.setIcon(getIcon());
        bean.setSort(getSort());
        bean.setStatus(getStatus());
        bean.setNodes(getNodes());
        bean.setState(getState());
        bean.setSelectable(getSelectable());
        return bean;
    }

    /** 
     * 格式化显示
     */ 
    @Override
    public String toString() {
        return "{" + 
        	", id:" + getId() + 
        	", text:" + getText() + 
        	", parentId:" + getParentId() + 
        	", href:" + getHref() + 
        	", icon:" + getIcon() + 
        	", sort:" + getSort() +
             ",nodes" + getNodes() +
             ",state" + getState() +
              ",selectable" + getSelectable() +
        	", status:" + getStatus() +
        "}";
    }
}