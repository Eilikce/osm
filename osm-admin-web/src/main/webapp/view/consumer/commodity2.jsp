<%@page import="com.eilikce.osm.bo.consumer.CommodityShow"%>
<%@page import="com.eilikce.osm.bo.consumer.ConsumerBo"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%
	Consumer consumerBo = (Consumer)session.getAttribute("consumerBo");
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
        <script type="text/javascript" src="../js/commodity.js"></script>
	</head>

<body id="body">
<a name="top"></a>
<header>
			<div class="new-header">
        	<a href="../index/group.do" class="new-a-back" id="backUrl"><span>返回</span></a>
							<h2>商品列表</h2>
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
                <a href="../cart/openCart.do" id="html5_cart" class="new-tbl-cell">
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
           <div class="new-goods-btn">
                <a id="m2" href="commodity1.do?groupId=<%=request.getParameter("groupId") %>&itemId=<%=request.getParameter("itemId") %>" class="new-g-tbn">列表图</a>
                <a id="m1" href="commodity2.do?groupId=<%=request.getParameter("groupId") %>&itemId=<%=request.getParameter("itemId") %>" class="new-g-tbn2 on">列表</a>
                <a id="m3" href="commodity3.do?groupId=<%=request.getParameter("groupId") %>&itemId=<%=request.getParameter("itemId") %>" class="new-g-tbn3">放大</a>
            </div>
        </div>
		<ul class="new-mu_l2w">
		<%
			List<CommodityShow> commodityShowList =  (List<CommodityShow>)request.getAttribute("commodityShowList");
			for(CommodityShow c : commodityShowList){
				%>
				<li class="new-mu_l2">
				<div class="new-mu_l2a">
					<span class="new-mu_tmb"><img src="../image/commodity/<%=c.getImgSrc() %>"  width="100" height="100"  alt=""/></span>
			            <span class="new-mu_l2cw">
			                  	<strong class="new-mu_l2h"><%=c.getCommodityName()%></strong>
			                    <span class="new-mu_l2h new-mu_l2h-v1">
			                    	<span class="new-txt-rd2"><%=c.getCommodityDetail() %></span>
			                    </span>
			                 	<span class="new-mu_l2c new-p-re"><strong class="new-txt-rd2">&yen;<%=c.getPrice() %></strong>
								<span class="addcartbtn" style="color:red" onclick="addCart(<%=c.getCommodityId() %>)">加入购物车</span>
						</span>                    
		            </span>
				</div>
        	</li>
				<%
			}
		%>
		</ul>
	</div>
		<div class="new-paging">
			<div class="new-tbl-type">
				<div class="new-tbl-cell">
					<span class="new-a-prve"><span>上一页</span></span>
				</div>
				<div class="new-tbl-cell new-p-re">
					<div class="new-a-page">
						<span class="new-open">1/5</span>
					</div>
					<select class="new-select" onChange="window.location.href=this.value">
						<option value="hotSaleWare.action@type=101&page=1&module=1&resourceType=index_floor&resourceValue=t101&sid=e0d0f025d6d3e8e8d7be5428c43ef911" selected>第1页</option>
						<option value="hotSaleWare.action@type=101&page=2&module=1&resourceType=index_floor&resourceValue=t101&sid=e0d0f025d6d3e8e8d7be5428c43ef911">第2页</option>
						<option value="hotSaleWare.action@type=101&page=3&module=1&resourceType=index_floor&resourceValue=t101&sid=e0d0f025d6d3e8e8d7be5428c43ef911">第3页</option>
						<option value="hotSaleWare.action@type=101&page=4&module=1&resourceType=index_floor&resourceValue=t101&sid=e0d0f025d6d3e8e8d7be5428c43ef911">第4页</option>
						<option value="hotSaleWare.action@type=101&page=5&module=1&resourceType=index_floor&resourceValue=t101&sid=e0d0f025d6d3e8e8d7be5428c43ef911">第5页</option>
					</select>
				</div>
				<div class="new-tbl-cell">
					<a class="new-a-next" href="hotSaleWare.action@type=101&page=2&module=1&resourceType=index_floor&resourceValue=t101&sid=e0d0f025d6d3e8e8d7be5428c43ef911"><span>下一页</span></a>
				</div>
			</div>
		</div>
	</div>
<script>
	$(document).ready(function(){
		var m = $('#module').val();
		$('#m'+m).addClass('on');
	})
</script>
</body>
</html>
