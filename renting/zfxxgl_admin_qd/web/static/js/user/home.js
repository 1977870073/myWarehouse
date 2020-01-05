window.onload=function () {
    init();
}

function init() {
    var fd = $("#fd");
    var zh = $("#zh");
    var yx = $("#yx");
    $.ajax({
        type: 'get',
        url: '/web/do/user/getUsesInfo',
        success: function(data){
            fd.html(data.name);
            zh.html(data.username);
            yx.html(data.email);
        }
    });
}

function initBox() {
    var xname = $("#xname");
    var xemail = $("#xemail");
    $.ajax({
        type: 'get',
        url: '/web/do/user/getUsesInfo',
        success: function(data){
            xname.val(data.username);
            xemail.val(data.email);
        }
    });
}

function updateInfo() {
    var xname = $("#xname").val();
    var xemail = $("#xemail").val();
    $.ajax({
        type: 'get',
        url: '/web/do/user/updateUserIfo',
        data:{"xname":xname, "xemail": xemail},
        success: function(data){
            if(data=="seccess"){
                layer.msg("修改成功！");
                init();
                return true;
            }else{
                layer.msg("修改失败！", {icon:2, anim:6});
                return false;
            }
        }
    });
}