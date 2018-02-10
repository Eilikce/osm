/**
 * commodity.js
 */

// 大分类按钮，切换小分类
function select_group(obj) {
	var groupid = $(obj).attr("groupid");
	$(".detail .groupdiv").addClass("hidden_div");
	$(".detail .groupdiv").eq(groupid).removeClass("hidden_div");
}

// 小分类按钮，跳转商品页面
function enter_commodity() {
	window.location.href="../shopping/commodity.do";
}

function addCart(commodityId){
	var url = "../cart/addCommoidity.do"
	var paramdata = {
		commodityId : commodityId
	};	
		
	$.ajax({
		type: 'post',
		url:url,
	    data: paramdata,
		async:true,
	});
}