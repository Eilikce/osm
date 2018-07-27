$(function() {// 初始化内容
	
	loginJqueryInit();
	
	$("#loginAccount").keydown(function(e) {  
        if (e.keyCode == 13) {  
        	loginCommond();
        }  
   });  
	$("#loginPass").keydown(function(e) {  
		if (e.keyCode == 13) {  
			loginCommond();
		}  
	});  

});  

function loginJqueryInit(){
	$("button").button();
}

/**
 * 登陆
 */
function loginCommond() {
	var targetUrl = $("#loginForm").attr("action");
	var data = $("#loginForm").serialize();
	$.ajax({
		type : 'post',
		url : targetUrl,
		cache : false,
		data : data,
		success : function(data) {
			if("success"==data){
				window.location.href = "api";//跳转到本层目录
			}else{
				$("#signFailed").show();
			}
		},
		error : function() {
			alert("请求失败")
		}
	})
}
