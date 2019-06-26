<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
    <script src="/js/jquery-3.3.1.min.js"></script>
    <script src="/js/jquery.form.js"></script>
</head>
<body>
<form style="text-align: center" action="/emp/update2" method="post" id="form2">
    <input type="hidden" name="number" value="${emp.number}">
    姓名：<input type="text" name="name" value="${emp.name}"><br>
    职位：<input type="text" name="job" value="${emp.job}"><br>
    直属领导：<input type="text" name="mgr" value="${emp.mgr}"><br>
    入职日期：<input type="date" name="hiredate" value="<fmt:formatDate value='${emp.hiredate}' pattern='yyyy-MM-dd'/>"><br>
    薪水：<input type="text" name="sal" value="${emp.sal}"><br>
    津贴：<input type="text" name="comm" value="${emp.comm}"><br>
    部门：<select name="deptno">
    <c:forEach var="dept" items="${depts}">
        <option value="${dept.deptno}" <c:if test="${dept.deptno == emp.deptno}">selected="true"</c:if>>${dept.dname}</option>
    </c:forEach>
</select><br>
    大头贴：<input type="file" id="us" name="mf" value="${emp.imgurl}"><br>
    <img src="" alt="" id="img2"  width="150px" height="200px"><br>
    <input type="hidden" id="hd2" name="imgurl" value="">
    <input type="submit" value="提交">

</form>
</body>
<script>
    $('#us').change(function () {
        alert(11)
        var f = {
            type:'post',
            url:'/emp2/upload',
            dataType:'json',
            success:function (data) {
                $('#img2').attr('src', data);
                $('#hd2').val(data)
            }
        };

        $('#form2').ajaxSubmit(f);
    })
</script>
</html>
