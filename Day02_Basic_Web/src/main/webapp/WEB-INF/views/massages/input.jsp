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
	<form action="/massages/inputproc">
		<input type="text" placeholder="작성자이름" name="sender"><br>
		<input type="text" placeholder="보낼 메세지 내용" name="message"><br>
		<button>전송</button>
		<a href="/"><button type="button">홈으로</button></a>
	</form>
</body>
</html>