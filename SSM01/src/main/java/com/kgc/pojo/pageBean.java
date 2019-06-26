package com.kgc.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class pageBean {
    //分页四大参数
    private int currPage=1;
    private int size=3;
    private int count;
    private int totalPage;

    //2.搜索条件参数
    private String name;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date startHiredate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date endHiredate;
    private Integer deptno;

    public int getCurrPage() {
        return currPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        //去掉前后空格
        this.name = name == null ? null:name.trim();
    }

    public Date getStartHiredate() {
        return startHiredate;
    }

    public void setStartHiredate(Date startHiredate) {
        this.startHiredate = startHiredate;
    }

    public Date getEndHiredate() {
        return endHiredate;
    }

    public void setEndHiredate(Date endHiredate) {
        this.endHiredate = endHiredate;
    }

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }
}
