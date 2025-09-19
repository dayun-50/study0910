<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<title>Login Complete</title>
<style>
.container {
	max-width: 500px;
	margin: 100px auto;
	padding: 30px;
	border: 3px solid Darkgreen;
	border-radius: 15px;
	background: white;
}

.welcome {
	text-align: center;
	font-weight: bold;
	color: DarkOrange;
	font-size: 32px;
}

input[type="text"], input[type="password"] {
	width: 100%;
	margin: 15px 0;
	font-size: 20px;
	border-radius: 5px;
	border: none;
	border-bottom: 1px solid green;
	outline: none;
}

button {
	width: 30%;
	padding: 10px;
	font-size: 10px;
	background-color: Darkgreen;
	color: white;
	border: none;
	border-radius: 10px;
	cursor: pointer;
	transition: 0.3s;
}

button:hover {
	background-color: orange;
	transform: scale(1.1);
	box-shadow: 0 0 10px 5px rgba(255, 165, 0, 0.7);
}

.click {
	display: flex;
	justify-content: center;
	gap: 10px;
	margin-top: 15px;
}

.click button {
	width: 120px;
}

.row {
	display: flex;
	justify-content: center;
	gap: 10px;
	margin-top: 15px;
}

div.row a {
	font-size: 12px;
	border: none;
	text-decoration: none;
}

.error {
	color: red;
	text-align: center;
	margin-top: 10px;
	font-weight: bold;
}

.container .click form {
	display: flex;
	justify-content: center;
	gap: 10px; /* 버튼 사이 간격 */
	width: 100%;
}
</style>
</head>
<body>
	<div class="container">
		<div class="welcome">${userName} 님안녕하세요!</div>
		<div class="click">
			<button type="button" id="chat">채팅참여</button>
			<button type="button">마이페이지</button>
			<button type="button" id="borad">게시판</button>
			<button type="button">로그아웃</button>
			<button type="button">회원탈퇴</button>
		</div>
	</div>
	
<script>
	$("#borad").on("click", ()=>{
		window.location.href = "/borad/boradList";
	});
	
	$("#chat").on("click", ()=>{
		window.location.href = "/page/chatPage";
	});

</script>
</body>
</html>