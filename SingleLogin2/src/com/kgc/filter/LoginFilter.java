package com.kgc.filter;

import com.kgc.bean.Account;
import com.kgc.service.Loginservice;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    private Loginservice service = new Loginservice();
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        System.out.println("你已进入拦截器");
       // singleFilter(req,resp,chain);
        distributeFilter(req,resp,chain);



    }

    private void distributeFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        //有没有登录 ？cookie中没有account对象
        //强转请求和响应对象
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        //2、获得session
        HttpSession session = request.getSession();
        //3、从cookie中取出account对象
        Account account = service.getAccountFromCookie(request);
        //4、验证和拦截

        if(account != null){
            session.setAttribute("account",account);
            chain.doFilter(req, resp);
        }else{
            response.sendRedirect("/SingleLogin2/login.jsp");
        }
    }

    //单服务器
    private void singleFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        //没有登录 session中没有account对象
        //强转请求和响应对象
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        //2、获得session
        HttpSession session = request.getSession();
        //3、从session
        Account account = (Account) session.getAttribute("account");
        //4、验证和拦截

        if(account != null){
            chain.doFilter(req, resp);
        }else{
            response.sendRedirect("/SingleLogin2/login.jsp");
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
