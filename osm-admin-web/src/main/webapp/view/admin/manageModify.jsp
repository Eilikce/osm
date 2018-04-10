<%@page import="com.eilikce.osm.core.bo.CommodityShow"%>
<%@page import="com.eilikce.osm.core.bo.CommodityGroupItemBo"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%
	List<CommodityShow>  commodityShowList = (List<CommodityShow>)request.getAttribute("commodityShowList");
		List<CommodityGroupItem> groupList = (List<CommodityGroupItem>)request.getAttribute("groupList");
		
		Integer commodityPage = (Integer)request.getAttribute("page");
		Integer commodityPageSize = (Integer)request.getAttribute("pageSize");
%>

<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<link rel="icon" type="image/png" href="../image/assets/img/favicon.ico">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>商品修改</title>

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
                    <a class="navbar-brand" href="#">商品管理</a>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-left">
                        <li>
                           <a href="manageAdd.do" title="商品新增">
                                <i class="fa fa-tag"></i>
                            </a>
                        </li>
                        <li>
                           <a href="manageBatch.do" title="批量新增">
                                <i class="fa fa-tags"></i>
                            </a>
                        </li>
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
                                <h4 class="title">商品列表</h4>
							</div>
                            <div class="content table-responsive table-full-width">
								<div class="col-md-2">
									<div class="form-group">
										<input id="searchId_input" type="text" min="1" class="form-control" placeholder="商品编号" name="searchId" value="${empty param.commodityId?null:param.commodityId}"/>
									</div>
								</div>
								<button type="button" class="btn btn-info btn-fill pull-left" onclick="searchId($('#searchId_input'));">精确搜索</button>
								<div class="col-md-2">
									<div class="form-group">
										<input id="searchBarcode_input" type="number" class="form-control" placeholder="条形码" name="searchBarcode" value="${empty param.barcode?null:param.barcode}"/>
									</div>
								</div>
								<button type="button" class="btn btn-info btn-fill pull-left" onclick="searchBarcode($('#searchBarcode_input'));">条码查找</button>
								<div class="col-md-2">
									<div class="form-group">
										<input id="search_input" type="text" class="form-control" placeholder="商品名称" name="search" value="${empty param.search?null:param.search}"/>
									</div>
								</div>
								<button type="button" class="btn btn-info btn-fill pull-left" onclick="search($('#search_input'));">搜索</button>
                                <table class="table table-hover table-striped">
                                    <thead>
                                        <th>序号</th>
                                    	<th>图片</th>
                                        <th>货品名称</th>
                                        <th>货品详细</th>
                                    	<th>一级分类</th>
                                    	<th>二级分类</th>
                                    	<!-- <th>图片名称</th>
                                    	<th>图片路径</th> -->
                                    	<th>存货数</th>
                                    	<th>售价(元)</th>
                                    	<th>进价(元)</th>
                                    	<th>销量</th>
                                    	<th>单位</th>
                                    	<th>录入时间</th>
                                    	<th>上架</th>
                                        <th>修改</th>
                                    	<th>删除</th>
                                    </thead>
                                    <tbody>
                                    <%
                                    	int sequence = 1+((commodityPage-1)*commodityPageSize);
                                                                                                            	for(CommodityShow c : commodityShowList){
                                    %>
                                        <tr>
                                        	<td id="td_<%=c.getCommodityId()%>_sequence"><%=sequence++%></td>
                                        	<td id="td_<%=c.getCommodityId()%>_commodityImage"><img title="图片名称<%=c.getImgName()%>&#13;图片路径<%=c.getImgPath()%>" src="../image/commodity/<%=c.getImgSrc()%>" onerror="this.src='../image/common/error.jpg'" height="100px"></td>
                                        	<td id="td_<%=c.getCommodityId()%>_commodityName" title="<%=c.getCommodityDetail()%>"><%=c.getCommodityName()%></td>
                                        	<td id="td_<%=c.getCommodityId()%>_commodityDetail"><%=c.getCommodityDetail()%></td>
                                        	<td id="td_<%=c.getCommodityId()%>_groupName"><%=c.getGroupName()%></td>
                                        	<td id="td_<%=c.getCommodityId()%>_itemName"><%=c.getItemName()%></td>
                                        	<td id="td_<%=c.getCommodityId()%>_number"><%=c.getNumber()%></td>
                                        	<td id="td_<%=c.getCommodityId()%>_original"><%=c.getOriginal()%></td>
                                        	<td id="td_<%=c.getCommodityId()%>_price"><%=c.getPrice()%></td>
                                        	<td id="td_<%=c.getCommodityId()%>_salesVolume"><%=c.getSalesVolume()%></td>
                                        	<td id="td_<%=c.getCommodityId()%>_unit"><%=c.getUnit()%></td>
                                        	<td id="td_<%=c.getCommodityId()%>_createDate"><%=c.getCreateDate()%></td>
                                        	<td id="td_<%=c.getCommodityId()%>_shelves">
                                        			<%
                                        				if(c.getShelves()==1){
                                        			%>
                                        			<a href='javascript:void(0);' class='fa fa-check' onclick='modify_shelves("<%=c.getCommodityId()%>",1);' />
                                        			<%
                                        				}else{
                                        			%>
                                        			<a href='javascript:void(0);' class='fa fa-close' onclick='modify_shelves("<%=c.getCommodityId()%>",0);'/>
                                        			<%
                                        				}
                                        			%>
                                        	</td>
                                        	<td><a href="#1F"  onclick="modify('<%=c.getCommodityId()%>');"><i class="fa fa-edit"/></a></td>
                                        	<td><a href="javascript:void(0);"  onclick="deleteCommodity('<%=c.getCommodityId()%>' ,'<%=c.getCommodityName()%>' );"><i class="fa fa-trash-o"/></a></td>
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
                    <div class="col-md-8">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">修改商品</h4>
                            </div>
                            <div class="content">
                                <form id="commodityModifyForm">
                                    <div class="row">
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label>商品编号</label>
                                                <input id="commodityId" type="text" class="form-control" readonly="readonly" placeholder="编号" name="commodityId" value="">
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
                                                <label class="form-group dropdown">
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
	                                            </label>
	                                            <input id="groupName" type="text" class="form-control" readonly="readonly" placeholder="一级分类" name="groupName" >
	                                            <input id="groupId" type="hidden" class="form-control" readonly="readonly" placeholder="一级分类Id" name="groupId" >
                                        </div>
                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label id="item-span"  class="form-group dropdown">
							                              <a href="javascript:void(0);" onclick="openItem();" class="dropdown-toggle" data-toggle="dropdown">
							                              		二级分类
							                                    <b class="caret"></b>
							                              </a>
	                                            </label>
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
                                                <input id="salesVolume" type="number" min="0" class="form-control" disabled placeholder="销量" name="salesVolume" >
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

                                    <button type="button" class="btn btn-info btn-fill pull-left" onclick="resetModify();">重置修改</button>
                                    <button type="button" class="btn btn-info btn-fill pull-right" onclick="submitModify();">确认修改</button>
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
    <script type="text/javascript" src="../js/manageModify.js"></script>
    <script type="text/javascript" src="../js/common/jquery.serializejson.js"></script>
</html>
