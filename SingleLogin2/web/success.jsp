<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功</title>
</head>
<body>
<h3>这是登录成功后可以访问的页面</h3>
欢迎${sessionScope.account.name}
<h2><a href="/SingleLogin2/login">注销</a></h2><%--session remove--%>

</body>
</html>
