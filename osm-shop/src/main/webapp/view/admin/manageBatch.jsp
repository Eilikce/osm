<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<link rel="icon" type="image/png" href="assets/img/favicon.ico">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>批量新增</title>

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
                    <a class="navbar-brand" href="#">批量新增</a>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-left">
                        <li>
                           <a href="manageModify.do" title="商品修改">
                                <i class="fa fa-edit"></i>
                            </a>
                        </li>
                        <li>
                           <a href="manageAdd.do" title="商品新增">
                                <i class="fa fa-tag"></i>
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
                                <h4 class="title">批量导入</h4>
                            </div>
                            <div class="content">
                                <form id="commodityAddForm" action="importXlsx.do" method="post" enctype="multipart/form-data">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>xlsx文件选择</label>
                                                <input id="importXlsx_input" type="file" class="form-control" name="mfile"  value="">
                                            </div>
                                        </div>
                                    </div>
                                    <button id="submitAddList" type="button" class="btn btn-info btn-fill pull-left" onclick="submitAdds(true);">批量导入</button>
                                    <div class="clearfix"></div>
                                </form>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
            
           
           <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">结果</h4>
                                <p id="infoResult" class="category"></p>
							</div>
                            <div class="content table-responsive table-full-width">
                                <table class="table table-hover"  id="importResult_table">
                                	<thead>
                                        <th id="error_info"></th>
                                    </thead>
                                    <tbody id="importResult_tbody">
                                        <tr>
                                        	<td></td>
                                        </tr>
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
    <script type="text/javascript" src="../js/manageBatch.js"></script>
    <script type="text/javascript" src="../js/common/jquery.serializejson.js"></script>
</html>
