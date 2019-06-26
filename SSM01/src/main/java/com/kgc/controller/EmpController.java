
package com.kgc.controller;

import com.kgc.pojo.Dept2;
import com.kgc.pojo.Emp;
import com.kgc.pojo.pageBean;
import com.kgc.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    private IEmpService service;

@RequestMapping("/show")
    public ModelAndView show(pageBean page, ModelAndView mav){
        //取 调 存
        //模糊分页条件查询员工
        List<Emp> list = service.show(page);
        //查询所有的部门——show.jsp中下拉框显示所有的部门
        List<Dept2> depts = service.selectDepts();

        mav.addObject("list",list);
        mav.addObject("depts",depts);
        mav.addObject("page",page);

        mav.setViewName("show");
        return mav;
    }

    @RequestMapping("/deleteById/{number}")
    public String deleteById(@PathVariable String number){
        int i = service.deleteById(Integer.parseInt(number));
        return "redirect:/emp/show";//去show方法重查
    }
//页面跳转
    @RequestMapping("/add1")
    public String add1(Model model){
        List<Dept2> depts = service.selectDepts();
        model.addAttribute("depts",depts);
        return "add";
    }
    //实现新增
    @RequestMapping("add2")
    public String add2(Emp emp){
        int i = service.addEmp(emp);
        return "redirect:/emp/show";
    }

    // 1.查询单条 2.页面跳转
    @RequestMapping("update1/{number}")
    public String update1(@PathVariable String number, Model model){
        Emp emp = service.selectById(Integer.parseInt(number));
        model.addAttribute("emp",emp);
        List<Dept2> depts = service.selectDepts();
        model.addAttribute("depts",depts);
        return "update";
    }

    @RequestMapping("update2")
    public String update2(Emp emp){
        int i = service.updateEmp(emp);
        return "redirect:/emp/show";
    }


}

