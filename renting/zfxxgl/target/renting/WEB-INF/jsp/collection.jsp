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
                    <a href="${pageContext.request.contextPath }/user/initUserInfo.action">个人中心</a><br />
                    <a href="${pageContext.request.contextPath }/collection/init.action">我的收藏</a><br />
                    <a href="${pageContext.request.contextPath }/appointment/initYuyue.action">我的预约</a><br />
                    <a href="${pageContext.request.contextPath }/index/invalidate.action">退出</a><br />
                </div>
            </div>
        </div>
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
                    <c:if test="${info.flag==2}">
                        <div class="mask">
                            <h3>已下架</h3>
                        </div>
                    </c:if>
                </dt>
                <dd>
                    <p>
                        <c:if test="${info.flag==2}">
                            <a href="javascript:void(0)" target="_blank">${info.title}</a>
                        </c:if>
                        <c:if test="${info.flag!=2}">
                            <a href="${pageContext.request.contextPath }/detailsRead/init.action?id=${info.id}" target="_blank">${info.title}</a>
                        </c:if>
                    </p>
                    <p>
                            ${info.rental_mode}
                        <span class="splitline">|</span>
                            ${info.house_type}
                        <span class="splitline">|</span>
                            ${info.area}平方
                        <span class="splitline">|</span>
                            ${info.orientation}
                    </p>
                    <p>${info.district}-${info.residential_areas}</p>
                    <p>${info.residential_note}</p>
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