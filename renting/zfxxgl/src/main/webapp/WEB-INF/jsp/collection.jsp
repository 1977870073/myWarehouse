<%--
  Created by IntelliJ IDEA.
  User: 呵呵
  Date: 2019/3/31
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>我的收藏</title>
    <link href="${pageContext.request.contextPath }/img/icon.png" rel="icon" />
    <link href="${pageContext.request.contextPath }/css/collection.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/css/top.css" rel="stylesheet">
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
                    <a href="#">个人中心</a><br />
                    <a href="${pageContext.request.contextPath }/myRenting/init.action">我的出租</a><br />
                    <a href="${pageContext.request.contextPath }/collection/init.action">我的收藏</a><br />
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

<!--右侧菜单栏-->
<div class="rightNav">
    <div class="toTop" onclick="toTop()"></div>
</div>


<!--内容-->
<div class="content">
    <div class="content-top">我的收藏</div>
    <c:if test="${queryInfo!=null&&queryInfo.size()>0}">
        <c:forEach var="info" items="${queryInfo }">
            <dl class="conList">
                <dt>
                    <a href="${pageContext.request.contextPath }/detailsRead/init.action?id=${info.id}" target="_blank">
                        <img src="/upload/${info.picture}" width="220px" height="165.24px">
                    </a>
                </dt>
                <dd>
                    <p><a href="${pageContext.request.contextPath }/detailsRead/init.action?id=${info.id}" target="_blank">${info.title}</a></p>
                    <p>
                            ${info.rentalMode}
                        <span class="splitline">|</span>
                            ${info.houseType}
                        <span class="splitline">|</span>
                            ${info.area}平方
                        <span class="splitline">|</span>
                            ${info.orientation}
                    </p>
                    <p>${info.district}-${info.residentialAreas}</p>
                    <p>${info.residentialNote}</p>
                    <p><span>${info.price}</span>元/月</p>
                    <button type="button" class="delete" onclick="send(${info.id})">删&nbsp;除</button>
                </dd>
            </dl>
        </c:forEach>
    </c:if>
    <c:if test="${queryInfo.size()<=0}">
        <div class="content-null">
            <span>您没有收藏的房子！</span>
        </div>
    </c:if>
</div>

<script src="${pageContext.request.contextPath }/js/jquery-3.3.1.min.js"></script>
<script src="${pageContext.request.contextPath }/js/general.js"></script>
<script src="${pageContext.request.contextPath }/js/collection.js"></script>
</body>
</html>
<script type="text/javascript">
    function send(id) {
        var flag = confirm("确定要删除吗？")
        if(flag==true){
            $.ajax({
                url: '${pageContext.request.contextPath }/collection/deleteInfo.action',
                type: 'post',
                data: {"id":id},
                dataType: 'text',
                success: function (data) {
                    if(data=="success"){
                        alert("删除成功")
                        window.location.href = '${pageContext.request.contextPath }/collection/init.action';
                    }else{
                        alert("删除失败")
                    }
                }
            })
        }
    }
</script>