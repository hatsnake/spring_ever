<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>articleView</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$("#topBtn").on("click", function() {
			$("html, body").animate({ scrollTop:0 }, 100);
			return false;
		});
		
		$("#heartWrapper").on("click", function() {
			const heartIconTag = $("#heartIcon");
			const heartClass = heartIconTag.attr("class");
			const heartCountTag = $("#heartCount");
			//let heartCount = heartCountTag.text();
			const ano = $("#ano").val();
			const mid = $("#mid").val();
			
			// 좋아요 갯수 불러오기
			$.ajax({
				url: "/article/like",
				data: {
					ano:ano
				},
				method:"GET"
			})
			.done(function(result) {
				heartCountTag.text(result);
			})
			.fail(function() {
				alert("좋아요 갯수 불러오기를 실패하였습니다.");
			})
			
			// 로그인 여부 파악하기
			if(!mid) {
				let result = confirm("이 기능은 로그인 멤버만 사용할 수 있습니다.\n로그인하시겠습니까?");
				if(result) {
					location.href="/member/login";	
				}
				
				return;
			}
			
			// 빈 하트 상태
			if(heartClass === "far fa-heart") {
				$.ajax({
					url: "/article/addLike",
					data: {
						ano:ano,
						mid:mid
					},
					method:"POST"
				})
				.done(function(result) {
					heartIconTag.attr("class", "fas fa-heart");
					heartCount++;
					heartCountTag.text(heartCount);
				})
				.fail(function() {
					alert("좋아요 기능에 문제가 발생하였습니다.");
				});
			} 
			
			// 들어있는 하트 상태
			if(heartClass === "fas fa-heart") {
				$.ajax({
					url: "/article/removeLike",
					data: {
						ano:ano,
						mid:mid
					},
					method:"POST"
				})
				.done(function(result) {
					heartIconTag.attr("class", "far fa-heart");
					heartCount--;
					heartCountTag.text(heartCount);
				})
				.fail(function() {
					alert("좋아요 기능에 문제가 발생하였습니다.");
				});
			}
		});
	});
</script>

<style>
	table .ellipsis {
		position: relative;
	}
	
	.table .ellipsis span {
		overflow: hidden;
		white-space: nowrap;
		text-overflow: ellipsis;
		position: absolute;
		left: 9px;
		right: 9px;
	}
	
	.ellipsis:before {
		content: '';
		display: inline-block;
	}
	
	.comment_inbox_text {
		border: 0px;
		background: transparent;
		resize: none;
	}
	
	.comment_inbox_text:focus {
		box-shadow: none;
		outline: none;
	}
	.report-span:before {
		content: "｜";
	    margin: 0px 5px;
	    color: silver;
	}
</style>

</head>
<body>

<c:import url="/header"></c:import>
<c:import url="/sidebar"></c:import>

 <main id="main" class="main">
	<input type="hidden" id="ano" value="${article.ano}">
	<input type="hidden" id="mid" value="${member.mid}">
	
    <div class="container pagetitle clearfix" style="width:860px; margin:0 auto;">
      <div class="float-end">
		<div class="btn btn-sm fw-bold" style="background:#e6e6e6;"><i class="fas fa-chevron-up"></i> &nbsp; 이전글</div>
		<div class="btn btn-sm fw-bold" style="background:#e6e6e6;"><i class="fas fa-chevron-down"></i> &nbsp; 다음글</div>
		<div class="btn btn-sm fw-bold" style="background:#e6e6e6;">목록</div>
	  </div>
    </div><!-- End Page Title -->
	
	<div class="container" style="width:860px; margin:0 auto;">
		<div class="mt-3 p-4" style="border:1px solid gray; border-radius:5px;">
			<div class="ms-1" style="color:#03c75a; font-size:13px;">${article.acategoryno} <i class="fas fa-chevron-right"></i></div>
			<div>
				<span class="fw-bold fs-4">[${article.acategorynoref}] </span>
				<span class="fw-bold fs-4">${article.atitle}</span>
			</div>
			<div class="clearfix">
				<div class="float-start d-flex align-items-start mt-2"> 
					<img src="https://bootdey.com/img/Content/avatar/avatar1.png" class="rounded-circle" alt="profile-image" style="width:36px; height:36px;">
					<div class="w-100 ms-3">
						<div style="font-size:14px;">
							<span class="me-1 fw-bold">${article.awriter}</span>
							<span>침팬치</span>
							<div class="badge badge-sm" style="background:#d4d4d4; color:#000; border-radius:5px;">1:1 채팅</div>
						</div>
						<div class="text-muted mt-1" style="font-size:12px;">
							<span class="me-1">2022.01.29. 17:04</span> 
							<span>조회 224</span>
						</div>  
					</div>
				</div>
				<div class="float-end" style="line-height:55px;">
					<span>
						<span class="me-2" style="font-size:13px;">
							<i class="far fa-comment-dots"></i>&nbsp;
							<span>댓글</span> 
							<span class="fw-bold">17</span>
						</span>
						<span class="me-2" style="font-size:13px;">URL 복사</span>
						<span><i class="fas fa-ellipsis-v" style="color:#b2b2b2; font-size:16px;"></i></span>
					</span>
				</div>
			</div>
			<hr>

			<div>
				${article.acontent}
			</div>

			<div class="d-flex align-items-start mt-4"> 
				<img src="https://bootdey.com/img/Content/avatar/avatar1.png" class="rounded-circle" alt="profile-image" style="width:36px; height:36px;">
				<div class="w-100 ms-3">
					<div style="font-size:12px; line-height:40px;">
						<span class="fw-bold" style="font-size:16px;">${article.awriter}</span>
						<span>님의 게시글 더보기 ></span>
					</div>
				</div>
			</div>

			<div class="clearfix mt-3">
				<div class="float-start">
					<span id="heartWrapper" class="me-3">
						<i id="heartIcon" class="far fa-heart" style="color:red;"></i>
						<!-- <i class="fas fa-heart"></i> -->
						<span style="font-size:12px;">좋아요</span> 
						<span id="heartCount" style="font-size:14px; font-weight:bold;">0</span>
					</span>
					<span>
						<i class="far fa-comment-dots position-relative">
						  <span class="position-absolute top-0 start-100 translate-middle p-1 bg-danger border border-light rounded-circle">
						    <span class="visually-hidden">New alerts</span>
						  </span>
						</i>
						<span style="font-size:12px;">댓글</span> 
						<span style="font-size:14px; font-weight:bold;">17</span>
					</span>
				</div>
				<div class="float-end">
					<span>
						<i class="far fa-share-square"></i>
						<span style="font-size:13px;">공유</span>
					</span>
					<span class="report-span" style="font-size:13px;">신고</span>
				</div>
			</div>

			<hr>
	
			<!-- 텍스트아레나 -->
			<div class="fw-bold fs-5">댓글</div>

			<div class="mt-3 p-3" style="border:1px solid gray; border-radius:5px; background:white;">
				<div>${member.mid}</div>
				<div class="mt-2">
					<textarea class="comment_inbox_text" placeholder="댓글을 남겨보세요" rows="2" style="width:100%; overflow:hidden; overflow-wrap: break-word; height:36px;"></textarea>
				</div>
				<div class="clearfix">
					<div class="float-start">
						<span class="me-2 fs-5"><i class="fas fa-camera"></i></span>
						<span class="fs-5"><i class="far fa-smile"></i></span>
					</div>
					<div class="float-end">
						<div class="btn btn-success btn-sm">등록</span>
					</div>
				</div>
			</div>
			<!-- /텍스트아레나 -->
		</div>

		<!-- 카드 -->
		<div class="card mt-4" style="box-shadow:none !important; background:transparent;">
		  <div class="card-body p-4">
			<div class="row">
			  <div>
				<!-- 댓글 -->
				<div>
					<div class="d-flex flex-start mt-2" style="border-bottom:1px solid #E1E1E1; ">
					  <a class="me-3" href="#">
						<img
						  class="rounded-circle shadow-1-strong"
						  src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/img%20(11).webp"
						  alt="avatar"
						  width="36"
						  height="36"
						/>
					  </a>
					  <div style="margin-bottom:-7px; width:100%;">
						<div>
						  <div class="d-flex justify-content-between align-items-center">
							<p class="mb-1 fw-bold" style="font-size:14px;">
							  Anchovy
							</p>
						  </div>
						  <p class="small mb-0">
							아니 다들 모여있었냐고 ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ
						  </p>
						  <p>
							<span class="text-muted me-1" style="font-size:12px;">2022.01.29. 02:39</span>
							<span class="text-muted" style="font-size:12px;">답글쓰기</span>
						  </p>
						</div>
					  </div>
					  <div class="flex-grow-1 flex-shrink-1">
					  	<i class="fas fa-ellipsis-v" style="color:#b2b2b2; font-size:16px;"></i>
					  </div>
					</div>
				</div>
				<!-- /댓글 -->
			
				<!-- 대댓글 -->
				<div>
					<div class="d-flex flex-start mt-3" style="margin-left:50px; border-bottom:1px solid #E1E1E1;">
					  <a class="me-3" href="#">
						<img
						  class="rounded-circle shadow-1-strong"
						  src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/img%20(11).webp"
						  alt="avatar"
						  width="36"
						  height="36"
						/>
					  </a>
					  <div style="margin-bottom:-7px; width:100%;">
						<div>
						  <div class="d-flex justify-content-between align-items-center">
							<p class="mb-1 fw-bold" style="font-size:14px;">
							  Anchovy
							</p>
						  </div>
						  <p class="small mb-0">
							아니 다들 모여있었냐고 ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ
						  </p>
						  <p>
							<span class="text-muted me-1" style="font-size:12px;">2022.01.29. 02:39</span>
							<span class="text-muted" style="font-size:12px;">답글쓰기</span>
						  </p>
						</div>
					  </div>
					  <div class="flex-grow-1 flex-shrink-1">
					  	<i class="fas fa-ellipsis-v" style="color:#b2b2b2; font-size:16px;"></i>
					  </div>
					</div>
				</div>
				<!-- /대댓글 -->

				<!-- 대댓글 -->
				<div>
					<div class="d-flex flex-start mt-3" style="margin-left:50px; border-bottom:1px solid #E1E1E1;">
					  <a class="me-3" href="#">
						<img
						  class="rounded-circle shadow-1-strong"
						  src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/img%20(11).webp"
						  alt="avatar"
						  width="36"
						  height="36"
						/>
					  </a>
					  <div style="margin-bottom:-7px; width:100%;">
						<div>
						  <div class="d-flex justify-content-between align-items-center">
							<p class="mb-1 fw-bold" style="font-size:14px;">
							  Anchovy
							</p>
						  </div>
						  <p class="small mb-0">
							아니 다들 모여있었냐고 ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ
						  </p>
						  <p>
							<span class="text-muted me-1" style="font-size:12px;">2022.01.29. 02:39</span>
							<span class="text-muted" style="font-size:12px;">답글쓰기</span>
						  </p>
						</div>
					  </div>
					  <div class="flex-grow-1 flex-shrink-1">
					  	<i class="fas fa-ellipsis-v" style="color:#b2b2b2; font-size:16px;"></i>
					  </div>
					</div>
				</div>
				<!-- /대댓글 -->

				<!-- 페이지네이션 -->
				<nav class="mt-4" aria-label="Page navigation example">
				  <ul class="pagination pagination-sm justify-content-center">
					<li class="page-item ms-1 me-1">
					  <a class="page-link" href="#" aria-label="Previous">
						<span aria-hidden="true">&laquo; 이전</span>
					  </a>
					</li>
					<li class="page-item ms-1 me-1"><a class="page-link" href="#">1</a></li>
					<li class="page-item ms-1 me-1"><a class="page-link" href="#">2</a></li>
					<li class="page-item ms-1 me-1"><a class="page-link" href="#">3</a></li>
					<li class="page-item ms-1 me-1">
					  <a class="page-link" href="#" aria-label="Next">
						<span aria-hidden="true">다음 &raquo;</span>
					  </a>
					</li>
				  </ul>
				</nav>
				<!-- /페이지네이션 -->

			  </div>
			</div>
		  </div>
		</div>
		<!-- /카드 -->
	</div>

	<div class="clearfix mt-2">
		<div class="float-start">
			<a href="/article/write" class="btn btn-success btn-sm">
				<i class="fas fa-pen"></i>
				<span>글쓰기</span>
			</a>
			<div class="btn btn-sm fw-bold" style="background:#e6e6e6;">답글</div>
		</div>
		<div class="float-end">
			<div class="btn btn-sm fw-bold" style="background:#e6e6e6;">목록</div>
			<div id="topBtn" class="btn btn-sm fw-bold" style="background:#e6e6e6;"><i class="fas fa-caret-up"></i> &nbsp; TOP</div>			
		</div>
	</div>

</main><!-- End #main -->

<c:import url="/footer"></c:import>

</body>
</html>