var cp01;
window.onload = function () {
    cp01 = getQueryVariable("cp01");
    if(!isEmpty(cp01)){
        query();
    }else{
        alert("无法正常访问该网页！");
    }
}
//获取通知数据
function query(){
    $.ajax({
        type: 'get',
        url: '/web/do/notice/getData',
        data:{"type":cp01},
        dataType: 'json',
        success: function(data){
            renderHTML(data);
            reloadTZ();
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
//将通知的红点去掉
function reloadTZ() {
    window.parent.hasNewNotice(cp01);
}
//将数据渲染到content
function renderHTML(json){
    if(json.queryInfo==null || json.queryInfo == undefined || json.queryInfo.length<=0){
        var content_html = "<div class=\"content-null\">\n" +
            "            <span>您没有收到消息！</span>\n" +
            "        </div>";
        $("#content").html(content_html);
        $("#qksy").css("display","none");
    }else{
        $("#content").html("");
        $("#content-info").tmpl(json).appendTo("#content");
        $("#qksy").css("display","block");
    }
}
//删除消息
function del(id) {
    $.ajax({
        type: 'post',
        url: '/web/do/notice/delNotice',
        data:{"id":id},
        success: function(data){
            query();
        }
    });
}
//删除所有消息
function delAll() {
    $.ajax({
        type: 'get',
        url: '/web/do/notice/delAllNotice',
        success: function(data){
            query();
        }
    });
}