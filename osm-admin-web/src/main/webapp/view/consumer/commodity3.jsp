<%@page import="com.eilikce.osm.entity.consumer.Commodity"%>
<%@page import="com.eilikce.osm.entity.consumer.Consumer"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%
			Consumer consumer = (Consumer)session.getAttribute("consumer");
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
<input type="hidden" id="module" value="3"/>
<div class="new-ct">
	<div class="new-search new-goods-lst">
		<div class="new-goods-tab">
            <span class="tit"><%=consumer.getName() %></span>
           <div class="new-goods-btn">
                <a id="m2" href="commodity1.do?groupId=<%=request.getParameter("groupId") %>&itemId=<%=request.getParameter("itemId") %>" class="new-g-tbn">列表图</a>
                <a id="m1" href="commodity2.do?groupId=<%=request.getParameter("groupId") %>&itemId=<%=request.getParameter("itemId") %>" class="new-g-tbn2">列表</a>
                <a id="m3" href="commodity3.do?groupId=<%=request.getParameter("groupId") %>&itemId=<%=request.getParameter("itemId") %>" class="new-g-tbn3 on">放大</a>
            </div>
        </div>
				
		<div class="new-goods-img-lst">
			<%
					List<Commodity> commodityList =  (List<Commodity>)request.getAttribute("commodityList");
					int listSize = commodityList.size();
					for(int i=0 ; i<listSize ; i++ ){
						Commodity c = commodityList.get(i);
						%>
			<div class="new-big-img new-mg-t15">
            	<div class="new-goods-section2 new-p-re">
                	<img src="../image/<%=c.getImgSrc() %>/<%=c.getImgName() %>" onerror="this.src='../image/<%=c.getImgSrc() %>/<%=c.getImgName() %>'" width="300" height="300" alt="" class="new-goods-img">
					<span class="new-goods-txt2">
                    	<strong>&yen;<%=c.getPrice() %></strong>
                    	<strong style="float: right ;" onclick="addCart(<%=c.getCommodityId() %>)">加入购物车</strong>
                        <span><%=c.getCommodityDetail() %></span>
                    </span>
                </div>
            </div>
						<%
					}
			%>
		</div>
	</div>
	

	    <div class="new-paging">
    	<div class="new-tbl-type">
								        				            			<div class="new-tbl-cell">
                    				<span class="new-a-prve"><span>上一页</span></span>
            			</div>
    					<div class="new-tbl-cell new-p-re">
                        	<div class="new-a-page">
                            	<span class="new-open">1/10</span>
                            </div>
                            <select class="new-select" onChange="window.location.href=this.value">
                                							<option value="hotSaleWare.action@type=101&page=1&module=3&resourceType=index_floor&resourceValue=t101&sid=e0d0f025d6d3e8e8d7be5428c43ef911" selected>第1页</option>
							    							<option value="hotSaleWare.action@type=101&page=2&module=3&resourceType=index_floor&resourceValue=t101&sid=e0d0f025d6d3e8e8d7be5428c43ef911" >第2页</option>
							    							<option value="hotSaleWare.action@type=101&page=3&module=3&resourceType=index_floor&resourceValue=t101&sid=e0d0f025d6d3e8e8d7be5428c43ef911" >第3页</option>
							    							<option value="hotSaleWare.action@type=101&page=4&module=3&resourceType=index_floor&resourceValue=t101&sid=e0d0f025d6d3e8e8d7be5428c43ef911" >第4页</option>
							    							<option value="hotSaleWare.action@type=101&page=5&module=3&resourceType=index_floor&resourceValue=t101&sid=e0d0f025d6d3e8e8d7be5428c43ef911" >第5页</option>
							    							<option value="hotSaleWare.action@type=101&page=6&module=3&resourceType=index_floor&resourceValue=t101&sid=e0d0f025d6d3e8e8d7be5428c43ef911" >第6页</option>
							    							<option value="hotSaleWare.action@type=101&page=7&module=3&resourceType=index_floor&resourceValue=t101&sid=e0d0f025d6d3e8e8d7be5428c43ef911" >第7页</option>
							    							<option value="hotSaleWare.action@type=101&page=8&module=3&resourceType=index_floor&resourceValue=t101&sid=e0d0f025d6d3e8e8d7be5428c43ef911" >第8页</option>
							    							<option value="hotSaleWare.action@type=101&page=9&module=3&resourceType=index_floor&resourceValue=t101&sid=e0d0f025d6d3e8e8d7be5428c43ef911" >第9页</option>
							    							<option value="hotSaleWare.action@type=101&page=10&module=3&resourceType=index_floor&resourceValue=t101&sid=e0d0f025d6d3e8e8d7be5428c43ef911" >第10页</option>
							                            </select>
                        </div>
											    					<div class="new-tbl-cell">
    						<a class="new-a-next" href='javascript:window.location.href="hotSaleWare.action@type=101&page=2&module=3&resourceType=index_floor&resourceValue=t101&sid=e0d0f025d6d3e8e8d7be5428c43ef911"'><span>下一页</span></a>
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
