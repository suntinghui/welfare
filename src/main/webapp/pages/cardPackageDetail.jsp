<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%   
String path = request.getContextPath();   
String basePath = request.getScheme()+"://" +request.getServerName()+":" +request.getServerPort()+path+"/" ;   
%>

<html>
<head>
  <title>卡片详情</title>
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

<div class="p-15 p-b-10">
  <div class="card-list-item">
    <a href="payment-code.html">
      <img src="${detail.backgroundPicUrl }" width="100%" class="img-card-item"/>
    </a>
  </div>
</div>
<div class="p-l-15 p-r-15 p-b-30">
  <a href="useCardQR?cardNo=${detail.cardNo }" class="weui-btn weui-btn_plain-primary">立即使用</a>
</div>
<div class="weui-cells m-t-0">
  <div class="weui-cell">
    <div class="weui-cell__bd">
      <p>卡名</p>
    </div>
    <div class="weui-cell__ft text-dark">${detail.name }</div>
  </div>
  <div class="weui-cell">
    <div class="weui-cell__bd">
      <p>卡号</p>
    </div>
    
    <c:choose>
    <c:when test="${not empty detail.cardNoIntr}">
    	<div class="weui-cell__ft text-dark">${detail.cardNoIntr }</div>
    </c:when>
    <c:otherwise>
    	<div class="weui-cell__ft text-dark">${detail.cardNo }</div>
    </c:otherwise>
    </c:choose>
  </div>
  <div class="weui-cell">
    <div class="weui-cell__bd">
      <p>余额</p>
    </div>
    <div class="weui-cell__ft text-dark">${detail.balance }元</div>
  </div>
  <div class="weui-cell">
    <div class="weui-cell__bd">
      <p>有效期至</p>
    </div>
    <div class="weui-cell__ft text-dark">${detail.gp }</div>
  </div>
  <a class="weui-cell weui-cell_access" href="startCardGift">
    <div class="weui-cell__bd">
      <p>转赠</p>
    </div>
    <div class="weui-cell__ft">
    </div>
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
