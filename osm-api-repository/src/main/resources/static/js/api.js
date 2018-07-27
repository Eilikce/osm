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
		var apiDesc = apiJsonArr[i].desc;
		var apiExample = formatJson(JSON.stringify(apiJsonArr[i].example));
		
		dom += 
		'<h3><span class="api-name" >'+
		apiPath
		+
		'</span>'+
		'<span class="api-desc">'+
		apiDesc
		+
		'</span></h3>'+
		'<div>'+
		'<pre>'+
		apiExample
		+
		'</pre>'+
		'</div>';
		
	}
	
	return dom;
}

/**
 * 请求后台数据，返回数据数组
 */
function apiDataAjax(){
	var j = [
	     	{
	    		"api":"/aaa/bbb/ccc",
	    		"desc":"First",
	    		"author":"",
	    		"date":"",
	    		"example":{
	    			"code": "0",
	    			"msg": "success",
	    			"data": {
	    				"aaa": "aaa",
	    		
	    				"bbb": 11111
	    			}
	    		}
	    	},
	    	{
	    		"api":"/aaa/sss/zzz",
	    		"desc":"第二个功能",
	    		"author":"",
	    		"date":"",
	    		"example":{
	    			"code": "0",
	    			"msg": "success",
	    			"data": {
	    				"adfsdsf": "asdasdasd",
	    		
	    				"basdfadsfbb": 222222
	    			}
	    		}
	    	}
	    ]
	;
	return j; 
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