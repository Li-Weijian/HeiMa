<%@ page import="com.liweijian.domain.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: 35264
  Date: 2017/12/3 0003
  Time: 22:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>elJsp</title>
</head>
<body>

<!-- 模拟域中的数据 -->
<%
    pageContext.setAttribute("company", "传智播客");

    //存储字符串
    request.setAttribute("company", "黑马程序员");

    //存储一个对象
    User user = new User();
    user.setId(1);
    user.setName("zhangsan");
    user.setPassword("123");
    session.setAttribute("user", user);

    //存储一个集合
    List<User> list = new ArrayList<User>();
    User user1 = new User();
    user1.setId(2);
    user1.setName("lisi");
    user1.setPassword("123");
    list.add(user1);
    User user2 = new User();
    user2.setId(3);
    user2.setName("wangwu");
    user2.setPassword("123");
    list.add(user2);
    application.setAttribute("list", list);

%>


<!-- 脚本法取出域中的值 -->
<%=request.getAttribute("company") %>
<%
    User sessionUser = (User)session.getAttribute("user");
    out.write(sessionUser.getName());
%>
<hr/>
<!-- 使用EL表达式获得域中的值 -->
${requestScope.company }
${sessionScope.user.name }
${applicationScope.list[1].name}

<!-- 使用el表达式 全域查找 -->
${company }
${user.name }
${list[1].name}

</body>
</html>
