<%--
  Created by IntelliJ IDEA.
  User: 35264
  Date: 2017/12/4 0004
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入jstl依赖库--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>jstl测试</title>
</head>
<body>

    <%
        request.setAttribute("count",10);
    %>

    <%--一般jstl配合el进行使用--el取数据，jstl进行逻辑操作--%>
    <c:if test="${count == 10}">
        xxxxx
    </c:if>



</body>
</html>
