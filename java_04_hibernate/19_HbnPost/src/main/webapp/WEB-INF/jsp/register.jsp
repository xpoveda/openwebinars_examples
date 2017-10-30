<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>HbnPost</title>

<!-- Bootstrap core CSS -->
<link href="webjars/bootstrap/3.3.7-1/css/bootstrap.min.css"
	rel="stylesheet">


<!-- Custom styles for this template -->

<link href="<c:url value="/assets/css/jumbotron-narrow.css" />"
	rel="stylesheet">


<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<div class="container">
		<div class="header clearfix">
			<nav>
				<ul class="nav nav-pills pull-right">
					<!-- <li role="presentation" class="active"><a href="#">Home</a></li>
					<li role="presentation"><a href="#">About</a></li>
					<li role="presentation"><a href="/autores">Autores</a></li>-->
					<c:choose>
						<c:when test="${not empty sessionScope.userLoggedIn}">
							<jsp:include page="includes/menu_logged.jsp" flush="true">
								<jsp:param name="inicio" value="inicio" />
								<jsp:param name="usuario" value="${sessionScope.userLoggedIn.nombre}" />
							</jsp:include>

						</c:when>
						<c:otherwise>
							<jsp:include page="includes/menu.jsp">
								<jsp:param name="inicio" value="inicio" />
							</jsp:include>
						</c:otherwise>
					</c:choose>
				</ul>
			</nav>
			<h3 class="text-muted">HbnPost</h3>
		</div>

		<div class="col-lg-8 col-lg-offset-2">
			<div class="text-center">
				<h3>
					<b>Registro</b>
				</h3>
			</div>
			<form:form id="register-form" action="/register" method="post"
				modelAttribute="userRegister" role="form" autocomplete="off">
				<div class="form-group">

					<form:input type="text" name="nombre" id="nombre" tabindex="1"
						class="form-control" placeholder="Nombre" path="nombre" />
				</div>
				<div class="form-group">
					<form:input type="text" name="ciudad" id="ciudad" tabindex="2"
						class="form-control" placeholder="Ciudad, País" path="ciudad" />
				</div>
				
				<div class="form-group">
					<form:input type="email" name="email" id="email" tabindex="4"
						class="form-control" placeholder="Email" path="email" />
				</div>
				<div class="form-group">
					<form:input type="password" name="password" id="password"
						tabindex="5" class="form-control" placeholder="Password"
						path="password" />
				</div>
				<div class="form-group">
					<input type="password" name="confirm-password"
						id="confirm-password" tabindex="6" class="form-control"
						placeholder="Repetir Password" data-rule-equalTo="#password">
				</div>
				<div class="form-group">
					<div class="row">
						<div class="col-xs-6 col-xs-offset-3">
							<input type="submit" name="register-submit" id="register-submit"
								tabindex="9" class="form-control btn btn-info"
								value="Registrar ahora">
						</div>
					</div>
				</div>
				<input type="hidden" class="hide" name="token" id="token"
					value="7c6f19960d63f53fcd05c3e0cbc434c0">
			</form:form>
		</div>

		<footer class="footer"> </footer>

	</div>
	<!-- /container -->
	<script src="webjars/jquery/3.1.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
	<script src="/assets/js/jquery.validate.min.js"></script>	
	<script src="/assets/js/messages_es.min.js"></script>	
	<script>
		$(document).ready(function() {
			$("#register-form").validate();
			
		});
	
	</script>

</body>
</html>
