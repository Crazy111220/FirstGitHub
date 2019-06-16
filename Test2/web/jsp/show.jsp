<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
<h1 align="center">用户数据列表</h1>

<%--条件查询部分--%>
<form action="/Test2/show" method="post" style="text-align: center">
    卡种分类：<select name="cards_id">
    <option value="0">全选</option>
    <c:forEach var="card" items="${sessionScope.cards}">
        <option value="${card.card_id}" <c:if test="${card.card_id == sessionScope.page.cards_id}">selected="selected"</c:if>>${card.card_name}</option>
    </c:forEach>
</select>&ensp;
    姓名：<input type="text" id="nameid" name="name" size="4" value="${sessionScope.page.name}">&ensp;
    <input type="submit" value="查询">&ensp;
    <a href="/Test2/jsp/add.jsp">添加账户</a>
    
</form>
<hr>
<%--页面展示部分--%>
<table border="1" cellpadding="15" cellspacing="0" align="center">
    <tr>
        <td>账号编号</td>
        <td>姓名</td>
        <td>详细地址</td>
        <td>开户日期</td>
        <td>卡种</td>
        <td colspan="2" align="center">操作</td>

    </tr>
    <c:forEach var="user" items="${sessionScope.list}">
        <tr>
            <td>${user.num}</td>
            <td>${user.name}</td>
            <td>${user.addr}</td>
            <td>${user.create_date}</td>
            <td>${user.card.card_name}</td>
            <td><a href="/Test2/del?id=${user.id}">删除</a></td>
            <td><a href="/Test2/update?id=${user.id}">修改</a></td>
        </tr>
    </c:forEach>

</table>
<hr>
<%--分页部分--%>
<table border="1" cellpadding="15" cellspacing="0" align="center">
    <tr>
        <td><a href="javascript:goPage(1)">首页</a></td>
        <td><a href="javascript:goPage(${sessionScope.page.currPage - 1})">上一页</a></td>
        <c:forEach var="i" begin="1" end="${sessionScope.page.totalPage}">
            <td><a href="javascript:goPage(${i})">${i}</a></td>
        </c:forEach>
        <td><a href="javascript:goPage(${sessionScope.page.currPage + 1})">下一页</a></td>
        <td><a href="javascript:goPage(${sessionScope.page.totalPage})">尾页</a></td>
        <td>跳转到<input type="text" value="${sessionScope.page.currPage}" size="1">页
            <input type="button" value="GO" onclick="goPage(this.previousElementSibling.value)"></td>
    </tr>
</table>

</body>
<script>
    function goPage(pageNo) {
        var totalPage = ${sessionScope.page.totalPage}
        if(pageNo > totalPage){
            pageNo = totalPage
        }
        if(pageNo < 1){
            pageNo = 1
        }
        location.href="/Test2/show?currPage=" + pageNo;

    }
//双击清空
        var nameid = document.getElementById('nameid')
        nameid.ondblclick = function () {
            this.value = "";
        }


</script>
</html>
