layui.use(['jquery','element'], function() {
	// 引入layui内置的jQuery模块
	var $ = layui.$;
	// 引入element模块
	var element = layui.element;
	
	// 监听tabs模块
	element.on('tab(bodytab)', function(data){
	    console.log(data);
	  });
	
	
	// 读取本地json文件,需要解决文件跨域问题
	// $.getJSON("../json/nav.json",function(data){
	// 	$.each(data,function(i,e){
	// 		console.log(e)
	// 	})
	// })


	$.each(nav, function(i, e) {
		// console.log(e);
		$(".nav ul").append("<li class=\"layui-nav-item\"><a href='" + e.href + "' target='iframe'>" + "<i class=\"layui-icon\">"+e.icon+"</i>"+"&nbsp;"+e.title + "</a></li>")
	})

	//标志导航栏状态
	var flag = false; 
	// 控制导航栏开启和关闭
	$("#co").click(function() {
		if (flag) {
			$(".body").css("width", "90%");
			$(".body").css("left", "10%");
			$("#co-i").html("&#xe668;");
			flag = false;
		} else {
			$(".body").css("width", "100%");
			$(".body").css("left", "0%");
			$("#co-i").html("&#xe66b;");
			flag = true;
		}

	})
});
