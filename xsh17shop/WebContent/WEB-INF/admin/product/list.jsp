<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@include file="/head.jsp" %>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="css/Style.css" rel="stylesheet" type="text/css" />
		<script language="javascript" src="js/public.js"></script>
		<script type="text/javascript">
			function addProduct(){
				window.location.href = "adminProduct_addPage.action";
			}
			
			$(function(){ 
				$(".pimg").mouseover(function(event) { 
					console.log(event.originalEvent);
					var me = $(this);
					$('<img />')
					.appendTo(me.parent())
					.attr('src', me.attr('src'))
					.css({
						position: 'absolute',
						left: event.originalEvent.pageX,
						top: event.originalEvent.pageY
					});
				}).mouseout(function() { 
					$(this).next().remove();
				});
			})
		</script> 
	</HEAD>
	<body>
		<br>
		<div class="panel panel-default">
			<div class="panel-heading">
				<strong>用户列表</strong>
			</div>
			<div class="ta_01" align="right">
				<button type="button" id="add" name="add" value="添加" class="button_add" onclick="addProduct()">
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
							商品名称
						</td>
						<td align="center" width="17%">
							商品图片
						</td>
						<td align="center" width="17%">
							商品价格
						</td>
						<td align="center" width="17%">
							是否热门
						</td>
						<td width="7%" align="center">
							编辑
						</td>
						<td width="7%" align="center">
							删除
						</td>
					</tr>
					<s:iterator var="product" value="pageBean.list" status="status">
					<tr >
						<td style="CURSOR: hand; HEIGHT: 22px" align="center"
							width="18%">
							<s:property value="#status.count"/>
						</td>
						<td style="CURSOR: hand; HEIGHT: 22px" align="center"
							width="17%">
							<s:property value="#product.pname"/>
						</td>
						<td style="CURSOR: hand; HEIGHT: 22px" align="center"
							width="18%">
							<img alt="商品图片" class="pimg" id="image1" width="100px" height="60px" src="<s:property value="#product.image"/>">
						</td>
						<td style="CURSOR: hand; HEIGHT: 22px" align="center"
							width="17%">
							<s:property value="#product.shop_price"/>
						</td>
						<td style="CURSOR: hand; HEIGHT: 22px" align="center"
							width="17%">
							<s:if test="#product.shop_price =1">是</s:if>
							<s:else>否</s:else>
						</td>
						<td align="center" style="HEIGHT: 22px">
							<a href="adminProduct_edit.action?pid=<s:property value="#product.pid"/>">
								<img src="images/i_edit.gif" border="0" style="CURSOR: hand">
							</a>
						</td>
						<td align="center" style="HEIGHT: 22px">
							<a href="adminProduct_delete.action?pid=<s:property value="#product.pid"/>">
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
				<a href="adminProduct_findAll.action?page=1">首页</a>
				<a href="adminProduct_findAll.action?page=<s:property value="pageBean.page-1"/>">上一页</a>
			</s:if>
			<s:if test="pageBean.page != pageBean.totalPage">
				<a href="adminProduct_findAll.action?page=<s:property value="pageBean.page+1"/>">下一页</a>
				<a href="adminProduct_findAll.action?page=<s:property value="pageBean.totalPage"/>">尾页</a>
			</s:if>
		</div>
	</body>
</HTML>

