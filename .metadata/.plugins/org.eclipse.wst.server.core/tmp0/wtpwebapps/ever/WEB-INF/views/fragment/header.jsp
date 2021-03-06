<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
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
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>   

<script>
	$(document).ready(function() {
		$(".header-login-btn").on("click", function() {
			location.href="/member/login";
		});
	})
</script>

<!-- ======= Header ======= -->
<header id="header" class="header fixed-top d-flex align-items-center">

  <div class="d-flex align-items-center justify-content-between">
    <a href="/" class="logo d-flex align-items-center">
      <img src="/assets/img/logo.png" alt="">
      <span class="d-none d-lg-block">NiceAdmin</span>
    </a>
    <i class="bi bi-list toggle-sidebar-btn"></i>
  </div><!-- End Logo -->

  <div class="search-bar">
    <form class="search-form d-flex align-items-center" method="POST" action="#">
      <input type="text" name="query" placeholder="Search" title="Enter search keyword">
      <button type="submit" title="Search"><i class="bi bi-search"></i></button>
    </form>
  </div><!-- End Search Bar -->

  <nav class="header-nav ms-auto">
    <ul class="d-flex align-items-center">

      <li class="nav-item d-block d-lg-none">
        <a class="nav-link nav-icon search-bar-toggle " href="#">
          <i class="bi bi-search"></i>
        </a>
      </li><!-- End Search Icon-->

      <li class="nav-item dropdown">

        <a class="nav-link nav-icon" href="#" data-bs-toggle="dropdown">
          <i class="bi bi-bell"></i>
          <span class="badge bg-primary badge-number">4</span>
        </a><!-- End Notification Icon -->

        <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow notifications">
          <li class="dropdown-header">
            You have 4 new notifications
            <a href="#"><span class="badge rounded-pill bg-primary p-2 ms-2">View all</span></a>
          </li>
          <li>
            <hr class="dropdown-divider">
          </li>

          <li class="notification-item">
            <i class="bi bi-exclamation-circle text-warning"></i>
            <div>
              <h4>Lorem Ipsum</h4>
              <p>Quae dolorem earum veritatis oditseno</p>
              <p>30 min. ago</p>
            </div>
          </li>

          <li>
            <hr class="dropdown-divider">
          </li>

          <li class="notification-item">
            <i class="bi bi-x-circle text-danger"></i>
            <div>
              <h4>Atque rerum nesciunt</h4>
              <p>Quae dolorem earum veritatis oditseno</p>
              <p>1 hr. ago</p>
            </div>
          </li>

          <li>
            <hr class="dropdown-divider">
          </li>

          <li class="notification-item">
            <i class="bi bi-check-circle text-success"></i>
            <div>
              <h4>Sit rerum fuga</h4>
              <p>Quae dolorem earum veritatis oditseno</p>
              <p>2 hrs. ago</p>
            </div>
          </li>

          <li>
            <hr class="dropdown-divider">
          </li>

          <li class="notification-item">
            <i class="bi bi-info-circle text-primary"></i>
            <div>
              <h4>Dicta reprehenderit</h4>
              <p>Quae dolorem earum veritatis oditseno</p>
              <p>4 hrs. ago</p>
            </div>
          </li>

          <li>
            <hr class="dropdown-divider">
          </li>
          <li class="dropdown-footer">
            <a href="#">Show all notifications</a>
          </li>

        </ul><!-- End Notification Dropdown Items -->

      </li><!-- End Notification Nav -->

	  <c:if test="${member == null}">
	      <li class="nav-item dropdown">
		    <a class="nav-link nav-icon" href="/member/login">
			  <div class="btn btn-success btn-sm header-login-btn" style="border-radius:0px;">?????????</div>
	        </a>
	      </li>
      </c:if>

	  <c:if test="${member != null}">
	      <li class="nav-item dropdown pe-3">
	
	        <a class="nav-link nav-profile d-flex align-items-center pe-0" href="#" data-bs-toggle="dropdown">
	          <img src="/upload/displayFile?fileName=/${member.mimage}" alt="Profile" class="rounded-circle"
	          	   style="width:36px; height:36px;">
	          <span class="d-none d-md-block dropdown-toggle ps-2"></span>
	        </a>
	
	        <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow profile">
	          <li class="dropdown-header">
	            <h6>${member.mnickname} (${member.mid})</h6>
	            <span></span>
	          </li>
	          <li>
	            <hr class="dropdown-divider">
	          </li>
	
	          <li>
	            <a class="dropdown-item d-flex align-items-center" href="/member/update">
	              <i class="bi bi-person"></i>
	              <span>??? ?????????</span>
	            </a>
	          </li>
	          <li>
	            <hr class="dropdown-divider">
	          </li>
	
	          <li>
	            <a class="dropdown-item d-flex align-items-center" href="users-profile.html">
	              <i class="bi bi-gear"></i>
	              <span>Account Settings</span>
	            </a>
	          </li>
	          <li>
	            <hr class="dropdown-divider">
	          </li>
	
	          <li>
	            <a class="dropdown-item d-flex align-items-center" href="pages-faq.html">
	              <i class="bi bi-question-circle"></i>
	              <span>Need Help?</span>
	            </a>
	          </li>
	          <li>
	            <hr class="dropdown-divider">
	          </li>
	
	          <li>
	            <a class="dropdown-item d-flex align-items-center" href="/member/logout">
	              <i class="bi bi-box-arrow-right"></i>
	              <span>????????????</span>
	            </a>
	          </li>
	
	        </ul>
	      </li>
      </c:if>
      
    </ul>
  </nav><!-- End Icons Navigation -->

</header><!-- End Header -->