<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>마이페이지</title>
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
            box-shadow: 0 4px 10px rgba(0,0,0,0.1);
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
        .form-group input[type="text"],
        .form-group input[type="email"],
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
    <div class="container">
        <h2>마이페이지</h2>

        <form id="mypageForm" action="/membership/update" method="post">
            <input type="hidden" name="id" value="${user.id}">

            <div class="form-group">
                <label>아이디</label>
                <input type="text" value="${user.id}" readonly>
            </div>
            <div class="form-group">
                <label>이름</label>
                <input type="text" name="name" value="${user.name}">
            </div>
            <div class="form-group">
                <label>전화번호</label>
                <input type="text" name="phone" value="${user.phone}">
            </div>
            <div class="form-group">
                <label>이메일</label>
                <input type="email" name="email" value="${user.email}">
            </div>

            <!-- 우편번호 + 주소찾기 -->
            <div class="form-group">
                <label>우편번호</label>
                <div class="zipcode-group">
                    <input type="text" name="zipcode" value="${user.zipcode}" readonly>
                    <button type="button" class="address-btn" onclick="execDaumPostcode()">주소찾기</button>
                </div>
            </div>
            <div class="form-group">
                <label>주소</label>
                <input type="text" name="address" value="${user.address}" readonly>
            </div>
            <div class="form-group">
                <label>상세주소</label>
                <input type="text" name="detailAddress" value="${user.detailAddress}">
            </div>

            <!-- 비밀번호 -->
            <div id="passwordSection">
                <div class="form-group">
                    <label>새 비밀번호</label>
                    <input type="password" name="pw">
                </div>
                <div class="form-group">
                    <label>비밀번호 확인</label>
                    <input type="password" name="passwordCheck">
                </div>
            </div>

            <div class="buttons">
                <button type="button" onclick="showEditFields()">정보수정</button>
                <button type="submit" id="submitBtn">수정 완료</button>
                <button type="button" onclick="location.href='/membership/home'">홈으로</button>
            </div>
        </form>
    </div>

    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script>
        function showEditFields() {
            document.getElementById("passwordSection").style.display = "block";
            document.getElementById("submitBtn").style.display = "inline-block";
            document.querySelector(".address-btn").style.display = "inline-block";
        }

        function execDaumPostcode() {
            new daum.Postcode({
                oncomplete: function(data) {
                    document.querySelector("input[name='zipcode']").value = data.zonecode;
                    document.querySelector("input[name='address']").value = data.address;
                    document.querySelector("input[name='detailAddress']").focus();
                }
            }).open();
        }
    </script>
</body>
</html>
