package com.w3cmart.entity.rolePermission;

import com.h.common.admin.superpage.BeanSuper;

@SuppressWarnings("serial")
public class RolePermission implements BeanSuper {
    private Long id;

    private Long roleId;

    private Long permissionId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    /** 
     * 拷贝，将对象中的字段全部拷贝到子对象中
     * @param bean 接收对象的子类
     * @return 拷贝完成后的子类
     */ 
    public  <T extends RolePermission> T copy(T bean) {
        bean.setId(getId());
        bean.setRoleId(getRoleId());
        bean.setPermissionId(getPermissionId());
        return bean;
    }

    /** 
     * 格式化显示
     */ 
    @Override
    public String toString() {
        return "{" + 
        	", id:" + getId() + 
        	", roleId:" + getRoleId() + 
        	", permissionId:" + getPermissionId() + 
        "}";
    }
}