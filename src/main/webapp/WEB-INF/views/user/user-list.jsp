<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="right_col" role="main">
	<div class="clearfix"></div>

	<div class="col-md-12 col-sm-12  ">
		<div class="x_panel">
			<div class="x_title">
				<h2>User List</h2>

				<div class="clearfix"></div>
			</div>


			<div class="x_content">
				<a href="<c:url value="/user/add"/> "
					class="btn btn-app">Add<i class="fa fa-plus"></i></a>
				<div class="container">
					<form:form modelAttribute="searchForm"
						cssClass="form-horizontal form-label-left"
						servletRelativeAction="/user/list/1" method="post">
						<div class="item form-group">
							<label class="col-form-label col-md-3 col-sm-3 label-align"
								for="userName">User Name </label>
							<div class="col-md-6 col-sm-6 ">
								<form:input type="text" path="userName" cssClass="form-control " />
							</div>
						</div>
						<div class="item form-group">
							<label class="col-form-label col-md-3 col-sm-3 label-align"
								for="name">Name </label>
							<div class="col-md-6 col-sm-6 ">
								<form:input type="text" path="name" cssClass="form-control" />
							</div>
						</div>
						
						<div class="item form-group">
							<label class="col-form-label col-md-3 col-sm-3 label-align"
								for="email">Email </label>
							<div class="col-md-6 col-sm-6 ">
								<form:input type="text" path="email" cssClass="form-control " />
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
								<th class="column-title">Id</th>
								<th class="column-title">User Name</th>
								<th class="column-title">Name</th>
								<th class="column-title">Email</th>
								<th class="column-title no-link last text-center" colspan="3"><span
									class="nobr">Action</span></th>
							</tr>
						</thead>

						<tbody>
							<c:forEach items="${listUser }" var="user"
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
								<td class=" ">${user.id }</td>
								<td class=" ">${user.userName }</td>
								<td class=" ">${user.name }</td>
								<td class=" ">${user.email }</td>
								<td><a
									href="<c:url value ="/user/view/${user.id}"/>"
									class="btn btn-round btn-secondary">View</a></td>
								<td><a
									href="<c:url value ="/user/edit/${user.id}"/>"
									class="btn btn-round btn-info">Edit</a></td>
								<td><a href="javascript:void(0);"
									onclick="confirmDelete(${user.id})"
									class="btn btn-round btn-danger">Delete</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<jsp:include page="../layout/paging.jsp"></jsp:include>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	 function confirmDelete(id){
		 if(confirm('Do you want delete this record?')){
			 window.location.href = '<c:url value="/user/delete/"/>'+id;
		 }
	 }

	 function gotoPage(page) {
		 console.log(page);
		$('#searchForm').attr('action', '<c:url value="/user/list/"/>' + page);
		$('#searchForm').submit();
	 }
	 
	 $(document).ready(function(){
		 processMessage();
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
