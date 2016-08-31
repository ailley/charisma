package com.w3cmart.entity.permission;

import com.h.common.admin.superpage.CriteriaSuper;
import com.w3cmart.common.enums.StatusEnum;

import java.util.ArrayList;
import java.util.List;

public class PermissionCriteria implements CriteriaSuper {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int top = -1;

    protected int skipCount = 0;

    public PermissionCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setTop(int top) {
        this.top=top;
    }

    public int getTop() {
        return top;
    }

    /**
     * 设置查询数据库时掠过前面多少条记录
     * @param skipCount 忽略前面记录的数量
     */
    public void setSkipCount(int skipCount) {
        this.skipCount = skipCount;
    }

    public int getSkipCount() {
        return skipCount;
    }

    public int getEndCount() {
        return skipCount + top;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> statusCriteria;

        protected List<Criterion> allCriteria;

        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
            statusCriteria = new ArrayList<Criterion>();
        }

        public List<Criterion> getStatusCriteria() {
            return statusCriteria;
        }

        protected void addStatusCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            statusCriteria.add(new Criterion(condition, value, "com.w3cmart.common.enums.StatusEnumHandler"));
            allCriteria = null;
        }

        protected void addStatusCriterion(String condition, StatusEnum value1, StatusEnum value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            statusCriteria.add(new Criterion(condition, value1, value2, "com.w3cmart.common.enums.StatusEnumHandler"));
            allCriteria = null;
        }

        public boolean isValid() {
            return criteria.size() > 0
                || statusCriteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            if (allCriteria == null) {
                allCriteria = new ArrayList<Criterion>();
                allCriteria.addAll(criteria);
                allCriteria.addAll(statusCriteria);
            }
            return allCriteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
            allCriteria = null;
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
            allCriteria = null;
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
            allCriteria = null;
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPermissionMarkIsNull() {
            addCriterion("permission_mark is null");
            return (Criteria) this;
        }

        public Criteria andPermissionMarkIsNotNull() {
            addCriterion("permission_mark is not null");
            return (Criteria) this;
        }

        public Criteria andPermissionMarkEqualTo(String value) {
            addCriterion("permission_mark =", value, "permissionMark");
            return (Criteria) this;
        }

        public Criteria andPermissionMarkNotEqualTo(String value) {
            addCriterion("permission_mark <>", value, "permissionMark");
            return (Criteria) this;
        }

        public Criteria andPermissionMarkGreaterThan(String value) {
            addCriterion("permission_mark >", value, "permissionMark");
            return (Criteria) this;
        }

        public Criteria andPermissionMarkGreaterThanOrEqualTo(String value) {
            addCriterion("permission_mark >=", value, "permissionMark");
            return (Criteria) this;
        }

        public Criteria andPermissionMarkLessThan(String value) {
            addCriterion("permission_mark <", value, "permissionMark");
            return (Criteria) this;
        }

        public Criteria andPermissionMarkLessThanOrEqualTo(String value) {
            addCriterion("permission_mark <=", value, "permissionMark");
            return (Criteria) this;
        }

        public Criteria andPermissionMarkLike(String value) {
            addCriterion("permission_mark like", value, "permissionMark");
            return (Criteria) this;
        }

        public Criteria andPermissionMarkNotLike(String value) {
            addCriterion("permission_mark not like", value, "permissionMark");
            return (Criteria) this;
        }

        public Criteria andPermissionMarkIn(List<String> values) {
            addCriterion("permission_mark in", values, "permissionMark");
            return (Criteria) this;
        }

        public Criteria andPermissionMarkNotIn(List<String> values) {
            addCriterion("permission_mark not in", values, "permissionMark");
            return (Criteria) this;
        }

        public Criteria andPermissionMarkBetween(String value1, String value2) {
            addCriterion("permission_mark between", value1, value2, "permissionMark");
            return (Criteria) this;
        }

        public Criteria andPermissionMarkNotBetween(String value1, String value2) {
            addCriterion("permission_mark not between", value1, value2, "permissionMark");
            return (Criteria) this;
        }

        public Criteria andPermissionDesIsNull() {
            addCriterion("permission_des is null");
            return (Criteria) this;
        }

        public Criteria andPermissionDesIsNotNull() {
            addCriterion("permission_des is not null");
            return (Criteria) this;
        }

        public Criteria andPermissionDesEqualTo(String value) {
            addCriterion("permission_des =", value, "permissionDes");
            return (Criteria) this;
        }

        public Criteria andPermissionDesNotEqualTo(String value) {
            addCriterion("permission_des <>", value, "permissionDes");
            return (Criteria) this;
        }

        public Criteria andPermissionDesGreaterThan(String value) {
            addCriterion("permission_des >", value, "permissionDes");
            return (Criteria) this;
        }

        public Criteria andPermissionDesGreaterThanOrEqualTo(String value) {
            addCriterion("permission_des >=", value, "permissionDes");
            return (Criteria) this;
        }

        public Criteria andPermissionDesLessThan(String value) {
            addCriterion("permission_des <", value, "permissionDes");
            return (Criteria) this;
        }

        public Criteria andPermissionDesLessThanOrEqualTo(String value) {
            addCriterion("permission_des <=", value, "permissionDes");
            return (Criteria) this;
        }

        public Criteria andPermissionDesLike(String value) {
            addCriterion("permission_des like", value, "permissionDes");
            return (Criteria) this;
        }

        public Criteria andPermissionDesNotLike(String value) {
            addCriterion("permission_des not like", value, "permissionDes");
            return (Criteria) this;
        }

        public Criteria andPermissionDesIn(List<String> values) {
            addCriterion("permission_des in", values, "permissionDes");
            return (Criteria) this;
        }

        public Criteria andPermissionDesNotIn(List<String> values) {
            addCriterion("permission_des not in", values, "permissionDes");
            return (Criteria) this;
        }

        public Criteria andPermissionDesBetween(String value1, String value2) {
            addCriterion("permission_des between", value1, value2, "permissionDes");
            return (Criteria) this;
        }

        public Criteria andPermissionDesNotBetween(String value1, String value2) {
            addCriterion("permission_des not between", value1, value2, "permissionDes");
            return (Criteria) this;
        }

        public Criteria andPermissionTypeIsNull() {
            addCriterion("permission_type is null");
            return (Criteria) this;
        }

        public Criteria andPermissionTypeIsNotNull() {
            addCriterion("permission_type is not null");
            return (Criteria) this;
        }

        public Criteria andPermissionTypeEqualTo(Integer value) {
            addCriterion("permission_type =", value, "permissionType");
            return (Criteria) this;
        }

        public Criteria andPermissionTypeNotEqualTo(Integer value) {
            addCriterion("permission_type <>", value, "permissionType");
            return (Criteria) this;
        }

        public Criteria andPermissionTypeGreaterThan(Integer value) {
            addCriterion("permission_type >", value, "permissionType");
            return (Criteria) this;
        }

        public Criteria andPermissionTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("permission_type >=", value, "permissionType");
            return (Criteria) this;
        }

        public Criteria andPermissionTypeLessThan(Integer value) {
            addCriterion("permission_type <", value, "permissionType");
            return (Criteria) this;
        }

        public Criteria andPermissionTypeLessThanOrEqualTo(Integer value) {
            addCriterion("permission_type <=", value, "permissionType");
            return (Criteria) this;
        }

        public Criteria andPermissionTypeIn(List<Integer> values) {
            addCriterion("permission_type in", values, "permissionType");
            return (Criteria) this;
        }

        public Criteria andPermissionTypeNotIn(List<Integer> values) {
            addCriterion("permission_type not in", values, "permissionType");
            return (Criteria) this;
        }

        public Criteria andPermissionTypeBetween(Integer value1, Integer value2) {
            addCriterion("permission_type between", value1, value2, "permissionType");
            return (Criteria) this;
        }

        public Criteria andPermissionTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("permission_type not between", value1, value2, "permissionType");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Long value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Long value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Long value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Long value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Long value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Long value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Long> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Long> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Long value1, Long value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Long value1, Long value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andUpdeteDateIsNull() {
            addCriterion("updete_date is null");
            return (Criteria) this;
        }

        public Criteria andUpdeteDateIsNotNull() {
            addCriterion("updete_date is not null");
            return (Criteria) this;
        }

        public Criteria andUpdeteDateEqualTo(Long value) {
            addCriterion("updete_date =", value, "updeteDate");
            return (Criteria) this;
        }

        public Criteria andUpdeteDateNotEqualTo(Long value) {
            addCriterion("updete_date <>", value, "updeteDate");
            return (Criteria) this;
        }

        public Criteria andUpdeteDateGreaterThan(Long value) {
            addCriterion("updete_date >", value, "updeteDate");
            return (Criteria) this;
        }

        public Criteria andUpdeteDateGreaterThanOrEqualTo(Long value) {
            addCriterion("updete_date >=", value, "updeteDate");
            return (Criteria) this;
        }

        public Criteria andUpdeteDateLessThan(Long value) {
            addCriterion("updete_date <", value, "updeteDate");
            return (Criteria) this;
        }

        public Criteria andUpdeteDateLessThanOrEqualTo(Long value) {
            addCriterion("updete_date <=", value, "updeteDate");
            return (Criteria) this;
        }

        public Criteria andUpdeteDateIn(List<Long> values) {
            addCriterion("updete_date in", values, "updeteDate");
            return (Criteria) this;
        }

        public Criteria andUpdeteDateNotIn(List<Long> values) {
            addCriterion("updete_date not in", values, "updeteDate");
            return (Criteria) this;
        }

        public Criteria andUpdeteDateBetween(Long value1, Long value2) {
            addCriterion("updete_date between", value1, value2, "updeteDate");
            return (Criteria) this;
        }

        public Criteria andUpdeteDateNotBetween(Long value1, Long value2) {
            addCriterion("updete_date not between", value1, value2, "updeteDate");
            return (Criteria) this;
        }

        public Criteria andMenuIdIsNull() {
            addCriterion("menu_id is null");
            return (Criteria) this;
        }

        public Criteria andMenuIdIsNotNull() {
            addCriterion("menu_id is not null");
            return (Criteria) this;
        }

        public Criteria andMenuIdEqualTo(Long value) {
            addCriterion("menu_id =", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotEqualTo(Long value) {
            addCriterion("menu_id <>", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdGreaterThan(Long value) {
            addCriterion("menu_id >", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdGreaterThanOrEqualTo(Long value) {
            addCriterion("menu_id >=", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdLessThan(Long value) {
            addCriterion("menu_id <", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdLessThanOrEqualTo(Long value) {
            addCriterion("menu_id <=", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdIn(List<Long> values) {
            addCriterion("menu_id in", values, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotIn(List<Long> values) {
            addCriterion("menu_id not in", values, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdBetween(Long value1, Long value2) {
            addCriterion("menu_id between", value1, value2, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotBetween(Long value1, Long value2) {
            addCriterion("menu_id not between", value1, value2, "menuId");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(StatusEnum value) {
            addStatusCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(StatusEnum value) {
            addStatusCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(StatusEnum value) {
            addStatusCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(StatusEnum value) {
            addStatusCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(StatusEnum value) {
            addStatusCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(StatusEnum value) {
            addStatusCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<StatusEnum> values) {
            addStatusCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<StatusEnum> values) {
            addStatusCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(StatusEnum value1, StatusEnum value2) {
            addStatusCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(StatusEnum value1, StatusEnum value2) {
            addStatusCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}