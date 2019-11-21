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
			
			
			<div>
				<c:forEach items="${dto.files}" var="file">
					<div id="f${file.fnum}">
						<p>${file.oname} <input type="button" id="${file.fnum}" class="del_file" value="del"></p>
					</div>
				</c:forEach>
			</div>
			<button type="submit" class="btn btn-default">Update</button>
		</form>
	</div>

</body>
<script type="text/javascript">

var count = 0;
count = ${size};
var files= $("#files").html();
$("#files").empty();
$("#add").click(function() {
	if(count<5){
	$("#files").append(files);
	count++}else{
		alert("최대 5개 가능");
	}
});
//이벤트 위임
$("#files").on("click",".del",function(){
	$(this).parents(".updel").remove();
	count--;
});

$(".del_file").click(function () {
	var fnum=$(this).attr("id") //id에 file.fnum을 넣고 본인의 id 속성을 가져옴
	$.post("./fileDelete",{fnum:fnum},function(data){
		data= data.trim(); //공백 제거
		if(data == '1'){
			$("#f"+fnum).remove();
			count--;
		}
		alert(data);
	});
});

</script>

</html>