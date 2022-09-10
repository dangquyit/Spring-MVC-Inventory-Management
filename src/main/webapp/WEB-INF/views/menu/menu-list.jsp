<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="right_col" role="main">
	<div class="clearfix"></div>

	<div class="col-md-12 col-sm-12  ">
		<div class="x_panel">
			<div class="x_title">
				<h2>Role List</h2>

				<div class="clearfix"></div>
			</div>


			<div class="x_content">
				<div class="container">
					<form:form modelAttribute="searchForm"
						cssClass="form-horizontal form-label-left"
						servletRelativeAction="/menu/list/1" method="POST">
						<div class="item form-group">
							<label class="col-form-label col-md-3 col-sm-3 label-align"
								for="url">Url </label>
							<div class="col-md-6 col-sm-6 ">
								<form:input path="url" cssClass="form-control " />
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
								<th  rowspan="2" class="column-title"
									style="border-left: 2px solid;">#</th>
								<th rowspan="2" class="column-title"
									style="border-left: 2px solid;">Url</th>
								<th rowspan="2" class="column-title"
									style="border-left: 2px solid;">Status</th>
								<th colspan="${listRole.size() }" class="column-title"
									style="border-left: 2px solid; text-align: center;">Role</th>
							</tr>
							<tr>
								<c:forEach items="${listRole }" var="role">
									<th class="column-title text-center"
										style="border-left: 2px solid">${role.roleName }</th>
								</c:forEach>
							</tr>
						</thead>

						<tbody>
							<c:forEach items="${listMenu }" var="menu" varStatus="loop">
								<c:choose>
									<c:when test="${loop.index %2 == 0 }">
										<tr class="even pointer">
									</c:when>
									<c:otherwise>
										<tr class="odd pointer">
									</c:otherwise>
								</c:choose>

								<td class=" ">${pageInfo.offset + loop.index + 1 }</td>
								<td class=" ">${menu.url }</td>
								<c:choose>
									<c:when test="${menu.activeFlag == 1 }">
										<td class=" " style="color: green;">Enable</td>
									</c:when>
									<c:otherwise>
										<td class=" " style="color: red;">Disable</td>
									</c:otherwise>
								</c:choose>

								<c:forEach items="${menu.mapAuth }" var="auth">
									<c:choose>
										<c:when test="${auth.value==1}">
											<td style="text-align: center;"><i class="fa fa-check" style="color: green;"></i></td>
										</c:when>
										<c:otherwise>
											<td style="text-align: center;"><i class="fa fa-times" style="color: red;"></i></td>
										</c:otherwise>
									</c:choose>
								</c:forEach>
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
	function gotoPage(page) {
		console.log(page);
		$('#searchForm').attr('action', '<c:url value="/menu/list/"/>' + page);
		$('#searchForm').submit();
	}

	$(document).ready(function() {
		processMessage();
	});
	function processMessage() {
		var msgSuccess = '${msgSuccess}';
		var msgError = '${msgError}';
		if (msgSuccess) {
			new PNotify({
				title : ' Success',
				text : msgSuccess,
				type : 'success',
				styling : 'bootstrap3'
			});
		}
		if (msgError) {
			new PNotify({
				title : ' Error',
				text : msgError,
				type : 'error',
				styling : 'bootstrap3'
			});
		}
	}
</script>
