<%--
  Created by IntelliJ IDEA.
  User: DY
  Date: 2018/12/23
  Time: 19:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String appPath = request.getContextPath(); %>
<html>
<head>
	<title>sign up</title>

	<!-- Required meta tags -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">

	<a class="col-sm-1 navbar-brand" href="../index.jsp">
		zufang
	</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="col-sm-8 collapse navbar-collapse" id="collapsibleNavbar">
		<ul class="navbar-nav">
			<li class="nav-item">
				<a class="nav-link" href="#">Link</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="#">Link</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="#">Link</a>
			</li>
		</ul>
	</div>
</nav>

<script src="<%=appPath%>/js/user.js"></script>

<div class="container">
	<form role="form" id="register" <%--action="<%=appPath%>/user/register" method="post"--%>>
		<div class="form-group">
			<label for="phonenumber">Phone number</label>
			<input type="text" class="form-control" id="phonenumber">
		</div>
		<div class="form-group">
			<label for="usernickname">User Name</label>
			<input type="text" class="form-control" id="usernickname">
		</div>
		<div class="form-group">
			<label for="password">Password</label>
			<input type="password" class="form-control" id="password">
		</div>
		<div class="form-group">
			<label for="confirmpassword">Confirm password</label>
			<input type="password" class="form-control" id="confirmpassword">
		</div>
		<hr>
		<div class="form-group">
			<label for="selectid">Select ID</label>
			<select name="id" id="selectid">
				<option value=0>身份证</option>
				<option value=1>护照</option>
			</select>
		</div>
		<button type="submit" class="btn btn-primary"
						onclick="signup_sumbit('<%=appPath%>/user/register')">
			Submit
		</button>
	</form>
</div>

</body>
</html>