<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="meta.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="head.jsp"%>
<body>
	<%@ include file="header.jsp" %>
	<div id="main">
		<s:iterator value="#session.menuList" id="menu" status="st">
			<div class='menu-box <s:if test="#st.Odd">left</s:if><s:else>right</s:else>'>
				<div id="menu-<s:property value='#menu.id'/>" class="menu">
					<s:property value='#menu.menuName' />
				</div>
				<div id="sub-menu-<s:property value='#menu.id'/>" class="sub-menu"></div>
			</div>
		</s:iterator>
	</div>
	<%@ include file="footer.jsp" %>
	<script type="text/javascript">
		$(function() {
			//翻转效果
			if (navigator.appName == "Microsoft Internet Explorer") {
				$('.menu-box').hover(function() {
					$(this).find(".menu").hide();
					findSubMenu($(this).find(".menu"));
					$(this).find(".sub-menu").show();
				}, function() {
					$(this).find(".menu").show();
					$(this).find(".sub-menu").hide();
				});
			} else {
				$(this).find(".sub-menu").css({
					opacity : 0
			
				});
				$('.menu-box').hover(function() {
					$(this).find(".menu").stop().transition({
						rotateY : '180deg',
						opacity : 0
					}, 'slow', function() {
						if ($(this).css('opacity') == 0) {
							$(this).hide();
						}
					});
					findSubMenu($(this).find(".menu"));
					$(this).find(".sub-menu").show().stop().transition({
						rotateY : '0',
						opacity : 1
					}, 'slow');
				}, function() {
					$(this).find(".menu").stop().show().transition({
						rotateY : '0deg',
						opacity : 1
					}, 'slow');
					$(this).find(".sub-menu").stop().transition({
						rotateY : '180deg',
						opacity : 0
					}, 'slow', function() {
						if ($(this).css('opacity') == 0) {
							$(this).hide();
						}
					});
				});
			}
		});
		
		function findSubMenu(parent){
			// 获取并设置子菜单
			var url = "${ctx}/jsp/menu!findSubMenu";
			var menuId = parent.attr("id").replace("menu-", "");
			var params = {
				parentId : menuId
			};
			$.post(url, params, function(data) {
				if (data.subMenuList) {
					var content = "";
					$.each(data.subMenuList, function(i, item){
						content = content + '<a href="' + item.url + '">' 
							+ item.menuName + '</a>';
					});
					$('#sub-menu-' + menuId).html(content);
				}
			});
		}
	</script>
</body>
</html>