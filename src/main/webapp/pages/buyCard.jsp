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
  <title>购卡</title>
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
<div class="weui-flex p-t-15 p-b-15 weui-payselect">

  <c:forEach var="sku" items="${skuList }">
  	<div class="weui-flex__item weui-payselect-li">
    	<a href="javascript:;" class="weui-btn weui-btn_default">${sku.fv }元</a>
  	</div>
  </c:forEach>

</div>
<div class="weui-cells weui-cells_form m-t-0">
  <div class="weui-cell">
    <div class="weui-cell__hd"><label class="weui-label">自定义金额</label></div>
    <div class="weui-cell__bd">
      <input class="weui-input" id="moneySelf" pattern="[0-9]*" placeholder="请输入整数金额" type="text">
    </div>
  </div>
  <div class="weui-cell" style="display: none;">
    <div class="weui-cell__hd"><label class="weui-label">自定义卡号</label></div>
    <div class="weui-cell__bd">
      <input class="weui-input" placeholder="请输入8位卡号(非必填)" type="number">
    </div>
  </div>
  <a class="weui-cell weui-cell_access open-popup" href="javascript:;" data-target="#fullpage" style="display: none;">
    <div class="weui-cell__bd">
      <p>选择卡面</p>
    </div>
    <div class="weui-cell__ft">非必选</div>
  </a>
  <div class="weui-cell">
    <div class="weui-cell__bd">
      <p>数量</p>
    </div>
    <div class="weui-cell__ft">
      <div class="weui-count">
        <a class="weui-count__btn weui-count__decrease"></a>
        <input class="weui-count__number" type="number" value="1"/>
        <a class="weui-count__btn weui-count__increase"></a>
      </div>
    </div>
  </div>
  <div class="weui-cell">
    <div class="weui-cell__hd">
      <label for="" class="weui-label">城市</label>
    </div>
    <div class="weui-cell__bd">
      <input class="weui-input" id="select-city" type="text" value="请选择城市">
      <input class="weui-input" id="select-city-value" value="" type="hidden">
    </div>
  </div>

  <div class="weui-cell">
    <div class="weui-cell__bd">
      <p>合计</p>
    </div>
    <div class="weui-cell__ft text-dark">100元</div>
  </div>
</div>
<div class="weui-agree p-t-20 p-b-20" for="weuiAgree">
  <input class="weui-agree__checkbox" id="weuiAgree" type="checkbox">
  <span class="weui-agree__text">
      阅读并同意<a href="javascript:void(0);" class="open-popup" data-target="#agreement">《相关条款》</a>
  </span>
</div>

<div class="p-l-15 p-r-15">
  <a href="javascript:;" class="weui-btn weui-btn_warn">购卡</a>
</div>

<!--选择卡面-->
<div id="fullpage" class='weui-popup__container'>
  <div class="weui-popup__overlay"></div>
  <div class="weui-popup__modal">
    <div class="toolbar">
      <div class="toolbar-inner">
        <a href="javascript:;" class="picker-button close-popup">关闭</a>
        <h1 class="title">选择卡面</h1>
      </div>
    </div>
    <div class="modal-content">
      <div class="weui-flex flex-wrap text-center">
        <div class=" card-item">
          <img src="<%=basePath %>/pages/images/demo-card-01.png" width="90%" class="img-round card-select-on"/>
        </div>
        <div class=" card-item">
          <img src="<%=basePath %>/pages/images/demo-card-02.png" width="90%" class="img-round"/>
        </div>
        <div class=" card-item">
          <img src="<%=basePath %>/pages/images/demo-card-03.png" width="90%" class="img-round"/>
        </div>
        <div class=" card-item">
          <span class="weui-badge delect-card" style="position: absolute;top: -.4em;right: .4em; z-index: 9999; padding:4px 8px;">删除</span>
          <img src="<%=basePath %>/pages/images/demo-card-04.png" width="90%" class="img-round"/>
        </div>
        <div class="card-item" id="self_card">
          <div class="custom-card-btn">
            <h1><i class="fa fa-plus"></i></h1>
            自定义卡面
          </div>

        </div>
      </div>
    </div>
  </div>
</div>
<!--选择卡面-->
<!--自定义卡面-->
<div class="custom-card-popup" id="tailor_page">
  <div class="toolbar">
    <div class="toolbar-inner">
      <a href="javascript:;" class="picker-button close-custom-card-popup">关闭</a>
      <h1 class="title">自定义卡面</h1>
    </div>
  </div>
  <div class="contaniner p-15">
    <div id="clipArea" style="user-select: none; overflow: hidden; position: relative; padding: 15px;">
      <div class="photo-clip-layer">
        <div class="photo-clip-move-layer">
          <div class="photo-clip-rotation-layer"></div>
        </div>
      </div>
      <div class="photo-clip-mask">
        <div class="photo-clip-mask-left"></div>
        <div class="photo-clip-mask-right"></div>
        <div class="photo-clip-mask-top"></div>
        <div class="photo-clip-mask-bottom"></div>
        <div class="photo-clip-area"></div>
      </div>
    </div>

    <div class="weui-flex m-t-10">
      <div class="weui-flex__item p-r-10">
        <input type="file" id="file" style="display:none">
        <button type="button" class="weui-btn weui-btn_plain-primary btn-select-file">选择文件</button>
      </div>
      <div class="weui-flex__item p-l-10">
        <a class="weui-btn weui-btn_plain-primary" href="javascript:;" id="clipBtn">截取</a>
      </div>
    </div>
    <div id="viewDiv">
      <div id="view" style="background-repeat: no-repeat; background-position: center center; background-size: contain;"></div>
    </div>


    <canvas class="display-none" id="card_bkImg"></canvas>
    <img class="view-card m-t-20" id="sss" src="<%=basePath %>/pages/images/demo-card-01.png" style="display: none">
    <a class="weui-btn weui-btn_primary display-none m-t-10" href="javascript:;" id="clipArea_sure">确定</a>


  </div>
</div>
<!--自定义卡面-->
<!--相关条款-->
<div id="agreement" class='weui-popup__container'>
  <div class="weui-popup__overlay"></div>
  <div class="weui-popup__modal">
    <div class="toolbar">
      <div class="toolbar-inner">
        <a href="javascript:;" class="picker-button close-popup">关闭</a>
        <h1 class="title">相关条款</h1>
      </div>
    </div>
    <div class="modal-content">
     <div class="p-15">
       <h3>购买须知</h3>
       <ol class="p-l-20 m-t-10">
         <li>购买成功后，您可在卡包中看到该张卡片。</li>
         <li>您可点击消费出示手机条码在收银线完成消费。</li>
         <li>您还可以在卡片详情中将卡片转赠给您的亲朋好友。</li>
         <li>本卡为不记名卡、不挂失、卡内金额不能兑换现金。</li>
         <li>电子卡在购买货品发生退货时，金额退至原卡内（具体以家乐福退货流程为准）。</li>
         <li>本卡有效期为三年，请在有效期内使用本卡。</li>
         <li>电子卡可凭售卖记录开票，使用时不再开票。</li>
         <li>‘订单详情’&amp;‘微信支付凭证及交易记录’为重要的交易凭证，将在电子购物卡的售后服务中作为购卡人的重要身份凭证。为了保障您的财产安全，请妥善保存，勿将本页面以及页面中的任何信息泄露、转发或复制给他人。如因订单详情、微信支付凭证及交易记录以及有关信息未被妥善保管导致您的任何损失，将由您自行承担。</li>
         <li>仅限礼品卡购买者兑换发票。</li>
       </ol>
       <hr class="hr">
       <h3>开票规则</h3>
       <ol class="p-l-20 m-t-10">
         <li>开票时间：为5个工作日内寄出。</li>
         <li>开票条件：无退卡记录；如发票开出后，则无法退卡。</li>
         <li>开票单位：途皓（北京）商务服务有限公司</li>
         <li>发票内容：单用途预付卡。</li>
         <li>邮费：自付</li>
       </ol>
       <hr class="hr">
       <h3>退卡规则</h3>
       <ol class="p-l-20 m-t-10">
         <li>退卡时间：原始购卡人需要在购卡后【七】个自然日内提出退卡申请，逾期则无法退卡。</li>
         <li>退款时间：5个工作日内退款到原购卡人账户；退卡申请提交后，则不能取消。如有需要，请重新购买。</li>
         <li>退卡条件：购买的电子卡未发生消费/转赠/发红包操作，可在线上办理退卡；如活动购买的电子卡已发生消费转赠红包操作，则无法退卡。（即电子卡须在购买人手机号名下)</li>
         <li>退卡金额：按照购卡的实际金额退现，现金退回到购买人的微信钱包。</li>
         <li>如已开票，则无法退卡。</li>
       </ol>
       <hr class="hr">
       <ul class="p-l-20 m-t-10">
         <li>工作时间：周一至周五（9：00-17：30）（中午12：00--13：00午餐时间）</li>
         <li>国家法定节假日：请关注公众号“Carrefour福利社”留言，我方会尽快答复，谢谢。</li>
         <li>客服电话：400-8086-217</li>
       </ul>
     </div>
    </div>
  </div>
</div>
<!--相关条款-->

<script src="<%=basePath %>/dist/lib/jquery-2.1.4.js"></script>
<script src="<%=basePath %>/dist/lib/fastclick.js"></script>
<script src="<%=basePath %>/dist/js/jquery-weui.js"></script>
<!--图片裁切-->
<script type="text/javascript" src="<%=basePath %>pages/js/hammer.min.js"></script>
<script type="text/javascript" src="<%=basePath %>pages/js/lrz.all.bundle.js"></script>
<script type="text/javascript" src="<%=basePath %>pages/js/iscroll-zoom-min.js"></script>
<script type="text/javascript" src="<%=basePath %>pages/js/PhotoClip.js"></script>
<script>
    $(function () {
        FastClick.attach(document.body);


        //LOADING
        $("#pre-loader").fadeOut();
        $('#pre-loader').delay(0).fadeOut('slow');
    });
    //选择金额
    $(".weui-payselect-li").on('click', function () {
        $(".weui-payselect-li").find('a').removeClass("weui-payselect-on");
        $(this).find('a').addClass("weui-payselect-on");
    });
    
    var cityDisplayValue = new Array();
    var cityValue= new Array();
    
    <c:forEach items="${cityList}" var="city">
    	cityDisplayValue.push("${city.city}")
    	cityValue.push("${city.jv}")
    </c:forEach>

    //选择城市
    $("#select-city").picker({
        title: "请选择城市",
        cols: [
            {
                textAlign: 'center',
                values: cityDisplayValue,
            }
        ],
        onChange: function(p, v, dv) {
        	var index = $.inArray(""+v, cityDisplayValue);
        	$("#select-city-value").val(cityValue[index]);
           
        },
        onClose: function(p, v, d) {
        	
        }
    });
    //选择数量
    var MAX = 99, MIN = 1;
    $('.weui-count__decrease').click(function (e) {
        var $input = $(e.currentTarget).parent().find('.weui-count__number');
        var number = parseInt($input.val() || "0") - 1
        if (number < MIN) number = MIN;
        $input.val(number)
    })
    $('.weui-count__increase').click(function (e) {
        var $input = $(e.currentTarget).parent().find('.weui-count__number');
        var number = parseInt($input.val() || "0") + 1
        if (number > MAX) number = MAX;
        $input.val(number)
    })
    //选择卡面
    $(".card-item").on('click', function () {
        $(this).children().addClass("card-select-on");
        $(this).siblings().children().removeClass("card-select-on");
        return false;
    })
    //删除卡面
    $(".delect-card").on('click', function () {
        $.confirm({
            title: '删除卡面',
            text: '确定删除这张自定义卡面吗',
            onOK: function () {
                //点击确认
                $.toast("删除成功");
            },
            onCancel: function () {
            }
        });
    })

    //打开自定义卡面窗口
    $("#self_card").click(function(){
        $("#tailor_page").show();
        $("#file").trigger("click");
    });
    //上传图片按钮
    $(".btn-select-file").click(function(){
        $("#file").trigger("click")
    });
    // 关闭自定义卡面窗口
    $('.close-custom-card-popup').click(function(){
        $("#tailor_page").hide();
    });

    //图片裁切
    var pc = new PhotoClip('#clipArea', {
        size: [300,180],
        outputSize: [1000,600],
        //adaptive: ['60%', '80%'],
        file: '#file',
        view: '#view',
        ok: '#clipBtn',
        //img: 'img/mm.jpg',
        loadStart: function() {
            console.log('开始读取照片');
        },
        loadComplete: function() {
            console.log('照片读取完成');
        },
        done: function(dataURL) {
            cardURL=dataURL;
            $("#sss").attr('src',dataURL).css("display","block");
            $("#clipArea_sure").css("display","block");
        },
        fail: function(msg) {
            alert(msg);
        }
    });

    //保存图片确定
    $("#clipArea_sure").click(function(){

        if($(this).hasClass("weui-btn_primary")){
            $.showLoading();
            var formData = new FormData();
            formData.append("image",convertBase64UrlToBlob(cardURL));
            //formData.append("image",cardURL);
            //console.log(convertBase64UrlToBlob(cardURL));
            $.ajax({
                url:"/member_img/addData",
                data:formData,
                type:"POST",
                dataType:"json",
                processData : false,         // 告诉jQuery不要去处理发送的数据
                contentType : false,        // 告诉jQuery不要去设置Content-Type请求头
                success:function(data){
                    zhuti_name="";
                    zhuti_src="";
                    pc.clear();
                    $("#view").attr("style","background-size: contain; background-position: 50% 50%; background-repeat: no-repeat;");
                    $("#view").html("");

                    $.hideLoading();
                },
                error:function(error){


                }
            });
        }else{
            return;
        }

    });


</script>

</body>

</html>
