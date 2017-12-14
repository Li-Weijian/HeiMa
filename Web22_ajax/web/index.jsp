<%--
  Created by IntelliJ IDEA.
  User: 35264
  Date: 2017/12/12 0012
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>

    <script type="text/javascript">
        function f1() {
            //1.创建ajax引擎对象
            var xmlHttp = new XMLHttpRequest();
            //2.创建监听
            xmlHttp.onreadystatechange = function () {
                if (xmlHttp.status == 200 && xmlHttp.readyState == 4){
                    //5.接收数据
                    var res = xmlHttp.responseText;
                    document.getElementById("mySpan1").innerHTML = res;
                }
            };
            //3.绑定提交地址
            xmlHttp.open("GET","/ajaxServlet", true);
            //4.发送请求
            xmlHttp.send();
        }

        function f2() {
            //1.创建ajax引擎对象
            var xmlHttp = new XMLHttpRequest();
            //2.创建监听
            xmlHttp.onreadystatechange = function () {
                if (xmlHttp.status == 200 && xmlHttp.readyState == 4){
                    //5.接收数据
                    var res = xmlHttp.responseText;
                    document.getElementById("mySpan2").innerHTML = res;
                }
            };
            //3.绑定提交地址
            xmlHttp.open("GET","/ajaxServlet", false);
            //4.发送请求
            xmlHttp.send();
        }
        
    </script>
  </head>
  <body>
      <input type="button" value="异步请求" onclick="f1()"><span id="mySpan1"></span>
      <br>
      <input type="button" value="同步请求" onclick="f2()"><span id="mySpan2"></span>
      <br>
      <input type="button" value="测试" onclick="alert()">
  </body>
</html>
