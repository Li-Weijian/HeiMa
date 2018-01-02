<%--
  Created by IntelliJ IDEA.
  User: 35264
  Date: 2018/1/2 0002
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>文件上传</title>
  </head>
  <body>
  <form name="filename" method="post" action="/fileUpload" enctype="multipart/form-data">
      <input name="username" type="text">
      <input type="file" name="filename">
      <input type="submit" value="上传文件">
  </form>
  </body>
</html>
