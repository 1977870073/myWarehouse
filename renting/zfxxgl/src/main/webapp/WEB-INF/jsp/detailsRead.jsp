<%--
  Created by IntelliJ IDEA.
  User: 呵呵
  Date: 2019/3/31
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>${info.title}</title>
    <%--<link rel="stylesheet" href="https://a.amap.com/jsapi_demos/static/demo-center/css/demo-center.css" />--%>
    <link rel="stylesheet" href="https://cache.amap.com/lbs/static/main1119.css"/>
    <link rel="stylesheet" href="https://cache.amap.com/lbs/static/AMap.PlaceSearchRender1120.css"/>
    <link href="${pageContext.request.contextPath }/img/icon.png" rel="icon" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/layui/css/layui.css" />
    <link href="${pageContext.request.contextPath }/css/details.css" rel="stylesheet">
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

<!--静态搜索栏-->
<div class="static-search">
    <form action="${pageContext.request.contextPath }/index/queryInfo.action" class="searchForm">
        <input type="text" placeholder="输入关键字" class="search-text" name="search"/>
        <input type="submit" value="搜索" class="search-button">
    </form>
</div>

<div class="content">
    <div class="conTop">${info.title}</div>
    <div class="showImg">
        <div class="sImg">
            <div class="bigImg">
                <c:forEach items="${info.pic}" var="pic">
                    <img width="690px" height="440px" src="/upload/${pic}">
                </c:forEach>
            </div>
            <div class="bl" style="opacity: 0"></div>
            <div class="br" style="opacity: 0"></div>
        </div>
        <div class="mImg">
            <div class="mListImg">
                <ul class="litImg" id="litImg">
                    <c:forEach items="${info.pic}" var="pic">
                        <li><img width="120px" height="78px" src="/upload/${pic}"></li>
                    </c:forEach>
                </ul>
            </div>
            <div class="mbl"><img src="${pageContext.request.contextPath }/img/lbtn.png" /></div>
            <div class="mbr"><img src="${pageContext.request.contextPath }/img/rbtn.png" /></div>
        </div>
    </div>
    <div class="rentInfo">
        <div class="rentPrice">
            <p><span>${info.price}</span>元/月 （押二付一）</p>
        </div>
        <div class="rentdiv1">
            <div class="rental_mode"><p>${info.rentalMode}</p><p>出租方式</p></div>
            <div class="house_type"><p>${info.houseType}</p><p>户型</p></div>
            <div class="rentArea"><p>${info.area}平方</p><p>建筑面积</p></div>
        </div>
        <div class="rentdiv2">
            <div class="orientation"><p>${info.orientation}</p><p>朝向</p></div>
            <div class="rentFloor"><p>${info.floor}</p><p>楼层（共${info.allfloor}层）</p></div>
            <div class="renovation"><p>${info.renovation}</p><p>装饰</p></div>
        </div>
        <div class="rentdiv3">
            <div class="residential_areas"><p>小&nbsp;&nbsp;&nbsp;&nbsp;区</p><p>${info.residentialAreas} (${info.district})</p></div>
            <div class="residential_areas2"><p>${info.residentialNote}</p></div>
            <div class="renovation"><p>地&nbsp;&nbsp;&nbsp;&nbsp;址</p><p>${info.address}</p></div>
        </div>
        <div class="rentdiv4">
            <div><img src="../img/noavatars.gif" height="80px"> </div>
            <div class="cInfo">
                <span>${info.userName}</span>
                <p>${info.userPhone}</p>
            </div>
        </div>
        <button class="yuyue">预约房东</button>
    </div>
</div>
<div class="ms">
    <div class="ms_top">房源描述</div>
    <div class="ms_content">
        <c:if test="${empty info.miaoshu}">
            <p id="miaoshu">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;暂无相关描述！</p>
        </c:if>
        <c:if test="${not empty info.miaoshu}">
            <p id="miaoshu">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${info.miaoshu}</p>
        </c:if>
    </div>
</div>
<%--地图--%>
<div class="cityMap">
    <div class="map-top">地图</div>
    <div id="container" style="width: 1000px;height: 600px;"></div>
    <div id="panel"></div>
</div>
<p style="display: none;" id="houseid">${info.id}</p>
<p id="address" hidden>${info.district}${info.address}${info.residentialAreas}</p>

<script type="text/javascript" src="https://webapi.amap.com/maps?v=1.4.14&key=0466ce613d6cc03b9b2a4e214c67ee89&plugin=AMap.PlaceSearch"></script>
<script type="text/javascript" src="https://cache.amap.com/lbs/static/PlaceSearchRender.js"></script>
<script type="text/javascript" src="https://cache.amap.com/lbs/static/addToolbar.js"></script>
<script src="${pageContext.request.contextPath }/js/jquery-3.3.1.min.js"></script>
<script src="${pageContext.request.contextPath }/layui/layui.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath }/js/general.js"></script>
<script src="${pageContext.request.contextPath }/js/details.js"></script>
</body>
</html>

<script type="text/javascript">
    var map = new AMap.Map("container", {
        resizeEnable: true
    });
    var placeSearch = new AMap.PlaceSearch({
        // city 指定搜索所在城市，支持传入格式有：城市名、citycode和adcode
        city: '广州'
    })
    placeSearch.search($("#address").text(), function (status, result) {
        // 查询成功时，result即对应匹配的POI信息
        var pois = result.poiList.pois;
        for(var i = 0; i < pois.length; i++){
            var poi = pois[i];
            var marker = [];
            marker[i] = new AMap.Marker({
                position: poi.location,   // 经纬度对象，也可以是经纬度构成的一维数组[116.39, 39.9]
                title: poi.name
            });
            // 将创建的点标记添加到已有的地图实例：
            map.add(marker[i]);
        }
        map.setFitView();

    })

    layui.use(['form','layer','laydate'], function () {
        var layer = layui.layer,
            form = layui.form,
            laydate = layui.laydate;
        laydate.render({
            elem: '#utime'
            ,type: 'datetime'
        });
        layer.config({
            extend: 'skin/style.css' //同样需要加载新皮肤
        });
        $('.yuyue').on("click", function () {
            yyboxClear();
            var yybox = layer.open({
                type: 1
                ,title: "填写预约信息" //不显示标题栏：false
                ,closeBtn: false
                ,area: '430px;'
                ,shade: 0.8
                ,skin: 'layer-ext-moon'
                ,shadeClose: true //是否点击遮蔽关闭
                ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
                ,btn: ['确定', '返回']
                ,btnAlign: 'c'
                ,moveType: 1 //拖拽模式，0或者1
                ,content: $('#yybox')
                ,yes: function () {
                    var uname = $('#uname').val();
                    var uphone = $('#uphone').val();
                    var utime = $('#utime').val();
                    var beizhu = $('#beizhu').val();
                    var house = $('#houseid').text();
                    if(isEmpty(uname)){
                        layer.msg("联系人不能为空！",{icon:2, anim:6})
                        $('#uname').select();
                        return false;
                    }
                    if(isEmpty(uphone)){
                        layer.msg("联系电话不能为空！",{icon:2, anim:6})
                        $('#uphone').select();
                        return false;
                    }
                    if(isEmpty(utime)){
                        layer.msg("预约时间不能为空！",{icon:2, anim:6})
                        return false;
                    }
                    $.ajax({
                        type: 'post',
                        url: '${pageContext.request.contextPath}/appointment/addAppointment.action',
                        data: {'uname':uname,'uphone':uphone,'utime':utime,'beizhu':beizhu,'id':house},
                        success: function (data) {
                            if(data=="success"){
                                layer.msg("预约成功，正在等待房东同意！", {icon:1});
                                layer.close(yybox);
                                return true;
                            }else{
                                layer.msg("预约失败！", {icon:2, anim:6});
                                return false;
                            }
                        }
                    })
                }
            });
        });
    })
    function yyboxClear() {
        $('#uname').val('');
        $('#uphone').val('');
        $('#utime').val('');
        $('#beizhu').val('');

    }
</script>
<div id="yybox" style="display: none;">
    <form class="layui-form" action="">
        <div class="layui-form-item">
            <label class="layui-form-label xyy">联系人</label>
            <div class="layui-input-inline">
                <input type="text" name="uname" id="uname" maxlength="20" required lay-verify="required" placeholder="请输入联系人" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label xyy">联系电话</label>
            <div class="layui-input-inline">
                <input type="text" name="uphone" id="uphone"maxlength="15" required lay-verify="required|phone|number" placeholder="请输入联系电话" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label xyy">预约时间</label>
            <div class="layui-input-inline">
                <input type="text" class="layui-input" placeholder="请选择预约时间"  id="utime" required lay-verify="required">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label xyy">备注</label>
            <div class="layui-input-inline">
                <textarea id="beizhu" rows="5" name="beizhu" placeholder="请输入内容"maxlength="150"  class="layui-textarea"></textarea>
            </div>
        </div>
    </form>
</div>
</html>