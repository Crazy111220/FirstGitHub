package com.kgc.service;

import com.kgc.pojo.Dept2;
import com.kgc.pojo.Emp;
import com.kgc.pojo.pageBean;

import java.util.List;

public interface IEmpService {
    List<Emp> show(pageBean page);

    List<Dept2> selectDepts();

    int deleteById(int number);

    int addEmp(Emp emp);

    Emp selectById(int number);

    int updateEmp(Emp emp);

    void batDel(Integer[] ids);
}

