<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Doctor Data Page</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<%@include file="Menu.jsp"%>

	<div class="container-fluid">

		<div class="card">

			<!-- card heading starts -->
			<div class="card-header bg-info text-white">
				<h2>WELCOME TO DOCTOR DATA PAGE</h2>
			</div>

			<!-- card body start -->
			<div class="card-body">
				<c:choose>
					<c:when test="${!empty doctors}">
						<table class="table table-hover">
							<tr>
								<th>Doctor_Id</th>
								<th>Doctor_Name</th>
								<th>Address</th>
								<th>Gender</th>
								<th>Contact_Num</th>
								<th>Specialization</th>
								<th>Service_Charges</th>
								<th>DELETE</th>
								<th colspan="1">EDIT</th>|<a href="excel"><font color="Red"><b>EXCEL SHEET</b></font></a>|<a href="pdf"><font color="Red"><b>PDF FORMAT</b></font></a>
								
</tr>
							<c:forEach items="${doctors}" var="doctor">
								<tr>
									<td><c:out value="${doctor.doc_Id}" /></td>
									<td><c:out value="${doctor.doctor_Name}" /></td>
									<td><c:out value="${doctor.address}" /></td>
									<td><c:out value="${doctor.gender}" /></td>
									<td><c:out value="${doctor.contact_Num}" /></td>
									<td><c:out value="${doctor.specialization}" /></td>
									<td><c:out value="${doctor.service_Charges}" /></td>
									
<td><a href="delete?id=${doctor.doc_Id}" class="btn btn-danger"><span class="glyphicon glyphicon-trash" title="Delete" aria-hidden="true"></span></a></td>
 <td><a href="edit?id=${doctor.doc_Id}" class="btn btn-danger"><span class="glyphicon glyphicon-edit" title="Edit" aria-hidden="true"></span></a></td>
								</tr>
							</c:forEach>
						</table>
					</c:when>
					<c:otherwise>
						<div class="text-info">No Data Found in Database</div>
					</c:otherwise>
				</c:choose>
				<!-- card body end -->
			</div>
            <!-- card footer -->
			<c:if test="${message ne null}">
				<div class="card-footer bg-warning">${message}</div>
			</c:if>
			<!-- card end -->
		</div>
		<!-- container end -->
	</div>
</body>
</html>



