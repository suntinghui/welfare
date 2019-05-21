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
  <title>退卡</title>
  <meta charset="utf-8">
  <meta content="IE=edge" http-equiv="X-UA-Compatible">
  <meta content="width=device-width, initial-scale=1, user-scalable=no" name="viewport">


  <link href="<%=basePath%>/dist/lib/weui.min.css" rel="stylesheet">
  <link href="<%=basePath%>/dist/css/jquery-weui.css" rel="stylesheet">
  <link rel="stylesheet" href="<%=basePath%>/pages/icons/font-awesome/css/font-awesome.css">
  <link href="<%=basePath%>/pages/css/style.css" rel="stylesheet">
  <style>
    .weui-uploader__input-box{
      width: 96%;
      height: 120px;
      border-radius: 8px;
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
<form id="form1" action="<%=basePath%>orderReturnAdd" modelAttribute="multiFileUploadForm" method="post" enctype="multipart/form-data">
<input type="hidden" id="oid" name="oid" valisate value='<%=request.getParameter("oid")%>'/>
  <div class="weui-cells weui-cells_form m-t-0">
  <div class="weui-cell">
    <div class="weui-cell__hd"><label class="weui-label">手机号</label></div>
    <div class="weui-cell__bd">
      <input class="weui-input" id="phone" name="phone" type="text" valisate="req" placeholder="请输入手机号" />
    </div>
  </div>
  <div class="weui-cell">
    <div class="weui-cell__bd">
      <div class="weui-uploader">
        <div class="weui-uploader__hd">
          <p class="weui-uploader__title">身份证正面</p>
          <div class="weui-uploader__info"></div>
        </div>
        <div class="weui-uploader__bd">
          <ul class="weui-uploader__files" id="uploaderFiles">

          </ul>
          <div class="weui-uploader__input-box">
            <input   class="weui-uploader__input" id="CardFront" name="multiUploadFiles[0]" valisate="req" placeholder="请选择身份证正面" type="file" accept="image/*" multiple=""/>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="weui-cell">
    <div class="weui-cell__bd">
      <div class="weui-uploader">
        <div class="weui-uploader__hd">
          <p class="weui-uploader__title">身份证背面</p>
          <div class="weui-uploader__info"></div>
        </div>
        <div class="weui-uploader__bd">
          <ul class="weui-uploader__files" id="uploaderFiles">

          </ul>
          <div class="weui-uploader__input-box">
            <input  class="weui-uploader__input" id="CardBack" name="multiUploadFiles[1]"   type="file" accept="image/*" multiple="" />
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="weui-cell">
    <div class="weui-cell__bd">
      <div class="weui-uploader">
        <div class="weui-uploader__hd">
          <p class="weui-uploader__title">购卡纪录截图</p>
          <div class="weui-uploader__info"></div>
        </div>
        <div class="weui-uploader__bd">
          <ul class="weui-uploader__files" id="uploaderFiles">

          </ul>
          <div class="weui-uploader__input-box">
            <input   class="weui-uploader__input" id="ShopingRec" name="multiUploadFiles[2]"  type="file" accept="image/*" multiple="" />
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<div class="text-right p-t-10 p-r-15">
  <a href="javascript:;" style="color: #6F7198;" class="open-popup" data-target="#checkOutRule">《退卡规则》</a>
</div>
<div class="p-15">
  <!-- <a href="javascript:;" onclick="submitAction();" class="weui-btn weui-btn_warn">提交</a> -->
  <input type="submit" class="weui-btn weui-btn_warn"> 
  <p class="m-t-10" style="font-size: 14px; color: #c00;"><i class="fa fa-exclamation-circle"></i> 提示消费纪录请在微信支付中找到账单详情然后截取</p>
</div>
 </form>


<!--退卡规则 -->
<div id="checkOutRule" class="weui-popup__container">
  <div class="weui-popup__overlay"></div>
  <div class="weui-popup__modal">
    <div class="p-15">
      <ol class="p-l-15">
        <li>退卡时间：原始购卡人需要在购卡后【七】个自然日内提出退卡申请，逾期则无法退卡。</li>
        <li>退款时间：自您申请之日起5个工作日内退款到原购卡人支付账户；退卡申请提交后，则不能取消。如有需要，请重新购买。</li>
        <li>退卡条件：购买的电子卡未发生消费/转赠操作，可在线上办理退卡：如活动购买的电子卡已发生消费转赠红包操作或订单的卡片发生消费（包括赠卡）则无法退。（即电子卡必须在购买人手机号名下）</li>
        <li>退卡金额：按照购卡的实际支付金额退回现金，退卡时赠卡一并收回。</li>
        <li>发生下列情况之一的则不能退卡：

          -购卡时间超过七天

          -卡片发生消费（包括赠卡）

          -卡片（包括赠卡）不在原购卡人手中

          -与购卡相关的订单已经申请开具发票

          -卡片（包括赠卡）发生消费后恢复原额度

          -已经兑换成实体卡

        </li>
        <li>所购买卡片和赠卡之间的关联关系以我方系统记录为准</li>
        <li>退卡方法：在线退卡，在公众号的“个人中心”基于订单申请退卡；</li>
      </ol>
      <p>工作时间：周一至周五（9：00-17：30）（中午12：00--13：00午餐时间）</p>
      <p>国家法定节假日：请关注公众号“Carrefour福利社”留言，我方会尽快答复，谢谢。</p>
      <p>客服电话：400-8086-217</p>
      <div class="p-15">
        <a href="javascript:;" class='weui-btn weui-btn_warn close-popup'>关闭</a>
      </div>
    </div>

  </div>
</div>
<!--退卡规则 -->
<script src="<%=basePath%>/dist/lib/jquery-2.1.4.js"></script>
<script src="<%=basePath%>/dist/lib/fastclick.js"></script>
<script src="<%=basePath%>/dist/js/jquery-weui.js"></script>
<script src="<%=basePath%>/pages/js/util.js" type="text/javascript"></script>

<script>
    $(function () {
        FastClick.attach(document.body);


        //LOADING
        $("#pre-loader").fadeOut();
        $('#pre-loader').delay(0).fadeOut('slow');
        
        
        
    });
	function submitAction() {
		var pars=DoValidate();
		if (pars) {
			
		 $("#form1").submit();
		}
	}
	
</script>

</body>

</html>
