<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<!-- Body Start -->
<div class="container">
	<form:form method="post" commandName="emp">
		<form:hidden path="emplId" />
		<fieldset class="form-group">
			<form:label path="emplId">Employee Id</form:label>
			<form:input path="emplId" type="text" class="form-control" disabled="true"/>
		</fieldset>
		<fieldset class="form-group">
			<form:label path="empName">Employee Name</form:label>
			<form:input path="empName" type="text" class="form-control"
				required="required" />
			<form:errors path="empName" cssClass="text-warning" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="department.deptId">Department Name</form:label>
			<form:select path="department.deptId" class="form-control">
				<form:options items="${dept}" itemValue="deptId" itemLabel="deptName"/>
			</form:select>			
			<form:errors path="department.deptId" cssClass="text-warning" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="salary">Salary</form:label>
			<form:input path="salary" type="text" class="form-control"
				required="required" />
			<form:errors path="salary" cssClass="text-warning" />
		</fieldset>

		<button type="submit" class="btn btn-success">Save</button>
	</form:form>
</div>
<!--  Body End -->
<%@ include file="common/footer.jspf"%>