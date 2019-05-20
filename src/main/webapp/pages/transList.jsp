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
<title>交易流水</title>
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
body {
	background: #f1f1f1;
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
	<div class="filter-bar">
		<div class="weui-cells weui-cells_form weui-flex m-t-0 text-center">
			<div class="weui-cell weui-cell_select">
				<div class="weui-cell__bd">
					<input class="weui-input" id="select-city" type="text" value="请选择城市">
				    <input class="weui-input" id="select-city-value" value="" type="hidden">
				</div>
			</div>
			<div class="weui-cell weui-flex__item">
				<input class="weui-input" type="text" id="datetime-start"
					data-toggle='date' placeholder="开始日期">
			</div>
			<div class="weui-cell weui-flex__item">
				<input class="weui-input" type="text" id="datetime-end"
					data-toggle='date' placeholder="结束日期">
			</div>
			<div class="weui-cell">
				<a id="btnSearch" href="javascrip:;"
					class="weui-btn weui-btn_mini weui-btn_default">筛选</a>
			</div>
		</div>
	</div>
	<div style="padding: 65px 15px 15px 15px;">

		<c:if test="${empty list }">

		</c:if>

		<c:if test="${not empty list }">

			<c:forEach var="trans" items="${list }">
				<div class="weui-form-preview">
					<a href="order-detail.html">
						<div class="weui-form-preview__hd">
							<label class="weui-form-preview__label">消费金额</label> <em
								class="weui-form-preview__value">¥${trans.priceSale }</em>
						</div>
						<div class="weui-form-preview__bd">
							<div class="weui-form-preview__item">
								<label class="weui-form-preview__label">订单号</label> <span
									class="weui-form-preview__value">${trans.coid }</span>
							</div>
							<div class="weui-form-preview__item">
								<label class="weui-form-preview__label">流水类型</label> <span
									class="weui-form-preview__value">${trans.typeTransDesp }</span>
							</div>
							<div class="weui-form-preview__item">
								<label class="weui-form-preview__label">添加时间</label> <span
									class="weui-form-preview__value">${trans.timeAdd }</span>
							</div>
						</div>
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

			$("#datetime-start").calendar()
			$("#datetime-end").calendar();
			
			
			//选择城市
			 var cityDisplayValue = new Array();
		var cityValue = new Array();

		<c:forEach items="${cityList}" var="city">
		<c:if test="${city.status == 1}">
		cityDisplayValue.push("${city.city}")
		cityValue.push("${city.jv}")
		</c:if>
		</c:forEach>

		//选择城市
		$("#select-city").picker({
			title : "请选择城市",
			cols : [ {
				textAlign : 'center',
				values : cityDisplayValue,
			} ],
			onChange : function(p, v, dv) {
				var index = $.inArray("" + v, cityDisplayValue);
				$("#select-city-value").val(cityValue[index]);

			},
			onClose : function(p, v, d) {

			}
		});
		
			
			$("#btnSearch").on('click', function() {
				 
				
				
			});
		});
	</script>

</body>

</html>
