<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../layout/bootstrap.jsp"/>
</head>
<body>
<c:import url="../layout/nav.jsp"/>
	<div class="container">
		<h2>${board} Update Page</h2>
		<form action="./${board}Update" method="post">
		<input type="text" name = "num" value="${dto.num}" hidden="" readonly="readonly">
			<div class="form-group">
				<label for="title">Title : </label> <input type="text"
					class="form-control" id="title" value="${dto.title}" name="title">
			</div>
			<div class="form-group">
				<label for="writer">Writer : </label> <input type="text"
					class="form-control" id="writer" readonly="readonly" value="${dto.writer}" name="writer">
			</div>
			<div class="form-group">
				<label for="contents">Contents:</label>
				
				<textarea class="form-control" rows="30" id="contents"
					name="contents"  >${dto.contents}</textarea>
			</div>

			<button type="submit" class="btn btn-default">Update</button>
		</form>
	</div>

</body>
</html>