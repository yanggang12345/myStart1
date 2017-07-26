<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String ctx = request.getContextPath();
	String base = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + ctx + "/";
	pageContext.setAttribute("ctx", ctx);
	pageContext.setAttribute("base", base);
%>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<base href="${ base }"/>
<link type="text/css" href="css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery.form.js"></script>
