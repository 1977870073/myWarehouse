window.onload = function(){
    BIGblAndbrFun();
    SMALLblAndbrFun();
    //获取页面数据
    var cp01 = getQueryVariable("cp01");
    if(!isEmpty(cp01)){
        $.ajax({
            type: 'get',
            url: '/web/do/detailsRead/init',
            data: {"bh": cp01},
            dataType: 'json',
            success: function(data){
                init(data);
            },
            error: function(errorMsg){
                alert("网络链接失败！")
            }
        });
    }
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

function init(data){
    document.title = data.title;
    $('#title').text(data.title);
    $('#rentPrice').text(data.price);
    $('#rental_mode').text(data.rentalMode);
    $('#house_type').text(data.houseType);
    $('#rentArea').text(data.area);
    $('#orientation').text(data.orientation);
    $('#rentFloor').text(data.floor);
    $('#rentAllFloor').text(data.allfloor);
    $('#renovation').text(data.renovation);
    $('#residential_areas').text(data.residentialAreas+"("+data.district+")");
    $('#residential_areas2').text(data.residentialNote);
    $('#rentAddress').text(data.address);
    $('#cName').text(data.userName);
    $('#cPhone').text(data.userPhone);
    var pic = data.pic;
    var bigHtml = "";
    var litHtml = "";
    for(var i=0; i<pic.length; i++){
        bigHtml +="<img width='690px' height='440px' src='/web/img/"+pic[i]+"'>";
        if(i==0){
            litHtml +="<li class='cur'><img src='/web/img/"+pic[i]+"'></li>";
        }else{
            litHtml +="<li><img src='/web/img/"+pic[i]+"'></li>";
        }
    }
    $('#bigImg').html(bigHtml);
    $('#litImg').html(litHtml);
    $('#address').text(data.district+data.address+data.residentialAreas);
    var miaoshu  = data.miaoshu;
    var ms="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    if(isEmpty(miaoshu)){
        ms+="暂无相关描述！";
    }else{
        ms+=miaoshu;
    }
    $('#miaoshu').html(ms);
    gaode();
}

function gaode() {
    var map = new AMap.Map("container", {
        resizeEnable: true
    });
    var placeSearch = new AMap.PlaceSearch({
        // city 指定搜索所在城市，支持传入格式有：城市名、citycode和adcode
        city: '广州'
    })
    placeSearch.search($("#address").text(), function (status, result) {
        // 查询成功时，result即对应匹配的POI信息
        var pois = result.poiList.pois;
        for(var i = 0; i < pois.length; i++){
            var poi = pois[i];
            var marker = [];
            marker[i] = new AMap.Marker({
                position: poi.location,   // 经纬度对象，也可以是经纬度构成的一维数组[116.39, 39.9]
                title: poi.name
            });
            // 将创建的点标记添加到已有的地图实例：
            map.add(marker[i]);
        }
        map.setFitView();

    })
}