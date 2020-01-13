<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>房信网</title>
    <link rel="icon" href="${pageContext.request.contextPath }/img/icon.png">
    <link href="${pageContext.request.contextPath }/css/index.css" rel="stylesheet">
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
        <div class="notice top-general" style="margin-left: 20px;" title="通知" onclick="window.location.href='${pageContext.request.contextPath }/notice/init.action'">
                <img src="${pageContext.request.contextPath }/img/notice.png" style="margin-top: 10px;"/>
                <c:if test="${flag==1}">
                    <span>new</span>
                </c:if>
        </div>
    </div>
</div>
<!--悬浮搜索栏-->
<div class="scroll-search" hidden="hidden">
    <div class="search-content">
            <input type="text" placeholder="输入关键字" class="search-text"/>
            <input type="button" value="搜索" class="search-button">
            <input type="button" value="我要出租" onclick="window.location.href='${pageContext.request.contextPath }/addHouseInfo/init.action'" class="renting-button">
    </div>
    <div class="search-close"></div>
</div>

<!--静态搜索栏-->
<div class="static-search">
        <input type="text" placeholder="输入关键字" class="search-text"/>
        <input type="button" value="搜索" class="search-button">
</div>

<!--条件选择菜单栏-->
<div class="choseNav">
    <h3 class="choseNavTop">筛选</h3>
    <div class="choseNavLists">
        <dl class="choseList c1">
            <dt>区域：</dt>
            <dd>
                <c:if test="${empty choose.district or choose.district=='不限'}">
                    <a href="#" class="listFocus">不限</a>
                </c:if>
                <c:if test="${not empty choose.district}">
                    <a href="#">不限</a>
                </c:if>
                <c:forEach items="${choose.c1}" var="c">
                    <c:if test="${c==choose.district}">
                        <a href="#" class="listFocus">${c}</a>
                    </c:if>
                    <c:if test="${c!=choose.district}">
                        <a href="#">${c}</a>
                    </c:if>
                </c:forEach>
            </dd>
        </dl>
        <dl class="choseList c2">
            <dt>租金：</dt>
            <dd>
                <c:if test="${empty choose.priceRange or choose.priceRange=='不限'}">
                    <a href="#" class="listFocus">不限</a>
                </c:if>
                <c:if test="${not empty choose.priceRange}">
                    <a href="#">不限</a>
                </c:if>
                <c:forEach items="${choose.c2}" var="c">
                    <c:if test="${c==choose.priceRange}">
                        <a href="#" class="listFocus">${c}</a>
                    </c:if>
                    <c:if test="${c!=choose.priceRange}">
                        <a href="#">${c}</a>
                    </c:if>
                </c:forEach>
            </dd>
        </dl>
        <dl class="choseList c3">
            <dt>户型：</dt>
            <dd>
                <c:if test="${empty choose.houseType or choose.houseType=='不限'}">
                    <a href="#" class="listFocus">不限</a>
                </c:if>
                <c:if test="${not empty choose.houseType}">
                    <a href="#">不限</a>
                </c:if>
                <c:forEach items="${choose.c3}" var="c">
                    <c:if test="${c==choose.houseType}">
                        <a href="#" class="listFocus">${c}</a>
                    </c:if>
                    <c:if test="${c!=choose.houseType}">
                        <a href="#">${c}</a>
                    </c:if>
                </c:forEach>
            </dd>
        </dl>
        <dl class="choseList c4">
            <dt>方式：</dt>
            <dd>
                <c:if test="${empty choose.rentalMode or choose.rentalMode=='不限'}">
                    <a href="#" class="listFocus">不限</a>
                </c:if>
                <c:if test="${not empty choose.rentalMode}">
                    <a href="#">不限</a>
                </c:if>
                <c:forEach items="${choose.c4}" var="c">
                    <c:if test="${c==choose.rentalMode}">
                        <a href="#" class="listFocus">${c}</a>
                    </c:if>
                    <c:if test="${c!=choose.rentalMode}">
                        <a href="#">${c}</a>
                    </c:if>
                </c:forEach>
            </dd>
        </dl>
        <dl class="choseList c5">
            <dt>朝向：</dt>
            <dd>
                <c:if test="${empty choose.orientation or choose.orientation=='不限'}">
                    <a href="#" class="listFocus">不限</a>
                </c:if>
                <c:if test="${not empty choose.orientation}">
                    <a href="#">不限</a>
                </c:if>
                <c:forEach items="${choose.c5}" var="c">
                    <c:if test="${c==choose.orientation}">
                        <a href="#" class="listFocus">${c}</a>
                    </c:if>
                    <c:if test="${c!=choose.orientation}">
                        <a href="#">${c}</a>
                    </c:if>
                </c:forEach>
            </dd>
        </dl>
    </div>
</div>

<!--右侧菜单栏-->
<div class="rightNav">
    <a href="${pageContext.request.contextPath }/addHouseInfo/init.action" title="发布房源" target="_blank"><div class="fabu"></div></a>
    <a href="${pageContext.request.contextPath }/collection/init.action" title="收藏房源" target="_blank"><div class="shoucang"></div></a>
    <div class="toTop" onclick="toTop()"></div>
</div>

<!--内容-->
<div class="content">
    <div class="content-top">全部房源</div>
    <c:if test="${queryInfo!=null&&queryInfo.size()>0}">
        <c:forEach var="info" items="${queryInfo }">
            <dl class="conList">
                <dt>
                    <a href="${pageContext.request.contextPath }/details/selectInfo.action?id=${info.id}" target="_blank">
                        <img src="/upload/${info.picture}" width="220px" height="165.24px">
                    </a>
                </dt>
                <dd>
                    <p><a href="${pageContext.request.contextPath }/details/selectInfo.action?id=${info.id}" target="_blank">${info.title}</a></p>
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
                </dd>
            </dl>
        </c:forEach>
    </c:if>
    <c:if test="${queryInfo.size()<=0}">
        <div class="content-null">
            <span>抱歉，没有房子的信息！</span>
        </div>
    </c:if>


    <div class="page">
        <a href="#">首页<span style="display: none">1</span></a>
        <c:if test="${page.pagNum<=page.start}">
            <a href="#">上一页<span style="display: none">${page.start}</span></a>
        </c:if>
        <c:if test="${page.pagNum>page.start}">
            <a href="#">上一页<span style="display: none">${page.pagNum-1}</span></a>
        </c:if>
        <c:forEach var="i" begin="${page.start}" end="${page.end}">
            <c:if test="${i==page.pagNum}">
                <a href="#"  class="page_active">${i}<span style="display: none">${i}</span></a>
            </c:if>
            <c:if test="${i!=page.pagNum}">
                <a href="#">${i}<span style="display: none">${i}</span></a>
            </c:if>
        </c:forEach>
        <c:if test="${page.pagNum>=page.totalPage}">
            <a href="#">下一页<span style="display: none">${page.totalPage}</span></a>
        </c:if>
        <c:if test="${page.pagNum<page.end}">
            <a href="#">下一页<span style="display: none">${page.pagNum+1}</span></a>
        </c:if>
        <a href="#">尾页<span style="display: none">${page.totalPage}</span></a>
        <span>共${page.totalPage}页</span>
    </div>

</div>


<!--底部-->
<div class="bottom">
    <i>---------------我是有底线的--------------------</i>
</div>

<script type="text/javascript" src="${pageContext.request.contextPath }/js/index.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/general.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.3.1.min.js"></script>
</body>
</html>
<script type="text/javascript">
    var c1,c2,c3,c4,c5,page;
    var search_text,search_button;
    var ahref = "${pageContext.request.contextPath }/index/queryInfo.action?";
    window.onload = function(){
        showHidden("top-address","top-hidden",0);
        showHidden("userLogin","top-hidden",1);
        var searchClose = document.getElementsByClassName("search-close")[0];
        searchClose.onclick = function () {
            closeFlag = false;
            sc.hidden = true;
        }
        for (var i = 1; i <=5 ; i++) {
            choseList(".c"+i+" a");
        }
        pageList('.page a');
        search_text = document.getElementsByClassName("search-text");
        search_button  = document.getElementsByClassName("search-button");
        search_button[0].onclick = function () {
            getText();
            window.location.href=ahref+"search="+search_text[0].value;
        }
        search_button[1].onclick = function () {
            getText();
            window.location.href=ahref+"search="+search_text[1].value;
        }
    }
    function getText(){
        c1 = $('.c1 a.listFocus').text();
        c2 = $('.c2 a.listFocus').text();
        c3 = $('.c3 a.listFocus').text();
        c4 = $('.c4 a.listFocus').text();
        c5 = $('.c5 a.listFocus').text();
        page = $('.page_active').text();
    }

    function pageList(obj){
        $(obj).click(function () {
            // console.log("a:"+$(this).children('span').text())
            getText();
            page = $(this).children('span').text()
            window.location.href=ahref+"index="+page+"&c1="+c1+"&c2="+c2+"&c3="+c3+"&c4="+c4+"&c5="+c5;
        });
    }

    function choseList(obj){
        $(obj).click(function() {
            $(this).parent().each(function () {//移除其余非点中状态
                $(obj).removeClass("listFocus");
            });
            $(this).addClass("listFocus");//给所点中的增加样式
            getText();
            page=1;
             // console.log("page:"+page+",c1:"+c1+",c2:"+c2+",c3:"+c3+",c4:"+c4+",c5:"+c5);
            window.location.href=ahref+"index="+page+"&c1="+c1+"&c2="+c2+"&c3="+c3+"&c4="+c4+"&c5="+c5;
        });
    }
</script>