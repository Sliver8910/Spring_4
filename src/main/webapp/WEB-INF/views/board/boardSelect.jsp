<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${board} title here</title>
<c:import url="../layout/bootstrap.jsp"/>
<style type="text/css">
.title_n {
	text-transform: uppercase;
}
</style>
</head>
<body>
	<c:import url="../layout/nav.jsp"/>
	<div class="container" >
	<h1 class="title_n">${board}</h1> 
		<table class="table ">
			<thead>
				<tr>
					<th class="th1">Title</th><th class="th1">Writer</th><th class="th1">Date</th><th class="th1">Hit</th>
				</tr>
			</thead> 
			<tbody> 
				<tr>
					<td id="title1">${boardVO.title}</td><td class="th1">${boardVO.writer}</td><td class="th1 date">${boardVO.reg_date}</td><td class="th1 hit">${boardVO.hit}</td>
				</tr>
				<tr>
					<td colspan="4"><div class="con1">${boardVO.contents}</div></td>
				</tr>
			</tbody>
		</table>
		<div>
			<c:forEach items="${boardVO.files}" var="file">
				<a href="./fileDown?fnum=${file.fnum}">${file.oname}</a>
			</c:forEach>
		</div>
		
		<a href="${board}List" class="btn btn-primary">글목록</a>
		<c:if test="${member.id eq boardVO.writer}">
			<a class="btn btn-primary" href="${board}Update?num=${boardVO.num}">Update</a>
			<a class="btn btn-danger" href="${board}Delete?num=${boardVO.num}">Delete</a>
		</c:if>
		<c:if test="${board eq 'qna'}">
			<a class="btn btn-primary" href="${board}Reply?num=${boardVO.num}">답글</a>
		</c:if>
	</div>
	
	
</body>
</html>