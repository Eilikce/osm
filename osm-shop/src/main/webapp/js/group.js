/**
 * group.js
 */

/**
 * 加载时执行
 */
$(function(){
	//默认显示groupid为1的小类
    $(".tbl-type[groupid='1']").removeClass("hidden_class");
    //搜索框绑定回车功能
    search_enter();
    
});  

// 大分类按钮，切换小分类
function select_group(obj) {
	var groupid = $(obj).attr("groupid");
	$(".tbl-type").addClass("hidden_class");
	$(".tbl-type[groupid='"+groupid+"']").removeClass("hidden_class");
}

// 小分类按钮，跳转商品页面
function enter_commodity(obj) {
	window.location.href="../shopping/commodity2.do";
}

/** 搜索按钮功能 **/
function search(){
	var search = $("#newkeyword").val();
	var url = "../shopping/commoditySearch2.do"+"?search="+search;
	url = encodeURI(url);
	window.location.href=url;
}

/** 搜索聚焦去掉默认文字 **/
function search_focus(){
	var search = $("#newkeyword").val('');
}
/** 搜索失焦，空值则添加默认文字 **/
function search_blur(){
	var search = $("#newkeyword").val();
	if(''==search){
		$("#newkeyword").val('搜索');
	}
}

/**
 * 搜索框绑定回车功能
 * @returns
 */
function search_enter(){
	// 绑定搜索回车功能
　$("#newkeyword").keydown(function(e) {  
	    if (e.keyCode == 13) {  
	    	search($('#newkeyword'));
	    }  
	});  
	// 绑定搜索id回车功能
	$("#newkeyword").keydown(function(e) {  
		if (e.keyCode == 13) {  
			searchId($('#newkeyword'));
		}  
	});  
}