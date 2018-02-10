/**
 * manageBatch.js
 */

/**
 * 加载时执行
 */
$(function(){ 
　　

}); 

/**
 * 批量插入方法
 */
function submitAdds(flag){
	
	//检查上传文件是否为空
	var file = $('#importXlsx_input').val();
	if(file==''){
		notification('top','center',"文件为空，请选择上传文件",1);
		return ;
	}
	
	//使用异步提交，提高用户体验，提交后关闭提交按钮功能，避免重复提交
	if(!flag){
		return ;
	}else{
		$("#submitAddList").attr("onclick","submitAdds(false);");//关闭提交按钮功能，避免重复提交
	}
	var url = "importXlsx.do";
	url = encodeURI(url);
	
	/*var paramdata = {
		group_id : groupId,
	};	*/
	
	var data = new FormData($( "#commodityAddForm")[0]);  
	//提示用户请稍后
	notification('top','center',"正在导入，请稍后",1);
	$.ajax({
		type: 'post',
		url:url,
		data: data,
		async: true,  
        cache: false,  //不缓存页面
        contentType: false,  //multipart/form-data形式必须
        processData: false,  //multipart/form-data形式必须
		success: function(data) {
			var parseFlag = data.parseFlag;
			if(!parseFlag){
				//如果文件解析失败，直接返回
				$("#importResult").text("导入失败，文件解析错误，请检查上传文件");
				notification('top','center',"导入失败，文件解析错误，请检查上传文件",4);
				$("#submitAddList").attr("onclick","submitAdds(true);");//重新开启提交按钮功能
				return ;
			}
			var returnInfo = data.returnInfo;
			var failureList = data.failureList;
			$("#infoResult").text(returnInfo);
			if(failureList.length>0){
				$("#error_info").text("错误信息");
				var dom = '';
				for (var i in failureList){
					dom += '<tr><td>'+failureList[i]+'</td></tr>';
				}
				
				$("#importResult_tbody").empty();
				$("#importResult_tbody").append(dom);
				notification('top','center',returnInfo,4);
			}else{
				$("#error_info").text("");
				$("#importResult_tbody").empty();
				notification('top','center',returnInfo,1);
			}
			
			$("#submitAddList").attr("onclick","submitAdds(true);");//重新开启提交按钮功能
		},
		error: function() {
			alert("MSG ERROR");
		}
	});
}

/**
 * 批量删除，起止点商品信息获取
 * @param point					start或end
 * @param commodityId	商品id
 * @returns
 */
function findCommodity(point,commodityId){
	
	var url = "../manage/findCommodityById.do";
	url = encodeURI(url);
	
	var paramdata = {
		commodityId : commodityId
	};	
	
	$.ajax({
		type: 'post',
		url:url,
		data: paramdata,
		dataType: "json",
		async:true,
		success: function(data) {
			if(data==null){
				if(point=="start"){
					$("#start_comodityName").val("");
					$("#start_comodityDetail").val("");
				}
				if(point=="end"){
					$("#end_comodityName").val("");
					$("#end_comodityDetail").val("");
				}
				notification('top','center'," 编号 "+commodityId+" 号商品不存在 , 请重新输入",4);
				return ;
			}
			var commodityName = data.commodityName;
			var commodityDetail = data.commodityDetail;
			if(point=="start"){
				$("#start_comodityName").val(commodityName);
				$("#start_comodityDetail").val(commodityDetail);
			}
			if(point=="end"){
				$("#end_comodityName").val(commodityName);
				$("#end_comodityDetail").val(commodityDetail);
			}
		},
		error: function() {
			alert("MSG ERROR");
		}
	});
}

/**
 * 通过起止点，批量删除商品信息
 * 
 * (废弃，取消批量删除功能)
 * @param start
 * @param end
 * @returns
 */
function deleteList(start,end){
	var flag = confirm("确认要删除 "+start+" 号到 "+end+" 号的商品么?");
	if(!flag){
		return ;
	}
	
	start = parseInt(start);
	end = parseInt(end);
	if(start>end){
		notification('top','center'," 开始编号 "+start+" 大于结束编号 "+end+" , 请重新输入",4);
		return;
	}
	var url = "../manage/deleteCommodityByRange.do";
	url = encodeURI(url);
	
	var paramdata = {
		startCommodityId : start,
		endCommodityId : end
	};	
	
	$.ajax({
		type: 'post',
		url:url,
		data: paramdata,
		dataType: "json",
		async:true,
		success: function(data) {
			$("#infoResult").text("批量删除 , 从 "+start+" 号到 "+end+" 号的商品 "+data+" 个");
			notification('top','center',"批量删除 , 从 "+start+" 号到 "+end+" 号的商品 "+data+" 个",1);
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
