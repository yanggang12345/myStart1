<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>datagrid---数据表格编辑</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/easyui/locale/easyui-lang-zh_CN.js"></script>
</head>
<body>
	<table id="grid">
	</table>
	<script type="text/javascript">
		$(function(){
			var index;//全局的行
			$('#grid').datagrid({
				columns:[[//定义标题行所有列
					{field:'id',title:'编号',checkbox:true},
					{field:'name',title:'姓名',
						editor:{//指定当前列具有编辑的功能
							type:'validatebox',
							options:{
								
							}
						}	
					},
					{field:'age',title:'年龄',
						editor:{//指定当前列具有编辑的功能
							type:'validatebox',
							options:{
								
							}
						}	
					},
				]],
				url:'/bos195/json/data.json',
				onAfterEdit:function(rowIndex,rowData,changes){//结束编辑事件
					$("#grid").datagrid("endEdit",rowIndex);
				},
				toolbar:[//工具栏
					{text:'保存',iconCls:'icon-add',handler:function(){
						//结束第一行的编辑状态
						$("#grid").datagrid("endEdit",index);
					}},
					{text:'添加',iconCls:'icon-add',
						handler:function(){
							//动态添加一行
							$("#grid").datagrid("insertRow",{
								index:0,
								row:{}
							});
							//第一行开启编辑状态
							index=0;
							$("#grid").datagrid("beginEdit",index);
						}
					},
					{text:'删除',iconCls:'icon-remove',
						handler:function(){
							var row=$("#grid").datagrid("getSelected");
							index=$("#grid").datagrid("getRowIndex",row);//当前选中行的索引
							$("#grid").datagrid("deleteRow",index);
						}
					
					},
					{text:'修改',iconCls:'icon-edit',
						handler:function(){
							//获得当前选中的行
							var row=$("#grid").datagrid("getSelected");
							index=$("#grid").datagrid("getRowIndex",row);//当前选中行的索引
							$("#grid").datagrid("beginEdit",index);
						}
					}
				],
				singleSelect:true,
				pagination:true,//分页条
				pageList:[3,5,7]
			});
		});
	</script>
</body>
</html>