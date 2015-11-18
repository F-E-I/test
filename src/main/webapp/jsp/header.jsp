<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="meta.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
HttpSession s = request.getSession();
if(s.getAttribute("user") == null){
	response.sendRedirect("/manager/jsp/user!login"); 
}
%>
<div id="header">
	<div class="container">
		<div class="logo">授课通用平台</div>
		<div class="nav">
			<ul>
				<li class="link"><a href="/manager/jsp/user!logout.action">退出</a></li>
				<li><s:property value="#session.user.userName" /></li>
			</ul>
		</div>
	</div>
</div>