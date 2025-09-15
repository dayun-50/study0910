<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<style>
body {
	background-color: #f4f4f4;
	font-family: Arial, sans-serif;
}

.container {
	max-width: 700px;
	margin: 50px auto;
	padding: 30px;
	border-radius: 10px;
	background-color: white;
	border: 2px solid #1E3A8A;
	box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
}

h2 {
	text-align: center;
	color: #1E3A8A;
	margin-bottom: 25px;
	font-size: 28px;
}

label {
	display: block;
	font-weight: bold;
	margin: 10px 0 5px;
	color: #1E3A8A;
}

input[type="text"], textarea {
	width: 100%;
	padding: 8px;
	font-size: 16px;
	border-radius: 5px;
	border: 1px solid gray;
	box-sizing: border-box;
}

textarea {
	resize: vertical;
	height: 150px;
}

.buttons {
	display: flex;
	justify-content: center;
	gap: 15px;
	margin-top: 20px;
}

.buttons button {
	padding: 10px 25px;
	font-size: 16px;
	background-color: #047857;
	color: white;
	border: none;
	border-radius: 8px;
	cursor: pointer;
	transition: 0.3s;
}

.buttons button:hover {
	background-color: #F59E0B;
}
</style>
</head>
<body>
	<div class="container">
		<h2>게시글 작성</h2>
		<form action="/board/write" method="post">
			<label>제목</label> <input type="text" name="title"
				placeholder="제목을 입력하세요" required> <label>작성자</label> <input
				type="text" name="writer" value="${user.name}" readonly> <input
				type="file">
			<label>내용</label>
			<textarea name="content" placeholder="내용을 입력하세요" required></textarea>


			<div class="buttons">
				<button type="submit">작성 완료</button>
				<button type="button" onclick="location.href='/board/list'">목록으로</button>
			</div>
		</form>
	</div>
</body>
</html>
