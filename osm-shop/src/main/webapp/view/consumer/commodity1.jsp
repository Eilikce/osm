<%@page import="com.eilikce.osm.core.bo.Commodity"%>
<%@page import="com.eilikce.osm.core.bo.Consumer"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>


<%
	ConsumerPo consumer = (ConsumerPo)session.getAttribute("consumer");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>OSM</title>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
	<meta name="author" content="m.jd.com">
		<meta name="viewport"
			content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
			<meta name="apple-mobile-web-app-capable" content="yes">
				<meta name="apple-mobile-web-app-status-bar-style" content="black">
					<meta name="format-detection" content="telephone=no">
						<link rel="stylesheet" type="text/css" href="../css/base.css"
							charset="gbk">
							<link rel="stylesheet" type="text/css" href="../css/sale.css"
								charset="gbk">
								<link rel="apple-touch-icon-precomposed"
									href="file:///C:/Users/Eilik/Desktop/%E5%BC%80%E5%8F%91%E7%9B%B8%E5%85%B3/%E4%BB%BF%E4%BA%AC%E4%B8%9C%E7%B4%A0%E6%9D%90/m.jd.com/images/apple-touch-icon.png">
									<script src="../js/common/jquery-1.6.2.min.js"></script>
									<script type="text/javascript" src="../js/common/common.js"></script>
									<script type="text/javascript" src="../js/common/spin.min.js"></script>
									<script type="text/javascript" src="../js/commodity.js"></script>
</head>
<body id="body" class="s">
	<a name="top"></a>
	<header>
	<div class="new-header">
		<a href="../index/group.do" class="new-a-back" id="backUrl"><span>返回</span></a>
		<h2>商品列表</h2>
		<a href="javascript:void(0)" id="btnJdkey" class="new-a-jd"><span>京东键</span></a>
	</div>
	<div class="new-jd-tab" style="display: none" id="jdkey">
		<div class="new-tbl-type">
			<a
				href="file:///C:/Users/Eilik/Desktop/%E5%BC%80%E5%8F%91%E7%9B%B8%E5%85%B3/%E4%BB%BF%E4%BA%AC%E4%B8%9C%E7%B4%A0%E6%9D%90/%E4%BB%BF%E4%BA%AC%E4%B8%9C/index.html@sid=e0d0f025d6d3e8e8d7be5428c43ef911"
				class="new-tbl-cell"> <span class="icon">首页</span>
				<p style="color: #6e6e6e;">首页</p>
			</a> <a
				href="file:///C:/Users/Eilik/Desktop/%E5%BC%80%E5%8F%91%E7%9B%B8%E5%85%B3/%E4%BB%BF%E4%BA%AC%E4%B8%9C%E7%B4%A0%E6%9D%90/%E4%BB%BF%E4%BA%AC%E4%B8%9C/category/all.html@sid=e0d0f025d6d3e8e8d7be5428c43ef911"
				class="new-tbl-cell"> <span class="icon2">分类搜索</span>
				<p style="color: #6e6e6e;">分类搜索</p>
			</a> <a href="../cart/openCart.do" id="html5_cart" class="new-tbl-cell">
				<span class="icon3">购物车</span>
				<p style="color: #6e6e6e;">购物车</p>
			</a> <a
				href="file:///C:/Users/Eilik/Desktop/%E5%BC%80%E5%8F%91%E7%9B%B8%E5%85%B3/%E4%BB%BF%E4%BA%AC%E4%B8%9C%E7%B4%A0%E6%9D%90/%E4%BB%BF%E4%BA%AC%E4%B8%9C/user/home.action@sid=e0d0f025d6d3e8e8d7be5428c43ef911"
				class="new-tbl-cell"> <span class="icon4">我的京东</span>
				<p style="color: #6e6e6e;">我的京东</p>
			</a>
		</div>
	</div>
	</header>
	<input type="hidden" id="page" value="1"> <input type="hidden" id="module" value="2">
			<div class="new-ct">
				<div class="new-search new-goods-lst">
					<div class="new-goods-tab">
						<span class="tit"><%=consumer.getName() %></span>
						<div class="new-goods-btn">
							<a id="m2" href="commodity1.do?groupId=<%=request.getParameter("groupId") %>&itemId=<%=request.getParameter("itemId") %>" class="new-g-tbn on">列表图</a> 
							<a id="m1" href="commodity2.do?groupId=<%=request.getParameter("groupId") %>&itemId=<%=request.getParameter("itemId") %>" class="new-g-tbn2">列表</a>
							<a id="m3" href="commodity3.do?groupId=<%=request.getParameter("groupId") %>&itemId=<%=request.getParameter("itemId") %>" class="new-g-tbn3">放大</a>
						</div>
					</div>
					<%
						List<CommodityPo> commodityList =  (List<CommodityPo>)request.getAttribute("commodityList");
								int listSize = commodityList.size();
								for(int i=0 ; i<listSize ; i++ ){
									CommodityPo c = commodityList.get(i);
									if(i%2==0){
										if(i==(listSize-1)){
					%>
								<div class="new-goods-img-lst new-tbl-type">
									<div class="new-tbl-cell">
										<div class="new-goods-section">
											<div class="new-img-box">
												<img src="../image/<%=c.getImgSrc() %>/<%=c.getImgName() %>" onerror="this.src=&#39;&#39;" width="130" height="130" alt="" class="new-goods-img">
												<span class="new-goods-txt new-p-re">
														<strong class="new-txt">&yen;<%=c.getPrice() %></strong>
														<span class="new-txt2" style="color: red" onclick="addCart(<%=c.getCommodityId() %>)">加入购物车</span>
												</span>
											</div>
										</div>
									</div>
									<div class="new-tbl-cell">
										<div class="new-goods-section">
											<div class="new-img-box">
											</div>
										</div>
									</div>
								</div>
								<%
							}else{
								%>
							<div class="new-goods-img-lst new-tbl-type">
								<div class="new-tbl-cell">
									<div class="new-goods-section">
										<div class="new-img-box">
											<img src="../image/<%=c.getImgSrc() %>/<%=c.getImgName() %>" onerror="this.src=&#39;&#39;" width="130" height="130" alt="" class="new-goods-img">
											<span class="new-goods-txt new-p-re">
													<strong class="new-txt">&yen;<%=c.getPrice() %></strong>
													<span class="new-txt2" style="color: red" onclick="addCart(<%=c.getCommodityId() %>)">加入购物车</span>
											</span>
										</div>
									</div>
								</div>
								<%
							}
						}else{
							%>
								<div class="new-tbl-cell">
									<div class="new-goods-section">
										<div class="new-img-box">
											<img src="../image/<%=c.getImgSrc() %>/<%=c.getImgName() %>" onerror="this.src=&#39;&#39;" width="130" height="130" alt="" class="new-goods-img">
											<span class="new-goods-txt new-p-re">
													<strong class="new-txt">&yen;<%=c.getPrice() %></strong>
													<span class="new-txt2" style="color: red" onclick="addCart(<%=c.getCommodityId() %>)">加入购物车</span>
											</span>
										</div>
									</div>
								</div>
							</div>
							<%
						}
					}
							%>


				<div class="new-paging">
					<div class="new-tbl-type">
						<div class="new-tbl-cell">
							<span class="new-a-prve"><span>上一页</span></span>
						</div>
						<div class="new-tbl-cell new-p-re">
							<div class="new-a-page">
								<span class="new-open">1/5</span>
							</div>
							<select class="new-select"
								onchange="window.location.href=this.value">
								<option
									value="hotSaleWare.action@type=101&amp;page=1&amp;module=2&amp;resourceType=index_floor&amp;resourceValue=t101&amp;sid=e0d0f025d6d3e8e8d7be5428c43ef911"
									selected="">第1页</option>
								<option
									value="hotSaleWare.action@type=101&amp;page=2&amp;module=2&amp;resourceType=index_floor&amp;resourceValue=t101&amp;sid=e0d0f025d6d3e8e8d7be5428c43ef911">第2页</option>
								<option
									value="hotSaleWare.action@type=101&amp;page=3&amp;module=2&amp;resourceType=index_floor&amp;resourceValue=t101&amp;sid=e0d0f025d6d3e8e8d7be5428c43ef911">第3页</option>
								<option
									value="hotSaleWare.action@type=101&amp;page=4&amp;module=2&amp;resourceType=index_floor&amp;resourceValue=t101&amp;sid=e0d0f025d6d3e8e8d7be5428c43ef911">第4页</option>
								<option
									value="hotSaleWare.action@type=101&amp;page=5&amp;module=2&amp;resourceType=index_floor&amp;resourceValue=t101&amp;sid=e0d0f025d6d3e8e8d7be5428c43ef911">第5页</option>
							</select>
						</div>
						<div class="new-tbl-cell">
							<a class="new-a-next"
								href="file:///C:/Users/Eilik/Desktop/%E5%BC%80%E5%8F%91%E7%9B%B8%E5%85%B3/%E4%BB%BF%E4%BA%AC%E4%B8%9C%E7%B4%A0%E6%9D%90/%E4%BB%BF%E4%BA%AC%E4%B8%9C/promotion/hotSaleWare.action@type=101&amp;page=2&amp;module=2&amp;resourceType=index_floor&amp;resourceValue=t101&amp;sid=e0d0f025d6d3e8e8d7be5428c43ef911"><span>下一页</span></a>
						</div>
					</div>
				</div>
			</div> <script>
				$(document).ready(function() {
					var m = $('#module').val();
					$('#m' + m).addClass('on');
				})
			</script> <script type="text/javascript">
	$("#unsupport").hide();
	if (!testLocalStorage()) { //not support html5
		if (0 != 0 && !$clearCart && !$teamId) {
			$("#html5_cart_num").text(0 > 0 > 0);
		}
	} else {
		updateToolBar('');
	}

	$("#html5_cart").click(function() {
		//	syncCart('e0d0f025d6d3e8e8d7be5428c43ef911',true);
		location.href = '../cart/cart.action';
	});

	function reSearch() {
		var depCity = window.sessionStorage.getItem("airline_depCityName");
		if (testSessionStorage() && isNotBlank(depCity)
				&& !/^\s*$/.test(depCity) && depCity != "") {
			var airStr = '<form action="../airline/list.action" method="post" id="reseach">'
					+ '<input type="hidden" name="sid"  value="e0d0f025d6d3e8e8d7be5428c43ef911"/>'
					+ '<input type="hidden" name="depCity" value="'
					+ window.sessionStorage.getItem("airline_depCityName")
					+ '"/>'
					+ '<input type="hidden" name="arrCity" value="'
					+ window.sessionStorage.getItem("airline_arrCityName")
					+ '"/>'
					+ '<input type="hidden" name="depDate" value="'
					+ window.sessionStorage.getItem("airline_depDate")
					+ '"/>'
					+ '<input type="hidden" name="depTime" value="'
					+ window.sessionStorage.getItem("airline_depTime")
					+ '"/>'
					+ '<input type="hidden" name="classNo" value="'
					+ window.sessionStorage.getItem("airline_classNo")
					+ '"/>'
					+ '</form>';
			$("body").append(airStr);
			$("#reseach").submit();
		} else {
			window.location.href = '../airline/index.action@sid=e0d0f025d6d3e8e8d7be5428c43ef911';
		}
	}
	//banner 关闭点击
	$('.div_banner_close').click(function() {
		$('#div_banner_header').unbind('click');
		jQuery.post('../index/addClientCookieVal.json', function(d) {
			$('#div_banner_header').slideUp(500);
		});
	});
	//banner 下载点击
	$('.div_banner_download').click(function() {
		var downloadUrl = $(this).attr('url');
		jQuery.post('../index/addClientCookieVal.json', function(d) {
			window.location.href = downloadUrl;
		});
	});
</script>
</body>
</html>