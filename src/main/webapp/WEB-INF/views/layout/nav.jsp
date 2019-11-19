<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="${pageContext.request.contextPath}/">WebSiteName</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="${pageContext.request.contextPath}">Home</a></li>
				<li class=><a href="${pageContext.request.contextPath}/point/pointList.jsp">Point</a></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Page 1-1</a></li>
						<li><a href="#">Page 1-2</a></li>
						<li><a href="#">Page 1-3</a></li>
					</ul></li>
				<li><a href="${pageContext.request.contextPath}/notice/noticeList">Notice</a></li>
				<li><a href="${pageContext.request.contextPath}/qna/qnaList">QNA</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
			<c:if test="${not empty sessionScope.member}">
				<li><a href="${pageContext.request.contextPath}/member/memberMypage"><span class="glyphicon glyphicon-user"></span>
						My Page</a></li>
				<li><a href="${pageContext.request.contextPath}/member/memberLogout"><span class="glyphicon glyphicon-log-out"></span>
						Logout</a></li>
			</c:if>
			<c:if test="${empty member}">
				<li><a href="${pageContext.request.contextPath}/member/memberJoin"><span class="glyphicon glyphicon-user"></span>
						Sign up</a></li>
				<li><a href="${pageContext.request.contextPath}/member/memberLogin"><span class="glyphicon glyphicon-log-in"></span>
						Login</a></li>
			</c:if>
			</ul>
		</div>
	</nav>

