<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<HTML>
	<HEAD>
	<%@include file="/head.jsp" %>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="css/Style.css" rel="stylesheet" type="text/css" />
	</HEAD>
	<body>
		<br>
		<div class="panel panel-default">
			<div class="panel-heading">
				<strong>用户列表</strong>
			</div>
			<div class="panel-body">
				<table class="table table-striped table-bordered table-hover table-condensed">
					<tr style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">
						<td align="center">
							序号
						</td>
						<td align="center">
							用户名
						</td>
						<td align="center">
							用户密码
						</td>
						<td align="center">
							用户姓名
						</td>
						<td align="center">
							用户电话
						</td>
						<td align="center">
							会员地址
						</td>
					</tr>
					<s:iterator var="user" value="pageBean.list" status="status">
					<tr >
						<td style="CURSOR: hand; HEIGHT: 22px" align="center">
							<s:property value="#status.count"/>
						</td>
						<td style="CURSOR: hand; HEIGHT: 22px" align="center">
							<s:property value="#user.username"/>
						</td>
						<td style="CURSOR: hand; HEIGHT: 22px" align="center">
							<s:property value="#user.password"/>
						</td>
						<td style="CURSOR: hand; HEIGHT: 22px" align="center">
							<s:property value="#user.name"/>
						</td>
						<td style="CURSOR: hand; HEIGHT: 22px" align="center">
							<s:property value="#user.phone"/>
						</td>
						<td style="CURSOR: hand; HEIGHT: 22px" align="center">
							<s:property value="#user.addr"/>
						</td>
					</tr>
					</s:iterator>	
				</table>
			</div>
		</div>
		<div class="ta_01" align="center" bgColor="#afd1f3">
			第<s:property value="pageBean.page"/>/<s:property value="pageBean.totalPage"/>页  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<s:if test="pageBean.page != 1">
				<a href="${ pageContext.request.contextPath }/user_findAll.action?page=1">首页</a>
				<a href="${ pageContext.request.contextPath }/user_findAll.action?page=<s:property value="pageBean.page-1"/>">上一页</a>
			</s:if>
			<s:if test="pageBean.page != pageBean.totalPage">
				<a href="${ pageContext.request.contextPath }/user_findAll.action?page=<s:property value="pageBean.page==pageBean.totalPage?pageBean.totalPage:pageBean.page+1"/>">下一页</a>
				<a href="${ pageContext.request.contextPath }/user_findAll.action?page=<s:property value="pageBean.totalPage"/>">尾页</a>
			</s:if>
		</div>
	</body>
</HTML>

