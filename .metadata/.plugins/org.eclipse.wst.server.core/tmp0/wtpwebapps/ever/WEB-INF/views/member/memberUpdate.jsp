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

  <!-- =======================================================
  * Template Name: NiceAdmin - v2.2.1
  * Template URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
	<script type="text/javascript">
		$(document).ready(function() {		
			
			mbirthFunc();
			
			$('.counter').each(function () {
				$(this).prop('Counter',0).animate({
					Counter: $(this).text()
					}, {
					duration: 2000,
					easing: 'swing',
					step: function (now) {
						$(this).text(Math.ceil(now));
					}
				});
			});
			
			$("#updateBtn").on("click", function() {
				var params = $("#updateForm").serialize();
				$.ajax({
					url: "/member/update",
					type: "POST",
					data: params,
					contentType: "application/x-www-form-urlencoded; charset=UTF-8",
					dataType: "html",
					success: function(result) {
						if(result) {
							alert("데이터 수정을 성공하셨습니다.");
						}
					}
				});
			});
		
		});
		
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
			$('#mbirth').attr('max', maxDate);	 		
		}
		
		function execPostCode() {
	         new daum.Postcode({
	             oncomplete: function(data) {
	                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
	 
	                // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
	                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
	                var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
	                var extraRoadAddr = ''; // 도로명 조합형 주소 변수
	 
	                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
	                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
	                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
	                    extraRoadAddr += data.bname;
	                }
	                // 건물명이 있고, 공동주택일 경우 추가한다.
	                if(data.buildingName !== '' && data.apartment === 'Y'){
	                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	                }
	                // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
	                if(extraRoadAddr !== ''){
	                    extraRoadAddr = ' (' + extraRoadAddr + ')';
	                }
	                // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
	                if(fullRoadAddr !== ''){
	                    fullRoadAddr += extraRoadAddr;
	                }
	 
	                // 우편번호와 주소 정보를 해당 필드에 넣는다.
	                console.log(data.zonecode);
	                console.log(fullRoadAddr);
	                
	                
	                $("[name=mzip]").val(data.zonecode);
	                $("[name=maddr1]").val(fullRoadAddr);
	                
	                /* document.getElementById('signUpUserPostNo').value = data.zonecode; //5자리 새우편번호 사용
	                document.getElementById('signUpUserCompanyAddress').value = fullRoadAddr;
	                document.getElementById('signUpUserCompanyAddressDetail').value = data.jibunAddress; */
	            }
	         }).open();
	     }
		
	</script>

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
                  <button class="nav-link active" data-bs-toggle="tab" data-bs-target="#profile-overview">프로필정보</button>
                </li>

                <li class="nav-item">
                  <button class="nav-link" data-bs-toggle="tab" data-bs-target="#profile-edit">프로필수정</button>
                </li>

                <li class="nav-item">
                  <button class="nav-link" data-bs-toggle="tab" data-bs-target="#profile-settings">설정</button>
                </li>

                <li class="nav-item">
                  <button class="nav-link" data-bs-toggle="tab" data-bs-target="#profile-change-password">비밀번호변경</button>
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
                    <div class="col-lg-9 col-md-10">${m.mauthid}</div>
                  </div>

                </div>

                <div class="tab-pane fade profile-edit pt-3" id="profile-edit">

                  <!-- Profile Edit Form -->
                  <form id="updateForm">
                  	<input type="hidden" name="mno" id="mno" value="${m.mno}">
                    <div class="row mb-3">
                      <label for="profileImage" class="col-md-4 col-lg-3 col-form-label">Profile Image</label>
                      <div class="col-md-8 col-lg-9">
                        <img src="/assets/img/profile-img.jpg" alt="Profile">
                        <div class="pt-2">
                          <a href="#" class="btn btn-primary btn-sm" title="Upload new profile image"><i class="bi bi-upload"></i></a>
                          <a href="#" class="btn btn-danger btn-sm" title="Remove my profile image"><i class="bi bi-trash"></i></a>
                        </div>
                      </div>
                    </div>

                    <div class="row mb-3">
                      <label for="fullName" class="col-md-4 col-lg-3 col-form-label">아이디</label>
                      <div class="col-md-8 col-lg-9">
                        <input type="text" class="form-control" value="${m.mid}" readonly="readonly" style="border:0px; background:white;">
                      </div>
                    </div>


                    <div class="row mb-3">
                      <label for="company" class="col-md-4 col-lg-3 col-form-label">이름</label>
                      <div class="col-md-8 col-lg-9">
                        <input type="text" name="mname" class="form-control" id="mname" value="${m.mname}">
                      </div>
                    </div>
                    
                    <div class="row mb-3">
                      <label for="about" class="col-md-4 col-lg-3 col-form-label">닉네임</label>
                      <div class="col-md-8 col-lg-9">
                        <input type="text" name="mnickname" class="form-control" id="mnickname" value="${m.mnickname}">
                      </div>
                    </div>

                    <div class="row mb-3">
                      <label for="Job" class="col-md-4 col-lg-3 col-form-label">생년월일</label>
                      <div class="col-md-8 col-lg-9">
                        <input type="date" name="mbirth"  class="form-control" 
                               id="mbirth" value="<fmt:formatDate value="${m.mbirth}" pattern="yyyy-MM-dd" />">
                      </div>
                    </div>

                    <div class="row mb-3">
                      <label for="Country" class="col-md-4 col-lg-3 col-form-label">성별</label>
                      <div class="col-md-8 col-lg-9">
	                      <select id="mgender" name="mgender" class="form-select your-input" aria-label="Default select example">
	                        <option>성별</option>
	                        <c:forEach var="list" items="${map}">
	                        	<option value="${list.key}" <c:if test="${m.mgender eq list.key}">selected</c:if>>
	                        		${list.value}
	                        	</option>
	                        </c:forEach>
	                      </select>
                      </div>
                    </div>

                    <div class="row mb-3">
                      <label for="Address" class="col-md-4 col-lg-3 col-form-label">이메일</label>
                      <div class="col-md-8 col-lg-9">
                        <input type="text" name="memail" id="memail" class="form-control"  value="${m.memail}">
                      </div>
                    </div>

                    <div class="row mb-3">
                      <label for="Phone" class="col-md-4 col-lg-3 col-form-label">전화번호</label>
                      <div class="col-md-8 col-lg-9">
                        <input type="text" name="mphone" id="mphone" class="form-control" value="${m.mphone}">
                      </div>
                    </div>

                    <div class="row mb-3">
                      <label for="Email" class="col-md-4 col-lg-3 col-form-label">주소</label>
                      <div class="col-md-8 col-lg-9">
                                              
                        <div class="form-group">                   
							<input type="text" class="form-control" style="width: 40%; display: inline;" 
							       placeholder="우편번호" name="mzip" id="mzip" value="${m.mzip}" readonly="readonly" >
						    <button type="button" class="btn btn-primary" onclick="execPostCode();"><i class="fa fa-search"></i> 우편번호 찾기</button>                               
						</div>
						<div class="form-group mt-2">
						    <input type="text" class="form-control" style="top: 5px;" 
						    	   placeholder="도로명 주소" name="maddr1" id="maddr1" value="${m.maddr1}" readonly="readonly" />
						</div>
						<div class="form-group mt-2">
						    <input type="text" class="form-control" placeholder="상세주소" name="maddr2" id="maddr2" value="${m.maddr2}" />
						</div>
                        
                      </div>
                    </div>

                  </form><!-- End Profile Edit Form -->
                  
                  <div class="text-center">
                    <div id="updateBtn" class="btn btn-primary">저장하기</div>
                  </div>

                </div>

                <div class="tab-pane fade pt-3" id="profile-settings">

                  <!-- Settings Form -->
                  <form>

                    <div class="row mb-3">
                      <label for="fullName" class="col-md-4 col-lg-3 col-form-label">Email Notifications</label>
                      <div class="col-md-8 col-lg-9">
                        <div class="form-check">
                          <input class="form-check-input" type="checkbox" id="changesMade" checked>
                          <label class="form-check-label" for="changesMade">
                            Changes made to your account
                          </label>
                        </div>
                        <div class="form-check">
                          <input class="form-check-input" type="checkbox" id="newProducts" checked>
                          <label class="form-check-label" for="newProducts">
                            Information on new products and services
                          </label>
                        </div>
                        <div class="form-check">
                          <input class="form-check-input" type="checkbox" id="proOffers">
                          <label class="form-check-label" for="proOffers">
                            Marketing and promo offers
                          </label>
                        </div>
                        <div class="form-check">
                          <input class="form-check-input" type="checkbox" id="securityNotify" checked disabled>
                          <label class="form-check-label" for="securityNotify">
                            Security alerts
                          </label>
                        </div>
                      </div>
                    </div>

                    <div class="text-center">
                      <button type="submit" class="btn btn-primary">Save Changes</button>
                    </div>
                  </form><!-- End settings Form -->

                </div>

                <div class="tab-pane fade pt-3" id="profile-change-password">
                  <!-- Change Password Form -->
                  <form>

                    <div class="row mb-3">
                      <label for="currentPassword" class="col-md-4 col-lg-3 col-form-label">Current Password</label>
                      <div class="col-md-8 col-lg-9">
                        <input name="password" type="password" class="form-control" id="currentPassword">
                      </div>
                    </div>

                    <div class="row mb-3">
                      <label for="newPassword" class="col-md-4 col-lg-3 col-form-label">New Password</label>
                      <div class="col-md-8 col-lg-9">
                        <input name="newpassword" type="password" class="form-control" id="newPassword">
                      </div>
                    </div>

                    <div class="row mb-3">
                      <label for="renewPassword" class="col-md-4 col-lg-3 col-form-label">Re-enter New Password</label>
                      <div class="col-md-8 col-lg-9">
                        <input name="renewpassword" type="password" class="form-control" id="renewPassword">
                      </div>
                    </div>

                    <div class="text-center">
                      <button type="submit" class="btn btn-primary">Change Password</button>
                    </div>
                  </form><!-- End Change Password Form -->

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