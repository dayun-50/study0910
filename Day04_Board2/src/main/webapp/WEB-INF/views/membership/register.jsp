<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <style>
        .container {
            max-width: 500px;
            margin: 50px auto;
            padding: 30px;
            border: 3px solid Darkgreen;
            border-radius: 15px;
            background: white;
        }
        h4 {
            text-align: center;
            font-weight: bold;
            color: DarkOrange;
            font-size: 32px;
        }
        input[type="text"], input[type="password"], input[type="email"], input[type="tel"] {
            width: 100%;
            margin: 10px 0;
            font-size: 18px;
            border-radius: 5px;
            border: none;
            border-bottom: 1px solid green;
            outline: none;
            padding: 5px;
        }
        .row {
            display: flex;
            gap: 10px;
            align-items: center;
            margin: 10px 0;
        }
        .row input {
            flex: 1;
        }
        button {
            padding: 8px 15px;
            font-size: 14px;
            background-color: Darkgreen;
            color: white;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            transition: 0.3s;
        }
        button:hover {
            background-color: orange;
            transform: scale(1.05);
            box-shadow: 0 0 8px 3px rgba(255,165,0,0.6);
        }
        .click {
            display: flex;
            justify-content: center; 
            gap: 20px;
            margin-top: 20px;
        }
        .click button {
            width: 150px;
            font-size: 16px;
        }
    </style>
</head>
<body>
<div class="container">
    <form id="registerForm" action="/membership/register" method="post">
        <h4>회원 가입 정보 입력</h4>

        <div class="row">
            <input type="text" placeholder="아이디를 입력해주세요" name="id">
            <button type="button" id="idcheck">중복확인</button>
        </div>
        <span id="idcheckMsg" style="display:block; margin-left:10px; color:green; font-weight:bold;"></span> <!-- 메시지 표시 -->

        <input type="password" placeholder="비밀번호를 입력해주세요" name="pw">
        <input type="password" placeholder="비밀번호를 다시 입력해주세요" name="pw_check">
        <input type="text" placeholder="이름을 입력해주세요" name="name">
        <input type="tel" placeholder="전화번호를 입력해주세요 (예: 010-1234-5678)" name="phone">
        <input type="email" placeholder="이메일을 입력해주세요" name="email">

        <div class="row">
            <input type="text" placeholder="우편번호" name="zipcode">
            <button type="button" id="postcodeBtn">찾기</button>
        </div>

        <input type="text" placeholder="주소" name="address">
        <input type="text" placeholder="상세주소" name="detailAddress">

        <div class="click">
            <button type="submit">회원가입</button>
            <button type="reset">다시 입력</button>
        </div>
    </form>
</div>

<script>
$(document).ready(function() {

	$("#idcheck").click(function() {
	    var userId = $("input[name='id']").val().trim();
	    if(!userId){
	        $("#idcheckMsg").text("아이디를 입력하세요.").css("color","red");
	        return;
	    }
	    $.ajax({
	        url: '/checkId',
	        type: 'GET',
	        data: { id: userId },
	        dataType: 'json',
	        success: function(res){
	            if(res.status === "available"){
	                $("#idcheckMsg").text(res.message).css("color","green");
	            } else {
	                $("#idcheckMsg").text(res.message).css("color","red");
	            }
	        },
	        error: function() {
	            $("#idcheckMsg").text("오류가 발생했습니다.").css("color","red");
	        }
	    });
	});

    $("#postcodeBtn").click(function(){
        new daum.Postcode({
            oncomplete: function(data) {
                $("input[name='zipcode']").val(data.zonecode);
                $("input[name='address']").val(data.address);
                $("input[name='detailAddress']").focus();
            }
        }).open();
    });

    $("#registerForm").submit(function(e){
        var pw = $("input[name='pw']").val();
        var pwCheck = $("input[name='pw_check']").val();
        if(pw !== pwCheck){
            alert("비밀번호가 일치하지 않습니다.");
            e.preventDefault();
            return false;
        }

        var required = ["id","pw","pw_check","name","phone","email","zipcode","address"];
        for(var i=0;i<required.length;i++){
            var val = $("input[name='"+required[i]+"']").val().trim();
            if(!val){
                alert("필수 항목을 모두 입력해주세요.");
                e.preventDefault();
                return false;
            }
        }

        var email = $("input[name='email']").val();
        var phone = $("input[name='phone']").val();
        var emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        var phonePattern = /^\d{2,3}-\d{3,4}-\d{4}$/;

        if(!emailPattern.test(email)){
            alert("이메일 형식이 올바르지 않습니다.");
            e.preventDefault();
            return false;
        }

        if(!phonePattern.test(phone)){
            alert("전화번호 형식이 올바르지 않습니다. 예: 010-1234-5678");
            e.preventDefault();
            return false;
        }
    });

});
</script>
</body>
</html>
