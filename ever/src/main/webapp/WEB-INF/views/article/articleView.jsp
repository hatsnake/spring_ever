<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>articleView</title>

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
</style>

</head>
<body>

<c:import url="/header"></c:import>
<c:import url="/sidebar"></c:import>

 <main id="main" class="main">

    <div class="container pagetitle clearfix" style="width:860px; margin:0 auto;">
      <div class="float-end">
		<div class="btn btn-primary">이전글</div>
		<div class="btn btn-primary">이전글</div>
		<div class="btn btn-primary">이전글</div>
	  </div>
    </div><!-- End Page Title -->
	
	<div class="container" style="width:860px; margin:0 auto;">
		<div class="mt-3 p-4" style="border:1px solid gray; border-radius:5px;">
			<div>자유게시판</div>
			<div>
				<span>[내가 싼 똥]</span>
				<span>Wakgood oppa brought me here! 💚</span>
			</div>
			<div class="clearfix">
				<div class="float-start d-flex align-items-start mt-2"> 
					<img src="https://bootdey.com/img/Content/avatar/avatar1.png" class="rounded-circle" alt="profile-image" style="width:36px; height:36px;">
					<div class="w-100 ms-3">
						<div style="font-size:14px;">
							<span class="me-1 fw-bold">구리구리12</span>
							<span>침팬치</span>
							<div class="badge badge-sm" style="background:gray;">1:1 채팅</div>
						</div>
						<div class="text-muted mt-1" style="font-size:12px;">
							<span class="me-1">2022.01.29. 17:04</span> 
							<span>조회 224</span>
						</div>  
					</div>
				</div>
				<div class="float-end" style="line-height:55px;">
					<span>
						<span>댓글 17</span>
						<span>URL 복사</span>
						<span>:</span>
					</span>
				</div>
			</div>
			<hr>

			<div>
				글내용
			</div>

			<div class="d-flex align-items-start mt-4"> 
				<img src="https://bootdey.com/img/Content/avatar/avatar1.png" class="rounded-circle" alt="profile-image" style="width:36px; height:36px;">
				<div class="w-100 ms-3">
					<div style="font-size:14px; line-height:40px;">
						<span class="fw-bold">구리구리12</span>
						<span>님의 게시글 더보기 ></span>
					</div>
				</div>
			</div>

			<div class="clearfix mt-3">
				<div class="float-start">
					<span>좋아요 0</span>
					<span>댓글 17</span>
				</div>
				<div class="float-end">
					<span>공유</span>
					<span>신고</span>
				</div>
			</div>

			<hr>
	
			<!-- 텍스트아레나 -->
			<div class="fw-bold fs-5">댓글</div>

			<div class="mt-3 p-3" style="border:1px solid gray; border-radius:5px; background:white;">
				<div>qkrtkdgur</div>
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
					  <div class="flex-grow-1 flex-shrink-1" style="margin-bottom:-7px;">
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
					  <div class="flex-grow-1 flex-shrink-1" style="margin-bottom:-7px;">
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
					  <div class="flex-grow-1 flex-shrink-1" style="margin-bottom:-7px;">
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

	<div class="clearfix mt-3">
		<div class="float-start">
			<div class="btn btn-success">글쓰기</div>
			<div class="btn btn-success">답글</div>
		</div>
		<div class="float-end">
			<div class="btn btn-success">목록</div>
			<div class="btn btn-success">TOP</div>			
		</div>
	</div>

</main><!-- End #main -->

<c:import url="/footer"></c:import>

</body>
</html>