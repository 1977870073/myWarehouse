// 隐藏显示信息，who必须为id，obj为class，index为索引
function showHidden(who,obj,index){
    var a  = document.getElementById(who);
    var hid = document.getElementsByClassName(obj)[index];
    a.onmouseover = function () {
        hid.style.left = a.offsetLeft+"px";
        hid.style.display="block"
        a.style.background = "#ac0000";
    }
    a.onmouseout = function () {
        a.style.background = "#c73733";
        hid.style.display="none"
    }
}
//返回顶部
function toTop(){
    var currentScroll = document.documentElement.scrollTop || document.body.scrollTop;
    if (currentScroll > 0) {
        //可以在下一帧开始时调用指定函数
        window.requestAnimationFrame(toTop);
        window.scrollTo (0,currentScroll - (currentScroll/5));
    }
}
//获取url中参数
function getQueryVariable(variable)
{
    var query = window.location.search.substring(1);
    var vars = query.split("&");
    for (var i=0;i<vars.length;i++) {
        var pair = vars[i].split("=");
        if(pair[0] == variable){return pair[1];}
    }
    return(false);
}
//判断参数是否为空
function isEmpty(obj){
    if(typeof obj == "undefined" || obj == null || obj == ""){
        return true;
    }else{
        return false;
    }
}