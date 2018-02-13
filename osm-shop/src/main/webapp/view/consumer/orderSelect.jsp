<%@page import="org.springframework.context.annotation.Import"%>
<%@page import="com.eilikce.osm.core.bo.ConsumerBo"%>
<%@page import="com.eilikce.osm.core.bo.Cart"%>
<%@page import="java.util.*"%>
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%
			ConsumerBo consumerBo = (ConsumerBo)session.getAttribute("consumerBo");
			Cart cart =(Cart)session.getAttribute("cart");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0036)http://localhost:8080/osm/welcome.do -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>OSM</title>
<meta name="author" content="m.jd.com">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no">

<link rel="stylesheet" type="text/css" href="../css/base.css"	charset="gbk">
<link rel="stylesheet" type="text/css" href="../css/index.css"	charset="gbk">
<link rel="stylesheet" type="text/css" href="../css/group.css"	charset="gbk">
<link rel="apple-touch-icon-precomposed" href="http://localhost:8080/m.jd.com/images/apple-touch-icon.png">

<script src="../js/common/jquery-3.2.0.min.js"></script>
<script src="../js/group.js"></script>
</head>

<body id="body">
	<a name="top"></a>
	<header> </header>
	<div class="new-ct main">
		<div class="logo">
			<img src="../image/common/logo.png" alt="logo">
		</div>

		<div class="keyword">
			<div class="ad2 ad2-v1">
					<h2 class="ad-h2">支付方式</h2>
				<div class="ad2-big-img">
					<h2 class="ad-h2">微信支付</h2>
					<a href="../payment/onlinePayment.do">
						<img src="http://img30.360buyimg.com/mobilecms/g15/M04/0F/00/rBEhWVMqgc8IAAAAAABZ260QdDsAAKY-wL1HsQAAFnz698.jpg" class="full-img" width=320 alt="掌上专享特惠">
					</a>
				</div>
				<div class="ad2-big-img">
					<h2 class="ad-h2">货到付款</h2>
					<a href="">
						<img src="http://img30.360buyimg.com/mobilecms/g15/M04/0F/00/rBEhWVMqgc8IAAAAAABZ260QdDsAAKY-wL1HsQAAFnz698.jpg" class="full-img" width=320 alt="掌上专享特惠">
					</a>
				</div>
			</div>
		</div>
	</div>
	<input type="hidden" value="6" id="activity">
	<input type="hidden" value="15" id="crazy">
	<div style="display: none;">
		<img src="../image/common/logo.png">
	</div>
	<div class="login-area" id="footer">
			<div class="version">
				<a href="javascript:void(0)" style="color : black ; font-size: 16px ; font-weight: bold">
					<span href="" style="color : red ; font-size: 16px ; font-weight: bold">合计</span>
					<span href="" style="color : red ; font-size: 16px ; font-weight: bold"><span  id="totalprice"><%=cart.getTotalPrice() %></span>&nbsp;元</span>
				</a>
			</div>
			<div class="version">
				<a href="javascript:void(0)">----------</a>
				<a href="javascript:void(0)" class="on">收货信息</a>
				<a href="javascript:void(0)" id="toPcHome">----------</a>
			</div>
			<div class="copyright">收货人 : <%=consumerBo.getName() %>	电话 : <%=consumerBo.getPhone() %></div>
			<div class="copyright">地址 : <%=consumerBo.getAddr() %></div>
		</div>
</body>
</html>