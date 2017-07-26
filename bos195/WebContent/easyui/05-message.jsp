<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>message---消息框</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	$(function(){
		/* alert("aaa"); */
		//$.messager.alert("标题","内容","error");
		/* window.setTimeout(function(){
			$.messager.show({
				title:"消息",
				msg:"消息在3秒后关闭",
				timeout:3000,
				showType:"slide"
			});
		},3000) */
		/* $.messager.confirm("对话","你要退出？",function(r){
			alert(r);
		}); */
		/* $.messager.prompt('提示信息','请输入你的姓名：',function(r){
			alert(r);
		}); */
		$.messager.progress('close');
		
	});
</script>
</head>
<body>
	
</body>
</html>