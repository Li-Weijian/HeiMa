<%@ page import="com.liweijian.domain.User" %><%--
  Created by IntelliJ IDEA.
  User: 35264
  Date: 2017/12/4 0004
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>
    <%
        User user = new User();
        user.setId(100);
        user.setName("张三");
        user.setPassword("123");

        //将用户存入session，模拟用户已经登录成功
        session.setAttribute("user",user);
    %>


</body>
</html>
