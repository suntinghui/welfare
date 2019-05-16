<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%   
String path = request.getContextPath();   
String basePath = request.getScheme()+"://" +request.getServerName()+":" +request.getServerPort()+path+"/" ;   
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>卡包列表</title>
<meta charset="utf-8">
<meta content="IE=edge" http-equiv="X-UA-Compatible">
<meta content="width=device-width, initial-scale=1, user-scalable=no"
	name="viewport">


<link href="<%=basePath %>dist/lib/weui.min.css" rel="stylesheet">
<link href="<%=basePath %>dist/css/jquery-weui.css" rel="stylesheet">
<link rel="stylesheet" href="<%=basePath %>pages/icons/font-awesome/css/font-awesome.css">
<link href="<%=basePath %>pages/css/style.css" rel="stylesheet">


</head>

<body ontouchstart>
	<!--=================================
 preloader -->
	<div id="pre-loader">
		<img src="<%=basePath %>pages/images/pre-loader/loader-08.svg" alt="">
	</div>
	<!--=================================
 preloader -->

	<div class="p-15">
		<div class="card-list-item m-b-10">
			<a href="card-gift.html" class="text-white"> <img
				src="<%=basePath %>pages/images/img-logo-card.png" class="img-logo-card" /> <img
				src="<%=basePath %>pages/images/demo-card-01.png" width="100%" class="img-card-item" />

				<div class="card-list-city">${list.size() }</div>
				<div class="card-list-number">5409627029043820357</div>
				<div class="card-list-value">
					<small>￥</small>100
				</div>
				<div class="card-list-mask"></div>
			</a>

		</div>
		<div class="card-list-item m-b-10">
			<a href="card-gift.html" class="text-white"> <img
				src="images/img-logo-card.png" class="img-logo-card" /> <img
				src="images/demo-card-02.png" width="100%" class="img-card-item" />

				<div class="card-list-city">全国</div>
				<div class="card-list-number">5409627029043820357</div>
				<div class="card-list-value">
					<small>￥</small>100
				</div>
				<div class="card-list-mask"></div>
			</a>
		</div>
		<div class="card-list-item m-b-10">
			<a href="card-gift.html" class="text-white"> <img
				src="images/img-logo-card.png" class="img-logo-card" /> <img
				src="images/demo-card-04.png" width="100%" class="img-card-item" />

				<div class="card-list-city">全国</div>
				<div class="card-list-number">5409627029043820357</div>
				<div class="card-list-value">
					<small>￥</small>100
				</div>
				<div class="card-list-mask"></div>
			</a>

		</div>
	</div>

	<script src="<%=basePath %>/dist/lib/jquery-2.1.4.js"></script>
	<script src="<%=basePath %>/dist/lib/fastclick.js"></script>
	<script src="<%=basePath %>/dist/js/jquery-weui.js"></script>

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
