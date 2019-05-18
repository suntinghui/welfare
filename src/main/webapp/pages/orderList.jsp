<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<title>我的订单</title>
<meta charset="utf-8">
<meta content="IE=edge" http-equiv="X-UA-Compatible">
<meta content="width=device-width, initial-scale=1, user-scalable=no"
	name="viewport">


<link href="<%=basePath%>/dist/lib/weui.min.css" rel="stylesheet">
<link href="<%=basePath%>/dist/css/jquery-weui.css" rel="stylesheet">
<link rel="stylesheet"
	href="<%=basePath%>/pages/icons/font-awesome/css/font-awesome.css">
<link href="<%=basePath%>/pages/css/style.css" rel="stylesheet">
<style>
body {
	background: #f1f1f1;
}
</style>

</head>

<body ontouchstart>
	<!--=================================
 preloader -->
	<div id="pre-loader">
		<img src="<%=basePath%>/pages/images/pre-loader/loader-08.svg" alt="">
	</div>
	<!--=================================
 preloader -->

	<!--<div class="no-data">-->
	<!--  <img src="images/no-data.png" />-->
	<!--  <p>暂无数据</p>-->
	<!--</div>-->

	<div class="p-15">

		<c:if test="${empty list }">
			<div class="no-data">
				<img src="<%=basePath%>/pages/images/no-data.png" />
				<p>数据查询成功，暂无可用数据</p>
			</div>

		</c:if>

		<c:if test="${not empty list }">

			<c:forEach var="order" items="${list }">

				<div class="weui-form-preview">
					<div class="weui-form-preview__hd">
						<label class="weui-form-preview__label">实付金额</label> <em
							class="weui-form-preview__value">¥${order.priceReal }</em>
					</div>
					<div class="weui-form-preview__bd">
						<div class="weui-form-preview__item">
							<label class="weui-form-preview__label">卡号</label> <span
								class="weui-form-preview__value">423423523452345</span>
						</div>
						<div class="weui-form-preview__item">
							<label class="weui-form-preview__label">订单类型</label> <span
								class="weui-form-preview__value">${order.typeDesc }</span>
						</div>
						<div class="weui-form-preview__item">
							<label class="weui-form-preview__label">下单时间</label> <span
								class="weui-form-preview__value">${order.timeAdd }</span>
						</div>
						<div class="weui-form-preview__item">
							<label class="weui-form-preview__label">订单状态</label> <span
								class="weui-form-preview__value">${order.statusDesc }</span>
						</div>
						<div class="weui-form-preview__item">
							<label class="weui-form-preview__label">开票状态</label> <span
								class="weui-form-preview__value">${order.invoiceDesc }</span>
						</div>
					</div>
					<div class="weui-form-preview__ft">
						<a id="invoice" class="weui-form-preview__btn weui-form-preview__btn_default"
							href="<%=basePath%>/pages/invoice.jsp?oid=${order.oid}">开票</a> 
						<a id="orderReturn"
							class="weui-form-preview__btn weui-form-preview__btn_primary"
							href="<%=basePath%>/pages/orderReturn.jsp">退卡</a>
					</div>
				</div>

			</c:forEach>

		</c:if>

	</div>


	<script src="<%=basePath%>/dist/lib/jquery-2.1.4.js"></script>
	<script src="<%=basePath%>/dist/lib/fastclick.js"></script>
	<script src="<%=basePath%>/dist/js/jquery-weui.js"></script>

	<script>
		$(function() {
			FastClick.attach(document.body);

			//LOADING
			$("#pre-loader").fadeOut();
			$('#pre-loader').delay(0).fadeOut('slow');

			$("#datetime-start").calendar()
			$("#datetime-end").calendar();
			
			
			
		});
	</script>

</body>

</html>
