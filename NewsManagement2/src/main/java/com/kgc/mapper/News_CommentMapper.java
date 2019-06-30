package com.kgc.mapper;

import com.kgc.pojo.News_Comment;
import com.kgc.pojo.News_CommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface News_CommentMapper {
    long countByExample(News_CommentExample example);

    int deleteByExample(News_CommentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(News_Comment record);

    int insertSelective(News_Comment record);

    List<News_Comment> selectByExample(News_CommentExample example);

    News_Comment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") News_Comment record, @Param("example") News_CommentExample example);

    int updateByExample(@Param("record") News_Comment record, @Param("example") News_CommentExample example);

    int updateByPrimaryKeySelective(News_Comment record);

    int updateByPrimaryKey(News_Comment record);
}