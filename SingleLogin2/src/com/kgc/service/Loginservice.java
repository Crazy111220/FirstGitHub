package com.kgc.service;

import com.kgc.bean.Account;
import com.kgc.dao.LoginDao;
import com.kgc.utils.AESUtil;
import com.kgc.utils.MD5Util;
import com.kgc.utils.StringUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Loginservice {
    private  final  static  String  MD5_KEY  = "kasdkjh86dkdkf_9dieuyred123la8ldjKhflJF";
    private final static String AES_COOKIES_KEY = "53DAJ866369Podfdsaf_00oeyrjcnfmkdf876";
    /*
    * 1、实现logoin查询方法 调用dao去模拟数据库map中查询
    * 2、向数据库map中添加两个用户数据——注册
    * */
    private LoginDao dao = new LoginDao();

    static{//静态代码块中的代码会在本类被加载的时候去执行
        Loginservice service = new Loginservice();
        service.insert("kgc","123","2018-10-1");
        service.insert("k9503","666","2019-05-1");

    }

    //新增——注册账户
    public int insert(String name, String psw, String createTime){
        //1、创建一个account对象
        Account account = new Account();
        //2、设置属性 name psw salt createTime
        account.setName(name);
        //对姓名name，进行md5加密得到salt
        String salt = MD5Util.MD5Encode(name, "utf-8");
        account.setSalt(salt);
        //原密码拼接两个salt
        psw = psw + "|" + salt + "|" + MD5_KEY;
        psw = MD5Util.MD5Encode(psw, "utf-8");
        account.setPsw(psw);
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date ctime = f.parse(createTime);
            account.setCreateTime(ctime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dao.insert(account);
    }
    //登录 查询——数据库map<String,Account>
    /*
    * 1、name 去数据库中查询 得到一个account对象
    * 2.account对象中取出加密处理后的密码 psw
    * 3、对接收用户输入的参数psw也进行同样的方式加密 得到psw
    * 4.对比psw1 和 psw2
    * */
    public Account login(String name, String psw) {
        Account account =  dao.select(name);
        if(account == null){
            return null;
        }else{
            String psw2 = account.getPsw();
            psw = psw + "|" + account.getSalt() + "|" + MD5_KEY;

            String psw1 = MD5Util.MD5Encode(psw, "utf-8");
            if(StringUtil.isEqual(psw1,psw2)){
                return account;
            }
            return null;
        }
    }
//从cookie中取出account对象
    public Account getAccountFromCookie(HttpServletRequest request) {
        Cookie[] cs = request.getCookies();
        if(cs == null){
            return null;
        }
        for(Cookie c : cs){
            if(StringUtil.isEqual(c.getName(),"id_time")){
                String key2 = c.getValue();
                //第一次解密：key1 和id
                String id_key1 = AESUtil.AESDncode(AES_COOKIES_KEY, key2);
                String[] id_key1_arr = id_key1.split("\\|");
                String id = id_key1_arr[0];
                String key1 = id_key1_arr[1];
                //id去数据库查询，得到account对象，取出time1，
                Account account = dao.selectAccountById(id);
                String time1 = account.getCreateTime().toString();
                if(account == null){
                    return null;
                }
                String time2 = AESUtil.AESDncode(account.getSalt(), key1);
                if(StringUtil.isEqual(time1,time2)){
                    return account;
                }

                break;
            }
        }


        return null;
    }
    //从cookie中存account对象——两次AES加密
    public void addAccountToCookie(Account account, HttpServletResponse response) {
        //第一次加密：盐作为加密因子
        String key1 = AESUtil.AESEncode(account.getSalt(), account.getCreateTime().toString());
        //第二次加密：
        String key2 = AESUtil.AESEncode(AES_COOKIES_KEY, account.getId() + "|" + key1);
        System.out.println(key2);
        Cookie c = new Cookie("id_time", key2);
        System.out.println(key2.length());
        c.setMaxAge(30);
        response.addCookie(c);

    }
}
