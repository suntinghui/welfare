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
  <title>操作结果</title>
  <meta charset="utf-8">
  <meta content="IE=edge" http-equiv="X-UA-Compatible">
  <meta content="width=device-width, initial-scale=1, user-scalable=no" name="viewport">


  <link href="<%=basePath%>/dist/lib/weui.min.css" rel="stylesheet">
  <link href="<%=basePath%>/dist/css/jquery-weui.css" rel="stylesheet">
  <link rel="stylesheet" href="<%=basePath%>/pages/icons/font-awesome/css/font-awesome.css">
  <link href="<%=basePath%>/pages/css/style.css" rel="stylesheet">


</head>

<body ontouchstart>
 
<c:if test="${resp.respCode=='00' }">

	<div class="weui-msg">
  <div class="weui-msg__icon-area"><i class="weui-icon-success weui-icon_msg"></i></div>
  <div class="weui-msg__text-area">
    <h2 class="weui-msg__title">${resp.respMsg }</h2>
    <p class="weui-msg__desc"></p>
  </div>
  
</div>

</c:if>

<c:if test="${resp.respCode != '00'  }">
<div class="weui-msg">
  <div class="weui-msg__icon-area"><i class="weui-icon-warn weui-icon_msg"></i></div>
  <div class="weui-msg__text-area">
    <h2 class="weui-msg__title">${resp.respMsg }</h2>
    <p class="weui-msg__desc"></p>
  </div>
  
</div>
</c:if>


<script src="<%=basePath%>/dist/lib/jquery-2.1.4.js"></script>
<script src="<%=basePath%>/dist/lib/fastclick.js"></script>
<script src="<%=basePath%>/dist/js/jquery-weui.js"></script>

<script>
    $(function () {
        FastClick.attach(document.body);

    });

</script>

</body>

</html>
