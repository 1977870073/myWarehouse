function getInfo(id) {
    $.ajax({
        type: 'post',
        url: '/web/do/appointment/getAppointmentInfoById',
        data: {"id":id},
        dataType: 'json',
        success: function (data) {
            if(data!=null){
                $('#yyuser').html(data.userName+"("+data.user+")");
                $('#yyuname').html(data.uname);
                $('#yyuphone').html(data.uphone);
                $('#yytime').val(data.utime);
                var url = "/web/zf/html/comm/detailsRead.html?cp01="+data.house;
                var title = "<a href='javascript:;' onclick='kk(\""+url+"\")'>"+data.title+"</a>";
                $('#yytitle').html(title);
                $('#yybz').html(data.beizhu);
                $('#yyid').val(id);
            }else{
                layer.msg("获取信息失败！")
            }
        }
    });
}

function btnYes(id,notice, time) {
    $.ajax({
        type: 'post',
        url: '/web/do/appointment/toYes',
        data: {"id":id, "notice": notice, "time":time},
        success: function (data) {
            if(data=="success"){
                layer.msg("操作成功！", {icon: 1});
            }else{
                layer.msg("操作失败！", {icon: 2, anim: 6});
            }
        }
    });
}
function btnNo(id,notice) {
    $.ajax({
        type: 'post',
        url: '/web/do/appointment/toNo',
        data: {"id":id, "notice": notice},
        success: function (data) {
            if(data=="success"){
                layer.msg("操作成功！", {icon: 1});
            }else{
                layer.msg("操作失败！", {icon: 2, anim: 6});
            }
        }
    });
}

function clearInfo() {
    $('#yyuser').html("");
    $('#yyuname').html("");
    $('#yyuphone').html("");
    $('#yytime').val("");
    $('#yytitle').html("");
    $('#yybz').html("");
    $('#fdNotice').val("");
    $('#yyid').val("");
}