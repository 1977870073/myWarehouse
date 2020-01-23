<%--
  Created by IntelliJ IDEA.
  User: 呵呵
  Date: 2020/1/14
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>个人中心</title>
    <link href="${pageContext.request.contextPath }/img/icon.png" rel="icon" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/layui/css/layui.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/user/home.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/fonts_expand/iconfont.css"/>
    <link href="${pageContext.request.contextPath }/css/top.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath }/css/general.css" rel="stylesheet">
</head>
<body>
<!--导航栏-->
<div class="top">
    <a href="${pageContext.request.contextPath }/index/queryInfo.action?index=1" class="top-title">房信网</a>
    <div id="top-address"  class="top-general"  style="margin-left: 20px;">
        <div>广州<img src="${pageContext.request.contextPath }/img/navicon.gif"></div>
        <div class="top-hidden" style="display: none">
            <div class="sanjiao"></div>
            <div class="hidden-content">暂无其它地区</div>
        </div>
    </div>
    <div class="top-general" onclick="window.location.href='${pageContext.request.contextPath }/index/queryInfo.action?index=1'">首页</div>
    <div class="top-right">
        <div class="userLogin top-general" id="userLogin" onclick="window.location.href='${pageContext.request.contextPath }/login/init.action'">
            <c:if test="${not empty sessionScope.username}">
                <div>
                    <img src="${pageContext.request.contextPath }/img/login.png" style="margin-top: 10px;"/>
                    <span id="yhname">${sessionScope.username}</span>
                </div>
                <div class="top-hidden" style="display: none">
                    <div class="sanjiao"></div>
                    <div class="hidden-content" style="width: 100px;height: auto;">
                        <a href="#">个人中心</a><br />
                        <a href="${pageContext.request.contextPath }/myRenting/init.action">我的出租</a><br />
                        <a href="${pageContext.request.contextPath }/collection/init.action">我的收藏</a><br />
                        <a href="${pageContext.request.contextPath }/index/invalidate.action">退出</a><br />
                    </div>
                </div>
            </c:if>
            <c:if test="${empty sessionScope.username}">
                <div>
                    <img src="${pageContext.request.contextPath }/img/login.png" style="margin-top: 10px;"/>
                    <span>登陆</span>
                </div>
            </c:if>
        </div>
    </div>
</div>

<div class="home-content">
    <div class="home-icon"><img src="http://img.qqzhi.com/uploads/2018-12-15/225610954.jpg" alt="" ></div>
    <div class="home-content-info mczh"><span id="fd">房东</span><i class="layui-badge">用户</i></div>
    <div class="home-content-info"><i class="iconfont info-start-icon" title="账号">&#xe64b;</i><span id="zh">123456</span></div>
    <div class="home-content-info"><i class="iconfont info-start-icon" title="邮箱">&#xe739;</i><span id="yx">123@qq.com</span></div>
    <div class="home-content-info"><i class="iconfont info-start-icon" title="个性签名">&#xe61c;</i>在路上，可以耽于风景，却不可忘记再度启程。</div>
    <div class="home-content-info xg">
        <a href="javascript:;" class="layui-btn layui-btn-normal xgxx">修改信息</a>
    </div>
</div>

<div class="home-bottom">
    <span>感谢广大用户使用我们的租房网站</span>
</div>

<script src="${pageContext.request.contextPath }/js/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath }/layui/layui.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/general.js"></script>
<script>
    layui.use(['form','layer'], function () {
        var layer = layui.layer,
            form = layui.form;

        $('.xgxx').on("click", function () {
            initBox();
            layer.open({
                type: 1
                ,title: false //不显示标题栏：false
                ,closeBtn: false
                ,area: '350px;'
                ,shade: 0.8
                ,shadeClose: false //是否点击遮蔽关闭
                ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
                ,btn: ['修改', '返回']
                ,btnAlign: 'c'
                ,moveType: 1 //拖拽模式，0或者1
                ,content: $('#xgbox')
                ,yes: function () {
                    return updateInfo();
                }
            });
        });
    })

    window.onload=function () {
        showHidden("top-address","top-hidden",0);
        showHidden("userLogin","top-hidden",1);
        init();
    }

    function init() {
        var fd = $("#fd");
        var zh = $("#zh");
        var yx = $("#yx");
        $.ajax({
            type: 'get',
            url: '${pageContext.request.contextPath }/user/getUsesInfo.action',
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
            url: '${pageContext.request.contextPath }/user/getUsesInfo.action',
            success: function(data){
                xname.val(data.name);
                xemail.val(data.email);
            }
        });
    }

    function updateInfo() {
        var xname = $("#xname").val();
        var xemail = $("#xemail").val();
        $.ajax({
            type: 'get',
            url: '${pageContext.request.contextPath }/user/updateUserIfo.action',
            data:{"xname":xname, "xemail": xemail},
            success: function(data){
                if(data=="success"){
                    layer.msg("修改成功！");
                    $("#yhname").html(xname);
                    init();
                    return true;
                }else{
                    layer.msg("修改失败！", {icon:2, anim:6});
                    return false;
                }
            }
        });
    }
</script>
</body>
<div id="xgbox" style="display: none;">
    <form class="layui-form" action="">
        <div class="layui-form-item">
            <label class="layui-form-label xnotice">昵称</label>
            <div class="layui-input-inline">
                <input type="text" name="xname" id="xname" required lay-verify="required" placeholder="请输入昵称" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label xnotice">邮箱</label>
            <div class="layui-input-inline">
                <input type="text" name="xemail" id="xemail" required lay-verify="required|email" placeholder="请输入邮箱" autocomplete="off" class="layui-input">
            </div>
        </div>
    </form>
</div>
</html>
