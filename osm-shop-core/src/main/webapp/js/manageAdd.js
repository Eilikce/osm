/**
 * manageAdd.js
 */

/**
 * 加载时执行
 */
$(function(){ 
　　

}); 


/**
 * 一级分类选择
 * @param groupId
 * @param groupName
 * @returns
 */
function selectGroup(groupId,groupName){
	$("#groupName").val(groupName);
	$("#groupId").val(groupId);
	
	var url = "../manage/findCommodityItemListByGroupId.do";
	url = encodeURI(url);
	
	var paramdata = {
		group_id : groupId,
	};	
	
	$.ajax({
		type: 'post',
		url:url,
		data: paramdata,
		dataType: "json",
		async:false,
		success: function(data) {
			var dom = '<ul id="item-ul" class="dropdown-menu">';
			for (var i in data){
				var itemId = data[i].itemId;
				var itemName = data[i].itemName; 
				dom += '<li><a href="javascript:void(0);" onclick="selectItem(\''+ itemId +'\',\''+itemName+'\');">'+itemName+'</a></li>';
			}
			dom += '</ul>';
			
			$("#item-ul").remove();
			$("#item-span").append(dom);
			
			$("#itemName").val('');
			$("#itemId").val('');
		},
		error: function() {
			alert("MSG ERROR");
		}
	});
}

/**
 * 二级分类选择
 * @param itemId
 * @param itemName
 * @returns
 */
function selectItem(itemId,itemName){
	$("#itemName").val(itemName);
	$("#itemId").val(itemId);
}
	
/**
 * 打开二级分类菜单
 * @returns
 */
function openItem(){
	if($("#groupName").val() == ''){
		notification('top','center','请先选择一级分类',2);
	}
}

/**
 * 上架下架选择
 * @param flag 是否上架
 * @returns
 */
function selectShelvesShow(shelves){
	if(shelves!='1'){
		$("#shelvesShow").val('上架');
		$("#shelves").val(1);
	}else{
		$("#shelvesShow").val('下架');
		$("#shelves").val(0);
	}
}

/**
 * 清空输入信息
 * @returns
 */
function resetModify(){
	emptyInput();
}

/**
 * 提交新增
 * @returns
 */
function submitAdd(){
	//首先对input值去空格
	$("#commodityName").val($.trim($("#commodityName").val()));
	$("#commodityDetail").val($.trim($("#commodityDetail").val()));
	$("#groupId").val($.trim($("#groupId").val()));
	$("#itemId").val($.trim($("#itemId").val()));
	$("#shelves").val($.trim($("#shelves").val()));
	$("#barcode").val($.trim($("#barcode").val()));
	$("#number").val($.trim($("#number").val()));
	$("#unit").val($.trim($("#unit").val()));
	$("#salesVolume").val($.trim($("#salesVolume").val()));
	$("#original").val($.trim($("#original").val()));
	$("#price").val($.trim($("#price").val()));
	$("#source").val($.trim($("#source").val()));
//	$("#detail").val($.trim($("#detail").val()));//大文本框不修改
	
	var commodityName = $("#commodityName").val();
	if(commodityName==''){
		notification('top','center','请填写商品名称',4);
		location.href='#0F';
		return;
	}
	var groupId = $("#groupId").val();
	if(groupId==''){
		notification('top','center','请填写一级分类',4);
		location.href='#0F';
		return;
	}
	var itemId = $("#itemId").val();
	if(itemId==''){
		notification('top','center','请填写二级分类',4);
		location.href='#0F';
		return;
	}
	var shelves = $("#shelves").val();
	if(shelves==''){
		notification('top','center','请填写是否上架',4);
		location.href='#0F';
		return;
	}
	var number = $("#number").val();
	if(number==''){
		notification('top','center','请填写存货数',4);
		location.href='#0F';
		return;
	}
	var unit = $("#unit").val();
	if(unit==''){
		notification('top','center','请填写单位',4);
		location.href='#0F';
		return;
	}
	var salesVolume = $("#salesVolume").val();
	if(salesVolume==''){
		notification('top','center','请填写销量架',4);
		location.href='#0F';
		return;
	}
	var original = $("#original").val();
	if(original==''){
		notification('top','center','请填写进价',4);
		location.href='#0F';
		return;
	}
	var price = $("#price").val();
	if(price==''){
		notification('top','center','请填写售价',4);
		location.href='#0F';
		return;
	}
	
	
	//校验图片文件后缀
	var imgPath = $("#imgFile").val();
	if(imgPath!=""){
		var arr=imgPath.split('\\');//注split可以用字符或字符串分割 
		var imgName=arr[arr.length-1];//这就是要取得的图片名称
		var imgSuffix = (imgName.split('.'))[1];//文件名后缀
		if(!(imgSuffix=="jpg"||imgSuffix=="jpeg"||imgSuffix=="png"||imgSuffix=="bmp")){
			notification('top','center','请重新上传jpg，jepg，png，bmp格式的文件',3);
			return ;
		}
	}
	
	//校验条形码为数字（注：当不输入条形码时候，value为""，isNaN结果为false。注：当输入格式如121-1231，input会读入""）
	var barcode = $("#barcode").val();
	if(isNaN(barcode)){
		notification('top','center','请重新输入数字条形码',4);
		location.href='#0F';
		return;
	}
	
	
	var paramdata = new FormData($( "#commodityAddForm")[0]);
	
	var url = "../manage/addCommodity.do";
	url = encodeURI(url);
	
	$.ajax({
		type: 'post',
		url:url,
		data: paramdata,
		async: true,  
        cache: false,  //不缓存页面
        contentType: false,  //multipart/form-data形式必须
        processData: false,  //multipart/form-data形式必须
		success: function(data) {
			if(data==1){
				emptyInput();//修改后清空编辑栏
				//refreshCommodityById(commodityId,paramJson);
				location.href='#0F';
				notification('top','center','商品添加成功',1);
			}else{
				notification('top','center','商品添加错误',3);
			}
		},
		error: function() {
			alert("MSG ERROR");
		}
	});
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
 * 在统计表中更新一条修改后的记录
 * @param commodityId	id号
 * @param paramdata	序列号修改json
 * @returns
 */
function refreshCommodityById(commodityId,paramdata){
	$("#td_"+commodityId+"_commodityId").text(paramdata.commodityId);
	$("#td_"+commodityId+"_commodityName").text(paramdata.commodityName);
	$("#td_"+commodityId+"_commodityDetail").text(paramdata.commodityDetail);
	$("#td_"+commodityId+"_groupName").text(paramdata.groupName);
	$("#td_"+commodityId+"_itemName").text(paramdata.itemName);
	$("#td_"+commodityId+"_imgName").text(paramdata.imgName);
	$("#td_"+commodityId+"_imgSrc").text(paramdata.imgSrc);
	$("#td_"+commodityId+"_number").text(paramdata.number);
	$("#td_"+commodityId+"_original").text(paramdata.original);
	$("#td_"+commodityId+"_price").text(paramdata.price);
	$("#td_"+commodityId+"_unit").text(paramdata.unit);
	$("#td_"+commodityId+"_salesVolume").text(paramdata.salesVolume);
	$("#td_"+commodityId+"_shelves").text(paramdata.shelves);
	$("#td_"+commodityId+"_createDate").text(paramdata.createDate);
	$("#td_"+commodityId+"_source").text(paramdata.source);
}

/**
 * 清空输入信息
 * @returns
 */
function emptyInput(){

	$("#commodityId").val("");
	$("#commodityName").val("");
	$("#commodityDetail").val("");
	$("#groupName").val("");
	$("#groupId").val("");
	$("#itemName").val("");
	$("#itemId").val("");
	$("#imgName").val("");
	$("#imgSrc").val("");
	$("#number").val("");
	$("#unit").val("");
	$("#shelves").val("");
	$("#shelvesShow").val("");
	$("#barcode").val("");
	$("#salesVolume").val("");
	$("#original").val("");
	$("#price").val("");
	$("#source").val("");
	$("#detail").val("");
	
	//清除图片上传框
	cleanInputFile("imgFile");

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

	location.href='?search='+getQueryString('search')+'&page='+page;
}

/**
 * 翻页跳转
 * @param obj
 * @returns
 */
function pageJump(obj){
	var page = obj.val(); 
	page = parseInt(page);
	if(page>0){
		location.href='?search='+getQueryString('search')+'&page='+page;
	}
}

/**
 * 搜索按钮
 * @param obj
 * @returns
 */
function search(obj){
	var search = $(obj).val();
	
	var url = "?search="+search;
	url = encodeURI(url);
	location.href=url;
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
 * 清除上传文件的input的file
 * @param id
 * @returns
 */
function cleanInputFile(id){
	var file = $("#"+id);
	file.after(file.clone().val(""));      
	file.remove();  
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
