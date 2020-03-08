<%--
  Created by IntelliJ IDEA.
  User: 呵呵
  Date: 2019/3/31
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>通知</title>
    <link href="${pageContext.request.contextPath }/img/icon.png" rel="icon" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/layui/css/layui.css" />
    <link href="${pageContext.request.contextPath }/css/top.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/css/admin.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/css/general.css" rel="stylesheet">
    <style>
        .note-list-del{
            float: right;
        }
        .note-list-del:hover{
            color: #3379f1;
            text-decoration: underline;
        }
    </style>
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
        <c:if test="${empty sessionScope.username}">
            <div class="userRegister top-general" style="margin-left: 20px;" onclick="window.location.href='${pageContext.request.contextPath }/register/init.action'">
                <a href="#">
                    <img src="${pageContext.request.contextPath }/img/register.png"  style="margin-top: 10px;"/>
                    <span>注册</span>
                </a>
            </div>
        </c:if>
    </div>
</div>

<!--内容-->
<div class="note-edge" style="margin: 50px auto 0 150px;width: 1000px;">
    <!--最新通知-->
    <div class="panel panel-default comment-panel">
        <div class="panel-header">通知<a href="javascript:;" onclick="delAll()" style="float:right;color: #999;font-size: 13px;" id="qksy">
            <c:if test="${queryInfo!=null&&queryInfo.size()>0}">清空所有</c:if></a></div>
        <div class="panel-body">
            <div class="commentbox" id="content">
                <c:if test="${queryInfo!=null&&queryInfo.size()>0}">
                    <ul class="commentList">
                        <c:forEach items="${queryInfo}" var="info">
                            <li class="item cl">
                                <c:if test="${info.sendflag==2}">
                                    <a href="#"><i class="avatar size-L radius"><img alt="" src="https://dev-file.iviewui.com/userinfoPDvn9gKWYihR24SpgC319vXY8qniCqj4/avatar"></i></a>
                                </c:if>
                                <c:if test="${info.sendflag==3}">
                                    <a href="#"><i class="avatar size-L radius"><img alt="" src="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1577622095210&di=e55aa52bbb40f103997ada9cf56f8c17&imgtype=0&src=http%3A%2F%2Fimg.qqzhi.com%2Fuploads%2F2019-04-13%2F102207491.jpg"></i></a>
                                </c:if>
                                <div class="comment-main">
                                    <header class="comment-header">
                                        <div class="comment-meta"><a class="comment-author" href="#">
                                            <c:if test="${info.sendflag==2}">
                                                管理员
                                            </c:if>
                                            <c:if test="${info.sendflag==3}">
                                                房东
                                            </c:if>
                                        </a> 发送于
                                            <time title="${info.dotime}" datetime="${info.dotime}">${info.dotime}</time>
                                            <a href="javascript:;" onclick="del(${info.id},this)" style="float:right;">删除</a>
                                        </div>
                                    </header>
                                    <div class="comment-body">
                                        <p>${info.message}</p>
                                    </div>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>
                </c:if>
                <c:if test="${queryInfo==null||queryInfo.size()<=0}">
                <div class="content-null">
                    <span>您没有收到消息！</span>
                </div>
                </c:if>
            </div>
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath }/js/jquery-3.3.1.min.js"></script>
<script src="${pageContext.request.contextPath }/layui/layui.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/js/general.js"></script>
<script type="application/javascript">
    window.onload=function () {
        showHidden("top-address","top-hidden",0);
        showHidden("userLogin","top-hidden",1);
    }
    //删除消息
    function del(id, dd) {
        $.ajax({
            type: 'post',
            url: '${pageContext.request.contextPath }/notice/delNotice.action',
            data:{"id":id},
            success: function(data){
                if(data=="success") {
                    var ddd = dd.parentNode.parentNode.parentNode.parentNode;
                    $(ddd).css("display", "none");
                }else{
                    layer.msg("删除失败！")
                }
            }
        });
    }
    //删除所有消息
    function delAll() {
        $.ajax({
            type: 'get',
            url: '${pageContext.request.contextPath }/notice/delAllNotice.action',
            success: function(data){
                if(data=="success") {
                    window.location.href="${pageContext.request.contextPath }/notice/init.action";
                }else{
                    layer.msg("删除失败！")
                }
            }
        });
    }
</script>
</body>
</html>