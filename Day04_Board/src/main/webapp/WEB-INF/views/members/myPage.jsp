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
<title>Insert title here</title>
<style>
body {
	background-color: #f4f4f4;
	font-family: Arial, sans-serif;
}

.container {
	max-width: 600px;
	margin: 50px auto;
	padding: 30px;
	border: 2px solid #1E3A8A;
	border-radius: 10px;
	background: #fff;
	box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
}

h2 {
	text-align: center;
	font-weight: bold;
	color: #1E3A8A;
	font-size: 28px;
	margin-bottom: 30px;
}

.form-group {
	margin-bottom: 18px;
}

.form-group label {
	display: block;
	font-weight: bold;
	margin-bottom: 5px;
	color: #047857;
}

.form-group input[type="text"], .form-group input[type="email"],
	.form-group input[type="password"] {
	width: calc(100% - 12px);
	padding: 6px;
	font-size: 16px;
	border: 1px solid #ccc;
	border-radius: 5px;
}

.zipcode-group {
	display: flex;
	gap: 5px;
}

.zipcode-group input {
	flex: 1;
}

.address-btn {
	display: none;
	background-color: #3B82F6;
	color: #fff;
	border: none;
	border-radius: 5px;
	padding: 6px 12px;
	cursor: pointer;
}

.address-btn:hover {
	background-color: #2563EB;
}

#passwordSection {
	display: none;
}

.buttons {
	display: flex;
	justify-content: center;
	gap: 15px;
	margin-top: 20px;
}

.buttons button {
	padding: 10px 20px;
	font-size: 16px;
	background-color: #047857;
	color: #fff;
	border: none;
	border-radius: 8px;
	cursor: pointer;
	transition: 0.3s;
}

.buttons button:hover {
	background-color: #F59E0B;
}

#submitBtn {
	display: none;
}
</style>
</head>
<body>

</body>
</html>