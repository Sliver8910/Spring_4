<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="./layout/summernote.jsp"></c:import>

<html>
<head>
<c:import url="./layout/bootstrap.jsp"></c:import>
	<title>Home</title>
</head>
<body>
<c:import url="./layout/nav.jsp"></c:import>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<div id="editor"></div>
<script type="text/javascript">
$("#editor").summernote();
</script>
</body>
</html>
