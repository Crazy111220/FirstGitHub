package com.kgc.mapper;

import com.kgc.pojo.News_Detail;
import com.kgc.pojo.News_DetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface News_DetailMapper {
    long countByExample(News_DetailExample example);

    int deleteByExample(News_DetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(News_Detail record);

    int insertSelective(News_Detail record);

    List<News_Detail> selectByExample(News_DetailExample example);

    News_Detail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") News_Detail record, @Param("example") News_DetailExample example);

    int updateByExample(@Param("record") News_Detail record, @Param("example") News_DetailExample example);

    int updateByPrimaryKeySelective(News_Detail record);

    int updateByPrimaryKey(News_Detail record);
}