<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Pages / Register - NiceAdmin Bootstrap Template</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="/assets/img/favicon.png" rel="icon">
  <link href="/assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.gstatic.com" rel="preconnect">
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="/assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="/assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="/assets/vendor/quill/quill.snow.css" rel="stylesheet">
  <link href="/assets/vendor/quill/quill.bubble.css" rel="stylesheet">
  <link href="/assets/vendor/remixicon/remixicon.css" rel="stylesheet">
  <link href="/assets/vendor/simple-datatables/style.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="/assets/css/style.css" rel="stylesheet">

  <!-- Vendor JS Files -->
  <script src="/assets/vendor/apexcharts/apexcharts.min.js"></script>
  <script src="/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="/assets/vendor/chart.js/chart.min.js"></script>
  <script src="/assets/vendor/echarts/echarts.min.js"></script>
  <script src="/assets/vendor/quill/quill.min.js"></script>
  <script src="/assets/vendor/simple-datatables/simple-datatables.js"></script>
  <script src="/assets/vendor/tinymce/tinymce.min.js"></script>
  <script src="/assets/vendor/php-email-form/validate.js"></script>

  <!-- Template Main JS File -->
  <script src="/assets/js/main.js"></script>
  <script src="http://code.jquery.com/jquery-latest.min.js"></script>

  <style>
    .your-label {
    	font-weight: bold;
    }

    .your-input {
    	padding: 8px;
    	border-radius: 0px;
    }

    .your-input:focus {
    	box-shadow: none;
    	outline: none;
    	border: 1px solid #ced4da;
    }

    #basic-addon2 {
    	border-left:0px; 
    	background:white;
    }

    #yourId {
    	border-right:0px;
    }

    #yourId:focus {
    	border-right:0px;
    }
    
    .btn-submit {
    	padding: 12px;
    }
    
    .fs-13 {
    	font-size: 13px;
    }
  </style>
  
  <script type="text/javascript">
  	$(document).ready(function() {
		mbirthFunc();
		
		let idValid = false;
		let passwordValid = false;
		let rePasswordValid = false;
		let nameValid = false;
		let nicknameValid = false;
		let birthValid = false;
		let genderValid = false;
		let emailValid = false;
		let phoneValid = false;
		let phoneConfirmValid = false;
		
		let code2 = "";
		
	  	$("#phoneBtn").on("click", function() {
			let phone = $("#yourPhone").val();

			if(phone == "") {
	  			$("#yourPhoneMsg").text("필수 정보입니다.");
	  			$("#yourPhoneMsg").css("color", "red");
	  			return false;
	  		}

	  		alert("인증번호를 발송하였습니다.\n휴대폰에서 인증번호를 확인해주세요.");
			console.log("폰번호 : " + phone);
			
			$.ajax({
				type: "get",
				data: {
					phone: phone
				},
				url:"/phoneCheck",
				cache: false,
				success: function(data) {
					if(data == "error") {
						alert("휴대폰 번호가 올바르지 않습니다.\n번호만 입력해주세요.");
						$("#yourPhoneConfirmMsg").text("유효한 번호를 입력해주세요.");
						$("#yourPhoneConfirmMsg").css("color", "red");
						$("#yourPhone").attr("autofocus", true);
					} else {
						$("#yourPhoneConfirm").attr("disabled", false);
						$("#yourPhoneConfirmMsg").text("인증번호를 입력한 뒤 본인인증을 눌러주세요.");
						$("#yourPhoneConfirmMsg").css("color", "#08a600");
						$("#yourPhone").attr("readonly", true);
						code2 = data;
					}
				}
			});
	  	});
		
		$("#yourPhoneConfirm").on("input", function() {
			console.log($("#yourPhoneConfirm").val() == code2);
			console.log($("#yourPhoneConfirm").val());
			console.log(code2);
			if($("#yourPhoneConfirm").val() == code2) {
				$("#yourPhoneConfirmMsg").text("인증번호가 일치합니다.");
				$("#yourPhoneConfirmMsg").css("color", "#08a600");
				$("#yourPhoneConfirm").attr("disabled", true);
				phoneConfirmValid = true;
				return;
			} else {
				$("#yourPhoneConfirmMsg").text("인증번호가 일치하지 않습니다. 확인해주시기 바랍니다.");
				$("#yourPhoneConfirmMsg").css("color", "red");
				$(this).attr("autofocus", true);
				phoneConfirmValid = false;
				return;
			}
			
			phoneConfirmValid = false;
		})
		
		$("#yourId").on("blur", function() {
			const yourIdVal = $("#yourId").val();
			idValid = idCheck(yourIdVal);
			
			scrollChange($("#yourId"), idValid);
		});
		
		$("#yourPassword").on("blur", function() {
			const yourPasswordVal = $("#yourPassword").val();
			passwordValid = passwordCheck(yourPasswordVal);
			
			scrollChange($("#yourPassword"), passwordValid);
		});
		
		$("#yourRePassword").on("blur", function() {
			const yourRePasswordVal = $("#yourRePassword").val();
			const yourPasswordVal = $("#yourPassword").val();
			rePasswordValid = passwordReCheck(yourRePasswordVal, yourPasswordVal);
			
			scrollChange($("#yourRePassword"), rePasswordValid);		
		});
		
		$("#yourName").on("blur", function() {
			const yourNameVal = $("#yourName").val();
			nameValid = nameCheck(yourNameVal);
			
			scrollChange($("#yourName"), nameValid);	
		});
		
		$("#yourNickname").on("blur", function() {
			const yourNicknameVal = $("#yourNickname").val();
			nicknameValid = nicknameCheck(yourNicknameVal);
			
			scrollChange($("#yourNickname"), nicknameValid);	
		});
		
		$("#yourBirth").on("blur", function() {
			const yourBirthVal = $("#yourBirth").val();
			birthValid = birthCheck(yourBirthVal);
		
			scrollChange($("#yourBirth"), birthValid);		
		});
		
		$("#yourGender").on("blur", function() {
			const yourGenderVal = $("#yourGender").val();
			genderValid = genderCheck(yourGenderVal);
			
			scrollChange($("#yourGender"), genderValid);	
		});

		$("#yourEmail").on("blur", function() {
			const yourEmailVal = $("#yourEmail").val();
			emailValid = emailCheck(yourEmailVal);
			
			scrollChange($("#yourEmail"), emailValid);	
		});		

		/*
		$("#yourPhone").on("blur", function() {
			const yourPhoneVal = $("#yourPhone").val();
			phoneValid = phoneCheck(yourPhoneVal);		
			
			scrollChange($("#yourPhone"), phoneValid);	
		});
		*/
		
		$("#btn-submit").on("click", function() {
			if(!idValid) {
				// 아이디 체크
				console.log("idValid");
				const yourIdVal = $("#yourId").val();
				idValid = idCheck(yourIdVal);
				scrollChange($("#yourId"), idValid);	
				return;
			} else if(!passwordValid) {
				// 비밀번호 체크
				console.log("passwordValid");
				const yourPasswordVal = $("#yourPassword").val();
				passwordValid = passwordCheck(yourPasswordVal);
				scrollChange($("#yourPassword"), passwordValid);
				return;
			} else if(!rePasswordValid) {	
				// 비밀번호 재확인 체크
				console.log("rePasswordValid");
				const yourPasswordVal = $("#yourPassword").val();
				const yourRePasswordVal = $("#yourRePassword").val();
				rePasswordValid = passwordReCheck(yourRePasswordVal, yourPasswordVal);
				scrollChange($("#yourRePassword"), rePasswordValid);	
				return;
			} else if(!nameValid) {
				// 이름 체크
				console.log("nameValid");
				const yourNameVal = $("#yourName").val();
				nameValid = nameCheck(yourNameVal);
				scrollChange($("#yourName"), nameValid);
				return;
			} else if(!nicknameValid) {
				// 별명 체크
				console.log("nicknameValid");
				const yourNicknameVal = $("#yourNickname").val();
				nicknameValid = nicknameCheck(yourNicknameVal);
				scrollChange($("#yourNickname"), nicknameValid);
				return;
			} else if(!birthValid) {
				// 생일 체크
				console.log("birthValid");
				const yourBirthVal = $("#yourBirth").val();
				birthValid = birthCheck(yourBirthVal);
				scrollChange($("#yourBirth"), birthValid);	
				return;
			} else if(!genderValid) {
				// 성별 체크
				console.log("genderValid");
				const yourGenderVal = $("#yourGender").val();
				genderValid = genderCheck(yourGenderVal);
				scrollChange($("#yourGender"), genderValid);
				return;
			} else if(!emailValid) {
				// 이메일 체크
				console.log("emailValid");
				const yourEmailVal = $("#yourEmail").val();
				emailValid = emailCheck(yourEmailVal);
				scrollChange($("#yourEmail"), emailValid);	
				return;
			} else if(!phoneConfirmValid) {
				// 전화번호 체크
				if($("#yourPhone").val == "") {
					$("#yourPhoneMsg").text("필수 수정입니다.");
					$("#yourPhoneMsg").css("color", "red");
				}
				
				console.log("z : " + phoneConfirmValid);
				
				$("#yourPhoneConfirmMsg").text("인증번호가 일치하지 않습니다. 확인해주시기 바랍니다.");
				$("#yourPhoneConfirmMsg").css("color", "red");
				
				scrollChange($("#yourPhone"), false);
				return;
			} else {
				const registerForm = $("#registerForm");
				registerForm.attr("action", "/member/register");
				registerForm.attr("method", "post");
				registerForm.submit();
			}
		});
		
  	});
  	
  	function scrollChange(tag, valid) {		
		if(!valid) {
			let offset = tag.offset();
			let winH = $(window).height();
			$("html").animate({scrollTop: (offset.top - winH/2)}, 200);
		}
  	}
  	
  	/*
  	function phoneCheck(val) {
  		if(val == "") {
  			$("#yourPhoneMsg").text("필수 정보입니다.");
  			$("#yourPhoneMsg").css("color", "red");
  			return false;
  		}
  		
  		return true;
  	}
  	*/
  	
  	function emailCheck(val) {
  		const regExp = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
  		
  		if(val == "") {
  			$("#yourEmailMsg").text("");
  			return true;
  		}
  		
		if(!regExp.test(val)) {
			$("#yourEmailMsg").text("이메일 주소를 다시 확인해주세요.");
			$("#yourEmailMsg").css("color", "red");
			return false;				
		}
		
		$("#yourEmailMsg").text("");
		return true;		
  	}
  	
  	function genderCheck(val) {
  		if(val == "00") {
			$("#yourGenderMsg").text("필수 정보입니다.");
			$("#yourGenderMsg").css("color", "red");
			return false; 	  			
  		}
  		
		$("#yourGenderMsg").text("");
		return true;
  	}
  	
  	function birthCheck(val) {
  		if(val == "") {
			$("#yourBirthMsg").text("필수 정보입니다.");
			$("#yourBirthMsg").css("color", "red");
			return false; 	  			
  		}
  		
		$("#yourBirthMsg").text("");
		return true;  		
  	}
  	
  	function nicknameCheck(val) {
  		const regExp = /^[a-zA-Z0-9가-힣][a-zA-Z0-9가-힣]{1,19}$/g;
  		let nicknameReturn = false;
  		
  		if(val == "") {
			$("#yourNicknameMsg").text("필수 정보입니다.");
			$("#yourNicknameMsg").css("color", "red");
			return false; 	  			
  		}
  		
		if(!regExp.test(val)) {
			$("#yourNicknameMsg").text("2~20자의 영문 대 소문자 한글, 숫자만 사용 가능합니다.");
			$("#yourNicknameMsg").css("color", "red");
			return false;				
		}
		
		$.ajax({
			url: "/member/nicknameCheck",
			method: "get",
			async: false,
			data: {
				mnickname : val
			},
			success: function(result) {
				if(result) {
					$("#yourNicknameMsg").text("사용 가능한 별명입니다.");
					$("#yourNicknameMsg").css("color", "#08a600");
					nicknameReturn = true;
				} else {	
					$("#yourNicknameMsg").text("이미 사용중입니다. 다른 별명을 입력해주세요.");
					$("#yourNicknameMsg").css("color", "red");
					nicknameReturn = false;
				}
			}
		});
		
		return nicknameReturn;
  	}
  	
  	function nameCheck(val) {
  		const regExp = /^[a-zA-Z0-9가-힣][a-zA-Z0-9가-힣]{0,39}$/g;
  		
  		if(val == "") {
			$("#yourNameMsg").text("필수 정보입니다.");
			$("#yourNameMsg").css("color", "red");
			return false; 	  			
  		}
  		
		if(!regExp.test(val)) {
			console.log(regExp.test(val));
			$("#yourNameMsg").text("한글과 영문 대 소문자를 사용하세요. (특수기호, 공백 사용 불가)");
			$("#yourNameMsg").css("color", "red");
			return false;				
		}
		
		$("#yourNameMsg").text("");
		return true;  		
  	}
  	
  	function passwordReCheck(yourPasswordVal, yourRePasswordVal) {
  		if(yourRePasswordVal == "") {
			$("#yourRePasswordMsg").text("필수 정보입니다.");
			$("#yourRePasswordMsg").css("color", "red");
			return false; 			
  		}
  		
  		if(yourPasswordVal != yourRePasswordVal) {
			$("#yourRePasswordMsg").text("비밀번호가 일치하지 않습니다.");
			$("#yourRePasswordMsg").css("color", "red");
			return false; 			 			
  		}
  		
		$("#yourRePasswordMsg").text("");
		return true;
  	}
  	
  	
  	function passwordCheck(val) {
  		const regExp = /^[a-zA-Z0-9\{\}\[\]\/?.,;:|\)*~`!^\-_+<>@\#$%&\\\=\(\'\"]{8,16}$/g;
		//const regExp = /(?=.*[a-zA-Z0-9])(?=.*?[#?!@$%^&*-]).{8,16}/;
		
		if(val == "") {
			$("#yourPasswordMsg").text("필수 정보입니다.");
			$("#yourPasswordMsg").css("color", "red");
			return false;
		}
		
		if(!regExp.test(val)) {
			console.log(regExp.test(val));
			$("#yourPasswordMsg").text("8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요");
			$("#yourPasswordMsg").css("color", "red");
			return false;				
		}
		
		$("#yourPasswordMsg").text("");
		return true;
  	}  	
  	
  	function idCheck(val) {
		const regExp = /^[a-zA-Z0-9][a-zA-Z0-9-_]{4,19}$/g;
		let idReturn = false;
		
		if(val == "") {
			$("#yourIdMsg").text("필수 정보입니다.");
			$("#yourIdMsg").css("color", "red");
			return false;
		}
		
		if(!regExp.test(val)) {
			console.log(regExp.test(val));
			$("#yourIdMsg").text("5~20자의 영문 대 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.");
			$("#yourIdMsg").css("color", "red");
			return false;				
		}
		
		$.ajax({
			url: "/member/idCheck",
			method: "get",
			async: false,
			data: {
				mid : val
			},
			success: function(result) {
				if(result) {
					$("#yourIdMsg").text("멋진 아이디네요!");
					$("#yourIdMsg").css("color", "#08a600");
					idReturn = true;
				} else {	
					$("#yourIdMsg").text("이미 사용중이거나 탈퇴한 아이디입니다.");
					$("#yourIdMsg").css("color", "red");
					idReturn = false;
				}
			}
		});
		
		return idReturn;
  	}
  	
	function mbirthFunc() {
		var dtToday = new Date();
		
		var month = dtToday.getMonth() + 1;
		var day = dtToday.getDate();
		var year = dtToday.getFullYear();
		
		if(month < 10)
		    month = '0' + month.toString();
		if(day < 10)
		    day = '0' + day.toString();
		
		var maxDate = year + '-' + month + '-' + day;    
		$('#yourBirth').attr('max', maxDate);	 		
	}
  </script>
</head>

<body>

  <main>
    <div class="container">

      <section class="section register min-vh-100 d-flex flex-column align-items-center justify-content-center py-4">
        <div class="container">
          <div class="row justify-content-center" style="width:460px; margin:0 auto;">
            <div class="d-flex flex-column align-items-center justify-content-center">

              <div class="d-flex justify-content-center py-4">
                <a href="/" class="logo d-flex align-items-center w-auto">
                  <div style="font-weight:bold; font-size:50px; color:#23cb1a;">EVER</div>
                </a>
              </div><!-- End Logo -->

              <div class="card mb-3" style="background:#f6f9ff !important; box-shadow:none;">

                <div class="card-body" style="width:412px !important; margin: 0px 0 30px 0;">

                  <form id="registerForm">
                    
                    <div class="input-group col-12">
                      <label for="yourId" class="form-label your-label">아이디</label>
                      <div class="input-group">
                        <input type="text" name="mid" class="form-control your-input" 
                              id="yourId" aria-describedby="basic-addon2" required>
                        <span class="input-group-text" id="basic-addon2">@naver.com</span>
                      </div>
                      <div id="yourIdMsg" class="mt-1 fs-13"></div>
                    </div>
                    <div class="col-12">
                      <label for="yourPassword" class="form-label your-label">비밀번호</label>
                      <input type="password" name="mpassword" class="form-control your-input" id="yourPassword" required>
                      <div id="yourPasswordMsg" class="mt-1 fs-13"></div>
                    </div>

                    <div class="col-12">
                      <label for="yourRePassword" class="form-label your-label">비밀번호 재확인</label>
                      <input type="password" class="form-control your-input" id="yourRePassword" required>
                      <div id="yourRePasswordMsg" class="mt-1 fs-13"></div>
                    </div>

                    <div class="col-12">
                      <label for="yourName" class="form-label your-label">이름</label>
                      <input type="text" name="mname" class="form-control your-input" id="yourName" required>
                      <div id="yourNameMsg" class="mt-1 fs-13"></div>
                    </div>

                    <div class="col-12">
                      <label for="yourNickname" class="form-label your-label">별명</label>
                      <input type="text" name="mnickname" class="form-control your-input" id="yourNickname" required>
                      <div id="yourNicknameMsg" class="mt-1 fs-13"></div>
                    </div>

                     <div class="col-12">
                      <label for="yourBirth" class="form-label your-label">생년월일</label>
                      <div>
                        <input type="date" name="mbirth" class="form-control your-input" id="yourBirth" required>
                      </div>
                      <div id="yourBirthMsg" class="mt-1 fs-13"></div>
                    </div> 

                    <div class="col-12">
                      <label for="yourGender" class="form-label your-label">성별</label>
                      <select id="yourGender" name="mgender" class="form-select your-input" aria-label="Default select example">
                        <option value="00" selected>성별</option>
                        <option value="01">남자</option>
                        <option value="02">여자</option>
                        <option value="03">선택 안함</option>
                      </select>
                      <div id="yourGenderMsg" class="mt-1 fs-13"></div>
                    </div>

                    <div class="col-12">
                      <label for="yourEmail" class="form-label your-label">본인 확인 이메일</label>
                      <input type="text" name="memail" class="form-control your-input" 
                             placeholder="선택입력" id="yourEmail" required>
                      <div id="yourEmailMsg" class="mt-1 fs-13"></div>
                    </div>

                    <div class="col-12">
                      <label for="yourPhone" class="form-label your-label">휴대전화</label>
                      
                      <div class="row g-2">
	                      <div class="col-8">
	                        <input type="text" name="mphone" class="form-control your-input" 
	                               placeholder="전화번호 입력" id="yourPhone" required>
	                      </div>
	                      <div id="phoneBtn" class="col-4" style="margin-right:0px;">
	                        <div class="btn btn-primary your-input">인증번호 받기</div>
	                      </div>
                      </div>
                      
                      <div class="row g2 mt-2">
                      	<div class="col-12">
                      	<input type="text" class="form-control your-input" 
                               placeholder="인증번호 입력하세요" id="yourPhoneConfirm" disabled="disabled" required>
                        </div>
                      </div>
                      
                      <div id="yourPhoneMsg" class="mt-1 fs-13"></div>
                      <div id="yourPhoneConfirmMsg" class="mt-1 fs-13"></div>
                    </div>

                               
                    <div class="col-12 mt-4">
                      <div id="btn-submit" class="btn btn-primary w-100 btn-submit">가입하기</div>
                    </div>
                  </form>

                </div>
              </div>

            </div>

          </div>
        </div>

        <div class="d-flex justify-content-center credits">
          Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
        </div>
      </section>

    </div>
  </main><!-- End #main -->

  <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

</body>

</html>