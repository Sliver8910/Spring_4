<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="../layout/bootstrap.jsp" />
<style type="text/css">
.title_n {
	text-transform: uppercase;
}
</style>

<title>${board}List</title>

</head>
<body>
	<c:import url="../layout/nav.jsp" />
	<div class="container">
		<h1 class="title_n">${board}</h1>
		<form id="frm" action="./${board}List">
			<input type="hidden" value="1" id="curPage" name="curPage">
			<div class="form-group col-xs-2">
				<select name="kind" class="form-control ">
					<option id="kt" value="kt">Title</option>
					<option id="kw" value="kw">Writer</option>
					<option id="kc" value="kc">Contents</option>
				</select>
			</div>
			<div class="input-group col-xs-3">
				<input type="text" class="form-control" placeholder="Search"
					name="search" value="${pager.search}">
				<div class="input-group-btn">
					<button class="btn btn-primary" type="submit">
						<i class="glyphicon glyphicon-search"></i>
					</button>
				</div>
			</div>
		</form>

		<table class="table ">
			<thead>
				<tr>
					<th class="th1">NUM</th>
					<th class="th1">Title</th>
					<th class="th1">Writer</th>
					<th class="th1">Date</th>
					<th class="th1">Hit</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="dto" varStatus="st">
					<!-- for문과 같은 효과  -->
					<tr>
						<td class="th1 num">${dto.num}</td>
						<td><c:catch>
								<!-- try catch와 같이 예외 처리, notice에는 depth가 없으므로 -->
								<c:forEach begin="1" end="${dto.depth}">--</c:forEach>
							</c:catch> <a href="${board}Select?num=${dto.num}">${dto.title}</a></td>
						<td class="th1">${dto.writer}</td>
						<td class="th1 date">${dto.reg_date}</td>
						<td class="th1 hit">${dto.hit}</td>
					</tr>
				</c:forEach>
			</tbody>


		</table>

		<div>
			<ul class="pagination">
				<c:if test="${pager.curBlock > 1}">
					<li><span id="${pager.startNum-1}" class="list"><</span></li>
				</c:if>
				<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
					<li><span id="${i}" class="list">${i}</span></li>
				</c:forEach>
				<c:if test="${pager.curBlock < pager.totalBlock}">
					<li><span id="${pager.lastNum+1}" class="list">></span></li>
				</c:if>
			</ul>

		</div>
		<c:if test="${not empty member}">
			<a class="btn btn-primary" href="./${board}Write">Write</a>
		</c:if>
	</div>

	<script type="text/javascript">
		var kind = '${pager.kind}';
		if (kind == '') {
			kind = "kt";
		}
		$("#" + kind).prop("selected", true);
		$(".list").click(function() {
			$("#curPage").val($(this).attr("id"));
			$("#frm").submit();
		});
	</script>

</body>
</html>