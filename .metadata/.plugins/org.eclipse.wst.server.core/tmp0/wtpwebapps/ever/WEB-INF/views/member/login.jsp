<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Pages / Login - NiceAdmin Bootstrap Template</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="/assets/img/favicon.png" rel="icon">
  <link href="/assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.gstatic.com" rel="preconnect">
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>

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

  <!-- =======================================================
  * Template Name: NiceAdmin - v2.2.1
  * Template URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
  <style>
    .find-info {
	    list-style-type: none;
	    margin: 0;
	    padding: 0;
    }

    .find-info li {
	    margin: 0 0 0 0;
	    padding: 0 0 0 0;
	    border: 0;
	    float: left;
    }

    .find-info li:after {
	    content: '???';
	    padding-left: 5px;
	    padding-right: 7px;
	    color: rgb(220 220 220);
    }

    .find-info li:last-child:after {
	    content: "";
    }

    #yourUsername {
		padding: 12px;  
    }

    #yourPassword {
		padding: 12px;
    }

    #loginBtn {
		padding: 12px;
		font-size: 23px;
		font-weight: 400;
    }

    .your-input {
		border: 1px solid #ced4da;
		border-left:0px;      
    }

    .your-input:focus {
		box-shadow: none;
		outline: none;
		border: 1px solid #ced4da;
		border-left:0px;     
    }

    .input-group-text {
		border-right:0px; 
		background:white;
    }
    
    .link-text {
    	text-decoration:none; 
    	color:#888;
    }

  </style>
</head>

<body>

  <main>
    <div class="container">

      <section class="section register min-vh-100 d-flex flex-column align-items-center justify-content-center py-4">
        <div class="container">
          <div class="row justify-content-center">
            <div class="col-xl-4 col-lg-5 col-md-7 col-sm-10 d-flex flex-column align-items-center justify-content-center">

              <div class="d-flex justify-content-center py-4">
                <a href="/" class="logo d-flex align-items-center w-auto">
                  <div style="font-weight:bold; font-size:50px; color:#23cb1a;">EVER</div>
                </a>
              </div><!-- End Logo -->

              <div class="card mb-3" style="border: 1px solid #b7b2b2; box-shadow:none !important;">

                <div class="card-body" style="margin:60px 0 30px 0;">

                  <form name="loginForm" action="/member/login" method="post" class="row g-3 needs-validation" novalidate>

                    <div class="col-12">
                      <div class="input-group has-validation">
                        <span class="input-group-text" id="basic-addon2">
                          <i class="fas fa-user"></i>
                        </span>
                        <input type="text" name="mid" class="form-control your-input" 
                               placeholder="?????????" id="yourUsername" required>
                        <div class="invalid-feedback">Please enter your username.</div>
                      </div>
                    </div>

                    <div class="col-12" style="margin-top:1px;">
                      <div class="input-group has-validation">
                        <span class="input-group-text" id="basic-addon2">
                          <i class="fas fa-unlock"></i>
                        </span>
                        <input type="password" name="mpassword" class="form-control your-input" 
                              placeholder="????????????" id="yourPassword" required>
                        <div class="invalid-feedback">Please enter your password!</div>
                      </div>
                    </div>

					<!--  
                    <div class="col-12">
                      <div class="form-check">
                        <input class="form-check-input" type="checkbox" name="remember" value="true" id="rememberMe">
                        <label class="form-check-label" for="rememberMe">????????? ?????? ??????</label>
                      </div>
                    </div>
                    -->
                    
                    <c:if test="${msg == false}">
                    	<p style="color:red;">????????? ??????! ???????????? ???????????? ??????????????????!</p>
                    </c:if>
                    
                    <div class="col-12 mt-4">
                      <button id="loginBtn" class="btn btn-primary w-100" type="submit">?????????</button>
                    </div>
                  </form>

                </div>
              </div>

              <div class="credits">
                <ul class="find-info">
                  <li>
                  	<a class="link-text" href="/member/register">???????????? ??????</a>
                  </li>
                  <li>
                  	<a class="link-text" href="/member/register">????????? ??????</a>
                  </li>
                  <li>
                  	<a class="link-text" href="/member/register">????????????</a>
                  </li>
                </ul>
              </div>

            </div>
          </div>
        </div>

      </section>

    </div>
  </main><!-- End #main -->

  <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

</body>

</html>