<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增页面</title>
</head>
<body>
<h3 align="center">修改信息</h3>
<form action="/Test2/update?id=${sessionScope.user.id}" method="post" style="text-align: center">
    账户编号：<input type="text" name="num" value="${sessionScope.user.num}"><br><br>
    姓&ensp;&ensp;名：<input type="text" name="name" value="${sessionScope.user.name}"><br><br>
    详细地址：<input type="text" name="addr" value="${sessionScope.user.addr}"><br><br>
    卡&ensp;&ensp;种：<select name="cards_id">
                <option value="O">请选择</option>
                <c:forEach var="card" items="${sessionScope.cards}">
                    <option value="${card.card_id}" <c:if test="${card.card_id == sessionScope.user.cards_id}">selected="selected"</c:if>>${card.card_name}</option>
                </c:forEach>
            </select><br><br>
    <input type="submit" value="修改">&ensp;
    <input type="reset" value="重置">
</form>

</body>
</html>
