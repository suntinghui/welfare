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
<title>卡包</title>
<meta charset="utf-8">
<meta content="IE=edge" http-equiv="X-UA-Compatible">
<meta content="width=device-width, initial-scale=1, user-scalable=no" name="viewport">

<link href="<%=basePath%>/dist/lib/weui.min.css" rel="stylesheet">
<link href="<%=basePath%>/dist/css/jquery-weui.css" rel="stylesheet">
<link rel="stylesheet"href="<%=basePath%>/pages/icons/font-awesome/css/font-awesome.css">
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

	<div class="p-15">

		<c:if test="${empty list }">
			<div class="no-data">
				<img src="<%=basePath%>/pages/images/no-data.png" />
				<p>数据查询成功，暂无可用数据</p>
			</div>
		</c:if>

		<c:if test="${not empty list }">
			<c:forEach var="card" items="${list }">

				<div class="card-list-item m-b-10">
					<a href="cardPackageDetail?id=${card.id }" class="text-white">
						<img src="${card.backgroundPicUrl }" width="100%"
						class="img-card-item" />

						<div class="card-list-city">${card.cityName }</div>
						<div class="card-list-number">${card.cardNo }</div>
						<div class="card-list-mask"></div>
					</a>
				</div>

			</c:forEach>

		</c:if>


	</div>

	<script src="<%=basePath%>/dist/lib/jquery-2.1.4.js"></script>
	<script src="<%=basePath%>/dist/lib/fastclick.js"></script>
	<script src="<%=basePath%>/dist/js/jquery-weui.js"></script>

	<script>
		$(function() {
			FastClick.attach(document.body);

			//LOADING
			$("#pre-loader").fadeOut();
			$('#pre-loader').delay(0).fadeOut('slow');
		});
	</script>

</body>

</html>
