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
  <title>领卡</title>
  <meta charset="utf-8">
  <meta content="IE=edge" http-equiv="X-UA-Compatible">
  <meta content="width=device-width, initial-scale=1, user-scalable=no" name="viewport">


  <link href="<%=basePath%>/dist/lib/weui.min.css" rel="stylesheet">
  <link href="<%=basePath%>/dist/css/jquery-weui.css" rel="stylesheet">
  <link rel="stylesheet" href="<%=basePath%>/pages/icons/font-awesome/css/font-awesome.css">
  <link href="<%=basePath%>/pages/css/style.css" rel="stylesheet">

</head>

<body ontouchstart>
<!--=================================
 preloader -->
<div id="pre-loader">
  <img src="<%=basePath%>/pages/images/pre-loader/loader-08.svg" alt="">
</div>
<!--=================================
 preloader -->

<div class="collar-card">
  <div class="collar-card-logo">
    <img src="${detail.headimgurl }" /></div>
  <div class="user-info">
    <img src="images/avatar.jpg"/>
    <h3>${detail.mssage }</h3>
    <p>${detail.phoneFrom } 赠送的礼品卡</p>
    <div class="p-20 collar-card-buttons">
      <a href="javascript:;" onclick="receiveAction();" class="weui-btn weui-btn_plain-primary">领取礼品卡</a>
      <a href="javascript:;" class="weui-btn weui-btn_plain-primary">进入首页</a>
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
    
    function receiveAction() {
    	var url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxf8ae9d1b9f9708bc&redirect_uri=http%3A%2F%2Fwelfare.ngrok.xiaomiqiu.cn%2Fwelfare%2FselectMemberCardById%3Fid%3D26098&response_type=code&scope=snsapi_base&state=210#wechat_redirect";
    	window.location.href = url;
    }

</script>

</body>

</html>
