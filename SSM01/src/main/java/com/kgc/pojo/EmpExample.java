package com.kgc.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class EmpExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    /**
     * 这是Mybatis Generator拓展插件生成的属性(请勿删除).
     * This field corresponds to the database table emp
     *
     * @mbg.generated
     * @author hewei
     */
    protected Integer offset;

    /**
     * 这是Mybatis Generator拓展插件生成的属性(请勿删除).
     * This field corresponds to the database table emp
     *
     * @mbg.generated
     * @author hewei
     */
    protected Integer rows;

    public EmpExample() {
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
        rows = null;
        offset = null;
    }

    /**
     * 这是Mybatis Generator拓展插件生成的方法(请勿删除).
     * This method corresponds to the database table emp
     *
     * @mbg.generated
     * @author hewei
     */
    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    /**
     * 这是Mybatis Generator拓展插件生成的方法(请勿删除).
     * This method corresponds to the database table emp
     *
     * @mbg.generated
     * @author hewei
     */
    public Integer getOffset() {
        return offset;
    }

    /**
     * 这是Mybatis Generator拓展插件生成的方法(请勿删除).
     * This method corresponds to the database table emp
     *
     * @mbg.generated
     * @author hewei
     */
    public void setRows(Integer rows) {
        this.rows = rows;
    }

    /**
     * 这是Mybatis Generator拓展插件生成的方法(请勿删除).
     * This method corresponds to the database table emp
     *
     * @mbg.generated
     * @author hewei
     */
    public Integer getRows() {
        return rows;
    }

    /**
     * 这是Mybatis Generator拓展插件生成的方法(请勿删除).
     * This method corresponds to the database table emp
     *
     * @mbg.generated
     * @author hewei
     */
    public EmpExample limit(Integer rows) {
        this.rows = rows;
        return this;
    }

    /**
     * 这是Mybatis Generator拓展插件生成的方法(请勿删除).
     * This method corresponds to the database table emp
     *
     * @mbg.generated
     * @author hewei
     */
    public EmpExample limit(Integer offset, Integer rows) {
        this.offset = offset;
        this.rows = rows;
        return this;
    }

    /**
     * 这是Mybatis Generator拓展插件生成的方法(请勿删除).
     * This method corresponds to the database table emp
     *
     * @mbg.generated
     * @author hewei
     */
    public EmpExample page(Integer page, Integer pageSize) {
        this.offset = page * pageSize;
        this.rows = pageSize;
        return this;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andNumberIsNull() {
            addCriterion("number is null");
            return (Criteria) this;
        }

        public Criteria andNumberIsNotNull() {
            addCriterion("number is not null");
            return (Criteria) this;
        }

        public Criteria andNumberEqualTo(Integer value) {
            addCriterion("number =", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotEqualTo(Integer value) {
            addCriterion("number <>", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThan(Integer value) {
            addCriterion("number >", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("number >=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThan(Integer value) {
            addCriterion("number <", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThanOrEqualTo(Integer value) {
            addCriterion("number <=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberIn(List<Integer> values) {
            addCriterion("number in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotIn(List<Integer> values) {
            addCriterion("number not in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberBetween(Integer value1, Integer value2) {
            addCriterion("number between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("number not between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andJobIsNull() {
            addCriterion("job is null");
            return (Criteria) this;
        }

        public Criteria andJobIsNotNull() {
            addCriterion("job is not null");
            return (Criteria) this;
        }

        public Criteria andJobEqualTo(String value) {
            addCriterion("job =", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobNotEqualTo(String value) {
            addCriterion("job <>", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobGreaterThan(String value) {
            addCriterion("job >", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobGreaterThanOrEqualTo(String value) {
            addCriterion("job >=", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobLessThan(String value) {
            addCriterion("job <", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobLessThanOrEqualTo(String value) {
            addCriterion("job <=", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobLike(String value) {
            addCriterion("job like", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobNotLike(String value) {
            addCriterion("job not like", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobIn(List<String> values) {
            addCriterion("job in", values, "job");
            return (Criteria) this;
        }

        public Criteria andJobNotIn(List<String> values) {
            addCriterion("job not in", values, "job");
            return (Criteria) this;
        }

        public Criteria andJobBetween(String value1, String value2) {
            addCriterion("job between", value1, value2, "job");
            return (Criteria) this;
        }

        public Criteria andJobNotBetween(String value1, String value2) {
            addCriterion("job not between", value1, value2, "job");
            return (Criteria) this;
        }

        public Criteria andMgrIsNull() {
            addCriterion("mgr is null");
            return (Criteria) this;
        }

        public Criteria andMgrIsNotNull() {
            addCriterion("mgr is not null");
            return (Criteria) this;
        }

        public Criteria andMgrEqualTo(Integer value) {
            addCriterion("mgr =", value, "mgr");
            return (Criteria) this;
        }

        public Criteria andMgrNotEqualTo(Integer value) {
            addCriterion("mgr <>", value, "mgr");
            return (Criteria) this;
        }

        public Criteria andMgrGreaterThan(Integer value) {
            addCriterion("mgr >", value, "mgr");
            return (Criteria) this;
        }

        public Criteria andMgrGreaterThanOrEqualTo(Integer value) {
            addCriterion("mgr >=", value, "mgr");
            return (Criteria) this;
        }

        public Criteria andMgrLessThan(Integer value) {
            addCriterion("mgr <", value, "mgr");
            return (Criteria) this;
        }

        public Criteria andMgrLessThanOrEqualTo(Integer value) {
            addCriterion("mgr <=", value, "mgr");
            return (Criteria) this;
        }

        public Criteria andMgrIn(List<Integer> values) {
            addCriterion("mgr in", values, "mgr");
            return (Criteria) this;
        }

        public Criteria andMgrNotIn(List<Integer> values) {
            addCriterion("mgr not in", values, "mgr");
            return (Criteria) this;
        }

        public Criteria andMgrBetween(Integer value1, Integer value2) {
            addCriterion("mgr between", value1, value2, "mgr");
            return (Criteria) this;
        }

        public Criteria andMgrNotBetween(Integer value1, Integer value2) {
            addCriterion("mgr not between", value1, value2, "mgr");
            return (Criteria) this;
        }

        public Criteria andHiredateIsNull() {
            addCriterion("hiredate is null");
            return (Criteria) this;
        }

        public Criteria andHiredateIsNotNull() {
            addCriterion("hiredate is not null");
            return (Criteria) this;
        }

        public Criteria andHiredateEqualTo(Date value) {
            addCriterionForJDBCDate("hiredate =", value, "hiredate");
            return (Criteria) this;
        }

        public Criteria andHiredateNotEqualTo(Date value) {
            addCriterionForJDBCDate("hiredate <>", value, "hiredate");
            return (Criteria) this;
        }

        public Criteria andHiredateGreaterThan(Date value) {
            addCriterionForJDBCDate("hiredate >", value, "hiredate");
            return (Criteria) this;
        }

        public Criteria andHiredateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("hiredate >=", value, "hiredate");
            return (Criteria) this;
        }

        public Criteria andHiredateLessThan(Date value) {
            addCriterionForJDBCDate("hiredate <", value, "hiredate");
            return (Criteria) this;
        }

        public Criteria andHiredateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("hiredate <=", value, "hiredate");
            return (Criteria) this;
        }

        public Criteria andHiredateIn(List<Date> values) {
            addCriterionForJDBCDate("hiredate in", values, "hiredate");
            return (Criteria) this;
        }

        public Criteria andHiredateNotIn(List<Date> values) {
            addCriterionForJDBCDate("hiredate not in", values, "hiredate");
            return (Criteria) this;
        }

        public Criteria andHiredateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("hiredate between", value1, value2, "hiredate");
            return (Criteria) this;
        }

        public Criteria andHiredateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("hiredate not between", value1, value2, "hiredate");
            return (Criteria) this;
        }

        public Criteria andSalIsNull() {
            addCriterion("sal is null");
            return (Criteria) this;
        }

        public Criteria andSalIsNotNull() {
            addCriterion("sal is not null");
            return (Criteria) this;
        }

        public Criteria andSalEqualTo(Double value) {
            addCriterion("sal =", value, "sal");
            return (Criteria) this;
        }

        public Criteria andSalNotEqualTo(Double value) {
            addCriterion("sal <>", value, "sal");
            return (Criteria) this;
        }

        public Criteria andSalGreaterThan(Double value) {
            addCriterion("sal >", value, "sal");
            return (Criteria) this;
        }

        public Criteria andSalGreaterThanOrEqualTo(Double value) {
            addCriterion("sal >=", value, "sal");
            return (Criteria) this;
        }

        public Criteria andSalLessThan(Double value) {
            addCriterion("sal <", value, "sal");
            return (Criteria) this;
        }

        public Criteria andSalLessThanOrEqualTo(Double value) {
            addCriterion("sal <=", value, "sal");
            return (Criteria) this;
        }

        public Criteria andSalIn(List<Double> values) {
            addCriterion("sal in", values, "sal");
            return (Criteria) this;
        }

        public Criteria andSalNotIn(List<Double> values) {
            addCriterion("sal not in", values, "sal");
            return (Criteria) this;
        }

        public Criteria andSalBetween(Double value1, Double value2) {
            addCriterion("sal between", value1, value2, "sal");
            return (Criteria) this;
        }

        public Criteria andSalNotBetween(Double value1, Double value2) {
            addCriterion("sal not between", value1, value2, "sal");
            return (Criteria) this;
        }

        public Criteria andCommIsNull() {
            addCriterion("comm is null");
            return (Criteria) this;
        }

        public Criteria andCommIsNotNull() {
            addCriterion("comm is not null");
            return (Criteria) this;
        }

        public Criteria andCommEqualTo(Double value) {
            addCriterion("comm =", value, "comm");
            return (Criteria) this;
        }

        public Criteria andCommNotEqualTo(Double value) {
            addCriterion("comm <>", value, "comm");
            return (Criteria) this;
        }

        public Criteria andCommGreaterThan(Double value) {
            addCriterion("comm >", value, "comm");
            return (Criteria) this;
        }

        public Criteria andCommGreaterThanOrEqualTo(Double value) {
            addCriterion("comm >=", value, "comm");
            return (Criteria) this;
        }

        public Criteria andCommLessThan(Double value) {
            addCriterion("comm <", value, "comm");
            return (Criteria) this;
        }

        public Criteria andCommLessThanOrEqualTo(Double value) {
            addCriterion("comm <=", value, "comm");
            return (Criteria) this;
        }

        public Criteria andCommIn(List<Double> values) {
            addCriterion("comm in", values, "comm");
            return (Criteria) this;
        }

        public Criteria andCommNotIn(List<Double> values) {
            addCriterion("comm not in", values, "comm");
            return (Criteria) this;
        }

        public Criteria andCommBetween(Double value1, Double value2) {
            addCriterion("comm between", value1, value2, "comm");
            return (Criteria) this;
        }

        public Criteria andCommNotBetween(Double value1, Double value2) {
            addCriterion("comm not between", value1, value2, "comm");
            return (Criteria) this;
        }

        public Criteria andDeptnoIsNull() {
            addCriterion("deptno is null");
            return (Criteria) this;
        }

        public Criteria andDeptnoIsNotNull() {
            addCriterion("deptno is not null");
            return (Criteria) this;
        }

        public Criteria andDeptnoEqualTo(Integer value) {
            addCriterion("deptno =", value, "deptno");
            return (Criteria) this;
        }

        public Criteria andDeptnoNotEqualTo(Integer value) {
            addCriterion("deptno <>", value, "deptno");
            return (Criteria) this;
        }

        public Criteria andDeptnoGreaterThan(Integer value) {
            addCriterion("deptno >", value, "deptno");
            return (Criteria) this;
        }

        public Criteria andDeptnoGreaterThanOrEqualTo(Integer value) {
            addCriterion("deptno >=", value, "deptno");
            return (Criteria) this;
        }

        public Criteria andDeptnoLessThan(Integer value) {
            addCriterion("deptno <", value, "deptno");
            return (Criteria) this;
        }

        public Criteria andDeptnoLessThanOrEqualTo(Integer value) {
            addCriterion("deptno <=", value, "deptno");
            return (Criteria) this;
        }

        public Criteria andDeptnoIn(List<Integer> values) {
            addCriterion("deptno in", values, "deptno");
            return (Criteria) this;
        }

        public Criteria andDeptnoNotIn(List<Integer> values) {
            addCriterion("deptno not in", values, "deptno");
            return (Criteria) this;
        }

        public Criteria andDeptnoBetween(Integer value1, Integer value2) {
            addCriterion("deptno between", value1, value2, "deptno");
            return (Criteria) this;
        }

        public Criteria andDeptnoNotBetween(Integer value1, Integer value2) {
            addCriterion("deptno not between", value1, value2, "deptno");
            return (Criteria) this;
        }

        public Criteria andImgurlIsNull() {
            addCriterion("imgUrl is null");
            return (Criteria) this;
        }

        public Criteria andImgurlIsNotNull() {
            addCriterion("imgUrl is not null");
            return (Criteria) this;
        }

        public Criteria andImgurlEqualTo(String value) {
            addCriterion("imgUrl =", value, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlNotEqualTo(String value) {
            addCriterion("imgUrl <>", value, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlGreaterThan(String value) {
            addCriterion("imgUrl >", value, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlGreaterThanOrEqualTo(String value) {
            addCriterion("imgUrl >=", value, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlLessThan(String value) {
            addCriterion("imgUrl <", value, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlLessThanOrEqualTo(String value) {
            addCriterion("imgUrl <=", value, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlLike(String value) {
            addCriterion("imgUrl like", value, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlNotLike(String value) {
            addCriterion("imgUrl not like", value, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlIn(List<String> values) {
            addCriterion("imgUrl in", values, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlNotIn(List<String> values) {
            addCriterion("imgUrl not in", values, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlBetween(String value1, String value2) {
            addCriterion("imgUrl between", value1, value2, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlNotBetween(String value1, String value2) {
            addCriterion("imgUrl not between", value1, value2, "imgurl");
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