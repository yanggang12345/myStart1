<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<HTML>
	<HEAD>
	<%@include file="/head.jsp" %>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="css/Style.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript">
			function addCategory(){
				window.location.href = "admin/category/add.jsp";
			}
		</script>
	</HEAD>
	<body>
		<br>
		<div class="panel panel-default">
			<div class="panel-heading">
				<strong>订单列表</strong>
			</div>
			<div class="ta_01" align="right">
				<button type="button" id="add" name="add" value="添加" class="button_add" onclick="addCategory()">
					&#28155;&#21152;
				</button>
			</div>
			<div class="panel-body">
				<table class="table table-striped table-bordered table-hover">
					<tr style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">
						<td align="center" width="18%">
							序号
						</td>
						<td align="center" width="17%">
							一级分类名称
						</td>
						<td width="7%" align="center">
							编辑
						</td>
						<td width="7%" align="center">
							删除
						</td>
					</tr>
					<s:iterator var="c" value="cList" status="status">
						<tr>
							<td style="CURSOR: hand; HEIGHT: 22px" align="center"
								width="18%">
								<s:property value="#status.count"/>
							</td>
							<td style="CURSOR: hand; HEIGHT: 22px" align="center"
								width="17%">
								<s:property value="#c.cname"/>
							</td>
							<td align="center" style="HEIGHT: 22px">
								<a href="adminCategory_edit.action?cid=<s:property value="#c.cid"/>">
									<img src="images/i_edit.gif" border="0" style="CURSOR: hand">
								</a>
							</td>
					
							<td align="center" style="HEIGHT: 22px">
								<a href="adminCategory_delete.action?cid=<s:property value="#c.cid"/>">
									<img src="images/i_del.gif" width="16" height="16" border="0" style="CURSOR: hand">
								</a>
							</td>
						</tr>
					</s:iterator>	
				</table>
			</div>
		</div>
	</body>
</HTML>

