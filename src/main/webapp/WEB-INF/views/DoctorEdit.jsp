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
				<h2>WELCOME TO DOCTOR EDIT PAGE</h2>
			</div>


			<!-- card body -->
			<div class="card-body">
				<form:form action="update" method="post" modelAttribute="doctor"
					cssClass="form">
					 <div class="form-group">
						<label for="doctor" class="control-label col-sm-4">Doctor_Id<font color="red">*</font></label>
						<form:input path="doc_Id" readonly="true" cssClass="form-control col-sm-4" />
						<form:errors path="doc_Id" cssClass="text-danger" />
					</div>
					<div class="form-group">
						<label for="doctor" class="control-label col-sm-4">Doctor_Name<font color="red">*</font></label>
						<form:input path="doctor_Name" cssClass="form-control col-sm-4" />
						<form:errors path="doctor_Name" cssClass="text-danger" />
					</div>
					<div class="form-group">
						<label for="doctor" class="control-label col-sm-4">Address<font color="red">*</font></label>
						<form:input path="address" cssClass="form-control col-sm-4" />
						<form:errors path="address" cssClass="text-danger" />
					</div>
					<div class="form-group">
						<label for="doctor" class="control-label col-sm-4">Gender<font color="red">*</font></label>
						<form:radiobutton path="gender" value="Male"
							cssClass="form-control col-sm-4" />
						Male
						<form:radiobutton path="gender" value="Female"
							cssClass="form-control col-sm-4" />
						Female
						<form:errors path="gender" cssClass="text-danger" />
					</div>
					<div class="form-group">
						<label for="doctor" class="control-label col-sm-4">Contact_Num<font color="red">*</font></label>
						<form:input path="contact_Num" cssClass="form-control col-sm-4" />
						<form:errors path="contact_Num" cssClass="text-danger" />
					</div>
					<div class="form-group">
						<label for="doctor" class="control-label col-sm-4">Specialization<font color="red">*</font></label>
						<form:input path="specialization" cssClass="form-control col-sm-4" />
						<form:errors path="specialization" cssClass="text-danger" />
					</div>
					<div class="form-group">
						<label for="doctor" class="control-label col-sm-4">Service_Charges<font color="red">*</font></label>
						<form:input path="service_Charges"
							cssClass="form-control col-sm-4" />
						<form:errors path="service_Charges" cssClass="text-danger" />
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




