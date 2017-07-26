<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>网上商城管理中心</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="${pageContext.request.contextPath }/css/general.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/css/main.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.css" />
<style type="text/css">
body{
	width: 500px;
	height: 400px;
	margin: 100px auto;
}
</style>

<body>
	
<s:actionerror />
	<div class="panel panel-default">
	  <div class="panel-heading">网上商城后台管理系统</div>
	  <div class="panel-body">
	    <form method="post" action="${pageContext.request.contextPath }/adminUser_login.action" name='theForm' onsubmit="return validate()" class="form-horizontal" role="form">
		   <div class="form-group">
			    <label for="name" class="col-sm-4 control-label">管理员账户</label>
			    <div class="col-sm-8">
			      <input type="name" class="form-control" id="name" placeholder="账户" name="username">
			    </div>
		   </div>
		  
		   <div class="form-group">
		    <label for="password" class="col-sm-4 control-label">管理员密码</label>
		    <div class="col-sm-8">
		      <input type="password" class="form-control" id="password" placeholder="密码" name="password">
		    </div>
		  </div>
		      
		  <div class="form-group">
		    <div class="col-sm-offset-4 col-sm-8">
		      <button type="submit" class="btn btn-default">进入管理中心</button>
		    </div>
		  </div>
		  <input type="hidden" name="act" value="进入管理中心"/> 
		</form>
	  </div>
	</div>


</body>
