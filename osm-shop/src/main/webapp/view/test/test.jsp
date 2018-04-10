<%@page import="com.eilikce.osm.bo.admin.RecordOrderBo"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%
	List<RecordOrder> recordOrderBoList = (List<RecordOrder>)request.getAttribute("recordOrderBoList");
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

	<div>测试数据：</div>
	<div><%=recordOrderBoList %></div>

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
