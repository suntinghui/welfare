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
<!--           <div class="weui-uploader__info"></div> -->
        </div>
        <div class="weui-uploader__bd">
          <ul class="weui-uploader__files">

          </ul>
          <div class="weui-uploader__input-box" style="background-size: auto 100%;">
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
          <ul class="weui-uploader__files">

          </ul>
          <div class="weui-uploader__input-box">
            <input  class="weui-uploader__input js_file" id="CardBack" name="multiUploadFiles[1]"   type="file" accept="image/*" multiple="" />
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
          <ul class="weui-uploader__files">

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
        
        
     // 允许上传的图片类型
        var allowTypes = ['image/jpg', 'image/jpeg', 'image/png', 'image/gif'];
        // 1024KB，也就是 1MB
        var maxSize = 1024 * 1024;
        // 图片最大宽度
        var maxWidth = 300;
        // 最大上传图片数量
        var maxCount = 1;
        $('.weui-uploader__input').on('change', function (event) {
        	var input=$(this);
            var files = event.target.files;
     
            // 如果没有选中文件，直接返回
            if (files.length === 0) {
                return;
            }
     
            for (var i = 0, len = files.length; i < len; i++) {
                var file = files[i];
                var reader = new FileReader();
     
                // 如果类型不在允许的类型范围内
                if (allowTypes.indexOf(file.type) === -1) {
                    $.weui.alert({text: '该类型不允许上传'});
                    continue;
                }
     
                if (file.size > maxSize) {
                    $.weui.alert({text: '图片太大，不允许上传'});
                    continue;
                }
     
                if (input.parents('.weui-uploader').find('.weui_uploader_file').length >= maxCount) {
                    $.weui.alert({text: '最多只能上传' + maxCount + '张图片'});
                    return;
                }
     
                reader.onloadend = function (e) {
                    var img = new Image();
                    img.onload = function () {
                        // 不要超出最大宽度
                        var w = Math.min(maxWidth, img.width);
                        // 高度按比例计算
                        var h = img.height * (w / img.width);
                        var canvas = document.createElement('canvas');
                        var ctx = canvas.getContext('2d');
                        // 设置 canvas 的宽度和高度
                        canvas.width = w;
                        canvas.height = h;
                        ctx.drawImage(img, 0, 0, w, h);
                        var base64 = canvas.toDataURL('image/png');
                        
                        //weui-uploader__input-box
                        input.parents('.weui-uploader').find('.weui-uploader__input-box').css({"background-image":"url("+base64+")","background-repeat":"no-repeat","background-size":"100% 100%"});
                       // background-repeat:repeat-x;no-repeat
                        // 插入到预览区
                       // var $preview = $('<li class="weui_uploader_file weui_uploader_status" style="background-image:url(' + base64 + ')"><div class="weui_uploader_status_content">0%</div></li>');
                        //var $preview = $('<li class="weui_uploader_file weui_uploader_status"  ><img  src="' + base64 + '" width="96%" height="150">  </li>');
                       
                        //input.parents('.weui-uploader').find('.weui-uploader__files').append($preview);
                       // var num = input.parents('.weui-uploader').find('.weui_uploader_file').length;
                        //$('.js_counter').text(num + '/' + maxCount);
     
                        // 然后假装在上传，可以post base64格式，也可以构造blob对象上传，也可以用微信JSSDK上传
     
                       /*  var progress = 0;
                        function uploading() {
                            $preview.find('.weui_uploader_status_content').text(++progress + '%');
                            if (progress < 100) {
                                setTimeout(uploading, 30);
                            }
                            else {
                                // 如果是失败，塞一个失败图标
                                //$preview.find('.weui_uploader_status_content').html('<i class="weui_icon_warn"></i>');
                                $preview.removeClass('weui_uploader_status').find('.weui_uploader_status_content').remove();
                            }
                        }
                        setTimeout(uploading, 30); */
                    };
     
                    img.src = e.target.result;
     
                  /*   $.post("/wap/uploader.php", { img: e.target.result},function(res){
                        if(res.img!=''){
                            alert('upload success');
                            $('#showimg').html('<img src="' + res.img + '">');
                        }else{
                            alert('upload fail');
                        }
                    },'json'); */
                };
                reader.readAsDataURL(file);
     
            }
        });
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
