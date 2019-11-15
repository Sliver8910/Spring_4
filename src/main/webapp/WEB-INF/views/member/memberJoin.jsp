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
		<h2>Member Join</h2>
		<form action="./memberJoin" method="post">
			<div class="form-group ">
				<label class="control-label col-sm-2" for="id">ID:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="id"
						required="required" id="id"> <span id="checkId"
						class="btn-primary input-group-addon ">중복확인</span>
				</div>
			</div>
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
						class="form-control" id="name">
				</div>
			</div>
			<div class="form-group">
				<label for="email" class="control-label col-sm-2">Email:</label>
				<div class="col-sm-10">
					<input type="email" name="email" required="required"
						class="form-control" id="email">
				</div>
			</div>
			<div class="form-group">
				<label for="birth" class="control-label col-sm-2">Birth:</label>
				<div class="col-sm-10">
					<input type="text" name="birth" required="required"
						class="form-control" id="birth">
				</div>
			</div>
			<div class="form-group">
				<p>Gender</p>
				<div class="radio">
					<label><input type="radio" value="F" name="gender" checked>F</label>
				</div>
				<div class="radio">
					<label><input type="radio" value="M" name="gender">M</label>
				</div>
			</div>

			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>

</body>
<script type="text/javascript">
	//$("선택자").action();
	$("#checkId").click(
			function() {
				var id = $("#id").val();
				window.open("./memberCheckId?id=" + id, "",
						"width=500,height=300, left=400, top=200")
			});//callback함수
</script>
</html>