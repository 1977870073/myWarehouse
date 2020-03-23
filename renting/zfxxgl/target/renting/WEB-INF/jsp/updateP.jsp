<%--
  Created by IntelliJ IDEA.
  User: 呵呵
  Date: 2020/1/13
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>修改密码</title>
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
        <legend>修改密码</legend>
    </fieldset>
    <form class="layui-form" action="">
        <div class="layui-form-item">
            <label class="layui-form-label">用户名:</label>
            <label class="layui-form-label" id="username">xxx</label>
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
            <div class="layui-input-block">
                <button type="submit" class="layui-btn" lay-submit="" lay-filter="xgfd">修改</button>
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
    var arg1;
    window.onload = function(){
        arg1 = getQueryVariable("arg1");
        if(!isEmpty(arg1)){
            document.getElementById("username").innerText = arg1;
        }
    }
    layui.use(['form'],function (){
        var form = layui.form;
        //自定义验证规则
        form.verify({
            password: [/(.+){6}$/, '密码少于6个字符']
        });
        //监听提交
        form.on('submit(xgfd)', function(data) {
            var password = data.field.password;
            var checkpassword = data.field.checkpassword;
            var index = layer.load(2, {time: 10*1000});
            if(password == checkpassword){
                if(!isEmpty(arg1)){
                    password = encrypt(password);
                    arg1 = encrypt(arg1);
                    $.ajax({
                        url: '${pageContext.request.contextPath }/login/updatePassword.action',
                        type: 'post',
                        data: {"arg1":arg1,"arg2":password},
                        dataType: 'text',
                        success: function (data) {
                            if(data=="success"){
                                layer.close(index);
                                window.location.href = '${pageContext.request.contextPath }/login/init.action';
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
                }
            }else{
                layer.close(index);
                layer.msg("密码不一致");
            }
            return false;
        });
    })
    function encrypt(word){
        var key = CryptoJS.enc.Utf8.parse("abcdefgabcdefg12");
        var srcs = CryptoJS.enc.Utf8.parse(word);
        var encrypted = CryptoJS.AES.encrypt(srcs, key, {mode:CryptoJS.mode.ECB,padding: CryptoJS.pad.Pkcs7});
        return encrypted.toString();
    }
</script>
</body>
</html>
