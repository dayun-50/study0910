<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home Page</title>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <style>
        .container {
            max-width: 500px;
            margin: 100px auto;
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
        input[type="text"], input[type="password"] {
            width: 100%;
            margin: 15px 0;
            font-size: 20px;
            border-radius:5px;
            border:none;
            border-bottom:1px solid green;
            outline: none;
        }
        button {
            width: 30%;
            padding: 10px;
            font-size: 16px;
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
            box-shadow: 0 0 10px 5px rgba(255,165,0,0.7);
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
        .row{
            display: flex;
            justify-content: center; 
            gap: 10px;               
            margin-top: 15px;
        }
        div.row a { 
            font-size: 12px;
            border:none;
            text-decoration: none;     
        }
        .error {
            color:red;
            text-align:center;
            margin-top:10px;
            font-weight:bold;
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
		<form action="/members/login" method="post">
			<img src="/img/a.png"
				style="width: 100px; height: 100px; margin-left: 200px;">
			<h4>어서와 지겨운 보드란다?</h4>
			<input type="text" placeholder="아이디를 입력해주세요" name="userId"> <input
				type="password" placeholder="비밀번호를 입력해주세요" name="userPw">

			<div class="click">
				<button type="submit">로그인</button>
				<button type="button" id="signup">회원가입</button>
			</div>
		</form>
		<div class="row">
			<a href="" class="findid">아이디 찾기</a>/ <a href="" class="findpw">비밀번호
				찾기</a>
		</div>
	</div>

	<script>
		//회원가입 페이지이동
		$("#signup").on("click", ()=>{
			window.location.href = "/page/signup";
		});
		
	</script>
</body>
</html>