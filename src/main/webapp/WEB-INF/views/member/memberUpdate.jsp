<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<c:import url="../layout/bootstrap.jsp" />
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:import url="../layout/nav.jsp" />
<div class="container">
		<h2>Member Update</h2>
		<form action="./memberUpdate" method="post">
			<div class="form-group">
				<label for="pw" class="control-label col-sm-2">Password:</label>
				<div class="col-sm-10">
					<input type="password" name="pw" required="required"
						class="form-control" id="pw">
				</div>
			</div>
			<div class="form-group">
				<label for="pw2" class="control-label col-sm-2">PasswordConfirm:</label>
				<div class="col-sm-10">
					<input type="password" name="pw2" required="required"
						class="form-control" id="pw2">
				</div>
			</div>
			<div class="form-group">
				<label for="name" class="control-label col-sm-2">Name:</label>
				<div class="col-sm-10">
					<input type="text" name="name" required="required"
						class="form-control" value="${dto.name}" id="name">
				</div>
			</div>
			<div class="form-group">
				<label for="email" class="control-label col-sm-2">Email:</label>
				<div class="col-sm-10">
					<input type="email" name="email" required="required"
						class="form-control" value="${dto.email}" id="email">
				</div>
			</div>	
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>

</body>
</html>