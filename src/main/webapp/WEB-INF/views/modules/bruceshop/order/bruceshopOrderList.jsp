<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>订单类型管理</title>
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
		<li class="active"><a href="${ctx}/bruceshop/order/bruceshopOrder/">订单类型列表</a></li>
		<shiro:hasPermission name="bruceshop:order:bruceshopOrder:edit"><li><a href="${ctx}/bruceshop/order/bruceshopOrder/form">订单类型添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="bruceshopOrder" action="${ctx}/bruceshop/order/bruceshopOrder/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>订单号：</label>
				<form:input path="orderno" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>会员昵称：</label>
				<form:input path="usernickname" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>订单号</th>
				<th>会员昵称</th>
				<th>支付方式</th>
				<th>支付状态</th>
				<th>订单状态</th>
				<th>订单总额</th>
				<th>订单运费</th>
				<th>商品总数量</th>
				<th>送货城市</th>
				<th>快递运单号</th>
				<th>快递公司名称</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="bruceshop:order:bruceshopOrder:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="bruceshopOrder">
			<tr>
				<td><a href="${ctx}/bruceshop/order/bruceshopOrder/form?id=${bruceshopOrder.id}">
					${bruceshopOrder.orderno}
				</a></td>
				<td>
					${bruceshopOrder.usernickname}
				</td>
				<td>
					${fns:getDictLabel(bruceshopOrder.paytype, 'bruceshop_payType', '')}
				</td>
				<td>
					${fns:getDictLabel(bruceshopOrder.paystatus, 'bruceshop_payStatus', '')}
				</td>	
				<td>
					${fns:getDictLabel(bruceshopOrder.orderstatus, 'bruceshop_orderStatus', '')}
				</td>
				<td>
					${bruceshopOrder.amount}
				</td>
				<td>
					${bruceshopOrder.fee}
				</td>
				<td>
					${bruceshopOrder.quantity}
				</td>
				<td>
					${bruceshopOrder.cityName}
				</td>
				<td>
					${bruceshopOrder.expressno}
				</td>
				<td>
					${fns:getDictLabel(bruceshopOrder.expresscompanyname, 'bruceshop_express', '')}
				</td>
				<td>
					<fmt:formatDate value="${bruceshopOrder.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${bruceshopOrder.remarks}
				</td>
				<shiro:hasPermission name="bruceshop:order:bruceshopOrder:edit"><td>
    				<a href="${ctx}/bruceshop/order/bruceshopOrder/form?id=${bruceshopOrder.id}">修改</a>
					<a href="${ctx}/bruceshop/order/bruceshopOrder/delete?id=${bruceshopOrder.id}" onclick="return confirmx('确认要删除该订单类型吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>