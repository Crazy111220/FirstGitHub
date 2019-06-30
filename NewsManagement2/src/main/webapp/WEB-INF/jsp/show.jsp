<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>展示页面</title>
    <script src="/js/jquery-3.3.1.min.js"></script>
</head>
<body>
<h1 align="center">Eiffel_Wu新闻管理系统</h1>
<hr style="color: red">
<%--1.条件查询--%>
<form  id="myForm" action="/con/show" method="post" style="text-align: center">
    新闻标题：<input type="text" name="title" value="${page.title}">

    <input type="hidden" id="pageNum" name="currPage" value="1">
    <input type="submit" value="查询">
</form>
<%--2.数据展示--%>
<table  align="center" cellpadding="15" cellspacing="0" border="1">
    <tr align="center">
        <td colspan="6"><h3>新闻列表</h3></td>
    </tr>
    <tr bgcolor="#7b68ee">
        <td>新闻编号</td>
        <td>新闻标题</td>
        <td>新闻摘要</td>
        <td>作者</td>
        <td>创建时间</td>
        <td>操作</td>
    </tr>
    <c:if test="${not empty list}">
        <c:forEach var="news" items="${list}" varStatus="vs">
            <tr <c:if test="${vs.index % 2 == 0}">bgcolor="#00bfff"</c:if>>
                <td>${news.id}</td>
                <td>${news.title}</td>
                <td>${news.summary}</td>
                <td>${news.author}</td>
                <td><fmt:formatDate value="${news.createdate}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
                <td>
                    <a href="/con/comment/${news.id}">查看评论</a>
                    <a href="/con/add1/${news.id}">评论</a>
                    <input type="button" class="aa" value="删除" onclick="check(${news.id})">
                </td>
            </tr>
        </c:forEach>
    </c:if>
</table>
<%--3.分页--%>
<hr color="color">
<table align="center" cellpadding="10" cellspacing="10" border="1">
    <tr>
        <td><a href="javascript:goPage(1)">首页</a></td>
        <td><a href="javascript:goPage(${page.currPage-1})">上一页</a></td>
        <c:forEach var="i" begin="1" end="${page.totalPage}">
            <td><a href="javascript:goPage(${i})">${i}</a></td>
        </c:forEach>
        <td><a href="javascript:goPage(${page.currPage+1})">下一页</a></td>
        <td><a href="javascript:toPage()">跳转</a>到第<input size="2" type="text" value="${page.currPage}" id="go">页</td>
        <td><a href="javascript:goPage(${page.totalPage})">尾页</a></td>
    </tr>
</table>

<!--js部分-->
<script>
    function check(v) {
        var a = confirm("确认删除吗？")
        if(a){
            location.href="/con/del/"+ v;
        }else{
            alert("删除失败！")
            return
        }

    }

    function goPage(page) {
        var total=${page.totalPage};

        if(page>total){
            page=total;
        }
        if(page<1){
            page=1;
        }

        $("#pageNum").val(page);
        $("#myForm").submit()
    }
    function toPage() {
        var page=$("#go").val();
        goPage(page)
    }
</script>

</body>
</html>

