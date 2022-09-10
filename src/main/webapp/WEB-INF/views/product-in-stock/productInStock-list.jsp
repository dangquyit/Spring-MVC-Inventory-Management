<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="right_col" role="main">
	<div class="clearfix"></div>
		<div class="x_panel">
			<div class="x_title">
				<h2>Product In Stock List</h2>
				<div class="clearfix"></div>
			</div>
			<div class="x_content">
				<div class="container">
					<form:form modelAttribute="searchForm"
						cssClass="form-horizontal form-label-left"
						servletRelativeAction="/product-in-stock/list/1" method="post">
						<div class="item form-group">
							<label for="description"
								class="col-form-label col-md-3 col-sm-3 label-align">Category
							</label>
							<div class="col-md-6 col-sm-6 ">
								<form:input path="productInfo.category.name"
									cssClass="form-control" type="text" />
							</div>
						</div>
						<div class="item form-group">
							<label class="col-form-label col-md-3 col-sm-3 label-align"
								for="code">Name </label>
							<div class="col-md-6 col-sm-6 ">
								<form:input type="text" path="productInfo.name"
									cssClass="form-control " />
							</div>
						</div>
						<div class="item form-group">
							<label class="col-form-label col-md-3 col-sm-3 label-align"
								for="name">Code </label>
							<div class="col-md-6 col-sm-6 ">
								<form:input type="text" path="productInfo.code"
									cssClass="form-control " />
							</div>
						</div>
						<div class="ln_solid"></div>
						<div class="item form-group">
							<div class="col-md-6 col-sm-6 offset-md-3">
								<button type="submit" class="btn btn-success">Search</button>
							</div>
						</div>
					</form:form>
				</div>
				<div class="table-responsive">
					<table class="table table-striped jambo_table bulk_action">
						<thead>
							<tr class="headings">
								<th class="column-title">#</th>
								<th class="column-title">Category</th>
								<th class="column-title">Code</th>
								<th class="column-title">Name</th>
								<th class="column-title">Image</th>
								<th class="column-title">Quantity</th>
								<th class="column-title">Price</th>
							</tr>
						</thead>

						<tbody>
							<c:forEach items="${listProductInStock }" var="productInStock"
								varStatus="loop">
								<c:choose>
									<c:when test="${loop.index %2 == 0 }">
										<tr class="even pointer">
									</c:when>
									<c:otherwise>
										<tr class="odd pointer">
									</c:otherwise>
								</c:choose>

								<td class=" ">${pageInfo.offset + loop.index + 1 }</td>
								<td class=" ">${productInStock.productInfo.category.name }</td>
								<td class=" ">${productInStock.productInfo.code }</td>
								<td class=" ">${productInStock.productInfo.name }</td>
								<c:url value="${productInStock.productInfo.imgUrl }"
									var="imgUrl" />
								<td class=" "><img src="${imgUrl }" alt="Error Image"
									width="100px" height="100px" /></td>
								<td class=" ">${productInStock.quantity }</td>
								<td class="price-small ">${productInStock.price }</td>
							</c:forEach>
						</tbody>
					</table>
					<jsp:include page="../layout/paging.jsp"></jsp:include>
				</div>
			</div>
		</div>
	</div>
<script type="text/javascript">
	function gotoPage(page) {
		console.log(page);
		$('#searchForm').attr('action',
				'<c:url value="/product-in-stock/list/"/>' + page);
		$('#searchForm').submit();
	}

	$(document).ready(function() {
		$('.price-small').each(function() {
			$(this).text(numeral($(this).text()).format('0,0'));
		})
	});
</script>
