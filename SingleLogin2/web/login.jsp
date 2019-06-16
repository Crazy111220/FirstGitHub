<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>
<form action="/SingleLogin2/login" method="post">
    姓名：<input type="text" name="name"><br>
    密码：<input type="password" name="psw"><br>
    记住我：<input type="checkbox" name="remember" value="1"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
