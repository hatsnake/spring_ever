<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Users / Profile - NiceAdmin Bootstrap Template</title>
  <meta content="" name="description">
  <meta content="" name="keywords">
  
  <script src="http://code.jquery.com/jquery-latest.min.js"></script>
  <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>

	<style>
		.counter-box {
		    display: block;
		    background: #f6f6f6;
		    padding: 40px 20px 37px;
		    text-align: center
		}
		
		.counter-box p {
		    margin: 5px 0 0;
		    padding: 0;
		    color: #909090;
		    font-size: 18px;
		    font-weight: 500
		}
		
		.counter-box i {
		    font-size: 60px;
		    margin: 0 0 15px;
		    color: #d2d2d2
		}
		
		.counter {
		    display: block;
		    font-size: 32px;
		    font-weight: 700;
		    color: #666;
		    line-height: 28px
		}
		
		.counter-box.colored {
		    background: #3acf87
		}
		
		.counter-box.colored p,
		.counter-box.colored i,
		.counter-box.colored .counter {
		    color: #fff
		}  
	</style>
</head>

<body>

<c:import url="/header"></c:import>
<c:import url="/sidebar"></c:import>

<main id="main" class="main">

    <div class="pagetitle" style="width:760px; margin:0 auto;">
      <h1>Profile</h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="index.html">Home</a></li>
          <li class="breadcrumb-item">Users</li>
          <li class="breadcrumb-item active">Profile</li>
        </ol>
      </nav>
    </div><!-- End Page Title -->

    <section class="section profile" style="width:760px; margin:0 auto;">
      <div class="row">
        <div class="col-xl-12">

          <div class="card">
            <div class="card-body profile-card pt-4 d-flex flex-column align-items-center">

              <img src="/assets/img/profile-img.jpg" alt="Profile" class="rounded-circle">
              <h2>Kevin Anderson</h2>
              <h3>Web Designer</h3>
              <div class="social-links mt-2">
                <a href="#" class="twitter"><i class="bi bi-twitter"></i></a>
                <a href="#" class="facebook"><i class="bi bi-facebook"></i></a>
                <a href="#" class="instagram"><i class="bi bi-instagram"></i></a>
                <a href="#" class="linkedin"><i class="bi bi-linkedin"></i></a>
              </div>
            </div>
          </div>

        </div>

        <div class="col-xl-12">

          <div class="card">
            <div class="card-body pt-3">
              <!-- Bordered Tabs -->
              <ul class="nav nav-tabs nav-tabs-bordered">

                <li class="nav-item">
                  <a href="/member/profile">
                  	<button class="nav-link active" data-bs-toggle="tab" data-bs-target="#profile-overview">프로필정보</button>
                  </a>
                </li>

                <li class="nav-item">
                  <a href="/member/update">
                  	<button class="nav-link" data-bs-toggle="tab" data-bs-target="#profile-edit">프로필수정</button>
                  </a>
                </li>

                <li class="nav-item">
                  <a href="/member/setting">
                  	<button class="nav-link" data-bs-toggle="tab" data-bs-target="#profile-settings">설정</button>
                  </a>
                </li>

                <li class="nav-item">
                  <a href="/member/changePassword">
                  	<button class="nav-link" data-bs-toggle="tab" data-bs-target="#profile-change-password">비밀번호변경</button>
                  </a>
                </li>

              </ul>
              <div class="tab-content pt-2">

                <div class="tab-pane fade show active profile-overview" id="profile-overview">
                
                  <div class="row">
			        <div class="four col-md-4 mt-3">
			            <div class="counter-box colored">
			            	<span class="counter">${m.mvisitedcount}</span>
			                <p>방문수</p>
			            </div>
			        </div>
			        <div class="four col-md-4 mt-3">
			            <div class="counter-box">
			            	<span class="counter">${m.mcommentcount}</span>
			                <p>댓글수</p>
			            </div>
			        </div>
			        <div class="four col-md-4 mt-3">
			            <div class="counter-box">
			            	<span class="counter">${m.mboardcount}</span>
			                <p>게시글수</p>
			            </div>
			        </div>
			      </div>
                  
                  <h3 class="card-title">프로필</h3>

                  <div class="row">
                    <div class="col-lg-3 col-md-2 label ">별명(아이디)</div>
                    <div class="col-lg-9 col-md-10">${m.mnickname} (${m.mid})</div>
                  </div>

                  <div class="row">
                    <div class="col-lg-3 col-md-2 label ">이름</div>
                    <div class="col-lg-9 col-md-10">${m.mname}</div>
                  </div>

                  <div class="row">
                    <div class="col-lg-3 col-md-2 label">생년월일</div>
                    <div class="col-lg-9 col-md-10"><fmt:formatDate value="${m.mbirth}" pattern="yyyy-MM-dd" /></div>
                  </div>

                  <div class="row">
                    <div class="col-lg-3 col-md-2 label">성별</div>
                    <div class="col-lg-9 col-md-10">${m.mgender}</div>
                  </div>

                  <div class="row">
                    <div class="col-lg-3 col-md-2 label">이메일</div>
                    <div class="col-lg-9 col-md-10">${m.memail}</div>
                  </div>

                  <div class="row">
                    <div class="col-lg-3 col-md-2 label">전화번호</div>
                    <div class="col-lg-9 col-md-10">${m.mphone}</div>
                  </div>

                  <div class="row">
                    <div class="col-lg-3 col-md-2 label">주소</div>
                    <div class="col-lg-9 col-md-10">(${m.mzip}) ${m.maddr1} ${m.maddr2}</div>
                  </div>

                  <div class="row">
                    <div class="col-lg-3 col-md-2 label">회원등급</div>
                    <div class="col-lg-9 col-md-10">${m.mauthname}</div>
                  </div>

                </div>

              </div><!-- End Bordered Tabs -->

            </div>
          </div>

        </div>
      </div>
    </section>

</main><!-- End #main -->

<c:import url="/footer"></c:import>

</body>

</html>