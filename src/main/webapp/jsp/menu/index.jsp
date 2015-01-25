<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../meta.jsp" %>
<!DOCTYPE html">
<html>
<%@ include file="../head.jsp" %>
<body>
	<%@ include file="../header.jsp" %>
	<div id="main">
		<div id="content">
			<div class="toolbar">
				<div class="btn back"></div>
				<div class="btn add"></div>
				<div class="btn delete"></div>
				<span class="title">菜单管理</span>
			</div>
			<div class="detail">
				<table class="d-table">
					<tr>
						<th>序号</th>
						<th>菜单编号</th>
						<th>菜单名称</th>
						<th>菜单地址</th>
						<th>父菜单编号</th>
					</tr>
					<s:iterator value="#request.menuList" id="menu" status="st">
						<tr>
							<td class="sno"><s:property value="#st.index + 1" /></td>
							<td><s:property value="#menu.id" /></td>
							<td><s:property value="#menu.menuName" /></td>
							<td><s:property value="#menu.url" /></td>
							<td><s:property value="#menu.parentId" /></td>
						</tr>
					</s:iterator>
				</table>
			</div>
		</div>
	</div>
	<%@ include file="../footer.jsp" %>
	<script type="text/javascript">
		$(function() {
			$('.d-table tr').each(function(i) {
				if (i % 2 == 0) {
					$(this).addClass("even");
				} else {
					$(this).addClass("odd");
				}
			});
		});
	</script>
</body>
</html>