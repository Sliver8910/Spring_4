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

<button id="btn2">Click</button>
<button id="btn">Get Json1</button>
<script type="text/javascript">
	$("#btn").click(function() {
		$.get("./getJson3", function(data) {
			$.each(data, function(i,vo) {
				console.log(i);
				console.log(vo.num);
			})
			/* for(var i=0;i<data.length;i++){
				console.log(data[i].num)
			} */
			//data=data.trim();
			//alert(typeof data);
			/* data=JSON.parse(data);
			alert(data.title); */
		});
	});
	
	$("#btn2").click(function() {
		$.ajax({
			type:"GET",
			url:"https://api.manana.kr/exchange/price.json",
			data : {
				base:"USD",
				price:"1",
				code: "KRW"
			},
			success:function(data){
				console.log(data.KRW)
			}
		});
	});
</script>
</body>
</html>
