<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>仓库管理管理</title>
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
		<li><a href="${ctx}/bruceshop/warehouse/bruceshopWarehouse/">仓库管理列表</a></li>
		<li class="active"><a href="${ctx}/bruceshop/warehouse/bruceshopWarehouse/form?id=${bruceshopWarehouse.id}">仓库管理<shiro:hasPermission name="bruceshop:warehouse:bruceshopWarehouse:edit">${not empty bruceshopWarehouse.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="bruceshop:warehouse:bruceshopWarehouse:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="bruceshopWarehouse" action="${ctx}/bruceshop/warehouse/bruceshopWarehouse/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">仓库名称：</label>
			<div class="controls">
				<form:input path="name" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">仓库所在城市：</label>
			<div class="controls">
				<%-- <form:input path="city" htmlEscape="false" maxlength="255" class="input-xlarge "/> --%>
				<sys:treeselect id="city" name="city" value="${bruceshopWarehouse.city}" labelName="parent.name" labelValue="${bruceshopWarehouse.cityName}"
					title="区域" url="/sys/area/treeData" extId="${area.id}" cssClass="" allowClear="true"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">仓库详细地址：</label>
			<div class="controls">
				<form:textarea path="address" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注信息：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="bruceshop:warehouse:bruceshopWarehouse:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>