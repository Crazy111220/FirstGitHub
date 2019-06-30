<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>查看评论</title>
</head>
<body>
<table align="center" cellspacing="0" cellpadding="10" border="1">
    <tr>
        <td colspan="4">
            <strong style="size: 40px">评论列表</strong>
            <input type="button" value="返回新闻列表" onclick="goback()">
        </td>
    </tr>
    <tr>
        <td>评论编号</td>
        <td>评论内容</td>
        <td>评论人</td>
        <td>评论时间</td>
    </tr>
    <c:if test="${not empty comments}">
        <c:forEach var="cs" items="${comments}">
            <tr>
                <td>${cs.id}</td>
                <td>${cs.content}</td>
                <td>${cs.autor}</td>
                <td>${cs.createdate}</td>
            </tr>
        </c:forEach>
    </c:if>
</table>
</body>
<script>
    function goback() {
        location.href="/";
    }
</script>
</html>
