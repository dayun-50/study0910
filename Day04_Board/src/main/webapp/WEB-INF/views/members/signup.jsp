<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
   <title>회원 가입</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q"
            crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"
            integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f5f5f5;
    }
    .container {
      width: 400px;
      margin: 50px auto;
      padding: 30px;
      background-color: white;
      border: 1px solid #ddd;
      border-radius: 10px;
      box-shadow: 0 0 10px rgba(0,0,0,0.1);
    }
    h2 {
      text-align: center;
      color: #007bff;
      margin-bottom: 20px;
    }
    input[type="text"], input[type="password"], input[type="email"] {
      width: calc(100% - 12px);
      padding: 8px;
      margin: 5px 0 10px;
      border: 1px solid #ccc;
      border-radius: 4px;
    }
    .button-group {
      text-align: center;
      margin-top: 20px;
    }
    button {
      padding: 8px 15px;
      margin: 5px;
      border: none;
      border-radius: 4px;
      background-color: #007bff;
      color: white;
      cursor: pointer;
    }
    .small-btn {
      padding: 6px 10px;
      font-size: 0.9em;
      margin-left: 5px;
    }
    
    
  </style>
</head>
<body>
<div class="container">
    <h2>회원 가입 정보 입력</h2>
    <form action="/members/signpu" method="post">
      <label for="id">ID</label><br>
      <input type="text" id="id" name="userId" placeholder="아이디를 입력하세요">
      <button type="button" id="idcheck" class="small-btn">중복확인</button><br>

      <label for="pw">PW</label><br>
      <input type="password" id="pw" name="userPw" placeholder="비밀번호를 입력하세요"><br>

      <label for="pw_check">PW 확인</label><br>
      <input type="password" id="pw_check" name="pw_check" placeholder="비밀번호를 다시 입력하세요"><br>

      <label for="name">이름</label><br>
      <input type="text" id="name" name="userName" placeholder="이름을 입력하세요"><br>

      <label for="phone">전화번호</label><br>
      <input type="text" id="phone" name="userPhone" placeholder="전화번호를 입력하세요 (예: 010-1234-5678)"><br>

      <label for="email">이메일</label><br>
      <input type="email" id="email" name="userEmail" placeholder="이메일을 입력하세요"><br>

       <div class="row input">
            <div class="col col-2 form-label">우편번호</div>
            <div class="col col-8">
                <input type="text" class="form-control readonly-disabled" name="userZip" placeholder="우편번호" readonly>
            </div>
            <div class="col col-2">
                <input type="button" class="btn btn-primary" onclick="searchPostcode()" value="찾기">
            </div>
        </div>
        <div class="row input">
            <div class="col col-2 form-label">주소</div>
            <div class="col col-10">
                <input type="text" class="form-control readonly-disabled" name="userAddress1" placeholder="주소" readonly>
            </div>
        </div>
        <div class="row input">
            <div class="col col-2 form-label">상세주소</div>
            <div class="col col-10">
                <input type="text" class="form-control" name="userAddress2" placeholder="상세주소를 입력하세요.">
            </div>
        </div>
      <div class="button-group">
        <button type="submit">회원가입</button>
        <button type="reset">다시입력</button>
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

    let idRegex = /^[a-z\d_]{4,12}$/;
    let passwordRegex = /([^\w\s])|([a-zA-Z])|(\d)/g;
    let nameRegex = /^[가-힣]{2,6}$/;
    let phoneRegex = /^010(-?\d{4}){2}$/;
    let emailRegex = /^.+@.+(\.com|\.co\.kr)$/;

    $("[name = userId]").on("keypress", function () {
        $("#checkIdDupl").css("display", "flex");
        setIdDupl(false);
    });

    $("[name = pwCheck]").on("keyup", function () {
        checkPassword();
    });

    $("[name = userPw]").on("keyup", function () {
        checkPassword();
    });

    $("[name = pwCheck], [name = userPw]").on("focus", function () {
        document.addEventListener('keydown', handleSpacebar);
    });

    $("[name = pwCheck], [name = userPw]").on("blur", function () {
        document.removeEventListener('keydown', handleSpacebar);
    });

    function handleSpacebar(event) {
        if (event.key === ' ' || event.keyCode === 32) {
            event.preventDefault();
        }
    }

    function checkPassword() {
        let passwordVal = $("[name = userPw]").val();
        let passwordCheckVal = $("[name = pwCheck]").val();

        if (passwordVal) {
            let temp;
            let tempFlag = [undefined, undefined, undefined];

            while ((temp = passwordRegex.exec(passwordVal)) != null) {
                for (let i = 1; i < temp.length; i++) {
                    if (!tempFlag[i]) {
                        tempFlag[i] = temp[i];
                    }
                }
            }

            if (tempFlag[1] && tempFlag[2] && tempFlag[3]) {
                $("#passwordRule").css("display", "none");
            } else {
                $("#passwordRule").css("display", "block");
                $("#passwordDuplicate").css("display", "none");
                return false;
            }
        }

        if (passwordVal && passwordCheckVal) {
            if (passwordVal != passwordCheckVal) {
                $("#passwordRule").css("display", "none");
                $("#passwordDuplicate").css("display", "block");
                return false;
            } else {
                $("#passwordDuplicate").css("display", "none");
            }
        }

        if (!passwordVal && !passwordCheckVal) {
            $("#passwordRule").css("display", "none");
            $("#passwordDuplicate").css("display", "none");
            return false;
        }
        return true;
    }

    let checkIdDupl = false;

    function setIdDupl(val) {
        checkIdDupl = val;
    }
    
   $("#registerFrm").on("submit", function checkValidation() {
        if (idRegex.test($("[name = userId]").val()) &&
            checkPassword() &&
            /* checkIdDupl && */
            nameRegex.test($("[name = userName]").val()) &&
            emailRegex.test($("[name = userEmail]").val()) &&
            phoneRegex.test($("[name = userPhone]").val())) {
            return true;
        } else {
            alert("입력 정보를 다시 확인해주세요.");
            return false;
        }
    }); 
   
   $("#idcheck").on("click",()=>{ //id중복체크
	   $.ajax({
		   type: "POST",
		   url:"/members/idcheck",
		   data:{id : $("#id").val()}
	   }).done((resp)=>{
		   if(resp > 0){
			   alert("중복된 ID");
		   }else{
			   alert("사용 가능 ID");
		   }
		   
	   })
   });
</script>
</body>
</html>
