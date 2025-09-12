<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<title>마이페이지</title>
<style>
body {
	background-color: #0d0d1a;
	font-family: Arial, sans-serif;
	color: #fff;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
}

.container {
	width: 550px;
	text-align: left;
	height: 550px;
}

/* ===== 페이지 제목 ===== */
.page-title {
	font-size: 20px;
	font-weight: bold;
	color: #ff00ff;
	/* 기존 Welcome 색상 */
	text-shadow: 0 0 8px #ff00ff, 0 0 30px #ff00ff;
	/* 기존 스타일 */
	margin-top: 40px;
}

.page-title a {
	float: left;
	text-decoration: none;
	color: #ff00ff;
	text-shadow: 0 0 5px #ff00ff, 0 0 15px #ff00ff;
	margin-top: 10px;
}

h1 {
	margin-bottom: 5px;
	font-size: 50px;
	color: #ffffff;
	/* 민트 계열 */
	text-shadow: 0 0 5px #00ffff;
	margin-top: 30px;
	margin-left: 15px;
}

h4 {
	margin-top: 10px;
	margin-left: 15px;
}

.form-group {
	display: flex;
	align-items: center;
	margin-bottom: 25px;
	justify-content: center;
}

label {
	width: 120px;
	color: #00ffff;
	font-size: 18px;
	margin-top: 20px;
}

.agreement input[type="radio"] {
	transform: scale(0.5);
	/* 70% 크기로 축소 */
	margin-left: 70px;
}

.input {
	flex: 1;
	padding: 5px;
	border: none;
	border-bottom: 1px solid #00ffff;
	background: transparent;
	color: #fff;
	outline: none;
	font-size: 18px;
	width: 370px;
	height: 33px;
}

.agreement {
	margin: 15px 0;
	font-size: 12px;
	color: #aaa;
	display: flex;
	align-items: center;
	gap: 2px;
	padding-right: 40px;
}

.btn-submit {
	width: 25%;
	padding: 10px;
	margin-left: 20px;
	border: none;
	border-radius: 15px;
	background: linear-gradient(to right, #00ffff, #ff4fc6);
	color: #fff;
	font-size: 16px;
	cursor: pointer;
	display: block;
}

#btn {
	background: linear-gradient(to right, #678989, #304242);
	color: #0d0d1a;
	float: left;
	width: 25%;
	padding: 10px;
	margin-left: 150px;
	border: none;
	border-radius: 15px;
	font-size: 16px;
	cursor: pointer;
	display: block;
}

#btn2 {
	background: linear-gradient(to right, #678989, #304242);
	color: #0d0d1a;
	float: left;
	width: 25%;
	padding: 10px;
	margin-left: 150px;
	border: none;
	border-radius: 15px;
	font-size: 16px;
	cursor: pointer;
	display: block;
}
/* ====== 별, 블록 배경 ====== */
.star {
	position: fixed;
	width: 2px;
	height: 2px;
	background: white;
	border-radius: 50%;
	animation: twinkle 3s infinite ease-in-out;
	z-index: 0;
}

@
keyframes twinkle { 0%, 100% {
	opacity: 0.3;
}

50
%
{
opacity
:
1;
}
}
#btnbox {
	width: 100%;
	float: left;
}

#titlebox {
	display: flex;
	/* flex 적용 */
	flex-direction: column;
	/* 세로 정렬 */
	justify-content: center;
	/* 수직 중앙 정렬 */
	align-items: flex-start;
	/* 좌측 정렬 */
	background: linear-gradient(to right, #36ffff99, #ff4fc799);
	/* 조금 밝게 */
	height: 130px;
	border-radius: 10px 10px 0px 0px;
	padding-left: 15px;
	/* 왼쪽 여백 */
	margin-bottom: 20px;
}

#titlebox h1 {
	margin: 0;
	/* 기존 margin 제거 */
	font-size: 50px;
	color: #ffffff;
}

#titlebox h6 {
	margin: 5px 0 0 0;
	/* h1과 약간 띄우기 */
	font-size: 13px;
}
/* 테이블 스타일 */
table {
	width: 100%;
	border-collapse: collapse;
	text-align: left;
	margin-bottom: 20px;
}

th {
	padding: 10px;
	font-size: 20px;
	color: #00ffff;
	border-bottom: 1px solid #00ffff;
}

.check-btn {
	background: linear-gradient(to right, #00ffff, #ff4fc6);
	color: #fff;
	border: none;
	border-radius: 15px;
	padding: 8px 15px;
	font-size: 14px;
	cursor: pointer;
	margin-left: 10px;
	transition: 0.3s;
}

.check-btn:hover {
	filter: brightness(1.2);
}
</style>
</head>
<body>
	<div class="container">
		<div id="titlebox">
			<h1>${list[0].userName }</h1>
		</div>
		<table>
			<thead>
				<tr>
					<th>회원정보</th>
				</tr>
			</thead>
		</table>
		<form action="/members/update" method="post">
			<div class="form-group">
				<label for="id">ID</label>
				<div class="input" id="id">${list[0].userId }</div>
			</div>



			<div class="form-group">
				<label for="name">Name</label>
				<div class="input" id="name">${list[0].userName }</div>
				<div id="nametext"></div>
			</div>

			<div class="form-group">
				<label for="phone">Phone</label>
				<div class="input update" id="phone">${list[0].userPhone }</div>
				<div id="phonetext"></div>
			</div>


			<div class="form-group">
				<label for="email">E-mail</label>
				<div class="input update" id="email" contenteditable="true">${list[0].userEmail}</div>
				<div id="emailtext" style="margin-top: 5px; font-size: 12px;"></div>
			</div>

			<div class="form-group">
				<label for="zip">Zipcode</label>
				<div class="input update" id="zip">${list[0].userZip }</div>
				<div id="ziptext"></div>
			</div>
			
			<div class="form-group">
				<label for="zip">상세주소</label>
				<div class="input update" id="add1">${list[0].userAddress1 }</div>
				<div id="ziptext"></div>
			</div>
			
			<div class="form-group">
				<label for="zip">상세주소2</label>
				<div class="input update" id="add2">${list[0].userAddress2 }</div>
				<div id="ziptext"></div>
			</div>
	
			<input type="hidden" name = "userPhone" id="userPhone">
			<input type="hidden" name = "userEmail" id="userEmail">
			<input type="hidden" name = "userZip" id="userZip">
			<input type="hidden" name = "userAddress1" id="userAddress1">
			<input type="hidden" name = "userAddress2" id="userAddress2">
			
			<a href="/members/main">뒤로가기</a>
			
			<div id="btnbox">
				<div class="form-group" id="original">
					<button type="button" class="btn-submit" id="btnup">정보수정</button>
				</div>

				<div class="form-group" id="change">
					<button type="button" id="btn2">수정취소</button>
					<button type="submit" class="btn-submit" id="btnup2">수정완료</button>
				</div>

			</div>
		</form>
	</div>

	<script>
		$("#change").hide();
        
		
		// 별 생성
        for (let i = 0; i < 200; i++) {
            const s = document.createElement('div'); s.className = 'star';
            s.style.top = Math.random() * 100 + 'vh';
            s.style.left = Math.random() * 100 + 'vw';
            s.style.animationDuration = (2 + Math.random() * 3) + 's';
            document.body.appendChild(s);
        }
	
        $("#btnup").on("click", function () { //정보수정 버튼 클릭시
        	$("#original").hide();
        	$("#change").show();
        	
        	$("#phone, #email, #zip, #add1, #add2").attr("contenteditable", true).css({"background":"rgba(240, 255, 255, 0.208)"});
        });
   	
        $("#btnup2").on("click", ()=>{ //수정 완료 버튼클릭시 히든에 넣기
        	$("#userPhone").val($("#phone").html());
        	$("#userEmail").val($("#email").html());
        	$("#userZip").val($("#zip").html());
        	$("#userAddress1").val($("#add1").html());
        	$("#userAddress2").val($("#add2").html());
        });
        
        $("#btn2").on("click", function(){ //수정 취소시 페이지 재로딩으로 다시 원본내용 나오도록함
        	window.location.href = "/members/mypage";
        });
		
       

    </script>
</body>
</html>