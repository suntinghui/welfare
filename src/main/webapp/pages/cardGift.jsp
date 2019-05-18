<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%   
String path = request.getContextPath();   
String basePath = request.getScheme()+"://" +request.getServerName()+":" +request.getServerPort()+path+"/" ;   
%>

<html>
<head>
<title>转赠</title>
<meta charset="utf-8">
<meta content="IE=edge" http-equiv="X-UA-Compatible">
<meta content="width=device-width, initial-scale=1, user-scalable=no"
	name="viewport">


<link href="<%=basePath%>/dist/lib/weui.min.css" rel="stylesheet">
<link href="<%=basePath%>/dist/css/jquery-weui.css" rel="stylesheet">
<link rel="stylesheet"
	href="<%=basePath%>/pages/icons/font-awesome/css/font-awesome.css">
<link href="<%=basePath%>/pages/css/style.css" rel="stylesheet">
<script src="<%=basePath%>/pages/js/jweixin-1.4.0.js"></script>

<style>
.weui-input {
	text-align: left;
}

.input-pay-number {
	border: 1px solid #f0f0f0;
	padding: 10px;
	width: 100%;
	box-sizing: border-box;
}

.weui-dialog__ft {
	font-size: 16px;
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

	<div class="weui-cells__title">请输入转赠留言</div>
	<div class="weui-cells weui-cells_form">
		<div class="weui-cell">
			<div class="weui-cell__bd">
				<textarea class="weui-textarea" placeholder="一片心意，希望你喜欢！" rows="3"></textarea>
				<div class="weui-textarea-counter">
					<span>0</span>/200
				</div>
			</div>
		</div>
	</div>
	<div class="p-15">
		<a href="javascript:void(0);" onclick="submitAction();" class="weui-btn weui-btn_warn btn-card-gift">转赠</a>
	</div>

	<div class="weui-cells__title">
		<p>温馨提示</p>
		<p>转赠后，礼品卡即处于“转赠中”状态；好友领取后，即与转赠者解绑，并与被转赠者建立转赠关系。</p>
	</div>

	<div id="share-gift" class="weui-popup__container">
		<div class="weui-popup__overlay"></div>
		<div class="weui-popup__modal"
			style="background: none; text-align: right">
			<img src="<%=basePath%>/pages/images/img-share-gift.png" width="60%"
				class="m-t-20 m-r-30" />
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
        
        wx.config({
    	    debug: true, 
    	    appId: "${share.appId}",
    	    timestamp:"${share.timestamp}",
    	    nonceStr: "${share.nonceStr}", 
    	    signature: "${share.signature}",
    	    jsApiList: ["onMenuShareAppMessage"]
    	});
        
		wx.ready(function () { 
    	});
        
        wx.error(function(res){
        	// $.scojs_message(res.errMsg, $.scojs_message.TYPE_ERROR);
        });
    });
    
    function submitAction(){
    	wx.onMenuShareAppMessage({
	    	title:"测试",
	        desc: '测试一下', 
	        link: 'http://welfare.ngrok.xiaomiqiu.cn/welfare/',
	        imgUrl: 'https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo_top_86d58ae1.png', 
	        success: function () {
	        	alert("分享成功");
	        },
	        cancel: function () {
				alert("分享失败");
	        }    	
	    })
    	
    	
    	
    }

    $(".btn-card-gift").click(function(){
        $.modal({
            title: '温馨提示',
            text: '<input class="input-pay-number" pattern="[0-9]*" placeholder="请输入卡包密码" type="number">',
            empty: false, // 是否允许为空
            buttons: [
                { text: "设置密码", onClick: function(){
                        window.location.href="edit-password.html";
                    } },
                { text: "确定", onClick: function(){
                        $("#share-gift").popup();
                    } },
                { text: "取消", className: "default", onClick: function(){ console.log("取消")} },
            ]
        });

    });
</script>

</body>

</html>
