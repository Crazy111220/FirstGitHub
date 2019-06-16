package com.dao;

import com.bean.Card;
import com.bean.User;
import com.bean.pageBean;

import java.util.List;

public interface IUserDao {
    List<User> selectAll(pageBean page);


    List<Card> selectCard();

    int selectCount(pageBean page);

    int add(User user);

    int del(String id);

    int update(User user);

    User selectById(String id);
}
