package com.w3cmart.entity.role;

import com.h.common.admin.superpage.BeanSuper;
import com.w3cmart.common.enums.StatusEnum;

@SuppressWarnings("serial")
public class Role implements BeanSuper {
    private Long id;

    private String roleName;

    private String roleCode;

    private String roleDes;

    private StatusEnum status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode == null ? null : roleCode.trim();
    }

    public String getRoleDes() {
        return roleDes;
    }

    public void setRoleDes(String roleDes) {
        this.roleDes = roleDes == null ? null : roleDes.trim();
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
    public  <T extends Role> T copy(T bean) {
        bean.setId(getId());
        bean.setRoleName(getRoleName());
        bean.setRoleCode(getRoleCode());
        bean.setRoleDes(getRoleDes());
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
        	", roleName:" + getRoleName() + 
        	", roleCode:" + getRoleCode() + 
        	", roleDes:" + getRoleDes() + 
        	", status:" + getStatus() + 
        "}";
    }
}