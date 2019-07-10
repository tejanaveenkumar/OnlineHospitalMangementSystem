<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BillingForm Data Page</title>
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
			<h1 style="text-align:center;">WELCOME TO BILLING DATA PAGE</h1>
					</div>

			<!-- card body start -->
			<div class="card-body">
				<c:choose>
					<c:when test="${!empty billings}">
						<table class="table table-hover">
							<tr>
						        <th>ID</th>
								<th>Patient_Name</th>
								<th>Patient_Id</th>
								<th>Date_Of_Admission</th>
								<th>Date_Of_Discharge</th>
								<th>Room_Type</th>
								<th>Total_Amount</th>
								<th>DELETE</th>
								<th colspan="1">EDIT</th>								
</tr>
							<c:forEach items="${billings}" var="billingForm">
								<tr>
									<td><c:out value="${billingForm.id}" /></td>
									<td><c:out value="${billingForm.patient_Name}" /></td>
									<td><c:out value="${billingForm.patient_Id}" /></td>
									<td><c:out value="${billingForm.date_Of_Admission}" /></td>
									<td><c:out value="${billingForm.date_Of_Discharge}" /></td>
									<td><c:out value="${billingForm.roomType}" /></td>
									<td><c:out value="${billingForm.amount}" /></td>
<td><a href="delete?id=${billingForm.id}" class="btn btn-danger"><span class="glyphicon glyphicon-trash" title="Delete" aria-hidden="true"></span></a></td>
 <td><a href="edit?id=${billingForm.id}" class="btn btn-danger"><span class="glyphicon glyphicon-edit" title="Edit" aria-hidden="true"></span></a></td>
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