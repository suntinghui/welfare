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
<title>交易详情</title>
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
	<div class="p-15">
		<div class="weui-form-preview">
			<div class="weui-form-preview__hd">
				<label class="weui-form-preview__label">付款金额</label> <em
					class="weui-form-preview__value">¥2400.00</em>
			</div>
			<div class="weui-form-preview__bd">
				<div class="weui-form-preview__item">
					<label class="weui-form-preview__label">流水类型</label> <span
						class="weui-form-preview__value">退卡</span>
				</div>
				<div class="weui-form-preview__item">
					<label class="weui-form-preview__label">添加时间</label> <span
						class="weui-form-preview__value">2019-05-14 12:00:00</span>
				</div>
				<div class="weui-form-preview__item">
					<label class="weui-form-preview__label">订单号</label> <span
						class="weui-form-preview__value">343423434234234234234</span>
				</div>
				<div class="weui-form-preview__item">
					<label class="weui-form-preview__label">微信订单号</label> <span
						class="weui-form-preview__value">343423434234234234234</span>
				</div>
				<div class="weui-form-preview__item">
					<label class="weui-form-preview__label">余额</label> <span
						class="weui-form-preview__value">¥100.00</span>
				</div>
			</div>
			<div class="weui-form-preview__ft">
				<a class="weui-form-preview__btn weui-form-preview__btn_default"
					href="order-list.html">返回列表</a>
			</div>
		</div>
	</div>


	<script src="<%=basePath%>/dist/lib/jquery-2.1.4.js"></script>
	<script src="<%=basePath%>/dist/lib/fastclick.js"></script>
	<script src="<%=basePath%>/dist/js/jquery-weui.js"></script>

	<script>
    $(function () {
        FastClick.attach(document.body);


        //LOADING
        $("#pre-loader").fadeOut();
        $('#pre-loader').delay(0).fadeOut('slow');

    });


</script>

</body>

</html>
