<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>OSM</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
        <link rel="stylesheet" type="text/css" href="/osm/css/welcome.css"/>
        <script src="/osm/js/common/jquery-3.2.0.min.js"></script> 
        <script src="/osm/js/welcome.js"></script> 
	</head>
	<body>
		<h2>OSM小区-网上超市</h2>
		<div>
			房号:
			<br/>
			<select id="discrict">
	  			<option value ="1">一</option>
	  			<option value ="2">二</option>
			</select>
			区
			<select id="number">
	  			<option value ="10">10</option>
	  			<option value ="20">20</option>
			</select>
			号楼
			<select id="unit">
	  			<option value ="1">1</option>
	  			<option value ="2">2</option>
	  			<option value ="3">3</option>
	  			<option value ="4">4</option>
			</select>
			单元
			<select id="room">
	  			<option value ="101">101</option>
	  			<option value ="102">102</option>
	  			<option value ="201">201</option>
	  			<option value ="202">202</option>
	  			<option value ="301">301</option>
	  			<option value ="302">302</option>
			</select>
			号
		</div>
		<div>姓名：</div>
		<input id="name" value="冯女士"/>
		<div>联系电话：</div>
		<input id="phone" value="133333333333"/>
		<br/><br/>
		<button id="but_enter" onclick="but_enter()">进入超市</button>
	</body>	
</html>