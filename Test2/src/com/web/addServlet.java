package com.web;

import com.bean.User;
import com.service.IUserService;
import com.service.impl.UserServiceImpl;
import com.utils.JdbcUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class addServlet extends HttpServlet {
    private IUserService service = new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        Map<String, String[]> map = request.getParameterMap();
        User user = JdbcUtil.mapToBean(User.class, map);
        int i = service.add(user);
        if(i == 1){
            response.getWriter().write("<script>alert('新增成功')</script>");
        }else{
            response.getWriter().write("<script>alert('新增失败')</script>");
        }
        request.getRequestDispatcher("/show").include(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
