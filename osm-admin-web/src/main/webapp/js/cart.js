/**
 * cart.js
 */

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
		success: function(data) {
			//返回新的货品数量字符串
			$("#count_"+commodityId).text(data.count);
			$("#totalprice").text(data.totalPrice);
		},
		error: function() {
			alert("增加货品出错");
		}
	});
}

function dropCart(commodityId){
	var url = "../cart/dropCommoidity.do"
	var paramdata = {
			commodityId : commodityId
	};	
	
	$.ajax({
		type: 'post',
		url:url,
		data: paramdata,
		dataType: 'json',
		async:true,
		success: function(data) {
			//返回新的货品数量字符串
			$("#count_"+commodityId).text(data.count);
			$("#totalprice").text(data.totalPrice);
		},
		error: function() {
			alert("减少货品出错");
		}
	});
}

function emptyCart(){
	var url = "../cart/emptyCart.do"
	$.ajax({
		type: 'post',
		url:url,
		async:true,
		success: function(data) {
			//清空购物车，清空所有货品栏目
			$(".new-mu_l2").remove();
			$("#totalprice").text(data.totalPrice);
		},
		error: function(msg) {
			alert("清空购物车出错"+msg);
		}
	});
}

