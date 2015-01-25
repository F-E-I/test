<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="meta.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教学管理系统后台</title>
<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/login.css">
<script type="text/javascript" src="${ctx}/resources/js/jquery-1.11.1.min.js" ></script>
<script type="text/javascript" src="${ctx}/resources/js/jquery.placeholder.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/jquery.validationEngine.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/languages/jquery.validationEngine-zh_CN.js" charset="utf-8"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/validationEngine.jquery.css">
</head>
<body>
	<div class="content">
		<div class="title">教学管理系统后台</div>
		<div class="errMsg"></div>
		<div class="login-form">
			<form id="loginForm" action="user!login" method="post">
				<div class="row">
					<input id="userName" class="text validate[required]" type="text" name="user.userName" placeholder="用户名"/>
				</div>
				<div class="row">
					<input id="password" class="password validate[required]" type="password" name="user.password" placeholder="密码"/>
				</div>
				<div class="row">
					<input class="btnSubmit" type="submit" value="登&nbsp;&nbsp;录" />
				</div>
			</form>
		</div>
	</div>
	<script type="text/javascript">
		$(function(){
			$("#loginForm").validationEngine();
			
			$('#userName').focus();
			if(!$.support.leadingWhitespace){
				$('#userName').select();
			}
			
			var errMsg = "<s:property value='actionErrors[0]'/>";
			if(errMsg){
				$('#userName').val("<s:property value='#session.user.userName'/>");
				$('#password').val("<s:property value='#session.user.password'/>");
				$('.errMsg').html(errMsg).slideDown('slow');
			}
		});
	</script>
</body>
</html>