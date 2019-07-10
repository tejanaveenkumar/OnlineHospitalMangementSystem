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
    font-size: 17px;
    font-weight: 500;
    line-height: 1.8;
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
				  <h1 style="text-align:center;">WELCOME TO PATIENT REGISTER PAGE</h1>
				
			</div>
			<!-- card body -->
			<div class="card-body">
				<form:form action="insert" method="post" modelAttribute="patient"
					cssClass="form">
					<div class="form-group">
						<label for="patient" class="control-label col-sm-4">PatientName<font color="red">*</font></label>
						<form:input path="patient_Name"  cssClass="form-control col-sm-4" />
						<form:errors path="patient_Name" cssClass="text-danger"  />
					</div>
					<div class="form-group">
						<label for="patient" class="control-label col-sm-4">DateOfBirth<font color="red">*</font></label>
						<form:input path="dob" cssClass="form-control col-sm-4" />
						<form:errors path="dob" cssClass="text-danger" />
					</div>
					<div class="form-group" style="display:inline;">
						<label for="patient" class="control-label col-sm-4">Sex<font color="red">*</font></label>
						<form:radiobutton path="sex" value="Male" cssClass="form-control col-sm-4" />Male
						<form:radiobutton path="sex" value="Female" cssClass="form-control col-sm-4" />Female
						<form:errors path="sex" cssClass="text-danger" />
					</div>
					<div class="form-group">
						<label for="patient" class="control-label col-sm-4">PatientAddress<font color="red">*</font></label>
						<form:input path="address" cssClass="form-control col-sm-4" />
						<form:errors path="address" cssClass="text-danger" />
					</div>
					<div class="form-group">
						<label for="patient" class="control-label col-sm-4">City<font color="red">*</font></label>
						<form:input path="city" cssClass="form-control col-sm-4" />
						<form:errors path="city" cssClass="text-danger" />
					</div>
					<div class="form-group">
						<label for="patient" class="control-label col-sm-4">State<font color="red">*</font></label>
						<form:input path="state" cssClass="form-control col-sm-4" />
						<form:errors path="state" cssClass="text-danger" />
					</div>
					<div class="form-group">
						<label for="patient" class="control-label col-sm-4">Service_TYPE<font color="red">*</font></label>
						<form:checkbox path="service_type" value="Good"
							cssClass="form-control col-sm-4" />
						Good
						<form:checkbox path="service_type" value="Bad"
							cssClass="form-control col-sm-4" />
						Bad
						<form:errors path="service_type" cssClass="text-danger" />
					</div>
					<div class="form-group">
						<label for="patient" class="control-label col-sm-4">Date_Of_Service<font color="red">*</font></label>
						<form:input path="date_Of_Service"
							cssClass="form-control col-sm-4" />
						<form:errors path="date_Of_Service" cssClass="text-danger" />
					</div>
					<div class="form-group">
						<input type="submit" value="Register" class="btn btn-success" />
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
<body>
<%@ include file = "Footer.jsp" %>
</body>
</html>




