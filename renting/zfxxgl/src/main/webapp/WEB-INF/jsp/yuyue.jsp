<%--
  Created by IntelliJ IDEA.
  User: 呵呵
  Date: 2020/1/19
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>预约房源</title>
    <link href="${pageContext.request.contextPath }/img/icon.png" rel="icon" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/layui/css/layui.css" />
    <link href="${pageContext.request.contextPath }/css/top.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/css/general.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/css/yuyue.css" rel="stylesheet">
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
                    <span>${sessionScope.username}</span>
                </div>
            </c:if>
            <c:if test="${empty sessionScope.username}">
                <div>
                    <img src="${pageContext.request.contextPath }/img/login.png" style="margin-top: 10px;"/>
                    <span>登陆</span>
                </div>
            </c:if>
            <div class="top-hidden" style="display: none">
                <div class="sanjiao"></div>
                <div class="hidden-content" style="width: 100px;height: auto;">
                    <a href="${pageContext.request.contextPath }/user/initUserInfo.action">个人中心</a><br />
                    <a href="${pageContext.request.contextPath }/collection/init.action">我的收藏</a><br />
                    <a href="${pageContext.request.contextPath }/appointment/initYuyue.action">我的预约</a><br />
                    <a href="${pageContext.request.contextPath }/index/invalidate.action">退出</a><br />
                </div>
            </div>
        </div>
    </div>
</div>

<div class="content">
    <div class="layui-tab">
        <ul class="layui-tab-title">
            <li class="layui-this">为过期预约信息</li>
            <li>过期预约信息</li>
        </ul>
        <div class="layui-tab-content">
            <div class="layui-tab-item layui-show">
                <table  class="layui-hide" id="yyInfo"></table>
            </div>
            <div class="layui-tab-item">
                <table  class="layui-hide" id="yygqInfo"></table>
            </div>
        </div>
    </div>
</div>
    <script type="text/html" id="biaoti">
        <a href="${pageContext.request.contextPath }/details/selectInfo.action?id={{d.house}}&cp01=yyxx" class="layui-table-link" target="_blank">{{d.title}}</a>
    </script>
    <script type="text/html" id="caozuo">
        <button type="button" class="layui-btn layui-btn-fluid layui-btn-ms layui-btn-radius layui-btn-warm" onclick="del({{d.id}})">删除</button>
    </script>
    <script src="${pageContext.request.contextPath }/js/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath }/layui/layui.js" type="text/javascript" charset="utf-8"></script>
    <script>
        layui.use(['table','element'],function () {
            var table = layui.table,
                element = layui.element;

            table.render({
                elem: '#yyInfo'
                ,url:'${pageContext.request.contextPath }/appointment/getyyinfo.action'
                ,cellMinWidth: 60
                ,size: 'lg'
                ,parseData: function (res) {
                    return {
                        "code": 0,
                        "msg": "",
                        "count": res[0],
                        data: res[1]
                    }
                }
                ,cols: [[
                    {field:'rownum',  title: '序号'}
                    ,{field:'title', title: '预约房源', templet: '#biaoti'}
                    ,{field:'user_name', title: '联系人'}
                    ,{field:'user_phone', title: '联系电话'}
                    ,{field:'utime', title: '预约时间'}
                    ,{field:'caozuo', title: '操作', width: '300', templet: '#caozuo'}
                ]],
                text: {
                    none: '暂无有效预约房源信息！'
                }
                ,page: true
            });
            table.render({
                elem: '#yygqInfo'
                ,url:'${pageContext.request.contextPath }/appointment/getgqyyinfo.action'
                ,cellMinWidth: 60
                ,size: 'lg'
                ,parseData: function (res) {
                    return {
                        "code": 0,
                        "msg": "",
                        "count": res[0],
                        data: res[1]
                    }
                }
                ,cols: [[
                    {field:'rownum',  title: '序号'}
                    ,{field:'title', title: '预约房源', templet: '#biaoti'}
                    ,{field:'utime', title: '预约时间'}
                    ,{field:'caozuo', title: '操作', width: '300', templet: '#caozuo'}
                ]],
                text: {
                    none: '暂无有效预约房源信息！'
                }
                ,page: true
            });
        })
    </script>
</body>
</html>
