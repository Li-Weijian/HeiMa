<%--
  Created by IntelliJ IDEA.
  User: 35264
  Date: 2017/12/7 0007
  Time: 18:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>转账</title>
</head>
<body>
    <form action="/transfer" method="post">
        转入人：<input type="text" name="in"><br>
        转出人：<input type="text" name="out"><br>
        转账金额：<input type="text" name="money"><br>

        <input type="submit" value="转账">

    </form>

</body>
</html>
