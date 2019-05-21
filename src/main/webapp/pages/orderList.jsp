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
<title>我的订单</title>
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

	<div class="p-15">

		<c:if test="${empty list }">
			<div class="no-data">
				<img src="<%=basePath%>/pages/images/no-data.png" />
				<p>数据查询成功，暂无可用数据</p>
			</div>

		</c:if>

		<c:if test="${not empty list }">

			<c:forEach var="order" items="${list }">

				<div class="weui-form-preview" isInvoice="${order.isInvoice}" status="${order.status}">
					<div class="weui-form-preview__hd">
						<label class="weui-form-preview__label">实付金额</label> <em
							class="weui-form-preview__value">¥${order.priceReal }</em>
					</div>
					<div class="weui-form-preview__bd">
						<div class="weui-form-preview__item">
							<label class="weui-form-preview__label">订单号</label> <span
								class="weui-form-preview__value">${order.oid }</span>
						</div>
						<div class="weui-form-preview__item">
							<label class="weui-form-preview__label">订单类型</label> <span
								class="weui-form-preview__value">${order.typeDesc }</span>
						</div>
						<div class="weui-form-preview__item">
							<label class="weui-form-preview__label">下单时间</label> <span
								class="weui-form-preview__value">${order.timeAdd }</span>
						</div>
						<div class="weui-form-preview__item">
							<label class="weui-form-preview__label">支付时间</label> <span
								class="weui-form-preview__value">${order.timePay }</span>
						</div>
						<div class="weui-form-preview__item">
							<label class="weui-form-preview__label">订单状态</label> <span
								class="weui-form-preview__value">${order.statusDesc }</span>
						</div>
						<div class="weui-form-preview__item">
							<label class="weui-form-preview__label">开票状态</label> <span
								class="weui-form-preview__value">${order.invoiceDesc }</span>
						</div>
					</div>
					<div class="weui-form-preview__ft">
						<a dataFiled="btn_invoice" style="display:none;" onclick="invoice(this,'${order.oid}')"  class="weui-form-preview__btn weui-form-preview__btn_default"
							>开票</a> 
						<a dataFiled="btn_orderReturn"  style="display:none;"
							class="weui-form-preview__btn weui-form-preview__btn_default"
							onclick="orderReturn(this,'${order.oid}')" >退卡</a>
					</div>
				</div>

			</c:forEach>

		</c:if>

	</div>


	<script src="<%=basePath%>/dist/lib/jquery-2.1.4.js"></script>
	<script src="<%=basePath%>/dist/lib/fastclick.js"></script>
	<script src="<%=basePath%>/dist/js/jquery-weui.js"></script>

	<script>
	    function invoice(obj,oid){
	    	if($(obj).hasClass('weui-btn_disabled'))
	    		return;
	    	window.location.href ="<%=basePath%>/pages/invoice.jsp?oid="+oid;
	    }
	    function orderReturn(obj,oid){
	    	if($(obj).hasClass('weui-btn_disabled'))
	    		return;
	    	window.location.href ="<%=basePath%>/pages/orderReturn.jsp?oid="+oid;
	    }
		$(function() {
			FastClick.attach(document.body);

			

			$("#datetime-start").calendar()
			$("#datetime-end").calendar();
			
			 InitBtnStatus=function(){
				 $(".weui-form-preview").each(function (i) {
					 //是否已开发票0：未开 1：审核中 2：已开；
	                 var isInvoice= $(this).attr("isInvoice");
					 //订单状态： 1：未完成-待支付 2：已完成 3：支付超时状态
	                 var status= $(this).attr("status");
	                 var btn_invoice=$(this).find("[dataFiled=btn_invoice]");
					 var btn_orderReturn=$(this).find("[dataFiled=btn_orderReturn]");
					 btn_invoice.show();
	                  if(status=='2'){
	                	  btn_orderReturn.removeClass("weui-btn_disabled");
	                	  btn_orderReturn.show();
	                	  if(isInvoice=='0'){
	 	                	 btn_invoice.show();
	 	                	 btn_invoice.removeClass("weui-btn_disabled");
	 	                  }
	                  }
	             }
	            );
			 };
			 InitBtnStatus();
		});
	</script>

</body>

</html>
