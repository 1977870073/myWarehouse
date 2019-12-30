layui.use(['layer', 'form', 'element', 'jquery', 'dialog'], function() {
	var layer = layui.layer;
	var element = layui.element;
	var form = layui.form;
	var $ = layui.jquery;
	var dialog = layui.dialog;
	var hideBtn = $('#hideBtn');
	var mainLayout = $('#main-layout');
	var mainMask = $('.main-mask');
    setName();//设置用户名
	//监听左侧菜单点击
	element.on('nav(leftNav)', function(elem) {
		var id = elem[0].attributes[2].value;
		var url = elem[0].attributes[1].value;
		var text = elem[0].attributes[3].value;
		if(!url){
			return;
		}
		var isActive = $('.main-layout-tab .layui-tab-title').find("li[lay-id=" + id + "]");
		if(isActive.length > 0) {
			//切换到选项卡
			element.tabChange('tab', id);
		} else {
			element.tabAdd('tab', {
				title: text,
				content: '<iframe src="' + url + '" name="iframe' + id + '" class="iframe" framborder="0" data-id="' + id + '" scrolling="auto" width="100%"  height="100%"></iframe>',
				id: id
			});
			element.tabChange('tab', id);
			
		}
		mainLayout.removeClass('hide-side');
	});
	//监听导航点击
	element.on('nav(rightNav)', function(elem) {
        var id = elem[0].attributes[2].value;
        var url = elem[0].attributes[1].value;
        var text = elem[0].attributes[3].value;
        if(!url){
            return;
        }
		var isActive = $('.main-layout-tab .layui-tab-title').find("li[lay-id=" + id + "]");
		if(isActive.length > 0) {
			//切换到选项卡
			element.tabChange('tab', id);
		} else {
			element.tabAdd('tab', {
				title: text,
				content: '<iframe src="' + url + '" name="iframe' + id + '" class="iframe" framborder="0" data-id="' + id + '" scrolling="auto" width="100%"  height="100%"></iframe>',
				id: id
			});
			element.tabChange('tab', id);
			
		}
		mainLayout.removeClass('hide-side');
	});
	//菜单隐藏显示
	hideBtn.on('click', function() {
		if(!mainLayout.hasClass('hide-side')) {
			mainLayout.addClass('hide-side');
		} else {
			mainLayout.removeClass('hide-side');
		}
	});
	//遮罩点击隐藏
	mainMask.on('click', function() {
		mainLayout.removeClass('hide-side');
	})
});

function tuichu() {
    var index = layer.load(2, {time: 10*1000});
	$.ajax({
		type: 'get',
		url: '/web/do/login/invalidate',
		success: function (data) {
            layer.close(index);
            window.location.href = "/web/zf/html/login.html";
        },
		error: function (errorMsg) {
            if(err.status>=400&&err.status<500){
                layer.msg(err.status+"网络异常！",{icon: 2, anim: 6})
            }else if(err.status>=500&&err.status<600){
                layer.msg(err.status+"服务器异常！",{icon: 2, anim: 6})
            }else{
                layer.msg(err.status+ '(' + err.statusText + ')',{icon: 2, anim: 6})
            }
            layer.close(index);
        }
	});
}

function setName() {
	$.ajax({
        type: 'get',
        url: '/web/do/login/getName',
        success: function (data) {
            $('#you_father_name').html(data);
        },
        error: function (errorMsg) {
            if(err.status>=400&&err.status<500){
                layer.msg(err.status+"网络异常！",{icon: 2, anim: 6})
            }else if(err.status>=500&&err.status<600){
                layer.msg(err.status+"服务器异常！",{icon: 2, anim: 6})
            }else{
                layer.msg(err.status+ '(' + err.statusText + ')',{icon: 2, anim: 6})
            }
        }
	});
}