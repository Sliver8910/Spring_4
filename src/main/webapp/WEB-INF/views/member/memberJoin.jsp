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
		<form id="frm" action="./memberJoin" method="post"
			enctype="multipart/form-data">
			<!-- Id -->
			<div class="form-group">
				<label class="control-label col-sm-2" for="Id">Id:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="id"
						placeholder="Enter id" name="id">
					<div id="checkIdResult"></div>
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
				<label for="file" class="control-label col-sm-2">File:</label>
				<div class="col-sm-10">
					<input type="file" name="file" class="form-control" id="file">
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
	var idCheck = false; //false: 중복된 ID, 또는 중복 검사를 하지 않은 경우
	//true : 중복되지 않은 ID.	
	$("#join").click(function() {
		alert(idCheck);
	});
	$("#id").blur(function() {
		var id = $(this).val();
		$.post("./memberCheckId", {
			id : id
		}, function(data) {
			data = data.trim();
			if (data == 'pass') {
				$("#checkIdResult").html('사용가능한 ID');
				$("#checkIdResult").attr("class", "text-success");
				idCheck = true;
			} else {
				$("#checkIdResult").html('중복된 ID');
				$("#checkIdResult").attr("class", "text-danger");
				idCheck = false;
				$("#id").val("");

			}
		});
	});
</script>
</html>