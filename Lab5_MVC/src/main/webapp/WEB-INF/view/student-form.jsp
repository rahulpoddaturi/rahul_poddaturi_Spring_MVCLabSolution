<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Student Registration Form</title>
</head>

<body>

	<div class="container">

		<h3>Please enter the details below</h3>
		<hr>

		<form action="/Lab5_MVC/student/save" method="POST">

			<!-- Add hidden form field to handle update -->
			<input type="hidden" name="id" value="${Student.id}" />

			<div class="form-inline">
				<input type="text" name="FirstName" value="${Student.firstName}"
					class="form-control mb-4 col-4" placeholder="First Name">



			</div>
			
			<div class="form-inline">
				<input type="text" name="LastName" value="${Student.lastName}"
					class="form-control mb-4 col-4" placeholder="Last Name">



			</div>
				
			<div class="form-inline">

				<input type="text" name="Department" value="${Student.department}"
					class="form-control mb-4 col-4" placeholder="Department">



			</div>

			<div class="form-inline">

				<input type="text" name="Country" value="${Student.country}"
					class="form-control mb-4 col-4" placeholder="Country">



			</div>

			<button type="submit" class="btn btn-info col-2">Save</button>

		</form>

		<hr>
		<a href="/Lab5_MVC/student/list">Back to Student List</a>

	</div>
</body>

</html>










