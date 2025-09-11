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
<form action="/contacts/input">
	<table border="1" align="center">
		<tr align="center">
			<th>연락처 신규 등록</th>
		</tr>
		<tr>
			<td align="center">
				<input type="text" placeholder="이름 입력" name="name">
			</td>
		</tr>
		<tr>
			<td align="center">
				<input type="text" placeholder="연락처 입력" name="phone">
			</td>
		</tr>
		<tr>
			<td align="center">
				<button align="center">등록</button>
			</td>
		</tr>
		<tr>
			<td align="center">
				<a href="/" align="center">뒤로가기</a>
			</td>
		</tr>
	</table>
</form>	
	
</body>
</html>