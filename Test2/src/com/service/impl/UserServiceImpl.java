package com.service.impl;

import com.bean.Card;
import com.bean.User;
import com.bean.pageBean;
import com.dao.IUserDao;
import com.dao.impl.UserDaoImpl;
import com.service.IUserService;

import java.util.List;

public class UserServiceImpl implements IUserService {
    private IUserDao dao = new UserDaoImpl();
    @Override
    public List<User> selectAll(pageBean page) {
        int count = dao.selectCount(page);
        int size = page.getSize();
        int totalPage = (count % size == 0) ? (count / size) : (count / size + 1);
        page.setCount(count);
        page.setTotalPage(totalPage);
        return dao.selectAll(page);
    }

    @Override
    public List<Card> selectCard() {
        return dao.selectCard();
    }

    @Override
    public int add(User user) {
        return dao.add(user);
    }

    @Override
    public int del(String id) {
        return dao.del(id);
    }

    @Override
    public int update(User user) {
        return dao.update(user);
    }

    @Override
    public User selectById(String id) {
        return dao.selectById(id);
    }
}
