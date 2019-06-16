package com.dao.impl;

import com.bean.Card;
import com.bean.User;
import com.bean.pageBean;
import com.dao.IUserDao;
import com.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class UserDaoImpl implements IUserDao {
    @Override
    public List<User> selectAll(pageBean page) {
        QueryRunner qr = new QueryRunner(JdbcUtil.getDs());
        try {
            int size = page.getSize();
            int startRow = (page.getCurrPage() - 1) * size;
            String sql = "select * from user where 1=1 ";
            //卡种分类查询
            String cards_id = page.getCards_id();
            if(cards_id != null && !cards_id.equals("0")){
                sql += " and cards_id = " + cards_id;
            }
            //姓名的模糊查询
            String name = page.getName();
            if(name != null && !name.trim().equals("")){
                sql += " and name like '%" + name.trim() + "%'";
            }
            sql += " limit ?,?";
            List<User> list = qr.query(sql, new BeanListHandler<User>(User.class),startRow,size);
            for(User user : list){
                Card card = qr.query("select * from card where card_id = ?", new BeanHandler<Card>(Card.class), user.getCards_id());
                user.setCard(card);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Card> selectCard() {
        QueryRunner qr = new QueryRunner(JdbcUtil.getDs());
        try {
            return qr.query("select * from card",new BeanListHandler<Card>(Card.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int selectCount(pageBean page) {
        QueryRunner qr = new QueryRunner(JdbcUtil.getDs());
        try {
            String sql = "select count(*) from user where 1=1 ";
            //卡种分类查询
            String cards_id = page.getCards_id();
            if(cards_id != null && !cards_id.equals("0")){
                sql += " and cards_id = " + cards_id;
            }
            //姓名的模糊查询
            String name = page.getName();
            if(name != null && !name.trim().equals("")){
                sql += " and name like '%" + name.trim() + "%'";
            }
            return qr.query(sql,new ScalarHandler<Long>()).intValue();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int add(User user) {
        QueryRunner qr = new QueryRunner(JdbcUtil.getDs());
        user.setCreate_date(new Date());
        Object[] param = {user.getNum(),user.getName(),user.getAddr(),user.getCreate_date(),user.getCards_id()};
        try {
            return qr.update("insert into user values (null,?,?,?,?,?)",param);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int del(String id) {
        QueryRunner qr = new QueryRunner(JdbcUtil.getDs());
        try {
            return qr.update("delete from user where id = ?",id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int update(User user) {
        QueryRunner qr = new QueryRunner(JdbcUtil.getDs());
        try {
            Object[] param = {user.getNum(),user.getName(),user.getAddr(),user.getCards_id(),user.getId()};
            return qr.update("update user set num=?,name=?,addr=?,cards_id=? where id=?",param);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User selectById(String id) {
        QueryRunner qr = new QueryRunner(JdbcUtil.getDs());
        try {
            return qr.query("select * from user where id = ?",new BeanHandler<User>(User.class),id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
