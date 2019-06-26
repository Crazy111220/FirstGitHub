package com.kgc.controller;

import com.alibaba.fastjson.JSON;
import com.kgc.service.IEmpService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.UUID;

@Controller
@RequestMapping("/emp2")
public class Controller2 {
    @Autowired
    private IEmpService service;

    //处理图片上传
    @RequestMapping("/upload")
    @ResponseBody
    public String upload(MultipartFile mf, HttpSession session){
        /*
        *1.图片上传放在哪里？服务器路径
         */
        String realPath = session.getServletContext().getRealPath("/imgs");
        System.out.println(realPath);
        //2.获取图片的名称
        String fname = mf.getOriginalFilename();
        //3.加上唯一的前缀
        fname=System.currentTimeMillis() + UUID.randomUUID().toString() + fname;
        //4.开始上传
        try{
            File f = new File(realPath,fname);
            if(!f.exists()){
                f.mkdirs();
            }
            mf.transferTo(f);//上传
        }catch(Exception e ){
            System.out.println("图片上传失败");
            System.out.println(e.getMessage());
        }

       /* JSONObject json = new JSONObject();//map-->json格式
        JSONArray objects = new JSONArray();//list-->json格式*/

        session.setAttribute("imgurl","/imgs/" + fname);

        //5.上传成功，响应图片在服务器中的路径

        return JSON.toJSONString("/imgs/" + fname);
    }

    //实现图片下载
    @RequestMapping("/down")
    public void down(String fname, HttpSession session, HttpServletResponse response) throws IOException {

        try{//1.先找到图片的位置
            String realPath = session.getServletContext().getRealPath("/imgs");

            //fname="/imgs/1561458096642a4e062d7-d3c8-449a-9d39-7c046f5a530a景甜.jpg"
            fname=fname.substring(5);
            System.out.println(realPath + fname);
            fname = new String(fname.getBytes("UTF-8"),"ISO-8859-1");//处理图片中文乱码
            //一个头两个流
            response.setHeader("content-disposition","attachment;filename="+fname);
            FileInputStream is = new FileInputStream(realPath + fname);
            ServletOutputStream os = response.getOutputStream();
            IOUtils.copy(is,os);

        }catch(Exception e){//图片下载异常，重定向去首页
            System.out.println("出错了");
            response.sendRedirect("/");
        }
    }
    @RequestMapping("/batDel")
    @ResponseBody//回调函数不起作用
    public void batDel(Integer[] ids){
        System.out.println(Arrays.toString(ids));
        service.batDel(ids);
    }


}
