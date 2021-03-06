<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>articleView</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<script type="text/javascript">


	$(document).ready(function() {
		
		const ano = $("#ano").val();
		const mno = $("#mno").val();
		
		checkLike(ano, mno);
		getLike(ano);
		
		$("#topBtn").on("click", function() {
			$("html, body").animate({ scrollTop:0 }, 100);
			return false;
		});
		
		$("#heartWrapper").on("click", function() {
			
			// 좋아요 기능 상수
			const heartIconTag = $("#heartIcon");
			let heartClass = heartIconTag.attr("class");
			const heartCountTag = $("#heartCount");
			
			// 로그인 여부 파악하기
			if(!mno) {
				let result = confirm("이 기능은 로그인 멤버만 사용할 수 있습니다.\n로그인하시겠습니까?");
				if(result) {
					location.href="/member/login";	
				}
				
				return;
			}
			
			// 좋아요 추가
			if(heartClass === "far fa-heart") {
				$.ajax({
					url: "/article/addLike",
					data: {
						ano: ano,
						mno: mno
					},
					method:"POST"
				})
				.done(function(result) {
					if(result == "true") {
						heartIconTag.attr("class", "fas fa-heart");
						let heartCount = heartCountTag.text();
						heartCount = parseInt(heartCount) + 1;
						heartCountTag.text(heartCount);
					}
				})
				.fail(function() {
					alert("좋아요 기능에 문제가 발생하였습니다.");
				});
			} 
			
			// 좋아요 삭제
			if(heartClass === "fas fa-heart") {
				$.ajax({
					url: "/article/removeLike",
					data: {
						ano: ano,
						mno: mno
					},
					type:"POST"
				})
				.done(function(result) {
					if(result == "true") {
						heartIconTag.attr("class", "far fa-heart");
						let heartCount = heartCountTag.text();
						heartCount = parseInt(heartCount) - 1;
						heartCountTag.text(heartCount);
					}
				})
				.fail(function() {
					alert("좋아요 기능에 문제가 발생하였습니다.");
				});
			}
		});
		
		// 게시글 리스트로 이동
		$(".list_btn").on("click", function() {
			location.href = "/article/list?page=${scri.page}" +
						    "&perPageNum=${scri.perPageNum}" +
						    "&searchType=${scri.searchType}" +
						    "&searchDate=${scri.searchDate}" +
						    "&keyword=${scri.keyword}";
		});
		
		// 댓글 작성
		$("#writeBtn").on("click", function() {
			const ccontentTag = $("#comment");
			const ccontent = ccontentTag.val();
			/*
			const cwriterTag = $("#mid");
			const cwriter = cwriterTag.val();
			*/
			const cwriterTag = $("#mno");
			const cwriter = cwriterTag.val();		
			const anoTag = $("#ano");
			const ano = anoTag.val();
			
			$.ajax({
				url:"/comment/write",
				type:"post",
				data:{
					ccontent: ccontent,
					cwriter: cwriter,
					ano: ano
				},
				success: function(result) {
					ccontentTag.val("");
					commentList();
				}
			});
			
		});
		

		commentList();
	});
	
	// 클립 주소 복사
	function clip() {
		let url = "";
		const textarea = document.createElement("textarea");
		document.body.appendChild(textarea);
		url = window.document.location.href;
		textarea.value = url;
		textarea.select();
		document.execCommand("copy");
		document.body.removeChild(textarea);
		alert("URL이 복사되었습니다.");
	}
	
	// 댓글 페이지네이션 리스트 클릭시 commentList 재실행
	function pageItemClick(page) {
		commentList(page);
	}
	
	// 댓글 리스트 생성
	function commentList(page) {
		const ano = $("#ano").val();
		const commentContainer = $("#comment-container");
		const paginationContainer = $("#pagination-container");
		let comment = "";
		let pagination = "";
		
		commentContainer.html("");
		paginationContainer.html("");
		
		$.ajax({
			url: "/comment/list",
			type: "get",
			data: {
				ano: ano,
				page: page
			},
			success: function(result) {
				console.log(JSON.stringify(result.commentList[0], null, 4))
				
				$(".commentCount").html(result.pageMaker.totalCount);
				
				let element = document.getElementById("scrollPlace");
				console.log(element);
				
				element.scrollIntoView({ behavior:'smooth', block: 'center'});
				
				// 댓글 리스트 출력
				for(let i=0; i<result.commentList.length; i++) {
					if(result.commentList[i].cdeleteyn == "N") {
						if(result.commentList[i].commentlevel == 1) {
							comment = `
								<!-- 댓글 -->
								<div class="comment-wrapper mt-3">
									<div class="comment-text">
										<div class="d-flex flex-start mt-2" style="border-bottom:1px solid #E1E1E1; ">
										  <a class="me-3" href="#">
											<img
											  class="rounded-circle shadow-1-strong"
											  src="/upload/displayFile?fileName=/${"${result.commentList[i].mimage}"}"
											  alt="avatar"
											  width="36"
											  height="36"
											/>
										  </a>
										  <div style="margin-bottom:-7px; width:100%;">
											<div>
											  <div class="d-flex justify-content-between align-items-center">
												<p class="mb-1 fw-bold" style="font-size:14px;">
												  ${"${result.commentList[i].mnickname}"}
												</p>
											  </div>
											  <p class="small mb-0">
												${"${result.commentList[i].ccontent}"}
											  </p>
											  <p>
												<span class="text-muted me-1" style="font-size:12px;">${"${result.commentList[i].cinsertdate}"}</span>
												<span class="text-muted reply-write" style="font-size:12px;" 
													  onclick="createTextarea(this)" data-pcno="${"${result.commentList[i].cno}"}">답글쓰기</span>
											  </p>
											</div>
										  </div>
										  <div class="flex-grow-1 flex-shrink-1">
											
											<span class="filter">
												<a class="icon me-1 fw-bold" href="#" data-bs-toggle="dropdown" style="color:black;">
													<i class="fas fa-ellipsis-v" style="color:#b2b2b2; font-size:16px;"></i>
												</a>
												<ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow">
												  <li><a class="dropdown-item" href="#">수정</a></li>
												  <li><a class="dropdown-item" href="#">삭제</a></li>
												  <!--  
												  <li><a class="dropdown-item" href="#">This Month</a></li>
												  <li><a class="dropdown-item" href="#">This Year</a></li>
												  -->
												</ul>
											</span>
										  </div>
										</div>
									</div>
		
								</div>
								<!-- /댓글 -->
								`;
						} else {
							comment = `
								<!-- 대댓글 -->
								<div class="comment-wrapper mt-3">
									<div class="comment-text">
										<div class="d-flex flex-start mt-2" style="margin-left:50px; border-bottom:1px solid #E1E1E1; ">
										  <a class="me-3" href="#">
											<img
											  class="rounded-circle shadow-1-strong"
											  src="/upload/displayFile?fileName=/${"${result.commentList[i].mimage}"}"
											  alt="avatar"
											  width="36"
											  height="36"
											/>
										  </a>
										  <div style="margin-bottom:-7px; width:100%;">
											<div>
											  <div class="d-flex justify-content-between align-items-center">
												<p class="mb-1 fw-bold" style="font-size:14px;">
												  ${"${result.commentList[i].mnickname}"}
												</p>
											  </div>
											  <p class="small mb-0">
												${"${result.commentList[i].ccontent}"}
											  </p>
											  <p>
												<span class="text-muted me-1" style="font-size:12px;">${"${result.commentList[i].cinsertdate}"}</span>
												<span class="text-muted reply-write" style="font-size:12px;" 
													  onclick="createTextarea(this)" data-pcno="${"${result.commentList[i].cno}"}">답글쓰기</span>
											  </p>
											</div>
										  </div>
										  <div class="flex-grow-1 flex-shrink-1">
											<i class="fas fa-ellipsis-v" style="color:#b2b2b2; font-size:16px;"></i>
										  </div>
										</div>
									</div>
		
								</div>
								<!-- /대댓글 -->				
							`;
						}
					} else {
						comment = `
							<!-- 대댓글 -->
							<div class="comment-wrapper mt-3">
								<div class="comment-text">
									<div class="d-flex flex-start mt-2" style="margin-left:50px; border-bottom:1px solid #E1E1E1; ">
									  <a class="me-3" href="#">
										<img
										  class="rounded-circle shadow-1-strong"
										  src="/upload/displayFile?fileName=/${"${result.commentList[i].mimage}"}"
										  alt="avatar"
										  width="36"
										  height="36"
										/>
									  </a>
									  <div style="margin-bottom:-7px; width:100%;">
										<div>
										  <div class="d-flex justify-content-between align-items-center">
											<p class="mb-1 fw-bold" style="font-size:14px;">
											  ${"${result.commentList[i].mnickname}"}
											</p>
										  </div>
										  <p class="small mb-0">
											삭제된 댓글입니다.
										  </p>
										  <p>
											<span class="text-muted me-1" style="font-size:12px;">${"${result.commentList[i].cinsertdate}"}</span>
											<span class="text-muted reply-write" style="font-size:12px;" 
												  onclick="createTextarea(this)" data-pcno="${"${result.commentList[i].cno}"}">답글쓰기</span>
										  </p>
										</div>
									  </div>
									  <div class="flex-grow-1 flex-shrink-1">
										<i class="fas fa-ellipsis-v" style="color:#b2b2b2; font-size:16px;"></i>
									  </div>
									</div>
								</div>
	
							</div>
							<!-- /대댓글 -->				
						`;
					}						
					
					commentContainer.append(comment);
				}
				
				// 페이지네이션 출력
				pagination = `
					<nav class="mt-4" aria-label="Page navigation example">
					  <ul class="pagination pagination-sm justify-content-center">
				`;
				
				if(result.pageMaker.prev === "true") {
					pagination += `
						<li class="page-item ms-1 me-1">
						  <a class="page-link" href="#" aria-label="Previous">
							<span aria-hidden="true">&laquo; 이전</span>
						  </a>
						</li>
					`;
				}
				
				for(let i=result.pageMaker.startPage; i<=result.pageMaker.endPage; i++) {
					if(i == result.pageMaker.cri.page) {
						pagination += `
							<li class="page-item ms-1 me-1 active"><span class="page-link" onclick="pageItemClick(${"${i}"});">${"${i}"}</span></li>
						`;						
					} else {
						pagination += `
							<li class="page-item ms-1 me-1"><span class="page-link" onclick="pageItemClick(${"${i}"});">${"${i}"}</span></li>
						`;
					}
				}
				
				if(result.pageMaker.next === "true" && pageMaker.endPage > 0) {
					pagination += `
						<li class="page-item ms-1 me-1">
						  <a class="page-link" href="#" aria-label="Next">
							<span aria-hidden="true">다음 &raquo;</span>
						  </a>
						</li>
					`;
				}

				pagination += `
					  </ul>
					</nav>				
				`;
				
				paginationContainer.append(pagination);
				
			}
		})
	}
	
	// textarea 자동 높이
	function autoHeight(e) {
		const textTagHeight = $(e).prop('scrollHeight');
		$(e).css('height', textTagHeight);
	}
	
	
	// textare 태그 생성
	function createTextarea(e) {
		const commentWrapperTag = $(e).closest(".comment-wrapper");
		
		const pcno = commentWrapperTag.find(".reply-write").attr("data-pcno");
		
		const commentTextareaTag = $(".comment-container").find(".comment-textarea");
		commentTextareaTag.remove();
		
		const commentTextarea = `
			<div class="comment-textarea">
				<div class="mt-3 mb-3 ms-5 p-3" style="border:1px solid gray; border-radius:5px; background:white;">
					<div>${member.mnickname}</div>
					<div class="mt-2">
						<textarea id="comment" class="comment_inbox_text" onkeyup="autoHeight(this)" onkeydown="autoHeight(this)"  placeholder="댓글을 남겨보세요" rows="2"></textarea>
					</div>
					<div class="clearfix">
						<div class="float-start">
							<span class="me-2 fs-5"><i class="fas fa-camera"></i></span>
							<span class="fs-5"><i class="far fa-smile"></i></span>
						</div>
						<div class="float-end">
							<div class="btn btn-success btn-sm" onclick="addReply(this, ${"${pcno}"})">등록</div>
						</div>
					</div>
				</div>
				<div style="border-bottom:1px solid #E1E1E1; "></div>
			</div>			
		`;
		
		commentWrapperTag.append(commentTextarea);
	}
	
	
	// 좋아요 갯수 불러오기
	function getLike(ano) {
		const heartIconTag = $("#heartIcon");
		const heartClass = heartIconTag.attr("class");
		const heartCountTag = $("#heartCount");

		$.ajax({
			url: "/article/getLike",
			data: {
				ano:ano
			},
			method:"GET"
		})
		.done(function(result) {
			heartCountTag.text(result);
		})
		.fail(function() {
			alert("좋아요 갯수 불러오기를 실패하였습니다. (getLike)");
		})
	}
	
	// 내가 좋아요 누른지 안 누른지 확인
	function checkLike(ano, mno) {
		const heartIconTag = $("#heartIcon");
		const heartClass = heartIconTag.attr("class");
		const heartCountTag = $("#heartCount");
		
		if(!mno) {
			heartIconTag.attr("class", "far fa-heart");
		} else {
			$.ajax({
				url: "/article/checkLike",
				data: {
					ano: ano,
					mno: mno
				},
				method:"GET"
			})
			.done(function(result) {
				if(result == "true") 
					heartIconTag.attr("class", "fas fa-heart");
				
				if(result == "false") 
					heartIconTag.attr("class", "far fa-heart");
			})
			.fail(function() {
				alert("좋아요 기능에 문제가 발생하였습니다. (checkLike)");
			});
		}
	}
	
	// 답글
	function addReply(e, pcno) {
		const commentTextareaTag = $(e).closest(".comment-textarea");
		const ano = $("#ano").val();
		const ccontent = commentTextareaTag.find(".comment_inbox_text").val();
		const cwriterTag = $("#mno");
		const cwriter = cwriterTag.val();
		
		$.ajax({
			url: "/comment/write",
			method: "post",
			data: {
				ano: ano,
				ccontent: ccontent,
				cwriter: cwriter,
				pcno: pcno
			},
			success: function(result) {
				console.log("성공 : " + result);
				commentList();
			}
			
		})
	}
	
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
		width:100%; 
		overflow:hidden; 
		overflow-wrap: break-word; 
		height:32px;
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
	<input type="hidden" id="mno" value="${member.mno}">
	<input type="hidden" id="mnickname" value="${member.mnickname}">
	
    <div class="container pagetitle clearfix" style="width:860px; margin:0 auto;">
      <div class="float-end">
		<div class="btn btn-sm fw-bold" style="background:#e6e6e6;"><i class="fas fa-chevron-up"></i> &nbsp; 이전글</div>
		<div class="btn btn-sm fw-bold" style="background:#e6e6e6;"><i class="fas fa-chevron-down"></i> &nbsp; 다음글</div>
		<div class="btn btn-sm fw-bold list_btn" style="background:#e6e6e6;">목록</div>
	  </div>
    </div><!-- End Page Title -->
	
	<div class="container" style="width:860px; margin:0 auto;">
		<form name="readForm" role="form" method="post">
			<input type="hidden" id="ano" name="ano" value="${article.ano}" />
			<input type="hidden" id="page" name="page" value="${scri.page}" />
			<input type="hidden" id="perPageNum" name="perPageNum" value="${scri.perPageNum}" />
			<input type="hidden" id="searchType" name="searchType" value="${scri.searchType}" />
			<input type="hidden" id="searchDate" name="searchType" value="${scri.searchType}" />
			<input type="hidden" id="keyword" name="keyword" value="${scri.keyword}" />
			<input type="hidden" id="articleMno" name="articleMno" value="${article.mno}" />
		</form>
		<div class="mt-3 p-4" style="border:1px solid gray; border-radius:5px;">
			<div class="ms-1" style="color:#03c75a; font-size:13px;">${article.acategoryno} <i class="fas fa-chevron-right"></i></div>
			<div>
				<span class="fw-bold fs-4">[${article.acategorynoref}] </span>
				<span class="fw-bold fs-4">${article.atitle}</span>
			</div>
			<div class="clearfix">
				<div class="float-start d-flex align-items-start mt-2"> 
					<img src="/upload/displayFile?fileName=/${article.mimage}" class="rounded-circle" alt="profile-image" 
					     style="width:47px; height:36px;">
					<div class="w-100 ms-3">
						<div style="font-size:14px;">
							<span class="filter">
								<a class="icon me-1 fw-bold" href="#" data-bs-toggle="dropdown" style="color:black;">${article.mnickname}</a>
								<ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow">
								  <li><a class="dropdown-item" href="/member/memberPublicProfile?mno=${article.mno}">게시글보기</a></li>
								  <!--  
								  <li><a class="dropdown-item" href="#">This Month</a></li>
								  <li><a class="dropdown-item" href="#">This Year</a></li>
								  -->
								</ul>
							</span>
							<span>침팬치</span>
							<div class="badge badge-sm" style="background:#d4d4d4; color:#000; border-radius:5px;">1:1 채팅</div>
						</div>
						<div class="text-muted mt-1" style="font-size:12px;">
							<span class="me-1">
								<fmt:formatDate value="${article.ainsertdate}" pattern="yyyy.MM.dd. HH:mm"></fmt:formatDate>
							</span> 
							<span>
								<span>조회</span>
								<span>${article.aviewcnt}</span>
							</span>
						</div>  
					</div>
				</div>
				<div class="float-end" style="line-height:55px;">
					<span>
						<span class="me-2" style="font-size:13px;">
							<i class="far fa-comment-dots"></i>&nbsp;
							<span>댓글</span> 
							<span class="commentCount fw-bold">0</span>
						</span>
						<span class="me-2">
							<a href="#" onclick="clip(); return false;" style="font-size:13px; color:black;">
								URL 복사
							</a>
						</span>
						<span>
							<i class="fas fa-ellipsis-v" style="color:#b2b2b2; font-size:16px;"></i>
						</span>
					</span>
				</div>
			</div>
			<hr>

			<div>
				${article.acontent}
			</div>

			<div class="d-flex align-items-start mt-4"> 
				<img src="/upload/displayFile?fileName=/${article.mimage}" class="rounded-circle" alt="profile-image" 
				     style="width:40px; height:36px;">
				<div class="w-100 ms-3">
					<div style="font-size:12px; line-height:40px;">
						<span class="fw-bold" style="font-size:16px;">${article.mnickname}</span>
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
						<span class="commentCount" style="font-size:14px; font-weight:bold;">0</span>
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
	
			<!-- 댓글작성 -->
			<div id="scrollPlace" class="fw-bold fs-5">댓글</div>

			<div class="mt-3 p-3" style="border:1px solid gray; border-radius:5px; background:white;">
				<div>${member.mnickname}</div>
				<div class="mt-2">
					<textarea id="comment" class="comment_inbox_text" onkeyup="autoHeight(this)" onkeydown="autoHeight(this)" 
							  placeholder="댓글을 남겨보세요" rows="2"></textarea>
				</div>
				<div class="clearfix">
					<div class="float-start">
						<span class="me-2 fs-5"><i class="fas fa-camera"></i></span>
						<span class="fs-5"><i class="far fa-smile"></i></span>
					</div>
					<div class="float-end">
						<div id="writeBtn" class="btn btn-success btn-sm">등록</div>
					</div>
				</div>
			</div>
			<!-- /댓글작성 -->
		</div>

		<!-- 카드 -->
		<div class="card mt-4" style="box-shadow:none !important; background:transparent;">
		  <div class="card-body">
			<div class="row">
			  <div>
			  	<div id="comment-container" class="comment-container">
					<!-- 댓글 리스트 나오는 곳 -->
				</div>
			
				<!-- 페이지네이션 -->
				<div id="pagination-container" class="pagination-container">
					<!-- 페이지네이션 나오는 곳 -->
				</div>
				<!-- /페이지네이션 -->

			  </div>
			</div>
		  </div>
		</div>
		<!-- /카드 -->
	</div>

	<div class="container clearfix mt-2" style="width:860px; margin:0 auto;">
		<div class="float-start">
			<a href="/article/write" class="btn btn-success btn-sm">
				<i class="fas fa-pen"></i>
				<span>글쓰기</span>
			</a>
			<div class="btn btn-sm fw-bold" style="background:#e6e6e6;">답글</div>
		</div>
		<div class="float-end">
			<div class="btn btn-sm fw-bold list_btn" style="background:#e6e6e6;">목록</div>
			<div id="topBtn" class="btn btn-sm fw-bold" style="background:#e6e6e6;"><i class="fas fa-caret-up"></i> &nbsp; TOP</div>			
		</div>
	</div>

</main><!-- End #main -->

<c:import url="/footer"></c:import>

</body>
</html>