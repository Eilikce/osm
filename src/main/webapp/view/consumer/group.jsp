<%@page import="org.springframework.context.annotation.Import"%>
<%@page import="com.eilikce.osm.bo.consumer.ConsumerBo"%>
<%@page import="com.eilikce.osm.bo.consumer.CommodityGroupItemBo"%>
<%@page import="com.eilikce.osm.bo.consumer.CommodityItemBo"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
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

		<div class="search" style="position: relative">
			<span class="input-box">
					<input name="keyword" type="text"	id="newkeyword" class="new-input" required="" placeholder="搜索"/>
				<div onclick="search();" class="btn-search">
					<span>search</span>
				</div>
			</span>
			<div class="new-srch-lst" id="shelper"	style="position: absolute; top: 2em; left: 3.28em; display: none; width: 201px; z-index: 10"></div>
		</div>
		<div class="keyword">
    	<%
			List<CommodityGroupItemBo> groupItemList = (List<CommodityGroupItemBo>)request.getAttribute("groupItemList");
			for(int i=0 ; i<groupItemList.size() ; i++ ){
				CommodityGroupItemBo cg = groupItemList.get(i);
    			%><a href="javascript:void(0)" class="btn-text" res="1"  groupid="<%=cg.getGroupId()%>" onclick="select_group(this)"><%=cg.getGroupName() %></a><%
			}
				%>
    </div>
		<div class="theme-pavilion">
		<%
			for(CommodityGroupItemBo cg : groupItemList){
				List<CommodityItemBo> commodityItemList = cg.getCommodityItemBoList();
				int listSize = commodityItemList.size();
				for(int i=0 ; i<listSize ; i++ ){
					CommodityItemBo ci = commodityItemList.get(i);
					if(i%2==0){
						if(i==(listSize-1)){
							
						%>
			<div class="tbl-type hidden_class" groupid="<%=ci.getGroupId() %>" >
				<span class="tbl-cell"> 
					<a href="../shopping/commodity2.do?groupId=<%=ci.getGroupId() %>&itemId=<%=ci.getItemId() %>">
						<img src="../image/<%=ci.getImgSrc() %>/<%=ci.getImgName() %>" class="half-img" width="160" alt="">
					</a>
				</span>
				 <span class="tbl-cell"> 
				 	<%-- <a href="http://localhost:8080/osm/promotion/hotSaleWare.action@module=2&amp;type=102&amp;resourceType=index_floor&amp;resourceValue=t102&amp;sid=e0d0f025d6d3e8e8d7be5428c43ef911">
				 		<img src="../image/<%=ci.getImgSrc() %>/<%=ci.getImgName() %>" class="half-img" width="160" alt="">
				 	</a> --%>
				</span>
			</div>
						<%
						}else{
						%>
			<div class="tbl-type hidden_class" groupid="<%=ci.getGroupId() %>">
				<span class="tbl-cell"> 
					<a href="../shopping/commodity2.do?groupId=<%=ci.getGroupId() %>&itemId=<%=ci.getItemId() %>">
						<img src="../image/<%=ci.getImgSrc() %>/<%=ci.getImgName() %>" class="half-img" width="160" alt="">
					</a>
				</span>
						<%
						}
					}else{
						%>
				 <span class="tbl-cell">
				 	<a href="../shopping/commodity2.do?groupId=<%=ci.getGroupId() %>&itemId=<%=ci.getItemId() %>">
				 	<img src="../image/<%=ci.getImgSrc() %>/<%=ci.getImgName() %>" class="half-img" width="160" alt="">
				 </a>
				</span>
			</div>
						<%
					}
					%>
					<%
				}
			}
		%>
		</div>
	</div>
	<input type="hidden" value="6" id="activity">
	<input type="hidden" value="15" id="crazy">
	<div style="display: none;">
		<img src="../image/common/logo.png">
	</div>
</body>
</html>