<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- 登录 注册 购物车... -->
<div class="container-fluid">
	<div class="col-md-4">
		<img src="img/logo2.png" />
	</div>
	<div class="col-md-5">
		<img src="img/header.png" />
	</div>
	<div class="col-md-3" style="padding-top:20px">
		<ol class="list-inline">
			<li><a href="login.jsp">登录</a></li>
			<li><a href="register.jsp">注册</a></li>
			<li><a href="cart.jsp">购物车</a></li>
			<li><a href="order_list.jsp">我的订单</a></li>
		</ol>
	</div>
</div>

<!-- 导航条 -->
<div class="container-fluid">
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">首页</a>
			</div>

			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active"><a href="product_list.htm">手机数码<span class="sr-only">(current)</span></a></li>
					<li><a href="#">电脑办公</a></li>
					<li><a href="#">电脑办公</a></li>
					<li><a href="#">电脑办公</a></li>
				</ul>
				<form class="navbar-form navbar-right" role="search">
					<div class="form-group" style="position: relative">
						<input type="text" class="form-control" placeholder="Search" onkeyup="searchWord(this)" id="search"/>
                        <div id="showDiv" style="display: none; background: #fff; position: absolute; z-index:1000;width: 200px; border: 1px solid #ccc">

                        </div>
					</div>
					<button type="submit" class="btn btn-default">Submit</button>

				</form>

                <script type="text/javascript">
                    
                    //鼠标进入商品名称时
                    function overFn(obj) {
                        $(obj).css("background","#DBEAF9");
                    }
                    //鼠标移出商品名称时
                    function outFn(obj) {
                        $(obj).css("background","#fff");
                    }
                    //鼠标点击商品名称时，将该名称显示在搜索框中
                    function clickFn(obj) {
                        $("#search").val($(obj).html());
                        $("#showDiv").css("display","none");

                    }
            
                    //查找商品方法 -- 当键盘松起时
                    function searchWord(obj) {
                        //1.获得输入框的内容
                        var word = $(obj).val();
                        //2.将获得的内容发送到服务器数据库进行模糊查询 -- 使用ajax
                        $.post(
                            "${pageContext.request.contextPath}/searchWord",
                            {"word":word},
                            function (data) {
                                //data = [{xiaomi},{huawei},....]
                                var content = "";
                                //有数据返回时，拼接字符串并显示
                                if (data.length > 0){
                                    for(var i = 0; i < data.length; i++){
                                        content += "<div style='padding: 5px; cursor: pointer' onmouseover='overFn(this)' onmouseout='outFn(this)' onclick='clickFn(this)'>"+data[i]+"</div>";        //拼接字符串
                                    }
                                    $("#showDiv").html(content);
                                    $("#showDiv").css("display","block");
                                }
                            },
                            "json"
                        );
                    }
                </script>

			</div>
		</div>
	</nav>
</div>