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
<title>开票</title>
<meta charset="utf-8">
<meta content="IE=edge" http-equiv="X-UA-Compatible">
<meta content="width=device-width, initial-scale=1, user-scalable=no"
	name="viewport">


<link href="<%=basePath%>/dist/lib/weui.min.css" rel="stylesheet">
<link href="<%=basePath%>/dist/css/jquery-weui.css" rel="stylesheet">
<link rel="stylesheet"
	href="<%=basePath%>/pages/icons/font-awesome/css/font-awesome.css">
<link href="<%=basePath%>/pages/css/style.css" rel="stylesheet">
<link rel="stylesheet" href="<%=basePath%>/dist/lib/sweetalert/sweetalert.css">


</head>

<body ontouchstart>

 
	<div class="weui-cells weui-cells_form m-t-0">
		<input id="oid" type="hidden" value='<%=request.getParameter("oid")%>' />

		<div class="weui-cell">
			<div class="weui-cell__hd">
				<label class="weui-label">抬头</label>
			</div>
			<div class="weui-cell__bd">
				<input id="title" valisate="req" class="weui-input" type="text" placeholder="请输入抬头">
			</div>
		</div>
		<div class="weui-cell">
			<div class="weui-cell__hd">
				<label class="weui-label">税号</label>
			</div>
			<div class="weui-cell__bd">
				<input id="code" valisate="req" class="weui-input" type="text" placeholder="请输入税号">
			</div>
		</div>
	</div>
	<div class="weui-cells__title">收票人信息</div>
	<div class="weui-cells weui-cells_form m-t-0">
		<div class="weui-cell">
			<div class="weui-cell__hd">
				<label class="weui-label">姓名</label>
			</div>
			<div class="weui-cell__bd">
				<input id="name" valisate="req" class="weui-input" type="text" placeholder="请输入收件人姓名">
			</div>
		</div>
		<div class="weui-cell">
			<div class="weui-cell__hd">
				<label class="weui-label">电话</label>
			</div>
			<div class="weui-cell__bd">
				<input id="phone" valisate="req-phone" class="weui-input" type="tel" placeholder="请输入收件人电话">
			</div>
		</div>
		<div class="weui-cell">
			<div class="weui-cell__hd">
				<label class="weui-label">email</label>
			</div>
			<div class="weui-cell__bd">
				<input id="email" valisate="req-email" class="weui-input" type="text" placeholder="请输入邮件地址">
			</div>
		</div>
		<div class="weui-cell">
			<div class="weui-cell__hd">
				<label class="weui-label">所在地区</label>
			</div>
			<div class="weui-cell__bd">
				<input id="address" valisate="req" class="weui-input" type="text" placeholder="请输入收件人详细地址">
			</div>
		</div>
		<div class="weui-cell">
			<div class="weui-cell__bd">
				<textarea id="bz" valisate  class="weui-textarea" placeholder="请输入备注" rows="3"></textarea>
				<div class="weui-textarea-counter">
					<span>0</span>/200
				</div>
			</div>
		</div>
	</div>

	<div class="p-15">
		<a href="javascript:void(0);" onclick="submitAction();" class="weui-btn weui-btn_warn">提交</a>
	</div>

	<script src="<%=basePath%>/dist/lib/jquery-2.1.4.js"></script>
	<script src="<%=basePath%>/dist/lib/fastclick.js"></script>
	<script src="<%=basePath%>/dist/js/jquery-weui.js"></script>
	<script src="<%=basePath%>/dist/lib/sweetalert/sweetalert.min.js"></script>
	<script src="<%=basePath%>/pages/js/util.js" type="text/javascript"></script>

	<script>
		$(function() {
			FastClick.attach(document.body);

			
		});
	</script>
	
	<script type="text/javascript">
	    
		function submitAction() {
			var pars=DoValidate();
			if (pars) {
				pars.oid=$("#oid").val();
				$.ajax({
					url : '<%=basePath%>/invoiceAdd',
					async : false,
					dataType : 'json',
					type : 'POST',
					data : pars,
					success : function(data, textStatus) {
						 
						/* if (data.respCode == "00") {
							
						} else {
							$.toast(data.respMsg);
						} */
						
						window.location.href="pages/result.jsp?respCode="+data.respCode+"&respMsg="+data.respMsg;
					},
					error : function(jqXHR, textStatus, errorThrown) {
						console.log("error");
						$.toast("error");
					}
				});
			}
			//swal("完成", "这是一个完成的提示","success");
		}
		
	</script>

</body>

</html>
