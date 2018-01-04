<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>商品管理管理</title>
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
		<li><a href="${ctx}/bruceshop/product/bruceshopProduct/">商品管理列表</a></li>
		<li class="active"><a href="${ctx}/bruceshop/product/bruceshopProduct/form?id=${bruceshopProduct.id}">商品管理<shiro:hasPermission name="bruceshop:product:bruceshopProduct:edit">${not empty bruceshopProduct.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="bruceshop:product:bruceshopProduct:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="bruceshopProduct" action="${ctx}/bruceshop/product/bruceshopProduct/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">商品分类：</label>
			<div class="controls">
				<%-- <form:input path="categoryId" htmlEscape="false" maxlength="64" class="input-xlarge "/> --%>
				<sys:treeselect id="categoryId" name="categoryId" value="${bruceshopProduct.categoryId}" labelName="parent.name" labelValue="${bruceshopProduct.categoryName}"
					title="父级编号" url="/bruceshop/category/bruceshopCategory/treeData" extId="${bruceshopCategory.id}" cssClass="" allowClear="true"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">商品名称：</label>
			<div class="controls">
				<form:input path="name" htmlEscape="false" maxlength="100" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">商品副标题：</label>
			<div class="controls">
				<form:input path="subtitle" htmlEscape="false" maxlength="200" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">商品主图：</label>
			<div class="controls">
				<%-- <form:input path="mainImage" htmlEscape="false" maxlength="500" class="input-xlarge "/> --%>
				<form:hidden path="mainImage" htmlEscape="false" maxlength="255" class="input-xlarge"/>
				<sys:ckfinder input="mainImage" type="images" uploadPath="/bruceshop/product"/>
				<span class="help-inline">建议Logo大小：800 × 800（像素）</span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">商品详情：</label>
			<div class="controls">
				<%-- <form:input path="detail" htmlEscape="false" class="input-xlarge "/> --%>
				<form:textarea id="detail" htmlEscape="false" path="detail" rows="4" maxlength="200" class="input-xxlarge"/>
				<sys:ckeditor replace="detail" uploadPath="/bruceshop/product" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">商品价格：</label>
			<div class="controls">
				<form:input path="price" htmlEscape="false" class="input-xlarge  number"/>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label">商品状态：</label>
			<div class="controls">
				<form:select path="status" class="input-xlarge ">
					<form:options items="${fns:getDictList('bruceshop_product_status')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">商品品牌：</label>
			<div class="controls">
				<%-- <form:input path="brandId" htmlEscape="false" maxlength="64" class="input-xlarge "/> --%>
				<form:select path="brandId" class="input-xlarge ">
					<c:forEach var="brand" items="${brandList}">
						<form:option value="${brand.id}" label="${brand.name}" />
					</c:forEach>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">仓库：</label>
			<div class="controls">
				<form:select path="warehouse" class="input-xlarge ">
					<c:forEach var="ware" items="${warehouseList}">
						<form:option value="${ware.name}" label="${ware.name}" />
					</c:forEach>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">库存数量：</label>
			<div class="controls">
				<form:input path="stock" htmlEscape="false" maxlength="11" class="input-xlarge  digits"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注信息：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="bruceshop:product:bruceshopProduct:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>