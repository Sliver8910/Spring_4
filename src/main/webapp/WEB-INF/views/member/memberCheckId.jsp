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
	<h1>${param.id} ${result}</h1>
	<div class="container">
		<form class="form-inline" action="./memberCheckId">
   		 	<div class="form-group">
     		 	<label for="id">Id:</label>
      			<input type="text" value="${param.id}" class="form-control" id="id" name="id">
   			</div>

    <button type="submit" class="btn btn-default">중복확인</button>
    <c:if test="${empty dto}">
    	<input type="button" class="btn btn-primary" id="useId" value="사용하기">
    </c:if>
 	 </form>
	</div>

</body>
<script type="text/javascript">
$("#useId").click(function() {
	var id = $("#id").val();
	
	//javascript
	//opener.document.getElementById("id").value=id;
	//jquery
	$("#id", opener.document).val(id);
	
	window.self.close();
});
</script>
</html>