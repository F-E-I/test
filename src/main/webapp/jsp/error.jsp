<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="meta.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="head.jsp"%>
<body>
	<div id="header">
		<div class="container">
			<div class="logo">授课通用平台</div>
		</div>
	</div>
	<div id="main">
		<div class="errContent">
			<div class="errMsg">
				<s:property value="msg" />
			</div>
			<input type="button" class="btn" value="重新登入"
				onclick="window.location.href='login.jsp'">
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>