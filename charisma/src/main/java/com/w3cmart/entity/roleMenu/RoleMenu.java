package com.w3cmart.entity.roleMenu;

import com.h.common.admin.superpage.BeanSuper;

@SuppressWarnings("serial")
public class RoleMenu implements BeanSuper {
    private Long id;

    private Long roleId;

    private Long menuId;

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

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    /** 
     * 拷贝，将对象中的字段全部拷贝到子对象中
     * @param bean 接收对象的子类
     * @return 拷贝完成后的子类
     */ 
    public  <T extends RoleMenu> T copy(T bean) {
        bean.setId(getId());
        bean.setRoleId(getRoleId());
        bean.setMenuId(getMenuId());
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
        	", menuId:" + getMenuId() + 
        "}";
    }
}