<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>商品管理管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/bruceshop/product/bruceshopProduct/">商品管理列表</a></li>
		<shiro:hasPermission name="bruceshop:product:bruceshopProduct:edit"><li><a href="${ctx}/bruceshop/product/bruceshopProduct/form">商品管理添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="bruceshopProduct" action="${ctx}/bruceshop/product/bruceshopProduct/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>商品名称：</label>
				<form:input path="name" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>商品分类</th>
				<th>商品名称</th>
				<th>商品价格</th>
				
				<th>商品状态</th>
				<th>商品品牌</th>
				<th>仓库</th>
				<th>库存数量</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="bruceshop:product:bruceshopProduct:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="bruceshopProduct">
			<tr>
				<td><a href="${ctx}/bruceshop/product/bruceshopProduct/form?id=${bruceshopProduct.id}">
					${bruceshopProduct.categoryName}
				</a></td>
				<td>
					${bruceshopProduct.name}
				</td>
				<td>
					${bruceshopProduct.price}
				</td>
				
				<td>
					${fns:getDictLabel(bruceshopProduct.status, 'bruceshop_product_status', '')}
				</td>
				<td>
					${bruceshopProduct.brandName}
				</td>
				<td>
					${bruceshopProduct.warehouse}
				</td>
				<td>
					${bruceshopProduct.stock}
				</td>
				<td>
					<fmt:formatDate value="${bruceshopProduct.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${bruceshopProduct.remarks}
				</td>
				<shiro:hasPermission name="bruceshop:product:bruceshopProduct:edit"><td>
    				<a href="${ctx}/bruceshop/product/bruceshopProduct/form?id=${bruceshopProduct.id}">修改</a>
					<a href="${ctx}/bruceshop/product/bruceshopProduct/delete?id=${bruceshopProduct.id}" onclick="return confirmx('确认要删除该商品管理吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>