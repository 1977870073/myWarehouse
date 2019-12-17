window.onload = function(){
	// query();
}
function query(num){
	$.ajax({
		type: 'get',
		url: '/web/do/house/init',
		data: {page:num},
		success: function(data){
			renderHTML(data);
		},
		error{
			
		}
	});
}
//将数据渲染到content
function renderHTML(json){
	if(json.queryInfo==null || json.queryInfo == undefined){
		var content_html = "<div class='content-top'>出租房屋</div><div class='content-null'><span>您没有出租的房子！</span></div>";
		$("#content").html(content_html);
	}else{
		$("#content-info").tmpl(json).appendTo("#content");
		var page_startToend_html = "";
		var page = json.page;
		if(page!=null){
			for(var i = page.start; i<=page.end; i++){
				if(i==page.pagNum){
					page_startToend_html+="<a href='#'  class='page_active'>"+i+"</a>";
				}else{
					page_startToend_html+="<a href='#' >"+i+"</a>";
				}
			}
			$("#page_startToend").html(page_startToend_html);
		}
	}
}
//删除
function send(id) {
	var flag = confirm("确定要删除吗？")
	if(flag==true){
		$.ajax({
			url: '#',
			type: 'post',
			data: {"id":id},
			dataType: 'text',
			success: function (data) {
				if(data=="success"){
					alert("删除成功")
					window.location.href = '#';
				}else{
					alert("删除失败")
				}
			}
		})
	}
}