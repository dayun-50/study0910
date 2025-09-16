<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<body>
	<table border="1" align="center">
		<tr>
			<th colspan="3">
				<img src="/img/a.png" style="width: 200px; height: 200px;">
			</th>
		</tr>
	
		<tr>
			<th colspan="2" >Index</th>
		</tr>
		<tr>
			<td>
				<a href="/massages/input">입력하기</a>
			</td>
			<td>
				<a href="/massages/output">출력하기</a>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button id= "ajax">해봐</button>
			</td>
		</tr>
		
		<tr>
			<td colspan="3" align="center">
			<form action="/massages/searchby" >
				<select name="column">
					<option value="sender">작성자</option>
					<option value="message">메세지</option>
				</select>
				<input type="text" placeholder="검색할 내용" name="keyword">
				<button>검색</button>
			</form>
			</td>
		</tr>
		<tr>
			<td colspan="3" align="center">
			<form action="/massages/searchByMultiple" >
				<input type="text" placeholder="input sender to search" name="sender"><br>
				<input type="text" placeholder="input message to search" name="message"><br>
				<button>검색</button>
			</form>
			</td>
		</tr>
	</table>
<script>

	//펑션을 람다식으로 했다 이말이야 e.뭐시기 쓸려면 소괄호안에 e선언해주면됩니두
	$("#ajax").on("click", ()=>{
		$.ajax({
			url:"/ajax"
			//2. dataType : json
		}).done((resp)=>{
			//1. resp = JSON.parse(resp);
			console.log(resp);
		})
	});



</script>

</body>
</html>