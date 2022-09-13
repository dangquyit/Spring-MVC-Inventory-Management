<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="right_col" role="main">
	<div class="clearfix"></div>

	<div class="x_panel">
		<div class="x_title">
			<h2>Goods Receipt List</h2>

			<div class="clearfix"></div>
		</div>


		<div class="x_content">
			<a href="<c:url value="/goods-receipt/add"/> " class="btn btn-app">Add<i
				class="fa fa-plus"></i></a> <a
				href="<c:url value="/goods-receipt/export"/> " class="btn btn-app">Export<i
				class="fa fa-cloud-download"></i></a>

			<div class="container">
				<form:form modelAttribute="searchForm"
					cssClass="form-horizontal form-label-left"
					servletRelativeAction="/goods-receipt/list/1" method="post">
					<div class="item form-group">
						<label for="code"
							class="col-form-label col-md-3 col-sm-3 label-align">Code
						</label>
						<div class="col-md-6 col-sm-6 ">
							<form:input path="code" cssClass="form-control" type="text" />
						</div>
					</div>
					<div class="item form-group">
						<label class="col-form-label col-md-3 col-sm-3 label-align"
							for="fromDate">From date </label>
						<div class=' col-md-6 col-sm-6 input-group date'
							id='fromDatePicker'>
							<form:input path="fromDate" type='text' cssClass="form-control" />
							<span class="input-group-addon"> <span
								class="glyphicon glyphicon-calendar"></span>
							</span>
						</div>
					</div>
					<div class="item form-group">
						<label class="col-form-label col-md-3 col-sm-3 label-align"
							for="toDate">To date </label>
						<div class=' col-md-6 col-sm-6 input-group date' id='toDatePicker'>
							<form:input path="toDate" type='text' cssClass="form-control" />
							<span class="input-group-addon"> <span
								class="glyphicon glyphicon-calendar"></span>
							</span>
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
							<th class="column-title">Code</th>
							<th class="column-title">Quantity</th>
							<th class="column-title">Price</th>
							<th class="column-title">Product</th>
							<th class="column-title">Update date</th>
							<th class="column-title no-link last text-center" colspan="2"><span
								class="nobr">Action</span></th>
						</tr>
					</thead>

					<tbody>
						<c:forEach items="${listInvoice }" var="invoice" varStatus="loop">
							<c:choose>
								<c:when test="${loop.index %2 == 0 }">
									<tr class="even pointer">
								</c:when>
								<c:otherwise>
									<tr class="odd pointer">
								</c:otherwise>
							</c:choose>

							<td class=" ">${pageInfo.offset + loop.index + 1 }</td>
							<td class=" ">${invoice.code }</td>
							<td class=" ">${invoice.quantity }</td>
							<td class="price-small">${invoice.price }</td>
							<td class=" ">${invoice.productInfo.name }</td>
							<td class="date">${invoice.updateDate }</td>
							<td><a
								href="<c:url value ="/goods-receipt/view/${invoice.id}"/>"
								class="btn btn-round btn-secondary">View</a></td>
							<td><a
								href="<c:url value ="/goods-receipt/edit/${invoice.id}"/>"
								class="btn btn-round btn-info">Edit</a></td>
							</tr>
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
		$('#searchForm').attr('action', '<c:url value="/goods-receipt/list/"/>' + page);
		$('#searchForm').submit();
	 }
	 
	 $(document).ready(function(){
		 processMessage();
		 $('#fromDatePicker').datetimepicker({
			 format : 'YYYY-MM-DD HH:mm:ss'
		 });
		 $('#toDatePicker').datetimepicker({
			 format : 'YYYY-MM-DD HH:mm:ss'
		 })
		  $('.price-small').each(function(){
			 $(this).text(numeral($(this).text()).format('0,0'));
		 }) 
	 });
	 function processMessage(){
		 var msgSuccess = '${msgSuccess}';
		 var msgError = '${msgError}';
		 if(msgSuccess){
			 new PNotify({
                 title: ' Success',
                 text: msgSuccess,
                 type: 'success',
                 styling: 'bootstrap3'
             });
		 }
		 if(msgError){
			 new PNotify({
                 title: ' Error',
                 text: msgError,
                 type: 'error',
                 styling: 'bootstrap3'
             });
		 }
	 }
	
	
</script>
