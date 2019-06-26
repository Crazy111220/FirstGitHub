<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <%--1.script不能简写为单表签
    2.jequery.from需要jquery的支持，放后面--%>
    <script src="/js/jquery-3.3.1.min.js"></script>
    <script src="/js/jquery.form.js"></script>
</head>
<body>
<form  id="form1" style="text-align: center" action="/emp/add2" method="post">

    姓名：<input type="text" name="name"><br>
    职位：<input type="text" name="job"><br>
    直属领导：<input type="text" name="mgr"><br>
    入职日期：<input type="date" name="hiredate"><br>
    薪水：<input type="text" name="sal"><br>
    津贴：<input type="text" name="comm"><br>
    部门：<select name="deptno">
                <c:forEach var="dept" items="${depts}">
                    <option value="${dept.deptno}">${dept.dname}</option>
                </c:forEach>

            </select><br>
    大头贴：<input type="file" id="up" name="mf"><br>
    <img  id="img1" src="" alt=""  width="150px" height="200px"><br>
    <input type="hidden" id="hd" name="imgurl" value="">
    <input type="submit" value="提交">

</form>

</body>
<script>
    
    $('#up').change(function () {

        var f = {
            type:'post',
            url:'/emp2/upload',
            dataType:'json',
            success:function (data) {
                $('#img1').attr('src',data);
                $('#hd').val(data)
            }
        };

        $('#form1').ajaxSubmit(f)// 表单异步提交
    });
    
</script>
</html>
