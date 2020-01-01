window.onload = function () {
    query();
}
//获取房源数据
function query(){
    $.ajax({
        type: 'get',
        url: '/web/do/notice/getData',
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
    window.parent.hasNewNotice();
}
//将数据渲染到content
function renderHTML(json){
    if(json.queryInfo==null || json.queryInfo == undefined){
        var content_html = "<div class=\"content-null\">\n" +
            "            <span>您没有收到消息！</span>\n" +
            "        </div>";
        $("#content").html(content_html);
    }else{
        $("#content-info").tmpl(json).appendTo("#content");
    }
}