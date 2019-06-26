package com.kgc.mapper;

import com.kgc.pojo.Dept2;
import com.kgc.pojo.Dept2Example;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Dept2Mapper {
    long countByExample(Dept2Example example);

    int deleteByExample(Dept2Example example);

    int deleteByPrimaryKey(Integer deptno);

    int insert(Dept2 record);

    int insertSelective(Dept2 record);

    List<Dept2> selectByExample(Dept2Example example);

    Dept2 selectByPrimaryKey(Integer deptno);

    int updateByExampleSelective(@Param("record") Dept2 record, @Param("example") Dept2Example example);

    int updateByExample(@Param("record") Dept2 record, @Param("example") Dept2Example example);

    int updateByPrimaryKeySelective(Dept2 record);

    int updateByPrimaryKey(Dept2 record);
}