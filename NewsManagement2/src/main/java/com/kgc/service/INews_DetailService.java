package com.kgc.service;

import com.kgc.pojo.News_Comment;
import com.kgc.pojo.News_Detail;
import com.kgc.pojo.pageBean;

import java.util.List;

public interface INews_DetailService {
    List<News_Detail> selectAll(pageBean page);

    List<News_Comment> selectById(String id);

    int add(News_Comment comment);

    void del(String id);
}
