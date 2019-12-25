window.onload = function(){
    var page = getQueryVariable("page");
    var uType = getQueryVariable("uType");
    if(isEmpty(uType)){
        if(isEmpty(page)){
            query(1,uType);
        }else{
            query(page,uType);
        }
	}else{
        if(isEmpty(page)){
            query(1,0);
        }else{
            query(page,0);
        }
	}

}
//获取房源数据
function query(num,uType){
	$.ajax({
        type: 'get',
        url: '/web/do/house/init',
        data: {"page": num,"userType": uType},
        dataType: 'json',
        success: function(data){
            renderHTML(data);
        },
        error: function(errorMsg){
            alert("网络链接失败！")
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
					page_startToend_html+="<a href='/web/zf/html/htgl/selectHouse.html?page="+i+"' class='page_active'  target='_self'>"+i+"</a>";
				}else{
					page_startToend_html+="<a href='/web/zf/html/htgl/selectHouse.html?page="+i+"'  target='_self'>"+i+"</a>";
				}
			}
			$("#page_startToend").html(page_startToend_html);
		}
	}
}
//删除
function del(id) {
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

//跳转修改页面
function tiaozhuan(id) {
	window.location.href="/web/zf/html/htgl/update.html?cp01="+id;
}
