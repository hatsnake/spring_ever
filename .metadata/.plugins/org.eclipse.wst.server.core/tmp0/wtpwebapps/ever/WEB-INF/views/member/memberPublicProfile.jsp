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

<script>
$(document).ready(function() {
	
	let page = 1;
	let mno = 2;
	
	$.ajax({
		url: "/member/memberArticleList",
		method: "get",
		data: {
			page: page,
			mno: mno
		},
		success: function(result) {
			console.log(result, null, 4);
		}
	});
	
	$.ajax({
		url: "/member/memberCommentList",
		method: "get",
		data: {
			page: page,
			mno: mno			
		},
		success: function(result) {
			console.log(result, null, 4);
		}
	});
	
});
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

    <section class="section profile" style="width:836px; margin:0 auto;">
    	<div class="clearfix">
			<div class="float-start d-flex align-items-start mt-2"> 
				<img src="https://t1.daumcdn.net/cfile/tistory/24283C3858F778CA2E" class="rounded-circle" alt="profile-image" 
				     style="width:70px; height:70px;">
				<div class="w-100 ms-3">
					<div class="fw-bold fs-5">?????????(hatsnake)</div>
					<div style="font-size:14px;">?????????</div>
					<div>
						<span class="me-1">
							<span style="font-size:14px; color:gray;">??????</span> 
							<span style="font-size:14px; font-weight:bold;">${visitedCount}</span>
						</span>
						<span class="me-1">
							<span style="font-size:14px; color:gray;">?????????</span> 
							<span style="font-size:14px; font-weight:bold;">${articleCount}</span>
						</span>
						<span>
							<span style="font-size:14px; color:gray;">?????? ??????</span> 
							<span style="font-size:14px; font-weight:bold;">${commentCount}</span>
						</span>
					</div>  
				</div>
			</div>
		</div>
		
		<div class="card mt-3">
			<div class="card-body pt-3">
              <ul class="nav nav-tabs nav-tabs-bordered" id="borderedTab" role="tablist">
                <li class="nav-item" role="presentation">
                  <button class="nav-link active" id="home-tab" data-bs-toggle="tab" data-bs-target="#bordered-article" type="button" role="tab" aria-controls="home" aria-selected="true">?????????</button>
                </li>
                <li class="nav-item" role="presentation">
                  <button class="nav-link" id="profile-tab" data-bs-toggle="tab" data-bs-target="#bordered-comment" type="button" role="tab" aria-controls="profile" aria-selected="false">????????? ???</button>
                </li>
              </ul>
              <div class="tab-content pt-2 mt-2" id="borderedTabContent">
                <div class="tab-pane fade show active" id="bordered-article" role="tabpanel" aria-labelledby="home-tab">
                	?????????
                </div>
                <div class="tab-pane fade" id="bordered-comment" role="tabpanel" aria-labelledby="profile-tab">
					????????? ???
                </div>
              </div>		
              	
			</div>
		</div>
    </section>

</main><!-- End #main -->

<c:import url="/footer"></c:import>

</body>

</html>