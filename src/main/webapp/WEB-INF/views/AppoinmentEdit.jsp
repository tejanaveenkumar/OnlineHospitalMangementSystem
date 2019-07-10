<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<style>
body {
	background-color: #FFF8DC;
    margin: 0;
    font-family: -apple-system,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif,"Apple Color Emoji","Segoe UI Emoji","Segoe UI Symbol";
    font-size: 21px;
    font-weight: 400;
    line-height: 1.5;
    color: #212529;
    text-align: left;
    background-color: #fff;

}
</style>
<style type="text/css">
.err {
	color: Red;
}
</style>
</head>
<body>
	<%@include file="Menu.jsp"%>

	<%-- <%@include file="Menu.jsp"%>
 --%>
	<!-- container start -->
	<div class="container-fluid">
		<!-- card start -->
		<div class="card">
			<!-- card Header -->
			<div class="card-header bg-primary text-white">
				<h2>WELCOME TO APPOINMENT EDIT PAGE</h2>
			</div>


			<!-- card body -->
			<div class="card-body">
				<form:form action="update" method="post" modelAttribute="appointment"
					cssClass="form">
					<div class="form-group">
						<label for="appoinment" class="control-label col-sm-4">ID<font color="red">*</font></label>
						<form:input path="id" readonly="true" cssClass="form-control col-sm-4" />
						<form:errors path="id" cssClass="text-danger" />
					</div>
					<div class="form-group">
						<label for="appoinment" class="control-label col-sm-4">Scheduled_On<font color="red">*</font></label>
						<form:input path="scheduled_On" cssClass="form-control col-sm-4" />
						<form:errors path="scheduled_On" cssClass="text-danger" />
					</div>
					<div class="form-group">
						<label for="appoinment" class="control-label col-sm-4">Patient_Name<font color="red">*</font></label>
						<form:input path="patient_Name" cssClass="form-control col-sm-4" />
						<form:errors path="patient_Name" cssClass="text-danger" />
					</div>
					<div class="form-group">
						<label for="appoinment" class="control-label col-sm-4">Patient_Id<font color="red">*</font></label>
						<form:input path="patient_Id" cssClass="form-control col-sm-4" />
						<form:errors path="patient_Id" cssClass="text-danger" />
					</div>
					<div class="form-group">
						<label for="appoinment" class="control-label col-sm-4">Mobile_Number<font color="red">*</font></label>
						<form:input path="mobile_Number" cssClass="form-control col-sm-4" />
						<form:errors path="mobile_Number" cssClass="text-danger" />
					</div>
					<div class="form-group">
						<label for="appoinment" class="control-label col-sm-4">Doctor_Name<font color="red">*</font></label>
						<form:select path="doctor_Name" cssClass="form-control col-sm-4">
							<form:option value="">--SELECT--</form:option>
							<form:option value="LAXMINARAYANA">LAXMINARAYANA</form:option>
							<form:option value="VIJAY">VIJAY</form:option>
							<form:option value="SHIVAKUMAR">SHIVAKUMAR</form:option>
						</form:select>
						<form:errors path="doctor_Name" cssClass="text-danger" />
					</div>
					<div class="form-group">
						<label for="appoinment" class="control-label col-sm-4">Category<font color="red">*</font></label>
						<form:select path="category" cssClass="form-control col-sm-4">
							<form:option value="">--SELECT--</form:option>
							<form:option value="LEPROSY">LEPROSY</form:option>
							<form:option value="CARDIOLOGISTS">CARDIOLOGISTS</form:option>
							<form:option value="DERMATOLOGIST">DERMATOLOGIST</form:option>
						</form:select>
						<form:errors path="category" cssClass="text-danger" />
					</div>
					<div class="form-group">
						<input type="submit" value="Update" class="btn btn-success" />
					</div>
				</form:form>

			</div>

			<!-- card footer -->
			<c:if test="${message ne null}">
				<div class="card-footer bg-info text-white">${message}</div>
			</c:if>

			<!-- card end -->
		</div>

		<!-- container end -->
	</div>
</body>
</html>




