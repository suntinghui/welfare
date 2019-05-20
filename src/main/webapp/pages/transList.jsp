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
					<input class="weui-input" id="select-transType" type="text" value="请选择消费类型">
				    <input class="weui-input" id="select-transType-value" value="" type="hidden">
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

	 
	 
			 
				<div id="listContent" class="weui-form-preview">
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
			 
	 

	</div>


	<script src="<%=basePath%>/dist/lib/jquery-2.1.4.js"></script>
	<script src="<%=basePath%>/dist/lib/fastclick.js"></script>
	<script src="<%=basePath%>/dist/js/jquery-weui.js"></script>
    <script type="text/javascript" src="<%=basePath%>/pages/js/util.js"></script>
	<script>
	//选择消费类型
	 var transTypeDisplayValue;
     var transTypeValue;
	    function LoadtransTypeDic(){
	    	transTypeDisplayValue = new Array();
	    	transTypeValue = new Array();
	    	$.ajax({
	            url: '<%=basePath%>/getTypeTrans',
	            async: false,
	            dataType: 'json',
	            type: 'POST',
	            data: '',
	            success: function(data , textStatus){
	              console.log("success");
	             /*  for(var i=0;i<data.length;i++){
	            	  var city=data[i];
	            	  cityDisplayValue.push(city.city);
	          		  cityValue.push(city.jv);
	              } */
	              for (var propKey in data) {
	            	  transTypeValue.push(propKey);
	            	  transTypeDisplayValue.push(data[propKey]);
	              }
	            },
	            error: function(jqXHR , textStatus , errorThrown){
	              console.log("error");
	            },
	        });
	    }
	   
	     var itemTemp='<a href="transDetail?detail=">';
	     itemTemp+='<div class="weui-form-preview__hd">';
	     itemTemp+='<label class="weui-form-preview__label">消费金额</label> <emclass="weui-form-preview__value">¥{priceSale}</em></div>';
	     itemTemp+='<div class="weui-form-preview__bd">';
	     itemTemp+='<div class="weui-form-preview__item">';
	     itemTemp+='<label class="weui-form-preview__label">订单号</label> <span lass="weui-form-preview__value">{coid}</span></div>';
	     itemTemp+='<div class="weui-form-preview__item">';
	     itemTemp+='<label class="weui-form-preview__label">流水类型</label> <span class="weui-form-preview__value">{typeTransDesp}</span>';
	     itemTemp+='</div>';
	     itemTemp+='<div class="weui-form-preview__item">';
	     itemTemp+='<label class="weui-form-preview__label">添加时间</label> <span class="weui-form-preview__value">{timeAdd}</span>';
	     itemTemp+='</div>';
	     itemTemp+='</div> </a>';
	    function LoadTranList(){
	    	
	    	var transType=$("#select-transType-value").val();
	    	var startDate=$("#datetime-start").val();
	    	var endDate=$("#datetime-start").val();
	    	
	    	$.ajax({
	            url: '<%=basePath%>/getTransList',
	            dataType: 'json',
	            type: 'POST',
	            data: {transType:transType,startDate:startDate,endDate:endDate},
	            success: function(data , textStatus){
	             
				   $("#listContent").empty();
				   for(var i=0;i<data.length;i++){
					   var trans= data[i];
					   var itemStr=itemTemp.format(trans);
					   $("#listContent").append(itemStr);
				   }
	            },
	            error: function(jqXHR , textStatus , errorThrown){
	              console.log("error");
	            },
	        });
	    }
	    
		$(function() {
			FastClick.attach(document.body);

			//LOADING
			$("#pre-loader").fadeOut();
			$('#pre-loader').delay(0).fadeOut('slow');

			$("#datetime-start").calendar()
			$("#datetime-end").calendar();
			
			
		
		LoadtransTypeDic();
		//选择消费类型
		$("#select-transType").picker({
			title : "请选择消费类型",
			cols : [ {
				textAlign : 'center',
				values : transTypeDisplayValue,
			} ],
			onChange : function(p, v, dv) {
				var index = $.inArray("" + v, transTypeDisplayValue);
				$("#select-transType-value").val(transTypeValue[index]);

			},
			onClose : function(p, v, d) {

			}
		});
		 //$("#select-transType").picker("setValue",["购卡"]);-laji,meyong
		 $("#select-transType-value").val("${param.transType}");
		 LoadTranList();
			$("#btnSearch").on('click', function() {
				 
				LoadTranList();
				
			});
		});
	</script>

</body>

</html>
