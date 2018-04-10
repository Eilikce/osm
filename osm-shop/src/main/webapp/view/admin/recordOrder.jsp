<%@page import="com.eilikce.osm.bo.admin.RecordOrderBo"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%
	List<RecordOrder> recordOrderBoList = (List<RecordOrder>)request.getAttribute("recordOrderBoList");

	Integer commodityPage = (Integer)request.getAttribute("page");
	Integer commodityPageSize = (Integer)request.getAttribute("pageSize");
%>

<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<link rel="icon" type="image/png" href="../image/assets/img/favicon.ico">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>订单列表</title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />


    <!-- Bootstrap core CSS     -->
    <link href="../css/assets/bootstrap.min.css" rel="stylesheet" />

    <!-- Animation library for notifications   -->
    <link href="../css/assets/animate.min.css" rel="stylesheet"/>

    <!--  Light Bootstrap Table core CSS    -->
    <link href="../css/assets/light-bootstrap-dashboard.css" rel="stylesheet"/>


    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link href="../css/assets/demo.css" rel="stylesheet" />


    <!--     Fonts and icons     -->
    <link href="../css/font-awesome.min.css" rel="stylesheet">
    <link href="../css/assets/pe-icon-7-stroke.css" rel="stylesheet" />
    <link href="../css/assets/pe-icon-7-stroke.css" rel="stylesheet" />

	<!-- OSM Css -->
    <link href="../css/manage.css" rel="stylesheet" />
    
</head>
<body>

<div class="wrapper">
    <div class="main-panel">
        <nav class="navbar navbar-default navbar-fixed">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navigation-example-2">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">订单查询</a>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-left">
                        <!-- <li>
                           <a href="manageAdd.do" title="订单查询">
                                <i class="fa fa-tag"></i>
                            </a>
                        </li>
                        <li>
                           <a href="manageBatch.do" title="批量新增">
                                <i class="fa fa-tags"></i>
                            </a>
                        </li> -->
                    </ul>

                    <ul class="nav navbar-nav navbar-right">
                        <li>
                           <a href="javascript:void(0);" onclick="pageUp(this);" page="${empty param.page?1:param.page}">
                               上一页
                            </a>
                        </li>
                        <li class="dropdown">
                              <a id="current_page" href="#" class="dropdown-toggle" data-toggle="dropdown" page="${empty param.page?1:param.page}">
                                    第${empty param.page?1:param.page}页
                                    <b class="caret"></b>
                              </a>
                              <ul class="dropdown-menu">
                                <li><a href="#"><input id="page" type="number" min="1" max="${totalPage }" class="form-control" placeholder="共${totalPage }页"  name="page" value="" ></a></li>
                                <li class="divider"></li>
                                <li><a href="javascript:void(0);" onclick="pageJump($('#page').val());">跳转</a></li>
                                <li><a href="javascript:void(0);" onclick="pageJump(${totalPage });">尾页</a></li>
                              </ul>
                        </li>
                        <li>
                            <a href="javascript:void(0);" onclick="pageDown(this);" page="${empty param.page?1:param.page}">
                                下一页
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>


        <div class="content"   id="0F">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">订单列表</h4>
							</div>
                            <div class="content table-responsive table-full-width">
                                <table class="table table-hover table-striped">
                                    <thead>
                                        <th>序号</th>
                                        <th>订单号</th>
                                    	<th>买家姓名</th>
                                    	<th>买家电话</th>
                                    	<th>订单时间</th>
                                    	<th>是否消单</th>
                                    	<th>成本(元)</th>
                                    	<th>总价(元)</th>
                                    	<th>利润(元)</th>
                                    	<th>订单详情</th>
                                    </thead>
                                    <tbody>
                                    <%
                                    	int sequence = 1+((commodityPage-1)*commodityPageSize);
                                                                        	for(RecordOrder rob : recordOrderBoList){
                                    %>
                                        <tr>
                                        	<td id="td_<%=rob.getOrderId() %>_sequence"><%=sequence++ %></td>
                                        	<td id="td_<%=rob.getOrderId() %>_orderId"><%=rob.getOrderId() %></td>
                                        	<td id="td_<%=rob.getOrderId() %>_consumerName"><%=rob.getConsumerName() %></td>
                                        	<td id="td_<%=rob.getOrderId() %>_consumerPhone"><%=rob.getConsumerPhone() %></td>
                                        	<td id="td_<%=rob.getOrderId() %>_orderDate"><%=rob.getOrderDate() %></td>
                                        	<td id="td_<%=rob.getOrderId() %>_orderInvalidShow"><%=rob.getOrderInvalidShow() %></td>
                                        	<td id="td_<%=rob.getOrderId() %>_totalCost"><%=rob.getTotalCost() %></td>
                                        	<td id="td_<%=rob.getOrderId() %>_totalPrice" ><%=rob.getTotalPrice() %></td>
                                        	<td id="td_<%=rob.getOrderId() %>_totalProfit"><%=rob.getTotalProfit() %></td>
                                        	<td id="td_<%=rob.getOrderId() %>_orderDetail"><a href="#1F"  onclick="orderDetail('<%=rob.getOrderId() %>','<%=rob.getConsumerName() %>','<%=rob.getConsumerPhone() %>');"><i class="fa fa-align-justify"/></a></td>
                                        </tr>
                                    <%
                                    	}
                                    %>
                                    </tbody>
                                </table>

                            </div>
                        </div>
                    </div>

                </div>
                </div>
                <div class="container-fluid" id="1F">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">订单详情</h4>
                                <p class="category">订单号：<span id="subtitle_orderId"></span>&nbsp;&nbsp;买家姓名：<span id="subtitle_consumerName"></span>&nbsp;&nbsp;电话：<span id="subtitle_consumerPhone"></span></p>
							</div>
                            <div class="content table-responsive table-full-width">
                                <table class="table table-hover table-striped">
                                    <thead>
                                        <th>序号</th>
                                        <th>商品名称</th>
                                    	<th>商品详情</th>
                                    	<th>条形码</th>
                                    	<th>一级分类</th>
                                    	<th>二级分类</th>
                                    	<th>销售数量</th>
                                    	<th>商品单位</th>
                                    	<th>商品进价</th>
                                    	<th>商品售价</th>
                                    	<th>商品利润</th>
                                    </thead>
                                    <tbody id="orderCommodityIList">
                                        
                                    </tbody>
                                </table>

                            </div>
                        </div>
                    </div>

                </div>
            </div>
           
        </div>

        <footer class="footer">
            <div class="container-fluid">
                <nav class="pull-left">
                    <ul>
                        <li>
                            <a href="#">
                                Home
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                Company
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                Portfolio
                            </a>
                        </li>
                        <li>
                            <a href="#">
                               Blog
                            </a>
                        </li>
                    </ul>
                </nav>
                <p class="copyright pull-right">
                    &copy; 2016 <a href="#">Creative Tim</a>, More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a>
                </p>
            </div>
        </footer>


    </div>
</div>


</body>

    <!--   Core JS Files   -->
	<script src="../js/assets/jquery-1.10.2.js" type="text/javascript"></script>
	<script src="../js/assets/bootstrap.min.js" type="text/javascript"></script>

	<!--  Checkbox, Radio & Switch Plugins -->
	<script src="../js/assets/bootstrap-checkbox-radio-switch.js"></script>

	<!--  Charts Plugin -->
	<script src="../js/assets/chartist.min.js"></script>

    <!--  Notifications Plugin    -->
    <script src="../js/assets/bootstrap-notify.js"></script>

    <!--  Google Maps Plugin  
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>
	-->
	
    <!-- Light Bootstrap Table Core javascript and methods for Demo purpose -->
	<script src="../js/assets/light-bootstrap-dashboard.js"></script>

	<!-- Light Bootstrap Table DEMO methods, don't include it in your project! -->
	<script src="../js/assets/demo.js"></script>

	<!-- OSM JavaScript -->
    <script type="text/javascript" src="../js/recordOrder.js"></script>
    <script type="text/javascript" src="../js/common/jquery.serializejson.js"></script>
</html>
