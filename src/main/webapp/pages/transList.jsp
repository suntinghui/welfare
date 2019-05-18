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
  <title>交易流水</title>
  <meta charset="utf-8">
  <meta content="IE=edge" http-equiv="X-UA-Compatible">
  <meta content="width=device-width, initial-scale=1, user-scalable=no" name="viewport">


  <link href="<%=basePath %>/dist/lib/weui.min.css" rel="stylesheet">
  <link href="<%=basePath %>/dist/css/jquery-weui.css" rel="stylesheet">
  <link rel="stylesheet" href="<%=basePath %>/pages/icons/font-awesome/css/font-awesome.css">
  <link href="<%=basePath %>/pages/css/style.css" rel="stylesheet">
  <style>
    body{
      background: #f1f1f1;
    }

  </style>

</head>

<body ontouchstart>
<!--=================================
 preloader -->
<div id="pre-loader">
  <img src="<%=basePath %>/pages/images/pre-loader/loader-08.svg" alt="">
</div>
<!--=================================
 preloader -->
<div class="filter-bar">
  <div class="weui-cells weui-cells_form weui-flex m-t-0 text-center">
    <div class="weui-cell weui-cell_select">
      <div class="weui-cell__bd">
        <select class="weui-select" name="select1">
          <option selected="" value="0">全部</option>
          <option value="1">购卡</option>
          <option value="2">领取</option>
          <option value="3">转赠</option>
          <option value="4">退货</option>
        </select>
      </div>
    </div>
    <div class="weui-cell weui-flex__item">
      <input class="weui-input" type="text" id="datetime-start" data-toggle='date' placeholder="开始日期">
    </div>
    <div class="weui-cell weui-flex__item">
      <input class="weui-input" type="text" id="datetime-end" data-toggle='date' placeholder="结束日期">
    </div>
    <div class="weui-cell">
      <a href="javascrip:;" class="weui-btn weui-btn_mini weui-btn_default">筛选</a>
    </div>
  </div>
</div>
<div style="padding: 65px 15px 15px 15px;">
  <div class="weui-form-preview">
    <a href="order-detail.html">
      <div class="weui-form-preview__hd">
        <label class="weui-form-preview__label">消费金额</label>
        <em class="weui-form-preview__value">¥2400.00</em>
      </div>
      <div class="weui-form-preview__bd">
        <div class="weui-form-preview__item">
          <label class="weui-form-preview__label">流水类型</label>
          <span class="weui-form-preview__value">购卡</span>
        </div>
        <div class="weui-form-preview__item">
          <label class="weui-form-preview__label">添加时间</label>
          <span class="weui-form-preview__value">2019-05-14 12:00:00</span>
        </div>
        <div class="weui-form-preview__item">
          <label class="weui-form-preview__label">订单号</label>
          <span class="weui-form-preview__value">343423434234234234234</span>
        </div>
      </div>
    </a>
  </div>
  <div class="weui-form-preview">
    <a href="order-detail.html">
      <div class="weui-form-preview__hd">
        <label class="weui-form-preview__label">消费金额</label>
        <em class="weui-form-preview__value">¥2400.00</em>
      </div>
      <div class="weui-form-preview__bd">
        <div class="weui-form-preview__item">
          <label class="weui-form-preview__label">流水类型</label>
          <span class="weui-form-preview__value">转赠</span>
        </div>
        <div class="weui-form-preview__item">
          <label class="weui-form-preview__label">添加时间</label>
          <span class="weui-form-preview__value">2019-05-14 12:00:00</span>
        </div>
        <div class="weui-form-preview__item">
          <label class="weui-form-preview__label">订单号</label>
          <span class="weui-form-preview__value">343423434234234234234</span>
        </div>
      </div>
    </a>
  </div>
  <div class="weui-form-preview">
    <a href="order-detail.html">
      <div class="weui-form-preview__hd">
        <label class="weui-form-preview__label">消费金额</label>
        <em class="weui-form-preview__value">¥2400.00</em>
      </div>
      <div class="weui-form-preview__bd">
        <div class="weui-form-preview__item">
          <label class="weui-form-preview__label">流水类型</label>
          <span class="weui-form-preview__value">退卡</span>
        </div>
        <div class="weui-form-preview__item">
          <label class="weui-form-preview__label">添加时间</label>
          <span class="weui-form-preview__value">2019-05-14 12:00:00</span>
        </div>
        <div class="weui-form-preview__item">
          <label class="weui-form-preview__label">订单号</label>
          <span class="weui-form-preview__value">343423434234234234234</span>
        </div>
      </div>
    </a>
  </div>
  <div class="weui-form-preview">
    <a href="order-detail.html">
      <div class="weui-form-preview__hd">
        <label class="weui-form-preview__label">消费金额</label>
        <em class="weui-form-preview__value">¥2400.00</em>
      </div>
      <div class="weui-form-preview__bd">
        <div class="weui-form-preview__item">
          <label class="weui-form-preview__label">流水类型</label>
          <span class="weui-form-preview__value">退货</span>
        </div>
        <div class="weui-form-preview__item">
          <label class="weui-form-preview__label">添加时间</label>
          <span class="weui-form-preview__value">2019-05-14 12:00:00</span>
        </div>
        <div class="weui-form-preview__item">
          <label class="weui-form-preview__label">订单号</label>
          <span class="weui-form-preview__value">343423434234234234234</span>
        </div>
      </div>
    </a>
  </div>
  <div class="weui-form-preview">
    <a href="order-detail.html">
      <div class="weui-form-preview__hd">
        <label class="weui-form-preview__label">消费金额</label>
        <em class="weui-form-preview__value">¥2400.00</em>
      </div>
      <div class="weui-form-preview__bd">
        <div class="weui-form-preview__item">
          <label class="weui-form-preview__label">流水类型</label>
          <span class="weui-form-preview__value">退货</span>
        </div>
        <div class="weui-form-preview__item">
          <label class="weui-form-preview__label">添加时间</label>
          <span class="weui-form-preview__value">2019-05-14 12:00:00</span>
        </div>
        <div class="weui-form-preview__item">
          <label class="weui-form-preview__label">订单号</label>
          <span class="weui-form-preview__value">343423434234234234234</span>
        </div>
      </div>
    </a>
  </div>
</div>


<script src="<%=basePath %>/dist/lib/jquery-2.1.4.js"></script>
<script src="<%=basePath %>/dist/lib/fastclick.js"></script>
<script src="<%=basePath %>/dist/js/jquery-weui.js"></script>

<script>
    $(function () {
        FastClick.attach(document.body);


        //LOADING
        $("#pre-loader").fadeOut();
        $('#pre-loader').delay(0).fadeOut('slow');

        $("#datetime-start").calendar()
        $("#datetime-end").calendar();
    });


</script>

</body>

</html>
