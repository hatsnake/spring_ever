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

  <!-- =======================================================
  * Template Name: NiceAdmin - v2.2.1
  * Template URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
  <style>
    .your-label {
      font-weight: bold;
    }

    .your-input {
      padding: 10px;
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
  </style>
  
  <script type="text/javascript">
  	$(document).ready(function() {
		mbirthFunc();
  	})
  	
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
                <a href="index.html" class="logo d-flex align-items-center w-auto">
                  <img src="assets/img/logo.png" alt="">
                  <span class="d-none d-lg-block">NiceAdmin</span>
                </a>
              </div><!-- End Logo -->

              <div class="card mb-3">

                <div class="card-body" style="margin: 50px 0 30px 0;">

                  <form id="registerForm" action="/member/register" method="post" class="row g-3 needs-validation" novalidate>
                    
                    <div class="input-group col-12">
                      <label for="yourId" class="form-label your-label">아이디</label>
                      <div class="input-group">
                        <input type="text" name="mid" class="form-control your-input" 
                              id="yourId" aria-describedby="basic-addon2" required>
                        <span class="input-group-text" id="basic-addon2">@naver.com</span>
                      </div>
                      <div class="invalid-feedback">Please, enter your name!</div>
                    </div>
                    <div class="col-12">
                      <label for="yourPassword" class="form-label your-label">비밀번호</label>
                      <input type="password" name="mpassword" class="form-control your-input" id="yourPassword" required>
                      <div class="invalid-feedback">Please, enter your name!</div>
                    </div>

                    <div class="col-12">
                      <label for="yourRePassword" class="form-label your-label">비밀번호 재확인</label>
                      <input type="password" class="form-control your-input" id="yourRePassword" required>
                      <div class="invalid-feedback">Please, enter your name!</div>
                    </div>

                    <div class="col-12">
                      <label for="yourName" class="form-label your-label">이름</label>
                      <input type="text" name="mname" class="form-control your-input" id="yourName" required>
                      <div class="invalid-feedback">Please enter a valid Email adddress!</div>
                    </div>

                    <div class="col-12">
                      <label for="yourNickName" class="form-label your-label">별명</label>
                      <input type="text" name="mnickname" class="form-control your-input" id="yourNickname" required>
                      <div class="invalid-feedback">Please enter a valid Email adddress!</div>
                    </div>

                     <div class="col-12">
                      <label for="yourBirth" class="form-label your-label">생년월일</label>
                      <div class="input-group has-validation">
                        <input type="date" name="mbirth" class="form-control your-input" id="yourBirth" required>
                        <div class="invalid-feedback">Please choose a username.</div>
                      </div>
                    </div> 

                    <div class="col-12">
                      <label for="yourGender" class="form-label your-label">성별</label>
                      <select id="yourGender" name="mgender" class="form-select your-input" aria-label="Default select example">
                        <option selected>성별</option>
                        <option value="01">남자</option>
                        <option value="02">여자</option>
                        <option value="03">선택 안함</option>
                      </select>
                      <div class="invalid-feedback">Please enter your password!</div>
                    </div>

                    <div class="col-12">
                      <label for="yourEmail" class="form-label your-label">본인 확인 이메일</label>
                      <input type="text" name="memail" class="form-control your-input" 
                             placeholder="선택입력" id="yourEmail" required>
                      <div class="invalid-feedback">Please enter your password!</div>
                    </div>

                    <div class="row g-2" style="margin-left:1px;">
                      <label for="yourPhone" class="form-label your-label">휴대전화</label>
                      <div class="col-8">
                        <input type="text" name="mphone" class="form-control your-input" 
                               placeholder="전화번호 입력" id="yourPhone" required>
                      </div>
                      <div class="col-auto" style="margin-right:0px;">
                        <div class="btn btn-primary your-input">인증번호 받기</button>
                      </div>

                      <div class="invalid-feedback">Please enter your password!</div>
                    </div>

                    <div class="col-12 mt-4">
                      <button class="btn btn-primary w-100 btn-submit" type="submit">가입하기</button>
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