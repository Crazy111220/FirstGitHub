package com.web;

import com.bean.Card;
import com.bean.User;
import com.bean.pageBean;
import com.service.IUserService;
import com.service.impl.UserServiceImpl;
import com.utils.JdbcUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class showServlet extends HttpServlet {
    private IUserService service = new UserServiceImpl();
    private pageBean page = new pageBean();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> map = request.getParameterMap();
        page = JdbcUtil.mapToBean(pageBean.class, map);
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //取 调 存 转
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String currPage = request.getParameter("currPage");
        if(currPage != null){
            page.setCurrPage(Integer.parseInt(currPage));
        }

        List<User> list = service.selectAll(page);
        List<Card> cards = service.selectCard();
        HttpSession session = request.getSession();
        session.setAttribute("list",list);
        session.setAttribute("page",page);
        session.setAttribute("cards",cards);
        request.getRequestDispatcher("/jsp/show.jsp").include(request,response);

    }
}
