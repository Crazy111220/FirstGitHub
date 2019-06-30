<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/con/add" method="post" style="text-align: center">
    <table align="center" border="1" cellspacing="0" cellpadding="10">
        <tr>
            <td colspan="2" bgcolor="#00bfff" style="size: 30px">增加评论</td>
        </tr>
        <tr>
            <td>评论内容</td>
            <td><textarea name="content"cols="30" rows="10"></textarea></td>
        </tr>
        <tr>
            <td>评论人</td>
            <td><input type="text" name="autor"></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="hidden" name="newid" value="${id}">
                <input type="hidden" name="createdate">
                <input type="submit" value="提交">
                <input type="button" value="返回" onclick="goback()">
            </td>
        </tr>
    </table>
</form>
</body>
<script>
    function goback() {
        location.href="/"
    }
</script>
</html>
