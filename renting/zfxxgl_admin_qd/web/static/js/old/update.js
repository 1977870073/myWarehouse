var dataArr = []; // 储存所选图片的结果(文件名和base64数据)
window.onload = function() {
    var input = document.getElementById("file_input");
    var result;
    var fd;  //FormData方式发送请求
    var oAdd = document.getElementById("add");
    var oInput = document.getElementById("file_input");

    if (typeof FileReader === 'undefined') {
        alert("抱歉，你的浏览器不支持 FileReader");
        input.setAttribute('disabled', 'disabled');
    } else {
        input.addEventListener('change', readFile, false);
    }　　　　　//handler


    function readFile() {
        fd = new FormData();
        var iLen = this.files.length;
        for (var i = 0; i < iLen; i++) {
            if (!input['value'].match(/.jpg|.gif|.png|.jpeg|.bmp/i)) {　　//判断上传文件格式
                return alert("上传的图片格式不正确，请重新选择");
            }
            var reader = new FileReader();
            fd.append(i, this.files[i]);
            reader.readAsDataURL(this.files[i]);  //转成base64
            reader.fileName = this.files[i].name;

            reader.onload = function (e) {
                var imgMsg = {
                    name: this.fileName,//获取文件名
                    base64: this.result   //reader.readAsDataURL方法执行完后，base64数据储存在reader.result里
                }
                dataArr.push(imgMsg);
                result = '<div class="delete">delete</div><div class="result"><img class="subPic" src="' + this.result + '" alt="' + this.fileName + '"/></div>';
                var div = document.createElement('div');
                div.innerHTML = result;
                div['className'] = 'float';
                document.getElementsByClassName('picshow')[0].appendChild(div);  　　//插入dom树
                var img = div.getElementsByTagName('img')[0];
                img.onload = function () {
                    var nowHeight = ReSizePic(this); //设置图片大小
                    this.parentNode.style.display = 'block';
                    var oParent = this.parentNode;
                    if (nowHeight) {
                        oParent.style.paddingTop = (oParent.offsetHeight - nowHeight) / 2 + 'px';
                    }
                }
                div.onclick = function () {
                    $(this).remove();                  // 在页面中删除该图片元素
                }
            }
        }
    }

    oAdd.onclick = function () {
        oInput.value = "";   // 先将oInput值清空，否则选择图片与上次相同时change事件不会触发
        oInput.click();
    }
}

layui.use('form', function(){
    var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功
    //但是，如果你的HTML是动态生成的，自动渲染就会失效
    //因此你需要在相应的地方，执行下述方法来进行渲染
    form.render();
    var cp01 = getQueryVariable("cp01")
    var cp02 = getQueryVariable("cp02")
    if(isEmpty(cp01)||isEmpty(cp02)||!(cp02=="1"||cp02=="2")){
        layer.msg("未包含页面信息", {icon:5, anim:6});
    }else{
        $.ajax({
            type: 'get',
            url: '/web/do/update/init',
            data: {'id': cp01,"type":cp02},
            dataType: 'json',
            success: function (data) {
                form.val("houseForm", {
                    "price": data.price,
                    "price_type":data.priceType,
                    "house_type": data.houseType,
                    "rental_mode": data.rentalMode,
                    "area": data.area,
                    "floor": data.floor,
                    "allfloor": data.allfloor,
                    "orientation": data.orientation,
                    "renovation": data.renovation,
                    "residential_areas": data.residentialAreas,
                    "residential_note": data.residentialNote,
                    "district": data.district,
                    "name": data.userName,
                    "phone": data.userPhone,
                    "title": data.title,
                    "address": data.address,
                    "id": data.id,
                    "miaoshu":data.miaoshu
                });
            },
            error: function(err){
                if(err.status>=400&&err.status<500){
                    layer.msg(err.status+"网络异常！",{icon: 2, anim: 6})
                }else if(err.status>=500&&err.status<600){
                    layer.msg(err.status+"服务器异常！",{icon: 2, anim: 6})
                }else if(err.status==1000){
                    parent.window.location.href = "/web/zf/html/login.html"
                }else{
                    layer.msg(err.status+ '(' + err.statusText + ')',{icon: 2, anim: 6})
                }
            }
        });
    }
    //监听提交
    form.on('submit(formDemo)', function(data){
        var submitArr = [];
        $('.subPic').each(function () {
                submitArr.push({
                    name: $(this).attr('alt'),
                    base64: $(this).attr('src')
                });
            }
        );
        var price = data.field.price;
        var priceType = data.field.price_type;
        var houseType = data.field.house_type;
        var rentalMode = data.field.rental_mode;
        var area = data.field.area;
        var floor = data.field.floor;
        var allfloor = data.field.allfloor;
        var orientation = data.field.orientation;
        var renovation = data.field.renovation;
        var residentialAreas =  data.field.residential_areas;
        var residentialNote = data.field.residential_note;
        var district = data.field.district;
        var userName =  data.field.name;
        var userPhone = data.field.phone;
        var title = data.field.title;
        var address = data.field.address;
        var id = data.field.id;
        var miaoshu = data.field.miaoshu;

        var index = layer.load(2, {time: 10*1000}); //又换了种风格，并且设定最长等待10秒
        if (submitArr.length>0){
            $.ajax({
                url: '/web/do/update/updateInfo',
                type: 'post',
                ansy: false,
                data: {"price":price,"priceType":priceType,"houseType":houseType,"rentalMode":rentalMode,"area":area,"floor":floor,
                    "allfloor":allfloor,"orientation":orientation,"renovation":renovation,"residentialAreas":residentialAreas,
                    "residentialNote":residentialNote,"district":district,"userName":userName,"userPhone":userPhone,"baseData":JSON.stringify(submitArr),
                    "title":title,"address":address,"id":id,"miaoshu":miaoshu,"cp02":cp02},
                dataType: 'text',
                success: function (data) {
                    if(data=="success"){
                        layer.msg("修改成功!", {icon:1})
                        layer.close(index);
                        window.location.href = '/web/zf/html/comm/selectHouse.html?page=1&uType=1';
                    }else{
                        layer.msg("修改失败", {icon:2, anim:6})
                        layer.close(index);
                        return false;
                    }
                }
            })
        } else{
            $.ajax({
                url: '/web/do/update/updateInfo',
                type: 'post',
                ansy: false,
                data: {"price":price,"priceType":priceType,"houseType":houseType,"rentalMode":rentalMode,"area":area,"floor":floor,
                    "allfloor":allfloor,"orientation":orientation,"renovation":renovation,"residentialAreas":residentialAreas,
                    "residentialNote":residentialNote,"district":district,"userName":userName,"userPhone":userPhone,
                    "title":title,"address":address,"id":id,"miaoshu":miaoshu,"cp02":cp02},
                dataType: 'text',
                success: function (data) {
                    if(data=="success"){
                        layer.msg("修改成功!", {icon:1})
                        layer.close(index);
                        window.location.href = '/web/zf/html/comm/selectHouse.html?page=1&uType=1';
                    }else{
                        layer.msg("修改失败", {icon:2, anim:6})
                        layer.close(index);
                        return false;
                    }
                }
            })
        }


        return false;
    });
});


//图片显示适配
function ReSizePic(ThisPic) {
    var RePicWidth = 200; //显示的宽度值

    var TrueWidth = ThisPic.width; //图片实际宽度
    var TrueHeight = ThisPic.height; //图片实际高度

    if (TrueWidth > TrueHeight) {
        //宽大于高
        var reWidth = RePicWidth;
        ThisPic.width = reWidth;
        //垂直居中
        var nowHeight = TrueHeight * (reWidth / TrueWidth);
        return nowHeight;  //将图片修改后的高度返回，供垂直居中用
    } else {
        //宽小于高
        var reHeight = RePicWidth;
        ThisPic.height = reHeight;
    }
}