<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.net.URL"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<html>
	<head>
	    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <meta http-equiv="Expires" CONTENT="0"/>
        <meta http-equiv="Cache-Control" CONTENT="no-cache"/>
        <meta http-equiv="Pragma" CONTENT="no-cache"/>
	</head>
	<body>
		<script type="text/javascript">
			 window.top.location.replace("${ctx}/jsp/login.jsp");
		</script>
	</body>
</html>