$(function() {// 初始化内容
	
	apiDataInit();
	
	apiJqueryInit();

});  

/**
 * api数据初始化
 */
function apiDataInit(){
	//格式化所有json数据
	$(".json-data").each(function (e) {
		var jsonData = $(this).text();
        $(this).text(formatJson(jsonData));
    })

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