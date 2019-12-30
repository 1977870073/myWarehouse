var cp02;
window.onload = function(){
    var page = getQueryVariable("page");
    var uType = getQueryVariable("uType");
    if(isEmpty(uType)){
        if(isEmpty(page)){
            query(1,0);
        }else{
            query(page,0);
        }
	}else{
    	cp02=uType;
        if(isEmpty(page)){
            query(1,uType);
        }else{
            query(page,uType);
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
        error: function(err){
            if(err.status>=400&&err.status<500){
                alert(err.status+"网络异常！")
            }else if(err.status>=500&&err.status<600){
                alert(err.status+"服务器异常！")
            }else if(err.status==1000){
                parent.window.location.href = "/web/zf/html/login.html"
            }else{
                alert(err.status+ '(' + err.statusText + ')')
            }
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
			url: '/web/do/house/deleteInfo',
			type: 'post',
			data: {"id":id},
			dataType: 'text',
			success: function (data) {
				if(data=="success"){
					alert("删除成功")
					window.location.href = '/web/zf/html/comm/selectHouse.html?page=1&uType=1';
				}else{
					alert("删除失败")
				}
			}
		})
	}
}

//跳转修改页面
function tiaozhuan(id) {
	if(isEmpty(cp02)){
		alert("页面信息不全，无法正常修改");
		return false;
	}
	window.location.href="/web/zf/html/comm/update.html?cp01="+id+"&cp02="+cp02;
}
