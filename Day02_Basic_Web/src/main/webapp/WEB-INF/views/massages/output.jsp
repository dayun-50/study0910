<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Message List</title>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<body>
	<table border="1" align="center">
		<tr>
			<th>Seq</th>
			<th>Sender</th>
			<th>Message</th>
		</tr>
		
		<c:forEach var="i" items="${list}">
			<tr>
				<td>${i.seq} </td>
				<td>${i.sender}</td>
				<td>${i.message}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="3" align="center">
			<form action="/massages/update">
				<input type="text" placeholder="input seq to update" name="seq"><br>
				<input type="text" placeholder="input sender to update" name="sender"><br>
				<input type="text" placeholder="input message to update" name="message"><br>
				<button>수정</button>
			</form>	
			</td>
		</tr>
		<tr>
			<td colspan="3" align="center">
			<form action="/massages/delete">
				<input type="text" placeholder="input seq to delete" name="dleSeq">
				<button>삭제</button>
			</form>	
			</td>
		</tr>
		<tr>
			<td colspan="3" align="center">
				<a href="/">back</a>
			</td>
			</tr>
		
	</table>
</body>
</html>