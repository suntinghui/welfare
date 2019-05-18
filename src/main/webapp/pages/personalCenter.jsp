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
  <title>个人中心</title>
  <meta charset="utf-8">
  <meta content="IE=edge" http-equiv="X-UA-Compatible">
  <meta content="width=device-width, initial-scale=1, user-scalable=no" name="viewport">


  <link href="<%=basePath %>/dist/lib/weui.min.css" rel="stylesheet">
  <link href="<%=basePath %>/dist/css/jquery-weui.css" rel="stylesheet">
  <link rel="stylesheet" href="<%=basePath %>/pages/icons/font-awesome/css/font-awesome.css">
  <link href="<%=basePath %>/pages/css/style.css" rel="stylesheet">


</head>

<body ontouchstart>
<!--=================================
 preloader -->
<div id="pre-loader">
  <img src="<%=basePath %>/pages/images/pre-loader/loader-08.svg" alt="">
</div>
<!--=================================
 preloader -->

<div class="account-info">
  <img src="${wxuser.headimgurl }" class="account-avatar"/>
  <h3>${wxuser.nickname }</h3>
  <p>用户ID:${user.id}</p>
</div>
<div class="weui-cells m-t-0">
  <a class="weui-cell weui-cell_access" href="intoEditPwd">
    <div class="weui-cell__bd">
      <p>卡包密码</p>
    </div>
    <div class="weui-cell__ft">修改</div>
  </a>
  
  <a class="weui-cell weui-cell_access" href="transList?transType=1">
    <div class="weui-cell__bd">
      <p>交易流水</p>
    </div>
    <div class="weui-cell__ft">详情</div>
  </a>
  
  <a class="weui-cell weui-cell_access" href="queryOrderList">
    <div class="weui-cell__bd">
      <p>我的订单</p>
    </div>
    <div class="weui-cell__ft">发票、退卡</div>
  </a>

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
