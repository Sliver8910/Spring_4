<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${board} Reply</title>
<c:import url="../layout/bootstrap.jsp"/>
</head>
<body>
	<c:import url="../layout/nav.jsp"/>
	<div class="container">
		<h2>${board} Reply</h2>
		<form action="./${board}Reply" method="post"> 
		<!-- 부모의 num을 가져오기 위해  -->
			<input type="hidden" name = "num" value="${num}">
			<div class="form-group">
				<label for="title">Title : </label> <input type="text"
					class="form-control" id="title" name="title">
			</div>
			<div class="form-group">
				<label for="writer">Writer : </label> <input type="text"
					class="form-control" id="writer" name="writer">
			</div>
			<div class="form-group">
				<label for="contents">Contents:</label>
				<textarea class="form-control" rows="30" id="contents"
					name="contents"></textarea>
			</div>


			<button type="submit" class="btn btn-default">Submit</button>
		</form>
	</div>
</body>
</html>