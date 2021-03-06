<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<HTML>
	<HEAD>
	<%@include file="/head.jsp" %>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="css/Style.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript">
			function addCategorySecond(){
				window.location.href = "adminCategorySecond_addPage.action";
			}
		</script>
	</HEAD>
	<body>
		<br>
			<div class="panel panel-default">
				<div class="panel-heading">
					<strong>用户列表</strong>
				</div>
				<div class="ta_01" align="right">
					<button type="button" id="add" name="add" value="添加" class="button_add" onclick="addCategorySecond()">
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
								二级分类名称
							</td>
							<td width="7%" align="center">
								编辑
							</td>
							<td width="7%" align="center">
								删除
							</td>
						</tr>
						<s:iterator var="cs" value="pageBean.list" status="status">
							<tr>
								<td style="CURSOR: hand; HEIGHT: 22px" align="center"
									width="18%">
									<s:property value="#status.count"/>
								</td>
								<td style="CURSOR: hand; HEIGHT: 22px" align="center"
									width="17%">
									<s:property value="#cs.csname"/>
								</td>
								<td align="center" style="HEIGHT: 22px">
									<a href="adminCategorySecond_edit.action?csid=<s:property value="#cs.csid"/>">
										<img src="images/i_edit.gif" border="0" style="CURSOR: hand">
									</a>
								</td>
						
								<td align="center" style="HEIGHT: 22px">
									<a href="adminCategorySecond_delete.action?csid=<s:property value="#cs.csid"/>">
										<img src="images/i_del.gif" width="16" height="16" border="0" style="CURSOR: hand">
									</a>
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

