<%--
  Created by IntelliJ IDEA.
  User: 呵呵
  Date: 2020/1/13
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>激活成功！</title>
    <link href="${pageContext.request.contextPath }/img/icon.png" rel="icon" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/layui/css/layui.css" />
    <style>
        .fly-marginTop{
            width: 750px;
            margin: 50px auto;
            text-align: center;
        }
        .fly-panel {
            margin-bottom: 15px;
            border-radius: 2px;
            background-color: #fff;
            box-shadow: 0 1px 2px 0 rgba(0,0,0,.05);
        }
        .fly-none {
            min-height: 400px;
            text-align: center;
            padding-top: 50px;
            color: #999;
        }
        .fly-none .icon-tishilian {
            display: inline-block;
            margin: 30px 0 20px;
        }
        .fly-none .iconfont {
            line-height: 300px;
            font-size: 300px;
            color: #393D49;
        }
        .div-hidden{
            display: none;
        }
    </style>
</head>
<body>
<ul class="layui-nav">
    <li class="layui-nav-item">
        <a href="#" onClick="javascript:history.back();">《返回</a>
    </li>
    <li class="layui-nav-item">
        <a href="${pageContext.request.contextPath }/login/queryInfo.action">登录</a>
    </li>
</ul>
<div class="layui-container fly-marginTop">
    <div class="fly-panel">
        <div class="fly-none">
            <h2><i class="iconfont"><img src="${pageContext.request.contextPath }/img/yz_success.png"></i></h2>
            <p>激活成功！</p>
        </div>
    </div>
    <div class="fly-panel div-hidden">
        <div class="fly-none">
            <h2><i class="iconfont"><img src="${pageContext.request.contextPath }/img/yz_success.png"></i></h2>
            <p>验证成功！</p>
        </div>
    </div>
    <div class="fly-panel  div-hidden">
        <div class="fly-none">
            <h2><i class="iconfont"><img src="${pageContext.request.contextPath }/img/yz_error.png"></i></h2>
            <p>验证失败！</p>
        </div>
    </div>
    <a href="#" id="tiaozhuan"></a>
</div>
<script src="${pageContext.request.contextPath }/js/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath }/layui/layui.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath }/js/general.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
    window.onload = function () {
        var div = document.getElementsByClassName("fly-panel");
        var arg1 = getQueryVariable("arg1");
        var arg2 = getQueryVariable("arg2");
        var arg3 = getQueryVariable("arg3");

        if(!isEmpty(arg1)&&!isEmpty(arg3)){
            if(!isEmpty(arg2)){
                if(arg2=="3"){
                    var url = "${pageContext.request.contextPath }/login/activationZYH.action";
                    urlFun(url);
                }else if(arg2=="4"){
                    var url = "${pageContext.request.contextPath }/login/activationWJYH.action";
                    urlFun(url);
                    div[0].classList.add("div-hidden");
                    div[1].classList.remove("div-hidden");
                }else{
                    div[0].classList.add("div-hidden");
                    div[2].classList.remove("div-hidden");
                }
            }
        }
        function  urlFun(url) {
            $.ajax({
                type: 'post',
                url: url,
                data:{'arg1':arg1, 'arg2':arg3},
                success:function (data) {
                    if(data[0]=="success"){
                        var a = document.getElementById("tiaozhuan");
                        a.href="${pageContext.request.contextPath }"+data[1];
                        a.innerText=data[2];
                    }else{
                        alert("校验码已超过有效期，请重新发送！")
                    }
                },
                error: function(err){
                    alert(err.status+"网络异常！");
                }
            });
        }
    }


</script>
</body>
</html>

