/**
 * index.js
 */

function but_enter() {
	//获取表单，提交请求，要求
	//要求addr、room、phone
	var discrict = $("#discrict").find("option:selected").text();
	var number = $("#number").find("option:selected").text();
	var unit = $("#unit").find("option:selected").text();
	var room = $("#room").find("option:selected").text();
	var addr = discrict + "区" + number + "号楼" + unit + "单元" + room + "号";
	
	var name = $("#name").val();
	var phone = $("#phone").val();
	
	var url = "../index/enterOsm.do";
	url = encodeURI(url)
	//TODO 实际实现，使用post提交表单
	var paramdata = {
		addr : addr,
		name : name,
		phone : phone,
	};	
	$.ajax({
		type: 'post',
		url:url,
		data: paramdata,
		async:true,
		success: function() {
			window.location.href = "../index/group.do";
		},
		error: function() {
			alert("对不起，进入超市失败，请联系店主");
		}
	});
}