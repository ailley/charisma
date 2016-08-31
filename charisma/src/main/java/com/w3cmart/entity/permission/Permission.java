package com.w3cmart.entity.permission;

import com.h.common.admin.superpage.BeanSuper;
import com.w3cmart.common.enums.StatusEnum;

@SuppressWarnings("serial")
public class Permission implements BeanSuper {
    private Long id;

    private String permissionMark;

    private String permissionDes;

    private Integer permissionType;

    private Long createDate;

    private Long updeteDate;

    private Long menuId;

    private StatusEnum status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPermissionMark() {
        return permissionMark;
    }

    public void setPermissionMark(String permissionMark) {
        this.permissionMark = permissionMark == null ? null : permissionMark.trim();
    }

    public String getPermissionDes() {
        return permissionDes;
    }

    public void setPermissionDes(String permissionDes) {
        this.permissionDes = permissionDes == null ? null : permissionDes.trim();
    }

    public Integer getPermissionType() {
        return permissionType;
    }

    public void setPermissionType(Integer permissionType) {
        this.permissionType = permissionType;
    }

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    public Long getUpdeteDate() {
        return updeteDate;
    }

    public void setUpdeteDate(Long updeteDate) {
        this.updeteDate = updeteDate;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
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
    public  <T extends Permission> T copy(T bean) {
        bean.setId(getId());
        bean.setPermissionMark(getPermissionMark());
        bean.setPermissionDes(getPermissionDes());
        bean.setPermissionType(getPermissionType());
        bean.setCreateDate(getCreateDate());
        bean.setUpdeteDate(getUpdeteDate());
        bean.setMenuId(getMenuId());
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
        	", permissionMark:" + getPermissionMark() + 
        	", permissionDes:" + getPermissionDes() + 
        	", permissionType:" + getPermissionType() + 
        	", createDate:" + getCreateDate() + 
        	", updeteDate:" + getUpdeteDate() + 
        	", menuId:" + getMenuId() + 
        	", status:" + getStatus() + 
        "}";
    }
}