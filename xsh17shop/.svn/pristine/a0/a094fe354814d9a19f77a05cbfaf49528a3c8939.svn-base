<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String ctx = request.getContextPath();
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + ctx + "/";
	pageContext.setAttribute("path", path);
	pageContext.setAttribute("ctx", ctx);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>菜单</title>
<base href="${ path }">
<link href="css/left.css" rel="stylesheet" type="text/css"/>
<link rel="styleSheet" href="css/dtree.css" type="text/css" />
</head>
<body>
	<table width="100" border="0" cellspacing="0" cellpadding="0">
	  <tr>
	    <td height="12"></td>
	  </tr>
	</table>
	<table width="100%" border="0">
	  <tr>
	    <td>
			<div class="dtree">
			
				<a href="javascript: d.openAll();">展开所有</a> | <a href="javascript: d.closeAll();">关闭所有</a>
				
				<script type="text/javascript" src="js/dtree.js"></script>
				<script type="text/javascript">
					
					d = new dTree('d');
					d.add('01',-1,'系统菜单树');
					d.add('0101','01','用户管理','','','mainFrame');
					d.add('010101','0101','用户管理','user_findAll.action','','mainFrame');
					d.add('0102','01','一级分类管理','','','mainFrame');
					d.add('010201','0102','一级分类管理','adminCategory_findAll.action','','mainFrame');
					d.add('0103','01','二级分类管理','','','mainFrame');
					d.add('010301','0103','二级分类管理','adminCategorySecond_findAll.action?page=1','','mainFrame');
					d.add('0104','01','商品管理','','','mainFrame');
					d.add('010401','0104','商品管理','adminProduct_findAll.action?page=1','','mainFrame');
					d.add('0105','01','订单管理','','','mainFrame');
					d.add('010501','0105','所有订单','adminOrder_findAll.action?page=1','','mainFrame');
					d.add('010502','0105','未付款订单','adminOrder_findByState.action?page=1&state=1','','mainFrame');
					d.add('010503','0105','已付款订单','adminOrder_findByState.action?page=1&state=2','','mainFrame');
					d.add('010504','0105','已发货订单','adminOrder_findByState.action?page=1&state=3','','mainFrame');
					d.add('010505','0105','完成的订单','adminOrder_findByState.action?page=1&state=4','','mainFrame');
					document.write(d);
					
				</script>
			</div>	
		</td>
	  </tr>
	</table>
</body>
</html>
