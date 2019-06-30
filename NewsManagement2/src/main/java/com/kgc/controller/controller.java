package com.kgc.controller;

import com.kgc.pojo.News_Comment;
import com.kgc.pojo.News_Detail;
import com.kgc.pojo.pageBean;
import com.kgc.service.INews_DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/con")
public class controller {
    @Autowired
    private INews_DetailService service;

    @RequestMapping("/show")
    public ModelAndView show(pageBean page, ModelAndView mav){
        List<News_Detail> list = service.selectAll(page);
        mav.addObject("list",list);
        mav.addObject("page",page);
        mav.setViewName("show");
        return mav;
    }
    @RequestMapping("/comment/{id}")
    public String selectById(@PathVariable String id, Model model){
        List<News_Comment> comments = service.selectById(id);
        model.addAttribute("comments",comments);
        return "ShowComment";
    }
    @RequestMapping("/add1/{id}")
    public String add1(@PathVariable String id, ModelMap map){
        map.addAttribute("id",id);
        return "add";
    }
    @RequestMapping("/add")
    public String add(News_Comment comment){
        int i = service.add(comment);
        return "redirect:/con/show";
    }
    @RequestMapping("/del/{id}")
    public String del(@PathVariable String id){
        service.del(id);
        return "redirect:/con/show";
    }

}
