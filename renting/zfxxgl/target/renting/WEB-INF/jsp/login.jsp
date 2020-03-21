<%--
  Created by IntelliJ IDEA.
  User: 呵呵
  Date: 2019/3/31
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <title>登录</title>
    <link href="${pageContext.request.contextPath }/img/icon.png" rel="icon" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/layui/css/layui.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/login.css" />
</head>

<body>
<div class="m-login-bg">
    <div class="m-login">
        <h3>租房信息管理系统登录</h3>
        <div class="m-login-warp">
            <form class="layui-form" id="fangdong">
                <div class="layui-form-item">
                    <input type="text" name="g_title" required lay-verify="f_title" placeholder="用户名" autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-item">
                    <input type="password" name="g_password" required lay-verify="f_password" placeholder="密码" autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <input type="text" name="g_verity" required lay-verify="f_verity" placeholder="验证码" autocomplete="off" class="layui-input">
                    </div>
                    <div class="layui-inline">
                        <canvas id="g_canvas" width="100" height="43" onclick="g_dj()" style="border: 1px solid #ccc; border-radius: 5px;"></canvas>
                    </div>
                </div>
                <div class="layui-form-item m-login-btn">
                    <div class="layui-inline">
                        <button class="layui-btn layui-btn-normal" lay-submit lay-filter="g_login">登录</button>
                    </div>
                    <div class="layui-inline">
                        <button type="reset" class="layui-btn layui-btn-primary">取消</button>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <a href="${pageContext.request.contextPath}/register/init.action">注册账号</a>
                    </div>
                    <div class="layui-inline">
                        <a href="${pageContext.request.contextPath}/login/initForger.action">忘记密码</a>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath }/js/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath }/js/aes.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath }/layui/layui.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath }/js/login.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath }/js/general.js" type="text/javascript" charset="utf-8"></script>
<script>
    layui.use(['form','element'], function() {
        var form = layui.form,
            layer = layui.layer;
        var element = layui.element;

        //自定义验证规则
        form.verify({
            g_title: function(value) {
                if(value.length < 6) {
                    return '用户名少于6个字符';
                }
            },
            g_password: [/(.+){6}$/, '密码少于6个字符'],
            g_verity: [/(.+){4}$/, '验证码必须是4位'],

        });
        //监听提交
        form.on('submit(g_login)', function(data) {
            var verity = data.field.g_verity;
            var index = layer.load(2, {time: 10*1000});
            if(checkedVerity("g_canvas",verity)){
                var username = encrypt(data.field.g_title);
                var password = encrypt(data.field.g_password);
                $.ajax({
                    url: '${pageContext.request.contextPath }/login/verification.action',
                    type: 'post',
                    data: {"username":username,"password":password},
                    dataType: 'text',
                    success: function (data) {
                        if(data=="success"){
                            layer.close(index);
                            var cp01 = getQueryVariable("cp01");
                            if(!isEmpty(cp01)){
                                window.location.href ='${pageContext.request.contextPath }/details/selectInfo.action?id='+cp01;
                                return;
                            }
                            window.location.href = '${pageContext.request.contextPath }/index/queryInfo.action';
                        }else if(data=="passE"){
                            layer.close(index);
                            layer.msg("密码错误！",{icon: 2, anim: 6})
                        }else if(data=="actiE"){
                            layer.close(index);
                            layer.msg("账号未激活,请激活后再登陆!",{icon: 2, anim: 6})
                        }else{
                            layer.close(index);
                            layer.msg("用户名不存在!",{icon: 2, anim: 6})
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
                layer.msg("验证码错误");
            }
            return false;
        });

    });
</script>
</body>

</html>