<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<%
	String cardNo = request.getParameter("cardNo");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>付款码</title>
<meta charset="utf-8">
<meta content="IE=edge" http-equiv="X-UA-Compatible">
<meta content="width=device-width, initial-scale=1, user-scalable=no"
	name="viewport">


<link href="<%=basePath%>/dist/lib/weui.min.css" rel="stylesheet">
<link href="<%=basePath%>/dist/css/jquery-weui.css" rel="stylesheet">
<link rel="stylesheet" href="<%=basePath%>/pages/icons/font-awesome/css/font-awesome.css">
<link href="<%=basePath%>/pages/css/style.css" rel="stylesheet">

</head>

<body ontouchstart>


	<div class="weui-panel weui-panel_access m-t-0">
		<div class="weui-panel__bd">
			<a href="javascript:void(0);"
				class="weui-media-box weui-media-box_appmsg">
				<div class="weui-media-box__hd">
					<img class="weui-media-box__thumb"
						src="<%=basePath%>/pages/images/img-logo-card.png" alt="">
				</div>
				<div class="weui-media-box__bd">
					<h4 class="weui-media-box__title">
						金额：<span id="amountDiv" class="text-danger">0.00 元</span>
					</h4>
					<p id="barCodeDiv" class="weui-media-box__desc"><%= cardNo %></p>
				</div>
			</a>
		</div>
	</div>
	<div class="p-10">
		<div class="weui-cells__title" id="timerDiv">有效期倒计时 60 秒</div>
		<div class="weui-progress">
			<div class="weui-progress__bar">
				<div id="progressDiv" class="weui-progress__inner-bar js_progress" style="width: 100%;"></div>
			</div>
		</div>
		<div class="text-center m-t-20">
			<img id="barcode"
				style="width: 80%; max-width: 300px; margin-top: 10px;" />

			<div id="qrcode"
				style="width: 80%; max-width: 256px; margin: 20px auto 0px auto; text-align: center;" />
		</div>

	</div>

	<script src="<%=basePath%>/dist/lib/jquery-2.1.4.js"></script>
	<script src="<%=basePath%>/dist/lib/fastclick.js"></script>
	<script src="<%=basePath%>/dist/js/jquery-weui.js"></script>
	<script src="<%=basePath%>/pages/js/JsBarcode.all.min.js"></script>
	<script src="<%=basePath%>/pages/js/qrcode.min.js"></script>

	<script>
		$(function() {
			FastClick.attach(document.body);
			
		});
	</script>

	<script type="text/javascript">
	
	refreshCode();
	
	var intervalId = 0;
	
	var timer = 60;
	var timerCount = function() {
		timer = timer - 1;
		if (timer == 0) {
			timer = 60;
			refreshCode();
		}

		$("#timerDiv").html("有效期倒计时 " + timer + " 秒");
		$("#progressDiv").width(timer / 60 * 100 + "%");
	}

	// 重新获取付款码
   	function refreshCode() {
   		$.ajax({
			type : "post",
			url : "<%=basePath%>payCode?cardNo=<%= cardNo %>",
			header:{
				"token" : "${sessionScope.kOPENID}",
			},
			data : {
			},
			dataType : "json",
			success : function(resp) {
				if (resp.respCode=='00') {
					refreshView(resp.data);
					
					window.clearInterval(intervalId);
					
					intervalId = setInterval(timerCount, 1000);
					
				} else {
					window.location.href="<%=basePath%>pages/result.jsp?respCode=01&respMsg="+resp.respMsg;
					window.clearInterval(intervalId);
				}
				
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				window.location.href="<%=basePath%>pages/result.jsp?respCode=01&respMsg=获取付款码失败，请重试";
			}

		});
	}

	// 刷新付款码
	function refreshView(payCode) {
		
		$("#amountDiv").html(payCode.amount+" 元");
		
		$("#qrcode").empty();
		
		// 条形码
		JsBarcode("#barcode", payCode.barCode, {
			width : 5,
			height : 260,
			displayValue : true,
			fontSize : 60
		});

		// 二维码
		var qrcode = new QRCode(document.getElementById("qrcode"), {
			text : payCode.barCode,
			width : 256,
			height : 256,
			colorDark : "#000000",
			colorLight : "#ffffff",
			correctLevel : QRCode.CorrectLevel.H
		});

		
	}
	</script>



</body>

</html>
