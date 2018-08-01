$(function() {// 初始化内容
	
	apiDataInit();
	
	apiJqueryInit();

});  

/**
 * api数据初始化
 */
function apiDataInit(){
	//ajax获取数据
	var apiJsonArr = apiDataAjax();
	//dom拼接
	var dom = apiDomCreate(apiJsonArr);
	
	//填充数据
	$("#accordion").append(dom);
}

/**
 * 根据数据拼接dom
 * @param apiJsonArr
 */
function apiDomCreate(apiJsonArr){
	
	var dom = "";
	
	for(i in apiJsonArr){
		var apiPath = apiJsonArr[i].api;
		var apiMethodType = apiJsonArr[i].methodType;
		var apiDesc = apiJsonArr[i].desc;
		var apiParam = apiJsonArr[i].param;
		var apiExample = formatJson(apiJsonArr[i].returnValue);
		
		dom += 
		'<h3><span>'+apiMethodType+'</span><span class="api-name" >'+apiPath+'</span></h3>'+
		'<div>'+
			'<span class="api-desc-title">Description:</span>'+
			'<pre class="api-desc-content">'+apiDesc+'</pre>'+
			'<span class="api-desc-title">Param:</span>'+
			'<pre class="api-desc-content">'+apiParam+'</pre>'+
			'<span class="api-desc-title">ReturnValue Example:</span>'+
			'<pre class="api-desc-content">'+apiExample+'</pre>'+
		'</div>';
		
	}
	
	return dom;
}

/**
 * 请求后台数据，返回数据数组
 */
function apiDataAjax(){
	var apiJsonArr;
	$.ajax({
		type: "GET",
		url:"api/apiData",
		dataType:"json",
		async:false,
		success: function(data){
			apiJsonArr = data;
		}
	});
	return apiJsonArr; 
}



/**
 * jquery ui 初始化
 */
function apiJqueryInit(){
	
	$( "#accordion" ).accordion({
		heightStyle:'content',	//折叠高度设置
		collapsible:true,		//所有面板可关闭
		active:false			//默认关闭所有面板
    });

	var availableTags = [
		"ActionScript",
		"AppleScript",
		"Asp",
		"BASIC",
		"C",
		"C++",
		"Clojure",
		"COBOL",
		"ColdFusion",
		"Erlang",
		"Fortran",
		"Groovy",
		"Haskell",
		"Java",
		"JavaScript",
		"Lisp",
		"Perl",
		"PHP",
		"Python",
		"Ruby",
		"Scala",
		"Scheme",
		"/osm-shop/login/login"
	];
	$( "#autocomplete" ).autocomplete({
		source: availableTags
	});

}