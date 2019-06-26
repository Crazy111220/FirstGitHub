<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
    <script src="/js/jquery-3.3.1.min.js"></script>
</head>
<body>
<%--条件查询部分--%>
<form id="myForm" action="/emp/show" method="post" style="text-align: center">
    姓名：<input type="text" name="name" value="${page.name}">
    入职日期：<input type="date" name="startHiredate" value="<fmt:formatDate
value='${page.startHiredate}' pattern='yyyy-MM-dd'/>" >-
    <input type="date" name="endHiredate" value="<fmt:formatDate value='${page.endHiredate}'
pattern='yyyy-MM-dd'/>">
    部门：<select name="deptno" >
    <option value="0">--请选择--</option>
    <c:forEach var="dept" items="${depts}">
        <option value="${dept.deptno}"
                <c:if test="${dept.deptno==page.deptno}">selected=true</c:if>
        >${dept.dname}</option>
    </c:forEach>
</select>
    <input type="hidden" id="pageNum" name="currPage" value="1">
    <input type="submit" value="搜索">
</form>
<%--页面展示部分--%>
<table align="center" cellpadding="15" cellspacing="0" border="1">
<tr>
    <td><input type="checkbox" id="checkAll">全选</td>
    <td>编号</td>
    <td>姓名</td>
    <td>职位</td>
    <td>直属领导</td>
    <td>入职日期</td>
    <td>薪水</td>
    <td>津贴</td>
    <td>部门</td>
    <td>大头贴</td>
    <td><input type="button" id="batchDel" value="批量删除"> | <input type="button" value="新增" onclick="location.href='/emp/add1'"></td>
</tr>
<c:if test="${not empty list}">
    <c:forEach var="emp" items="${list}">
        <tr>
            <td><input type="checkbox" class="checkNow" value="${emp.number}"></td>
            <td>${emp.number}</td>
            <td>${emp.name}</td>
            <td>${emp.job}</td>
            <td>${emp.mgr}</td>
            <td><fmt:formatDate value="${emp.hiredate}" pattern="yyyy-MM-dd"/></td>
            <td>${emp.sal}</td>
            <td>${emp.comm}</td>
            <td>${emp.dept2.dname}</td>
            <td><a href="/emp2/down?fname=${emp.imgurl}"><img src="${emp.imgurl}" width="100px" height="150px" ></a></td>
            <td><a href="/emp/deleteById/${emp.number}">删除</a>
                <a href="/emp/update1/${emp.number}">修改</a></td>
        </tr>
    </c:forEach>
</c:if>
</table>
<%--分页部分--%>
<table align="center" cellpadding="10" cellspacing="10" border="1">
    <tr>
        <td><a href="javascript:goPage(1)">首页</a></td>
        <td><a href="javascript:goPage(${page.currPage-1})">上一页</a></td>
        <c:forEach var="i" begin="1" end="${page.totalPage}">
            <td><a href="javascript:goPage(${i})">${i}</a></td>
        </c:forEach>
        <td><a href="javascript:goPage(${page.currPage+1})">下一页</a></td>
        <td>跳转到第<input size="2" type="text" value="${page.currPage}">页<input type="button" value="GO" onclick="goPage(this.previousElementSibling.value)"></td>
        <td><a href="javascript:goPage(${page.totalPage})">尾页</a></td>
    </tr>
</table>
<!--js部分-->
<script>
    $('#batchDel').click(function () {
        // 1.获取到选中的ids
        var ids = new Array();
        $(".checkNow:checked").each(function () {
            var number = $(this).val();
            ids.push(number);
        });
        // 2.使用ajax异步请求，将参数ids数组送到后台
        if(ids.length){
        $.post("/emp2/batDel",{ids:ids.toString()},function (data) {
            location.href="/";
        });
        }
    });

    // 实现全选和全不选
    $('#checkAll').click(function () {
        if($(this).prop("checked")){
            $('.checkNow').prop("checked",true)
        } else {
            $('.checkNow').prop("checked",false)
        }
    })


    function goPage(pageNo) {
        var totalPage = ${page.totalPage}
        if(pageNo > totalPage){
            pageNo = totalPage;
        }
        if(pageNo < 1){
            pageNo = 1;
        }
        $("#pageNum").val(pageNo);
        $("#myForm").submit()
    }
</script>

</body>
</html>
