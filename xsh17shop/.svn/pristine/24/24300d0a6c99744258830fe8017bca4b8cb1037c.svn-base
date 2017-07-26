<%@ page language="java" pageEncoding="UTF-8"%>
 
<%@ taglib uri="/struts-tags" prefix="s"%>

<HTML>
	<HEAD>
	<%@include file="/head.jsp" %>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="${pageContext.request.contextPath}/css/Style1.css" rel="stylesheet" type="text/css" />
		<script language="javascript" src="${pageContext.request.contextPath}/js/public.js"></script>
		
	</HEAD>
	<body>
		<br>
		<div class="panel panel-default">
			<div class="panel-heading">
				<strong>订单列表</strong>
			</div>
			<div class="panel-body">
				<table class="table table-striped table-bordered table-hover">
					<tr style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">
						<td align="center" width="8%">
							序号
						</td>
						<td align="center" width="7%">
							订单编号
						</td>
						<td align="center" width="7%">
							总金额
						</td>
						<td align="center" width="7%">
							收件人
						</td>
						<td align="center" width="7%">
							订单状态
						</td>
					</tr>
					<s:iterator var="o" value="pageBean.list" status="status">
						<tr>
							<td style="CURSOR: hand; HEIGHT: 22px" align="center"
								width="18%">
								<s:property value="#status.count"/>
							</td>
							<td style="CURSOR: hand; HEIGHT: 22px" align="center"
								width="17%">
								<s:property value="#o.oid"/>
							</td>
							<td style="CURSOR: hand; HEIGHT: 22px" align="center"
								width="17%">
								<s:property value="#o.total"/>
							</td>
							<td style="CURSOR: hand; HEIGHT: 22px" align="center"
								width="17%">
								<s:property value="#o.name"/>
							</td>
							<td style="CURSOR: hand; HEIGHT: 22px" align="center"
								width="17%">
								<s:if test="#o.state==1">
									未付款
								</s:if>
								<s:if test="#o.state==2">
									<a href="adminOrder_updateState.action?oid=<s:property value="#o.oid"/>"><font color="blue">发货</font></a>
								</s:if>
								<s:if test="#o.state==3">
									等待确认收货
								</s:if>
								<s:if test="#o.state==4">
									订单完成
								</s:if>
							</td>
						</tr>
					</s:iterator>
				</table>
			</div>
		</div>
		<div class="ta_01" align="center" bgColor="#afd1f3">
			第<s:property value="pageBean.page"/>/<s:property value="pageBean.totalPage"/>页  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<s:if test="pageBean.page != 1">
				<a href="adminOrder_findAll.action?page=1">首页</a>
				<a href="adminOrder_findAll.action?page=<s:property value="pageBean.page-1"/>">上一页</a>
			</s:if>
			<s:if test="pageBean.page != pageBean.totalPage">
				<a href="adminOrder_findAll.action?page=<s:property value="pageBean.page+1"/>">下一页</a>
				<a href="adminOrder_findAll.action?page=<s:property value="pageBean.totalPage"/>">尾页</a>
			</s:if>
		</div>
	</body>
</HTML>

