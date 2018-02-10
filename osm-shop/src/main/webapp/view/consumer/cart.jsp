<%@page import="com.eilikce.osm.bo.consumer.CommodityShow"%>
<%@page import="com.eilikce.osm.bo.consumer.ConsumerBo"%>
<%@page import="com.eilikce.osm.bo.consumer.Cart"%>
<%@page import="com.eilikce.osm.bo.consumer.CartCommodity"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%
			ConsumerBo consumerBo = (ConsumerBo)session.getAttribute("consumerBo");
			Cart cart =(Cart)session.getAttribute("cart");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
		<title>OSM</title>
    	<meta name="author" content="m.jd.com">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	    <meta name="apple-mobile-web-app-capable" content="yes">
        <meta name="apple-mobile-web-app-status-bar-style" content="black">
        <meta name="format-detection" content="telephone=no">
	  	<link rel="stylesheet" type="text/css" href="../css/base.css" charset="gbk"/>
		<link rel="stylesheet" type="text/css" href="../css/sale.css" charset="gbk"/>	
		<link rel="apple-touch-icon-precomposed" href="../../m.jd.com/images/apple-touch-icon.png"/>
		<script type="text/javascript" src="../js/common/jquery-1.6.2.min.js"></script>
		<script type="text/javascript" src="../js/common/common.js"></script>
        <script type="text/javascript" src="../js/common/spin.min.js"></script>
        <script type="text/javascript" src="../js/cart.js"></script>
	</head>

<body id="body">
<a name="top"></a>
<header>
			<div class="new-header">
        	<a href="javascript:pageBack();" class="new-a-back" id="backUrl"><span>返回</span></a>
							<h2>购物车</h2>
			            <a href="javascript:void(0)" id="btnJdkey" class="new-a-jd"><span>京东键</span></a>
    	</div>
		<div class="new-jd-tab" style="display:none" id="jdkey">
        	<div class="new-tbl-type">
                <a href="../index.html@sid=e0d0f025d6d3e8e8d7be5428c43ef911" class="new-tbl-cell">
                	<span class="icon">首页</span>
					<p style="color:#6e6e6e;">首页</p>
                </a>
                <a href="../category/all.html@sid=e0d0f025d6d3e8e8d7be5428c43ef911" class="new-tbl-cell">
                	<span class="icon2">分类搜索</span>
					<p style="color:#6e6e6e;">分类搜索</p>
                </a>
                <a href="javascript:void(0)" id="html5_cart" class="new-tbl-cell">
                	<span class="icon3">购物车</span>
					<p style="color:#6e6e6e;">购物车</p>
                </a>
                <a href="../user/home.action@sid=e0d0f025d6d3e8e8d7be5428c43ef911" class="new-tbl-cell">
                	<span class="icon4">我的京东</span>
					<p style="color:#6e6e6e;">我的京东</p>
                </a>
            </div>
        </div>
	</header>
<input type="hidden" id="page" value="1"/>
<input type="hidden" id="module" value="1"/>
<div class="new-ct">
	<div class="new-search new-goods-lst">
		<div class="new-goods-tab">
            <span class="tit"><%=consumerBo.getName() %></span>
        </div>
		<ul class="new-mu_l2w">
			<%
				HashMap<String, CartCommodity> cartMap = cart.getCartHashMap();
				for(HashMap.Entry<String, CartCommodity> entry : cartMap.entrySet()){
					
						String commodityId = entry.getKey();
						CartCommodity cartCommodity = entry.getValue();
						CommodityShow commodityShow = cartCommodity.getCommodityShow();
						int count = cartCommodity.getCount();
					%>
				<li class="new-mu_l2">
					<div class="new-mu_l2a">
						<span class="new-mu_tmb">
							<img src="../image/commodity/<%=commodityShow.getImgSrc() %>"  width="100" height="100"  alt=""/></span>
				            <span class="new-mu_l2cw">
				                  	<strong class="new-mu_l2h"><%=commodityShow.getCommodityName() %></strong>
				                    <span class="new-mu_l2h new-mu_l2h-v1">
				                    	<span class="new-txt-rd2" ></span>
				                    </span>
				                 	<span class="new-mu_l2c new-p-re">
					                 	<strong class="new-txt-rd2">&yen;<%=commodityShow.getPrice() %></strong>
										<strong class="addcartbtn" style="color:red; font-size: 16px" ><span onclick="addCart(<%=commodityId %>)">+</span>&nbsp;<span id="count_<%=commodityId %>"><%=count %></span>&nbsp;<span id="unit_<%=commodityId %>"><%=commodityShow.getUnit() %></span>&nbsp;<span onclick="dropCart(<%=commodityId %>)">-</span></strong>
									</span>                    
			            	</span>
					</div>
	        	</li>
					<%
				}
			%>
		</ul>
	</div>
		<div class="login-area" id="footer">
			<div class="version">
				<a href="javascript:void(0)" style="color : black ; font-size: 16px ; font-weight: bold" onclick="emptyCart()">清空</a>
				<a href="javascript:void(0)" style="color : black ; font-size: 16px ; font-weight: bold">
					<span href="" style="color : red ; font-size: 16px ; font-weight: bold">合计</span>
					<span href="" style="color : red ; font-size: 16px ; font-weight: bold"><span  id="totalprice"><%=cart.getTotalPrice() %></span>&nbsp;元</span>
				</a>
				<a href="../order/orderSelect.do" style="color : black ; font-size: 16px ; font-weight: bold">结算</a>
			</div>
			<div class="version">
				<a href="javascript:void(0)">----------</a>
				<a href="javascript:void(0)" class="on">收货信息</a>
				<a href="javascript:void(0)" id="toPcHome">----------</a>
			</div>
			<div class="copyright">收货人 : <%=consumerBo.getName() %>	电话 : <%=consumerBo.getPhone() %></div>
			<div class="copyright">地址 : <%=consumerBo.getAddr() %></div>
		</div>
		<script>
			$(document).ready(function() {
				var m = $('#module').val();
				$('#m' + m).addClass('on');
			})
		</script>
</body>
</html>
