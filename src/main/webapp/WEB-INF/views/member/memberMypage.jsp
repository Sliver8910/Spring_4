<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="../layout/bootstrap.jsp" />
<title>MyPage</title>
</head>
<body>
<c:import url="../layout/nav.jsp" />
<h1>회원정보</h1>
	<p>아이디 : ${dto.id}</p>
	<p>이름 : ${dto.name}</p>
	<p>이메일 : ${dto.email}</p>
	<P>성별 : ${dto.gender}</P>
	<p>생년월일 : ${dto.birth}</p>
	<p>포인트 : ${dto.point}</p>
	<div>
		<img alt="" src="../resources/upload/member/${member.fileName}">
	</div>
	
	<a href="./memberUpdate" class="btn btn-primary">회원정보 수정</a>
	<a href="./memberDelete" class="btn btn-danger">회원 탈퇴</a>

</body>
</html>