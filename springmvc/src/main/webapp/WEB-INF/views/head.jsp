<%
	String ctx = request.getContextPath();
	String base = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + ctx + "/";
	pageContext.setAttribute("ctx", ctx);
	pageContext.setAttribute("base", base);
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<base href="${ base }"/>
<script type="text/javascript">
var ctx = '${ ctx }';
</script>
<link type="text/css" href="css/bootstrap.min.css" rel="stylesheet">
<link type="text/css" href="css/main.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="${ ctx }/js/My97DatePicker/WdatePicker.js"></script>
