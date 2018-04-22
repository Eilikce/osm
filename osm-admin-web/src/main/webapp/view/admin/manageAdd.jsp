<%@page import="com.eilikce.osm.core.bo.common.CommodityGroupItem"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%
	List<CommodityGroupItem> groupList = (List<CommodityGroupItem>)request.getAttribute("groupList");
%>

<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<link rel="icon" type="image/png" href="assets/img/favicon.ico">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>商品新增</title>

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
                    <a class="navbar-brand" href="#">新增商品</a>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-left">
                        <li>
                           <a href="manageModify.do" title="商品修改">
                                <i class="fa fa-edit"></i>
                            </a>
                        </li>
                        <li>
                           <a href="manageBatch.do" title="批量新增">
                                <i class="fa fa-tags"></i>
                            </a>
                        </li>
                    </ul>

                </div>
            </div>
        </nav>


        <div class="content"   id="0F">
            <div class="container-fluid" id="1F">
                <div class="row">
                    <div class="col-md-8">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">商品信息</h4>
                            </div>
                            <div class="content">
                                <form id="commodityAddForm">
                                    <div class="row">
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label>编号</label>
                                                <input id="commodityId" type="text" class="form-control" readonly="readonly" placeholder="自动编号" name="commodityId" value="">
                                            </div>
                                        </div>
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label>名称</label>
                                                <input id="commodityName" type="text" class="form-control" placeholder="名称" name="commodityName" value="">
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>商品详细</label>
                                                <input id="commodityDetail" type="text" class="form-control" placeholder="商品详细 " name="commodityDetail" value="">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-2">
                                                <span class="form-group dropdown">
							                              <a href="#" class="dropdown-toggle" data-toggle="dropdown">
							                              一级分类
							                                    <b class="caret"></b>
							                              </a>
							                              <ul class="dropdown-menu">
							                              <%
							                              	for(CommodityGroupItem cg : groupList){
							                              %>
							                                <li><a href="javascript:void(0);" onclick="selectGroup(<%=cg.getGroupId() %>,'<%=cg.getGroupName() %>');"><%=cg.getGroupName() %></a></li>
							                              			<%
							                              		}
							                              %>
							                              </ul>
	                                            </span>
	                                            <input id="groupName" type="text" class="form-control" readonly="readonly" placeholder="一级分类" name="groupName" >
	                                            <input id="groupId" type="hidden" class="form-control" readonly="readonly" placeholder="一级分类Id" name="groupId" >
                                        </div>
                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <span id="item-span"  class="form-group dropdown">
							                              <a href="javascript:void(0);" onclick="openItem();" class="dropdown-toggle" data-toggle="dropdown">
							                              		二级分类
							                                    <b class="caret"></b>
							                              </a>
	                                            </span>
                                                <input id="itemName" type="text" class="form-control" readonly="readonly" placeholder="二级分类" name="itemName" >
                                                <input id="itemId" type="hidden" class="form-control" readonly="readonly" placeholder="二级分类Id" name="itemId" >
                                            </div>
                                        </div>
                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="form-group dropdown">
							                              <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown" onclick="selectShelvesShow($('#shelves').val());">
							                              			是否上架
							                                    <b class="caret"></b>
							                              </a>
	                                            </label>
                                                <input id="shelvesShow" type="disable" class="form-control"  readonly="readonly"  placeholder="是否上架" name="shelvesShow" value="">
                                                <input id="shelves" type="hidden" class="form-control"  readonly="readonly"  placeholder="是否上架" name="shelves" value="">
                                            </div>
                                        </div>
                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label for="exampleInputEmail1">条形码</label>
                                                <input id="barcode" type="number" min="0" class="form-control" placeholder="条形码" name="barcode" >
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label for="exampleInputEmail1">图片</label>
                                                <input id="imgFile" type="file" class="form-control" placeholder="上传图片" name="imgFile" >
                                                <input id="imgRule" type="hidden" class="form-control" placeholder="图片规则" name="imgRule" value="main" >
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label>存货数</label>
                                                <input id="number" type="number" min="0" class="form-control" placeholder="存货数"  name="number" value="" >
                                            </div>
                                        </div>
                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label>单位</label>
                                                <input id="unit" type="text" class="form-control" placeholder="单位" name="unit" value="">
                                            </div>
                                        </div>
                                        
                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label>销量</label>
                                                <input id="salesVolume" type="number" min="0" class="form-control" readonly="readonly" placeholder="0" name="salesVolume"  value="0">
                                            </div>
                                        </div>
                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label>进价(元)</label>
                                                <input id="original" type="number" step="0.01" min="0"  class="form-control" placeholder="进价(元)" name="original" value="">
                                            </div>
                                        </div>
                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label>售价(元)</label>
                                                <input id="price" type="number" step="0.01" min="0" class="form-control" placeholder="售价(元)" name="price" >
                                            </div>
                                        </div>
                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label>进货渠道</label>
                                                <input id="source" type="text" class="form-control" placeholder="进货渠道" name="source" >
                                            </div>
                                        </div>
                                    </div>
                                    
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <label>备注信息</label>
                                                <textarea id="detail" rows="5" class="form-control" placeholder="商品备注信息。"  name="detail"  value="Mike"></textarea>
                                            </div>
                                        </div>
                                    </div>

                                    <button type="button" class="btn btn-info btn-fill pull-left" onclick="resetModify();">清空信息</button>
                                    <button type="button" class="btn btn-info btn-fill pull-right" onclick="submitAdd();">确认添加</button>
                                    <div class="clearfix"></div>
                                </form>
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
    <script type="text/javascript" src="../js/manageAdd.js"></script>
    <script type="text/javascript" src="../js/common/jquery.serializejson.js"></script>
</html>
