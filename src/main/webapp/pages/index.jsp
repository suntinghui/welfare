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


<title>首页</title>
<meta charset="utf-8">
<meta content="IE=edge" http-equiv="X-UA-Compatible">
<meta content="width=device-width, initial-scale=1, user-scalable=no"
	name="viewport">


<link href="<%=basePath%>/dist/lib/weui.min.css" rel="stylesheet">
<link href="<%=basePath%>/dist/css/jquery-weui.css" rel="stylesheet">
<link rel="stylesheet"
	href="<%=basePath%>/pages/icons/font-awesome/css/font-awesome.css">
<link href="<%=basePath%>/pages/css/style.css" rel="stylesheet">


</head>

<body ontouchstart>

	<div class="swiper-container" data-space-between='10'
		data-pagination='.swiper-pagination' data-autoplay="1000">
		<div class="swiper-wrapper">
			<div class="swiper-slide">
				<img src="<%=basePath%>/pages/images/demo-slider-01.jpg"
					width="100%" alt="">
			</div>
			<div class="swiper-slide">
				<img src="<%=basePath%>/pages/images/demo-slider-02.jpg"
					width="100%" alt="">
			</div>
		</div>
		<div class="swiper-pagination"></div>
	</div>
	<div class="p-15">
		<a href="queryAllGoods" class="weui-btn weui-btn_warn">购卡</a>
	</div>
	<div class="weui-cells m-t-10">

		<a class="weui-cell weui-cell_access" href="promotion-list.html">
			<div class="weui-cell__hd">
				<i class="fa fa-gift text-danger p-r-5" style="font-size: 22px"></i>
			</div>
			<div class="weui-cell__bd">
				<p>正月活动</p>
			</div>
			<div class="weui-cell__ft">详情</div>
		</a> <a class="weui-cell weui-cell_access" href="card-list.html">
			<div class="weui-cell__hd">
				<i class="fa fa-credit-card text-danger p-r-5"
					style="font-size: 18px"></i>
			</div>
			<div class="weui-cell__bd">
				<p>卡包</p>
			</div>
			<div class="weui-cell__ft">详情</div>
		</a> <a class="weui-cell weui-cell_access" href="card-gift-list.html">
			<div class="weui-cell__hd">
				<i class="fa fa-heart-o text-danger p-r-5" style="font-size: 18px"></i>
			</div>
			<div class="weui-cell__bd">
				<p>转赠</p>
			</div>
			<div class="weui-cell__ft">转赠</div>
		</a> <a class="weui-cell weui-cell_access" href="showQRCode">
			<div class="weui-cell__hd">
				<i class="fa fa-user-circle-o text-danger p-r-5"
					style="font-size: 22px"></i>
			</div>
			<div class="weui-cell__bd">
				<p>我的</p>
			</div>
			<div class="weui-cell__ft">我的</div>
		</a>
	</div>


	<script src="<%=basePath%>/dist/lib/jquery-2.1.4.js"></script>
	<script src="<%=basePath%>/dist/lib/fastclick.js"></script>
	<script src="<%=basePath%>/dist/js/jquery-weui.js"></script>
	<script src="<%=basePath%>/dist/js/swiper.min.js"></script>
	<script>
		$(function() {
			FastClick.attach(document.body);
			$(".swiper-container").swiper({
				loop : true,
				autoplay : 3000
			});

		});
	</script>

</body>

</html>
