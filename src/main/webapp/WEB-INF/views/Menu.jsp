<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="base">${pageContext.request.requestURL}</c:set>
<c:set var="url"	value="${fn:replace(base, pageContext.request.requestURI, pageContext.request.contextPath)}" />


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

<nav class="navbar navbar-expand-sm bg-dark navbar-success ">	<!-- Brand -->
	<a class="navbar-brand " href="#"><img src="../resources/imgs/healthcareLogo.jpg" /></a>

	<!-- Links -->
	<ul class="navbar-nav">
		<!--   <li class="nav-item">
      <a class="nav-link" href="#">Link 1</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">Link 2</a>
    </li> -->

		<!-- Dropdown -->
		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			href="#" id="navbardrop" data-toggle="dropdown">Patient</a>
			<div class="dropdown-menu">
				<a class="dropdown-item" href="${url}/patient/register">Register </a> <a
					class="dropdown-item" href="${url}/patient/all">View All</a> 
			</div></li>


		<!-- Doctor-->
		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			href="#" id="navbardrop" data-toggle="dropdown">Doctor</a>
			<div class="dropdown-menu">
				<a class="dropdown-item" href="${url}/doctor/register">Register </a>
        <a class="dropdown-item" href="${url}/doctor/all">View All</a>
       
			</div></li>

		<!-- Appointment -->
		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			href="#" id="navbardrop" data-toggle="dropdown">Appointment</a>
			<div class="dropdown-menu">
				<a class="dropdown-item" href="${url}/appoinment/register">Register </a>
        <a class="dropdown-item" href="${url}/appoinment/all">View All</a>
      
			</div></li>
		<!-- Billing Form -->
		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			href="#" id="navbardrop" data-toggle="dropdown">Billing Form</a>
			<div class="dropdown-menu">
				<a class="dropdown-item" href="${url}/billing/register">Register </a>
        <a class="dropdown-item" href="${url}/billing/all">View All</a>
       
			</div></li>

		<!-- DoctorAppointment -->
		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			href="#" id="navbardrop" data-toggle="dropdown">DoctorAppointment</a>
			<div class="dropdown-menu">
				<a class="dropdown-item" href="${url}/doctappoint/register">Register </a>
        <a class="dropdown-item" href="${url}/doctappoint/all">View All</a>
       <%-- 
			</div></li>
		<!-- Employee -->
		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			href="#" id="navbardrop" data-toggle="dropdown">Employee</a>
			<div class="dropdown-menu">
				<a class="dropdown-item" href="${url}/employee/register">Register </a>
        <a class="dropdown-item" href="${url}/employee/getAll">View All</a>
       
			</div></li>

		<!-- Purchase Order -->
		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			href="#" id="navbardrop" data-toggle="dropdown">Purchase Order</a>
			<div class="dropdown-menu">
				<a class="dropdown-item" href="${url}/po/register">Register </a> <a
					class="dropdown-item" href="${url}/po/all">View All</a> 
			</div></li>
			
		<!-- Sale Order -->
		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			href="#" id="navbardrop" data-toggle="dropdown">Sale Order</a>
			<div class="dropdown-menu">
				<a class="dropdown-item" href="${url}/sale/register">Register </a> <a
					class="dropdown-item" href="${url}/sale/viewAll">View All</a>
			</div></li> --%>

		<!-- SWAGGER -->
		<%-- <li class="nav-item"><a class="nav-link"
			href="${url}/swagger-ui.html">Swagger</a></li> --%>

		<li class="nav-item"><a class="nav-link" href="${url}/logout">logout</a></li>

	</ul>
</nav>