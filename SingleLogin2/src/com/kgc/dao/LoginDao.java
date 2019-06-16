package com.kgc.dao;

import com.kgc.bean.Account;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class LoginDao {
    private static  HashMap<String, Account> map = new HashMap<>();
    private static  HashMap<Integer, Account> map_id = new HashMap<>();
    //自增长 从0开始
    private static AtomicInteger id = new AtomicInteger(0);
    public int insert(Account account) {
        /*
        * 1、模拟数据库
        * 2、实现新增
        * 3、实现查询
        * */

//用户名重复验证
        if(!map.containsKey(account.getName())){
            //实现id自增长，并且返回id
            int id = LoginDao.id.incrementAndGet();
            account.setId(id);
            map.put(account.getName(),account);
            map_id.put(account.getId(),account);
            return account.getId();
        }
        return 0;
    }

    public Account select(String name) {
        //查询name 得到key
        return map.get(name);
    }

    public Account selectAccountById(String id) {
        //通过id查询account对象
        return map_id.get(Integer.parseInt(id));
    }
}
