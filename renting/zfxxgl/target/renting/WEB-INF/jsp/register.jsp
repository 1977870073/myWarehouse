<%--
  Created by IntelliJ IDEA.
  User: 呵呵
  Date: 2019/3/31
  Time: 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>注册</title>
    <link href="${pageContext.request.contextPath }/img/icon.png" rel="icon" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/layui/css/layui.css" />
</head>
<body style="background: #eee;">
<ul class="layui-nav">
    <li class="layui-nav-item">
        <a href="javascript:;" onClick="javascript:history.back();">《返回</a>
    </li>
    <li class="layui-nav-item">
        <a href="${pageContext.request.contextPath }/login/init.action">登录</a>
    </li>
</ul>
<div style="margin: 30px 100px;padding: 10px 20px;background: #ffffff;height: 450px;">
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>注册账号</legend>
    </fieldset>
    <form class="layui-form layui-form-pane" action="">
        <div class="layui-form-item">
            <label class="layui-form-label">用户名</label>
            <div class="layui-input-inline">
                <input type="text" name="username" id="username" lay-verify="required|username" placeholder="请输入用户名" autocomplete="off" class="layui-input" onblur="checkFD()">
            </div>
            <div class="layui-form-mid" style="color: #fd4410;display: none;" id="exitUser">用户名已存在！</div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">昵称</label>
            <div class="layui-input-inline">
                <input type="text" name="ncname" lay-verify="required" placeholder="请输入昵称" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">密码</label>
            <div class="layui-input-inline">
                <input type="password" name="password" lay-verify="required|password" placeholder="请输入密码" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">确认密码</label>
            <div class="layui-input-inline">
                <input type="password" name="checkpassword" lay-verify="required|password" placeholder="请输入确认密码" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">邮箱</label>
            <div class="layui-input-inline">
                <input type="text" name="email" lay-verify="required|email" placeholder="请输入邮箱" autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux">请务必填写邮箱，系统将通过该邮箱发送激活码！</div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button type="submit" class="layui-btn" lay-submit="" lay-filter="zcfd">注册</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>
<script src="${pageContext.request.contextPath }/js/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath }/js/aes.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath }/layui/layui.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath }/js/general.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
    var exit = true;
    layui.use(['form'],function (){
        var form = layui.form;
        //自定义验证规则
        form.verify({
            username: function(value) {
                if(value.length < 6) {
                    return '用户名少于6个字符';
                }
            },
            password: [/(.+){6}$/, '密码少于6个字符']
        });
        //监听提交
        form.on('submit(zcfd)', function(data) {
            var password = data.field.password;
            var checkpassword = data.field.checkpassword;
            var index = layer.load(2, {time: 10*1000});
            if(password == checkpassword){
                var username = data.field.username;
                username = encrypt(username);
                password = encrypt(password);
                var nc = data.field.ncname;
                var email = data.field.email;
                if(exit){
                    $.ajax({
                        url: '${pageContext.request.contextPath }/register/registerUser.action',
                        type: 'post',
                        data: {"arg1":username,"arg2":password,"arg3":nc,"arg4":email},
                        dataType: 'text',
                        success: function (data) {
                            if(data=="success"){
                                layer.close(index);
                                layer.msg("注册成功！请前往邮箱激活。");
                                setTimeout(function () {
                                    window.location.href = '${pageContext.request.contextPath }/index/queryInfo.action';
                                },1000)
                            }else if(data=="exit"){
                                layer.close(index);
                                layer.msg("用户名已存在");
                            }else{
                                layer.close(index);
                                layer.msg("系统异常");
                            }
                        },
                        error: function(err){
                            layer.close(index);
                            if(err.status>=400&&err.status<500){
                                layer.msg(err.status+"网络异常！",{icon: 2, anim: 6})
                            }else if(err.status>=500&&err.status<600){
                                layer.msg(err.status+"服务器异常！",{icon: 2, anim: 6})
                            }else{
                                layer.msg(err.status+ '(' + err.statusText + ')',{icon: 2, anim: 6})
                            }
                        }
                    })
                }else{
                    layer.close(index);
                    layer.msg("用户名已存在,请换个用户名试试。");
                }
            }else{
                layer.close(index);
                layer.msg("密码不一致");
            }
            return false;
        });
    })
    function checkFD() {
        var username = $("#username").val();
        if(!isEmpty(username)){
            username = encrypt(username);
            $.ajax({
                type: 'post',
                url: '${pageContext.request.contextPath }/register/userIsExit.action',
                data: {"arg1": username},
                success:function (data) {
                    if(data=="exit"){
                        exit=false;
                        $("#exitUser").css("display","block");
                    }else{
                        exit=true;
                        $("#exitUser").css("display","none");
                    }
                }
            });
        }
    }
    function encrypt(word){
        var key = CryptoJS.enc.Utf8.parse("abcdefgabcdefg12");
        var srcs = CryptoJS.enc.Utf8.parse(word);
        var encrypted = CryptoJS.AES.encrypt(srcs, key, {mode:CryptoJS.mode.ECB,padding: CryptoJS.pad.Pkcs7});
        return encrypted.toString();
    }
</script>
</body>
</html>

