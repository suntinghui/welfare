<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ page import="com.welfare.client.Constants"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>修改密码</title>
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
.weui-vcode-btn {
	line-height: 24px;
}

.weui-vcode-btn, .weui-vcode-img {
	height: 24px;
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

	<div class="weui-cells weui-cells_form m-t-0">
		<div class="weui-cell">
			<div class="weui-cell__hd">
				<label class="weui-label">手机号</label>
			</div>
			<div class="weui-cell__bd">
				<input id="phoneInput" class="weui-input" type="tel"
					pattern="[0-9]*" maxlength="11" placeholder="请输入手机号">
			</div>
		</div>
		<div class="weui-cell weui-cell_vcode">
			<div class="weui-cell__hd">
				<label class="weui-label">验证码</label>
			</div>
			<div class="weui-cell__bd">
				<input class="weui-input" type="tel" placeholder="请输入验证码">
			</div>
			<div class="weui-cell__ft">
				<button id="getVerifyBtn" class="weui-vcode-btn">获取验证码</button>
			</div>
		</div>
		<div class="weui-cell">
			<div class="weui-cell__hd">
				<label class="weui-label">卡包密码</label>
			</div>
			<div class="weui-cell__bd">
				<input class="weui-input" type="password" pattern="[0-9]*"
					placeholder="请输入卡包密码">
			</div>
		</div>
		<div class="weui-cell">
			<div class="weui-cell__hd">
				<label class="weui-label">确认卡包密码</label>
			</div>
			<div class="weui-cell__bd">
				<input class="weui-input" type="password" pattern="[0-9]*"
					placeholder="请再次输入卡包密码">
			</div>
		</div>
	</div>
	<div class="p-15">
		<a href="javascript:;" class="weui-btn weui-btn_warn btn-submit"
			id="okBtn">确定</a>
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
    
    
    $("#getVerifyBtn").click(function(){
    	var phone = $("#phoneInput").val();
    	if (phone.length < 11) {
    		$.toast("手机号长度必须 是11位");
    		return;
    	}
    	
    	$.ajax({
			type:"post",
			url:"<%=Constants.SERVER_HOST%>/member/getVerifyCode/",
			 headers:{
			        "token":"<%=Constants.OPENID%>"
				},
				data : {
					"phoneNumbers" : phone
				},
				dataType : "json",
				contentType : "application/json; charset=utf-8",
				success : function(data) {
					alert(data)
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					alert(XMLHttpRequest.status);
                    alert(XMLHttpRequest.readyState);
                    alert(textStatus);

				}

			});

		});

		$("#okBtn").click(function() {
			$.toast("修改成功", "", function() {
				window.location.href = "";
			});

		});
	</script>

</body>

</html>
