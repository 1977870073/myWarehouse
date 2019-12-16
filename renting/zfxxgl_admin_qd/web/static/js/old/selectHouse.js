window.onload = function(){
	// query();
}
function query(){
	$.ajax({
		
	});
}
//删除
function send(id) {
	var flag = confirm("确定要删除吗？")
	if(flag==true){
		$.ajax({
			url: '#',
			type: 'post',
			data: {"id":id},
			dataType: 'text',
			success: function (data) {
				if(data=="success"){
					alert("删除成功")
					window.location.href = '#';
				}else{
					alert("删除失败")
				}
			}
		})
	}
}