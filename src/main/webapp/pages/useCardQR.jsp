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

	<img id="barcode" />

	<div id="qrcode"></div>

	<script src="<%=basePath%>/dist/lib/jquery-2.1.4.js"></script>
	<script src="<%=basePath%>/dist/lib/fastclick.js"></script>
	<script src="<%=basePath%>/dist/js/jquery-weui.js"></script>
	<script src="<%=basePath%>/dist/js/swiper.min.js"></script>
	<script src="<%=basePath%>/pages/js/JsBarcode.all.js"></script>
	<script src="<%=basePath%>/pages/js/qrcode.min.js"></script>

	<script type="text/javascript">
	var barCodeRepeat = function(){
		JsBarcode("#barcode", Math.floor(1000000+Math.random()*9000000)+"",{displayValue:true,fontSize:20});
	};
	setInterval(barCodeRepeat,10000);
	barCodeRepeat();
	
	var qrcode = new QRCode(document.getElementById("qrcode"), {
		text : Math.floor(1000000+Math.random()*9000000)+"",
		width : 128,
		height : 128,
		colorDark : "#000000",
		colorLight : "#ffffff",
		correctLevel : QRCode.CorrectLevel.H
	});
	
	
	</script>

	<script>
		$(function() {
			FastClick.attach(document.body);
			$(".swiper-container").swiper({
				loop : true,
				autoplay : 3000
			});

			//LOADING
			$("#pre-loader").fadeOut();
			$('#pre-loader').delay(0).fadeOut('slow');
		});
	</script>

</body>

</html>
