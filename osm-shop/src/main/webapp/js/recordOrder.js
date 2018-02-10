/**
 * recordOrder.js
 */

/**
 * 加载时执行
 */
$(function(){ 
		// 绑定搜索回车功能
　　$("#search_input").keydown(function(e) {  
		    if (e.keyCode == 13) {  
		    	search($('#search_input'));
		    }  
		});  
		// 绑定搜索id回车功能
		$("#searchId_input").keydown(function(e) {  
			if (e.keyCode == 13) {  
				searchId($('#searchId_input'));
			}  
		});  
		
}); 

/**
 * 查看订单详情按钮
 * @param orderId
 * @returns
 */
function orderDetail(orderId,consumerName,consumerPhone){
	
	//订单详情列表更新副标题
	orderDetailSubtitleRefresh(orderId,consumerName,consumerPhone);
	
	var url = "../recordOrder/findRecordOrderCommodityBoListByOrderId.do";
	url = encodeURI(url);
	
	var paramdata = {
			orderId : orderId
	};	
	
	$.ajax({
		type: 'post',
		url:url,
		data: paramdata,
		dataType: "json",
		async:true,
		success: function(data) {
			var dom = "";
			var i = 1;
			for(x in data){
				dom += '<tr>';
				dom += '<td id="td_' + data[x].orderCommodityId + '_sequence">'+ (i++) +'</td>';
				dom += '<td id="td_' + data[x].orderCommodityId + '_commodityName">'+ data[x].commodityName +'</td>';
				dom += '<td id="td_' + data[x].orderCommodityId + '_commodityDetail">'+ data[x].commodityDetail +'</td>';
				dom += '<td id="td_' + data[x].orderCommodityId + '_barcode">'+ data[x].barcode +'</td>';
				dom += '<td id="td_' + data[x].orderCommodityId + '_groupName">'+ data[x].groupName +'</td>';
				dom += '<td id="td_' + data[x].orderCommodityId + '_itemName">'+ data[x].itemName +'</td>';
				dom += '<td id="td_' + data[x].orderCommodityId + '_salesVolume">'+ data[x].salesVolume +'</td>';
				dom += '<td id="td_' + data[x].orderCommodityId + '_unit">'+ data[x].unit +'</td>';
				dom += '<td id="td_' + data[x].orderCommodityId + '_original">'+ data[x].original +'</td>';
				dom += '<td id="td_' + data[x].orderCommodityId + '_price">'+ data[x].price +'</td>';
				dom += '<td id="td_' + data[x].orderCommodityId + '_profit">'+ data[x].profit +'</td>';
				dom += '</tr>';
			}
			$("#orderCommodityIList").empty().append(dom);
			
		},
		error: function() {
			alert("MSG ERROR");
		}
	});
	
}


/**
 * 订单详情列表更新副标题
 * @param orderId
 * @param consumerName
 * @param consumerPhone
 * @returns
 */
function orderDetailSubtitleRefresh(orderId,consumerName,consumerPhone){
	$("#subtitle_orderId").text(orderId);
	$("#subtitle_consumerName").text(consumerName);
	$("#subtitle_consumerPhone").text(consumerPhone);
}

/**
 * 提示框弹出
 * @param from	纵向位置
 * @param align	横向位置
 * @param msg	信息
 * @param colorLevel		颜色级别编号
 * @returns
 */
function notification(from,align,msg,colorLevel){

//	color = Math.floor((Math.random() * 4) + 1);
	color = colorLevel;
	
	$.notify({
    	icon: "pe-7s-bell",
    	message: msg
    	
    },{
        type: type[color],
        delay: 1000,
        timer: 1000,
        placement: {
            from: from,
            align: align
        }
    });

}

/**
 * 上一页
 * @param obj
 * @returns
 */
function pageUp(obj){
	var currentPage = $(obj).attr("page");
	if(currentPage==1){
		return ;
	}
	page = parseInt(currentPage)-1;
	
	location.href='?search='+getQueryString('search')+'&page='+page;
}

/**
 * 下一页
 * @param obj
 * @returns
 */
function pageDown(obj){
	var currentPage = $(obj).attr("page");
	page = parseInt(currentPage)+1;
	var flag = checkPageEnd(page);//首先判断下一页是否有数据
	if(flag){
		location.href='?search='+getQueryString('search')+'&page='+page;
	}else{
		notification('top','center','已经是最后一页了',1);
	}
}

/**
 * 翻页跳转
 * @param obj
 * @returns
 */
function pageJump(page){
	page = parseInt(page);
	if(page>0){
		location.href='?search='+getQueryString('search')+'&page='+page;
	}
}

/**
 * 获取下一页是否有数据
 * @returns
 */
function checkPageEnd(page){
	
	var flag = true;
	
	var url = "../recordOrder/findCountByPage.do";
	url = encodeURI(url);
	
	var paramdata = {
			page : page
	};	
	
	$.ajax({
		type: 'post',
		url:url,
		data: paramdata,
		dataType: "json",
		async:false,
		success: function(data) {
			if(data==0){
				flag = false;
			}
		},
		error: function() {
			alert("MSG ERROR");
		}
	});
	
	return flag;
}


/**
 * 替换url参数值
 * @param url		url字符串
 * @param arg				参数名
 * @param val	参数替换值
 * @returns
 */
function changeUrlArg(url, arg, val) {
	var pattern = arg + '=([^&]*)';
	var replaceText = arg + '=' + val;
	return url.match(pattern) ? url.replace(eval('/(' + arg + '=)([^&]*)/gi'),
			replaceText) : (url.match('[\?]') ? url + '&' + replaceText : url
			+ '?' + replaceText);
}

/**
 * 查询url参数值
 * @param name		参数名
 * @returns				参数值
 */
function getQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); 
	var r = window.location.search.substr(1).match(reg); 
	if (r != null) 
		return decodeURI(r[2]);
	return ''; // 注意decodeURI解码，避免中文乱码
} 


/**
 *  对象数据展示
 * @param obj
 * @returns
 */
function showJson(obj){
	
var description = ""; 
for(var i in obj){ 
var property=obj[i]; 
description+=i+" = "+property+"\n"; 
} 
alert('success'+description);
}
