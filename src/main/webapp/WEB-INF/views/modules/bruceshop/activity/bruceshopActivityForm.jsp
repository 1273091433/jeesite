<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>促销活动管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/bruceshop/activity/bruceshopActivity/">促销活动列表</a></li>
		<li class="active"><a href="${ctx}/bruceshop/activity/bruceshopActivity/form?id=${bruceshopActivity.id}">促销活动<shiro:hasPermission name="bruceshop:activity:bruceshopActivity:edit">${not empty bruceshopActivity.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="bruceshop:activity:bruceshopActivity:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="bruceshopActivity" action="${ctx}/bruceshop/activity/bruceshopActivity/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">活动标题：</label>
			<div class="controls">
				<form:input path="title" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">活动图片：</label>
			<div class="controls">
				<%-- <form:input path="picture" htmlEscape="false" maxlength="1024" class="input-xlarge "/> --%>
				<form:hidden path="picture" htmlEscape="false" maxlength="255" class="input-xlarge"/>
				<sys:ckfinder input="picture" type="images" uploadPath="/bruceshop/activity/bruceshopActivity"/>
				<span class="help-inline">建议Logo大小：1000 × 145（像素）</span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">活动描述：</label>
			<div class="controls">
				<%-- <form:textarea path="content" htmlEscape="false" rows="4" class="input-xxlarge "/> --%>
				<form:textarea id="content" htmlEscape="false" path="content" rows="4" maxlength="200" class="input-xxlarge"/>
				<sys:ckeditor replace="content" uploadPath="/bruceshop/activity/bruceshopActivity" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注信息：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="bruceshop:activity:bruceshopActivity:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>