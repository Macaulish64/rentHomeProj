<%--
  Created by IntelliJ IDEA.
  User: DY
  Date: 2018/12/23
  Time: 19:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String appPath = request.getContextPath(); %>

<html>
<head>
	<title></title>

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

<style>
	.houseimg {
		width: 250px;
		height: 250px;
	}
</style>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">

	<a class="col-sm-1 navbar-brand" href="../templates/index.html">
		zufang
	</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="col-sm-8 collapse navbar-collapse" id="collapsibleNavbar">
		<ul class="navbar-nav">
			<li class="nav-item">
				<a class="nav-link" href="houselist.jsp">租房信息</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="demandlist.jsp">求租信息</a>
			</li>
		</ul>
	</div>
</nav>

<div class="container">
	<ul id="houseList">
		<% for (int i = 0; i < 3; i++) { %>
		<li class="row">
			<div class="img col-sm-4">
				<img class="houseimg" src="<%=appPath%>/img/a%20(1).JPG">
			</div>
			<div class="txt col-sm-4">
				<h3>Haha</h3>
				<h4>北京市海淀区西土城路10号北京邮电大学学一楼307</h4>
			</div>
			<div class="btn col-sm-4">
				<a class="button" style="alignment: center" href="houseinfo.jsp">
					Details
				</a>
			</div>
		</li>
		<% } %>
	</ul>
</div>

</body>
</html>
