package com.web;

import com.service.IUserService;
import com.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class delServlet extends HttpServlet {
    private IUserService service = new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String id = request.getParameter("id");
        int i = service.del(id);
        if(i == 1){
            response.getWriter().write("<script>alert('删除成功')</script>");
        }else{
            response.getWriter().write("<script>alert(删除失败')</script>");
        }
        request.getRequestDispatcher("/show").include(request,response);

    }
}
