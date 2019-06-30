package com.kgc.service.impl;

import com.kgc.mapper.News_CommentMapper;
import com.kgc.mapper.News_DetailMapper;
import com.kgc.pojo.*;
import com.kgc.service.INews_DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class News_DetailServiceImpl implements INews_DetailService {
    @Autowired
    private News_DetailMapper news_detailMapper;
    @Autowired
    private News_CommentMapper news_commentMapper;

    @Override
    public List<News_Detail> selectAll(pageBean page) {

        News_DetailExample e = new News_DetailExample();
        News_DetailExample.Criteria c = e.createCriteria();

        if(page.getTitle() != null){
            c.andTitleLike("%" + page.getTitle() + "%");
        }

        int count = (int) news_detailMapper.countByExample(e);
        int size = page.getSize();
        int totalPage = (count % size == 0) ? (count / size) : (count / size + 1);
        page.setCount(count);
        page.setTotalPage(totalPage);

        int startRow = (page.getCurrPage() -1) * size;
        e.limit(startRow, size);

        return news_detailMapper.selectByExample(e);
    }

    @Override
    public List<News_Comment> selectById(String id) {
        News_CommentExample e = new News_CommentExample();
        News_CommentExample.Criteria c = e.createCriteria();
        c.andNewidEqualTo(id);
        return news_commentMapper.selectByExample(e);
    }

    @Override
    public int add(News_Comment comment) {
        comment.setCreatedate(new Date());
        return news_commentMapper.insertSelective(comment);
    }

    @Override
    public void del(String id) {
        news_detailMapper.deleteByPrimaryKey(Integer.parseInt(id));
        News_CommentExample e = new News_CommentExample();
        News_CommentExample.Criteria c = e.createCriteria();
        c.andNewidEqualTo(id);
        news_commentMapper.deleteByExample(e);
    }
}
