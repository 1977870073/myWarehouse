window.onload = function(){
    showHidden("top-address","top-hidden",0);
    showHidden("userLogin","top-hidden",1);
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