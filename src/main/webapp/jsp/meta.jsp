<!DOCTYPE HTML>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	response.setHeader("Pragma","no-cache");
	response.setHeader("Cache-Control","no-cache");
	response.setDateHeader("Expires",-1);
%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />