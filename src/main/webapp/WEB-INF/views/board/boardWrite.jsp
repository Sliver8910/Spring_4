<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${board} Write</title>
<c:import url="../layout/bootstrap.jsp"/>
</head>
<body>
	<c:import url="../layout/nav.jsp"/>
	<div class="container">
		<h2>${board} Insert Page</h2>
		<form action="./${board}Write" method="post" enctype="multipart/form-data"> 
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
			<div id="files">
				<div class="form-group updel">
						<label for="file">File: </label> 
						<input type="file" class="form-control" id="file" name="file">
					<div class="form-group" >
						 <input type="button" class="btn btn-danger del" value="del">
					</div>
				</div>
			</div>
			
			<input type="button" id="add" class="btn btn-success" value="Add File">

			<button type="submit" class="btn btn-default">Submit</button>
		</form>
	</div>
</body>
<script type="text/javascript">
var files = $("#files").html();
var count =0 ;
var index = 0; // index  번호 

$("#files").on("click", ".del",function(){
	/* 여기서 this는 del 버튼 */
	$(this).parents(".updel").remove();
	//$(this).parent().parent().remove();
	count--;
});

$("#files").empty();
$("#add").click(function() { 
	if(count<5){
	$("#files").append(files);
	count++; 
		}else{
		alert("최대 5개 가능");
		}
});

var divs = document.querySelector("div")
divs.forEach(function (div) {
	div.addEventListener('click', function () {
		alert('del');
})});



</script>
</html>