<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원탈퇴 완료</title>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <style>
        body {
            background-color: #f4f4f4;
            font-family: Arial, sans-serif;
        }
        .container {
            max-width: 500px;
            margin: 100px auto;
            padding: 40px;
            border-radius: 10px;
            background-color: white;
            border: 2px solid #1E3A8A;
            box-shadow: 0 4px 10px rgba(0,0,0,0.1);
            text-align: center;
        }
        h2 {
            color: #1E3A8A;
            margin-bottom: 20px;
            font-size: 28px;
        }
        p {
            font-size: 18px;
            color: #333;
            margin: 15px 0;
        }
        .btn-home {
            margin-top: 30px;
            padding: 10px 25px;
            font-size: 16px;
            background-color: #047857;
            color: white;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            transition: 0.3s;
        }
        .btn-home:hover {
            background-color: #F59E0B;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>회원탈퇴 완료</h2>
        <p><c:out value="${user.id}"/>님, 그동안 저희 서비스를 이용해 주셔서 감사합니다.</p>
        <button class="btn-home" onclick="location.href='/membership/home'">홈으로 가기</button>
    </div>
</body>
</html>
