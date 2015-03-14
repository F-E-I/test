<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
<div id="add-question" class="dialog">
	<div class="body">
		<div class="cForm">
			<div class="cRow cType_radio cTextInput" id="cId_type" style="margin-top:12px">
				<div class="cInput">
					<ul>
						<li>
							<div class="cRadioInput">
								<input type="radio" name="type" id="type_0" value="0" checked="checked">
							</div>
							<div class="cRadioLabel singleSelect">
								<label>单选题</label>
							</div>
						</li>
						<li>
							<div class="cRadioInput">
								<input type="radio" name="type" id="type_1" value="1">
							</div>
							<div class="cRadioLabel multipleSelect">
								<label>多选题</label>
							</div>
						</li>
						<li>
							<div class="cRadioInput">
								<input type="radio" name="type" id="type_2" value="2">
							</div>
							<div class="cRadioLabel wordAnswer">
								<label>简答题</label>
							</div>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	$(function(){
		initDialog();
	});
</script>
</body>
</html>