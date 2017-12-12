<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/css/Style1.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
<script language="javascript"
	src="${pageContext.request.contextPath}/js/public.js"></script>
<script type="text/javascript">


			function addProduct(){
				window.location.href = "${pageContext.request.contextPath}/adminAddProductUI";
			}

			//删除商品
			function delProduct (pid) {
			    var isDel = confirm("确定删除吗？");
				if (isDel){
				    //确定删除
				    window.location.href = "${pageContext.request.contextPath}/adminDelProduct?pid="+pid;
				}
            }

            //多选删除商品
            function delCheckProduct() {

			    //获取多选框的选中状态
			    product = document.getElementsByName("checkProduct");
				checkProduct = [];
				for(k in product){
				    if (product[k].checked){
						checkProduct.push(product[k].value);
					}
				}
				//alert(checkProduct);

				//删除
				var isDel = confirm("确认删除吗？");
				if (isDel){
				    //将checkProduct数组当做参数传递到servlet
				    window.location.href = "${pageContext.request.contextPath}/adminDelProductByChecked?checkProduct="+checkProduct;
				}
            }

            $(function () {
				$("#is_hot option[value='${condition.is_hot}']").prop("selected",true);
				$("#cid option[value='${condition.cid}']").prop("selected",true);
            });
            
</script>
</HEAD>

<body>
	<br>
	<form id="Form1" name="Form1" action="${pageContext.request.contextPath}/adminSearchProductList" method="post">
		商品名称：<input type="text" name="pname" value="${condition.pname}">
		商品分类: <select name="cid" id="cid">
						<option value="">--不限--</option>
						<c:forEach items="${categoryList}" var="category">
							<option value="${category.cid}">${category.cname}</option>
						</c:forEach>
				   </select>
		是否热门：<select name="is_hot" id="is_hot">
						<option value="">--不限--</option>
						<option value="1">是</option>
						<option value="0">否</option>
				  </select>
		<input type="submit" value="搜索">

		<table cellSpacing="1" style="margin-top: 10px;" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
			<TBODY>
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3" ><strong>商品列表</strong>
					</TD>
				</tr>
				<tr>
					<td class="ta_01" align="right">
						<button type="button" id="delete" name="delete" value="删除"
								class="button_add" onclick="delCheckProduct()">
							删除</button>
						<button type="button" id="add" name="add" value="添加"
							class="button_add" onclick="addProduct()">
							&#28155;&#21152;</button>

					</td>
				</tr>
				<tr>
					<td class="ta_01" align="center" bgColor="#f5fafe">
						<table cellspacing="0" cellpadding="1" rules="all"
							bordercolor="gray" border="1" id="DataGrid1"
							style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
							<tr
								style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

								<td align="center" width="18%">序号</td>
								<td align="center" width="17%">商品图片</td>
								<td align="center" width="17%">商品名称</td>
								<td align="center" width="17%">商品价格</td>
								<td align="center" width="17%">是否热门</td>
								<td width="7%" align="center">编辑</td>
								<td width="7%" align="center">删除</td>
							</tr>

							<c:forEach items="${productList}" var="product" varStatus="vs">
								<tr onmouseover="this.style.backgroundColor = 'white'"
									onmouseout="this.style.backgroundColor = '#F5FAFE';">
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="18%"><input type="checkbox" name="checkProduct" value="${product.pid}">${vs.count}</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="17%"><img width="40" height="45" src="${pageContext.request.contextPath}/${product.pimage}"></td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="17%">${product.pname}</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="17%">${product.shop_price}</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="17%">
										<c:if test="${product.is_hot}">是</c:if>
										<c:if test="${!product.is_hot}">否</c:if>
									</td>
									<td align="center" style="HEIGHT: 22px">
										<a href="${ pageContext.request.contextPath }/adminEditProductUI?pid=${product.pid}">
										<img src="${pageContext.request.contextPath}/images/i_edit.gif" border="0" style="CURSOR: hand">
										</a>
									</td>

									<td align="center" style="HEIGHT: 22px"><a href="javascript:void(0);" onclick="delProduct('${product.pid}')"> <img
											src="${pageContext.request.contextPath}/images/i_del.gif"
											width="16" height="16" border="0" style="CURSOR: hand">
									</a></td>
								</tr>

							</c:forEach>
						</table>
					</td>
				</tr>

			</TBODY>
		</table>
	</form>
</body>
</HTML>

