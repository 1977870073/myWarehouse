window.onload = function(){
    showHidden("top-address","top-hidden",0);
    showHidden("userLogin","top-hidden",1);
    BIGblAndbrFun();
    SMALLblAndbrFun();
}
var afterImg = 0;
// 小图片左右事件
function SMALLblAndbrFun(){
    var litImg =document.getElementsByClassName("litImg")[0];
    var list = litImg.getElementsByTagName("li");
    var mbl = document.getElementsByClassName("mbl")[0];
    var mbr = document.getElementsByClassName("mbr")[0];
    var bigImg = document.getElementsByClassName("bigImg")[0].getElementsByTagName("img");
    var IndexImg = 1;
    var endImg = list.length;
    var width = 126;
    list[0].className="cur";
    litImg.style.width = width*list.length+"px";

    mbl.onclick = function(){
        IndexImg = ImgLast(bigImg,IndexImg);
        turnLeftImg();
    }
    mbr.onclick = function(){
        IndexImg = ImgNext(bigImg,IndexImg);
        turnRightImg();
    }
}
function turnLeftImg(){
    var litImg =document.getElementsByClassName("litImg")[0];
    var list = litImg.getElementsByTagName("li");
    var mbl = document.getElementsByClassName("mbl")[0];
    var mbr = document.getElementsByClassName("mbr")[0];
    var bigImg = document.getElementsByClassName("bigImg")[0].getElementsByTagName("img");
    var IndexImg = 1;
    var endImg = list.length;
    var width = 126;
    afterImg = turnLeft(litImg,list,afterImg,endImg,width);
}
function turnRightImg(){
    var litImg =document.getElementsByClassName("litImg")[0];
    var list = litImg.getElementsByTagName("li");
    var mbl = document.getElementsByClassName("mbl")[0];
    var mbr = document.getElementsByClassName("mbr")[0];
    var bigImg = document.getElementsByClassName("bigImg")[0].getElementsByTagName("img");
    var IndexImg = 1;
    var endImg = list.length;
    var width = 126;
    afterImg = turnRight(litImg,list,afterImg,endImg,width);
}
//小图片向右横移
function turnRight(litImg,list,a,endImg,width){
    a++;
    if(width*(a+5)>width*list.length){
        if(a>=endImg){
            a=0;
            litImg.style.left = -0+"px";
        }else{
            litImg.style.left = -(endImg-5)*width+"px";
        }
    }else{
        litImg.style.left = -a*width+"px";
    }
    for (var i = 0; i < list.length; i++) {
        list[i].className = "";
        if (i==a){
            list[i].className="cur";
        }
    }
    return a
}
//小图片向左横移
function turnLeft(litImg,list,a,endImg,width){
    a--;
    if(a<5){
        if(a<0){
            a=endImg-1;
            litImg.style.left = -(a-4)*width+"px";
        }else{
            litImg.style.left = -0+"px";
        }
    }else{
        litImg.style.left = -(a-4)*width+"px";
    }
    for (var i = 0; i < list.length; i++) {
        list[i].className = "";
        if (i==(a-1)){
            list[i].className="cur";
        }
    }
    return a;
}
//大图片左右事件
function BIGblAndbrFun(){
    var bl = document.getElementsByClassName("bl")[0];
    var br = document.getElementsByClassName("br")[0];
    var bigImg = document.getElementsByClassName("bigImg")[0].getElementsByTagName("img");
    var IndexImg = 1;
    var endImg = bigImg.length;
    bl.onmouseover = function(){
        fadeIn(bl,500);
    }
    br.onmouseover = function(){
        fadeIn(br,500)
    }
    bl.onmouseout = function(){
        fadeOut(bl,200);
    }
    br.onmouseout = function(){
        fadeOut(br,200)
    }
    bl.onclick = function(){
        IndexImg = ImgLast(bigImg,IndexImg);
        turnLeftImg();
    }
    br.onclick = function(){
        IndexImg = ImgNext(bigImg,IndexImg);
        turnRightImg();
    }

}
//上一张
function ImgLast(obj,IndexImg){
    var endImg = obj.length;
    if(IndexImg==1){
        IndexImg=endImg;
    }else{
        IndexImg-=1;
    }
    for (var i = 0; i < obj.length; i++) {
        if((i+1)==IndexImg){
            if(IndexImg==endImg){
                fadeOut(obj[0],800);
            }else{
                fadeOut(obj[i+1],800);
            }
            fadeIn(obj[i],800)
            obj[i].style.zIndex  = 10;
        }else{
            obj[i].style.zIndex  = -1;
        }
    }
    return IndexImg;
}
//下一张
function ImgNext(obj,IndexImg){
    var endImg = obj.length;
    if(IndexImg==endImg){
        IndexImg=1;
    }else{
        IndexImg+=1;
    }
    for (var i = 0; i < obj.length; i++) {
        if((i+1)==IndexImg){
            if(IndexImg==1){
                fadeOut(obj[endImg-1],800);
            }else{
                fadeOut(obj[i-1],800);
            }
            fadeIn(obj[i],800)
            obj[i].style.zIndex  = 10;
        }else{
            obj[i].style.zIndex  = -1;
        }
    }
    return IndexImg;
}


//淡入
function  fadeIn(obj,time) {
    var startTime = new Date();
    obj.style.opacity=0;
    var timer = setInterval(function () {
        var nowTime = new Date();
        var prop = (nowTime-startTime)/time;
        if(prop>=1){
            prop = 1;
            clearInterval(timer);
        }
        obj.style.opacity = prop;
    },13);
}
//淡出
function  fadeOut(obj,time) {
    var startTime=new Date();
    obj.style.opacity=1;//设置下初始值透明度
    var timer=setInterval(function(){
            var nowTime=new Date();
            var prop=(nowTime-startTime)/time;
            if(prop>=1){
                prop=1;//设置最终系数值
                clearInterval(timer);
            }
            obj.style.opacity=1-prop;//透明度公式： 初始值+系数*（结束值-初始值）
        },13);//每隔13ms执行一次function函数
}
