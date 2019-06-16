package com.kgc.web;

import com.kgc.bean.Account;
import com.kgc.service.Loginservice;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private Loginservice service = new Loginservice();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.setCharacterEncoding("utf-8");
        //singleLogin(request,response);
        distributeLogin(request,response);



    }
//两个Tomcat环境
    private void distributeLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1、取参数 name psw
        String name = request.getParameter("name");
        String psw = request.getParameter("psw");
        String remember = request.getParameter("remember");

        //2、调service 查询
        Account account = service.login(name,psw);
        //3.存session,cookie
        if(account != null){
            HttpSession session = request.getSession();
            session.setAttribute("account",account);
            if(remember != null && remember.equals("1")){//记住我
               //向cookie中添加account对象
                service.addAccountToCookie(account,response);
            }

            //4、跳转
            response.sendRedirect("/SingleLogin2/success.jsp");

        }else{

            response.sendRedirect("/SingleLogin2/fail.jsp");
        }
    }
//单服务器登录
    private void singleLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1、取参数 name psw
        String name = request.getParameter("name");
        String psw = request.getParameter("psw");
        String remember = request.getParameter("remember");

        //2、调service 查询
        Account account = service.login(name,psw);
        //3.存session
        if(account != null){
            HttpSession session = request.getSession();
            session.setAttribute("account",account);
            if(remember != null && remember.equals("1")){
                //创建同名的具有身份认证功能的cookie，去替换客户端手中原有的cookie
                Cookie cookie = new Cookie("JSESSIONID",session.getId());
                cookie.setMaxAge(3*60);
                session.setMaxInactiveInterval(3*60);
            }

            //4、跳转
            response.sendRedirect("/SingleLogin2/success.jsp");

        }else{

            response.sendRedirect("/SingleLogin2/fail.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().removeAttribute("account");
        Cookie cookie = new Cookie("id_time", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        response.sendRedirect("/SingleLogin2/");
    }
}
