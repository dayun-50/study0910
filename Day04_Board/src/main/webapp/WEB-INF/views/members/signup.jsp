<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q"
            crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"
            integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<title>Signup</title>
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

input[type="text"], input[type="password"], input[type="email"], input[type="tel"]
	{
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

#postcodeBtn{
	padding: 8px 15px;
	font-size: 14px;
	background-color: Darkgreen;
	color: white;
	border: none;
	border-radius: 8px;
	cursor: pointer;
	transition: 0.3s;

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
	box-shadow: 0 0 8px 3px rgba(255, 165, 0, 0.6);
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
    <form id="registerForm" action="/members/signup" method="post" accept-charset="UTF-8">
        <h4>회원 가입 정보 입력</h4>

        <div class="row">
            <input type="text" placeholder="아이디를 입력해주세요" name="userId">
            <button type="button" id="idcheck">중복확인</button>
        </div>
        <span id="idcheckMsg" style="display:block; margin-left:10px; color:green; font-weight:bold;"></span>

        <input type="password" placeholder="비밀번호를 입력해주세요" name="userPw">
        <input type="password" placeholder="비밀번호를 다시 입력해주세요" name="pw_check">
        <input type="text" placeholder="이름을 입력해주세요" name="userName">
        <input type="tel" placeholder="전화번호를 입력해주세요 (예: 01012345678)" name="userPhone">
        <input type="email" placeholder="이메일을 입력해주세요" name="userEmail">

        <div class="row input">
            <div class="col col-8">
                <input type="text" class="form-control readonly-disabled" name="userZip" placeholder="우편번호" readonly>
            </div>
            <div class="col col-2">
                <input type="button" id="postcodeBtn" class="btn btn-primary" onclick="searchPostcode()" value="찾기">
            </div>
        </div>
        <div class="row input">
            <div class="col col-10">
                <input type="text" class="form-control readonly-disabled" name="userAddress1" placeholder="주소" readonly>
            </div>
        </div>
        <div class="row input">
            <div class="col col-10">
                <input type="text" class="form-control" name="userAddress2" placeholder="상세주소를 입력하세요.">
            </div>
        </div>

        <div class="click">
            <button type="submit">회원가입</button>
            <button type="reset" id="back">뒤로가기</button>
        </div>
    </form>
</div>
<script>
function searchPostcode() {
    new daum.Postcode({
        oncomplete: function (data) {
            $("[name = 'userZip']").val(data.zonecode);
            $("[name = 'userAddress1']").val(data.address);
        }
    }).open()
}

function beforeSubmit() {
    $("[name = userAddress1]").removeAttr("disabled");
    $("[name = userZip]").removeAttr("disabled");
}

$("#back").on("click", ()=>{
	window.location.href = "/page/home";
});
</script>
</body>
</html>