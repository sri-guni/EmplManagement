<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<!-- Body Start -->
	<div class="container">
		<table class="table table-striped table-bordered table-hover">
			<caption>Employee List</caption>
			<thead>
				<tr>
					<th>Empl ID</th>
					<th>Name</th>
					<th>Department</th>
					<th>Location</th>
					<th>Salary</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${employees}" var="emp">
					<tr>
						<td>${emp.emplId}</td>
						<td>${emp.empName}</td>
						<td>${emp.department.deptName}</td>
						<td>${emp.department.location}</td>
						<td>${emp.salary}</td>
						<td><a type="button" class="btn-sm btn-success"
							href="/update-emp?id=${emp.emplId}">Update</a></td>
						<td><a type="button" class="btn-sm btn-warning"
							href="/delete-emp?id=${emp.emplId}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<a type="button" class="btn-sm btn-primary" href="/add-emp">Add a New Employee</a>
		</div>
	</div>
<!--  Body End -->
<%@ include file="common/footer.jspf" %>