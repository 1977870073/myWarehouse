window.onload = function(){
    BIGblAndbrFun();
    SMALLblAndbrFun();
	//获取页面数据
	var cp01 = getQueryVariable("cp01");
	if(!isEmpty(cp01)){
		$.ajax({
			type: 'get',
			url: '/web/do/approval/selectInfo',
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

//获取链接中的参数
function getQueryVariable(variable)
{
   var query = window.location.search.substring(1);
   var vars = query.split("&");
   for (var i=0;i<vars.length;i++) {
	   var pair = vars[i].split("=");
	   if(pair[0] == variable){return decodeURI(pair[1]);}//改动
   }
   return false;
}
//判断变量是否为空
function isEmpty(obj){
    if(typeof obj == "undefined" || obj == null || obj == ""){
        return true;
    }else{
        return false;
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
    var width = 131;
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
	$('#tYes').click(function(){
		tYes(data.id,data.user);
	});
	$('#tNo').click(function(){
		tNo(data.id,data.user);
	});
	
}

function tYes(id,user) {
	$.ajax({
		url: '/web/do/approval/tYes',
		type: 'post',
		data: {"id":id,"user":user},
		dataType: 'text',
		success: function (data) {
			console.log(data)
			if(data=="success"){
				alert("操作成功！");
				window.location.href = '/web/zf/html/htgl/index.html';
			}else{
				alert("操作失败！");
			}
		}
	})
}

function tNo(id,user) {
	$.ajax({
		url: '/web/do/approval/tNo',
		type: 'post',
		data: {"id":id,"uu":user},
		dataType: 'text',
		success: function (data) {
			console.log(data)
			if(data=="success"){
				alert("操作成功！");
				window.location.href = '/web/zf/html/htgl/index.html';
			}else{
				alert("操作失败！");
			}
		}
	})
}