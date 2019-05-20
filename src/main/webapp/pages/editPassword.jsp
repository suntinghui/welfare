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
				<input class="weui-input" id="Vcode" type="tel" placeholder="请输入验证码">
				<input type="hidden" id="hidVcode"/>
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
				<input class="weui-input" id="txtCardPwd" type="password" pattern="[0-9]*"
					placeholder="请输入卡包密码">
			</div>
		</div>
		<div class="weui-cell">
			<div class="weui-cell__hd">
				<label class="weui-label">确认卡包密码</label>
			</div>
			<div class="weui-cell__bd">
				<input class="weui-input" id="txtCardConfirmPwd" type="password" pattern="[0-9]*"
					placeholder="请再次输入卡包密码">
			</div>
		</div>
	</div>
	<div class="p-15">
		<a href="javascript:;" class="weui-btn weui-btn_warn btn-submit weui-btn_disabled"
			id="okBtn">确定</a>
	</div>


	<script src="<%=basePath%>/dist/lib/jquery-2.1.4.js"></script>
	<script src="<%=basePath%>/dist/lib/fastclick.js"></script>
	<script src="<%=basePath%>/dist/js/jquery-weui.js"></script>
    <script type="text/javascript" src="<%=basePath%>/pages/js/util.js"></script>
	<script>
    $(function () {
        FastClick.attach(document.body);
        //LOADING
        $("#pre-loader").fadeOut();
        $('#pre-loader').delay(0).fadeOut('slow');
        
        
    	$("#okBtn").click(function() {
    		if($(this).hasClass('weui-btn_disabled'))
    				return;
			/* $.toast("修改成功", "", function() {
				window.location.href = "";
			}); */
			
			var pars=Validate();
			if(pars){
				$.ajax({
    	            url: '<%=basePath%>editPackagePwd',
    	            async: false,
    	            dataType: 'json',
    	            type: 'POST',
    	            data: pars,
    	            success: function(data , textStatus){
    	              console.log("success");
    	              if(data.respCode=="00"){
    	            	  $.toast("修改成功");
    	              }else{
    	            	  $.toast(data.respMsg);
    	              }
    	            },
    	            error: function(jqXHR , textStatus , errorThrown){
    	              console.log("error");
    	            }
    	        });
			}

		});
    	
    	 $("#getVerifyBtn").click(function(){
    	    	var phoneNum = $("#phoneInput").val();
    	    	if(isEmpty(phoneNum))
    	   		{
    	    		$.toast("请输入手机号");
    	    		return;
    	   		}
    	   	
    	    	if (phoneNum.length < 11) {
    	    		$.toast("手机号长度必须 是11位");
    	    		return;
    	    	}
    	    	
    	    	$.ajax({
    				type:"POST",
    				url:"<%=basePath%>getVerifyCode",
    				data : {token:"oaPc35wLEs7uj_NtmbDf0gLn8UpY","phoneNumbers":phoneNum},
    					dataType : "json",
    					success : function(data) {
    						//alert(data)
    						if(data.respCode=="00"){
    							$("#hidVcode").val(data.respCode);
    							$("#okBtn").removeClass("weui-btn_disabled");
    						}else{
    							
    							$.toast(data.respMsg);
    						}
    					},
    					error : function(XMLHttpRequest, textStatus, errorThrown) {
    						alert(XMLHttpRequest.status);
    	                    alert(XMLHttpRequest.readyState);
    	                    alert(textStatus);

    					}

    				});

    			});

    });
    
    function Validate(){
    	var phone = $("#phoneInput").val();
    	if(isEmpty(phone))
   		{
    		$.toast("请输入手机号");
    		return false;
   		}
    	var Vcode=$("#Vcode").val();
    	if(isEmpty(Vcode)){
    		$.toast("请输入验证码");
    		return false;
    	}
    	/* var hidVcode=$("#hidVcode").val();
    	if(Vcode!=hidVcode){
    		$.toast("验证码错误！");
    		return false;
    	} */
    	var cardPwd=$("#txtCardPwd").val();
    	if(isEmpty(cardPwd)){
    		$.toast("请输入卡包密码");
    		return false;
    	}
    	var confirmPwd=$("#txtCardConfirmPwd").val();
    	if(isEmpty(confirmPwd)){
    		$.toast("请输入确认密码");
    		return false;
    	}
    	if(cardPwd!=confirmPwd){
    		$.toast("两次密码不一致");
    		return false;
    	}
    	return {code:Vcode,phoneNumber:phone,pwd:cardPwd};
    }
    
   
	</script>

</body>

</html>
