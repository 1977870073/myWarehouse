var closeFlag = true;
var sc = document.getElementsByClassName("scroll-search")[0];
window.onscroll = function(){
    if(closeFlag){
        scrollSearch(sc);
    }
}

function choseList(obj){
    $(obj).click(function() {
        $(this).parent().each(function () {//移除其余非点中状态
            $(obj).removeClass("listFocus");
        });
        $(this).addClass("listFocus");//给所点中的增加样式
        // console.log(obj+"-->"+$(obj.split(" ")[0]).attr('class').split(" ")[1])
        c1 = $('.c1 a.listFocus').text();
        c2 = $('.c2 a.listFocus').text();
        c3 = $('.c3 a.listFocus').text();
        c4 = $('.c4 a.listFocus').text();
        c5 = $('.c5 a.listFocus').text();
        console.log("c1:"+c1+",c2:"+c2+",c3:"+c3+",c4:"+c4+",c5:"+c5);
    });

}

function scrollSearch(obj){
    var hei = window.pageYOffset;
    if(parseInt(hei)>150){
        obj.hidden = false;
    }else{
        obj.hidden = true;
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
