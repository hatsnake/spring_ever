<%@page import="com.hatsnake.ever.article.vo.PageMaker"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>articleList</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
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
	
	.table .ellipsis a {
		overflow: hidden;
		white-space: nowrap;
		text-overflow: ellipsis;
	}
	
	.ellipsis:before {
		content: '';
		display: inline-block;
	}
	#atitle {
		color: black;
	}
	
	#atitle:hover {
		text-decoration:underline;		
	}
</style>
<script>
	$(document).ready(function() {
		$("#writeBtn").click(function() {
			location.href="/article/write";
		});
		
		$("#searchBtn").on("click", function() {
			const keywordInput = $("#keywordInput");
			const keywordInputValue = keywordInput.val();
			const blank_pattern = /[\s]/g;
			
			if(keywordInputValue == "" || blank_pattern.test(keywordInputValue) == true) {
				alert("검색어를 입력해주세요.");
				return;
			}
			
			self.location = "list" + '${pageMaker.makeQuery(1)}' + 
							"&searchType=" + $(".searchType option:selected").val() + 
							"&searchDate=" + $(".searchDate option:selected").val() +
							"&keyword=" + encodeURIComponent($('#keywordInput').val());
		});
	});
</script>
</head>
<body>

<c:import url="/header"></c:import>
<c:import url="/sidebar"></c:import>

 <main id="main" class="main">

    <div class="container pagetitle" style="width:860px; margin:0 auto;">
      <h1>전체 글 보기</h1>
    </div><!-- End Page Title -->

	<div class="container" style="width:860px; margin:0 auto;">
		<form role="form" method="get">
			<table class="table table-sm bg-white" style="border-collapse:inherit;">
			  <div>
				  <span style="float:left; margin-top:7px;">${pageMaker.totalCount}개의 글</span>
				  <span style="float:right; margin-bottom:2px;">
					<select class="form-select form-select-sm" aria-label="Default select example">
					  <option selected>5개씩</option>
					  <option value="1">10개씩</option>
					  <option value="2">15개씩</option>
					  <option value="3">20개씩</option>
					</select>
				  </span>
			  </div>
			  <div style="clear:both;"></div>
			  <hr style="border:1px solid black;" />
			  <thead>
				<tr>
				  <th class="col-1"></th>
				  <th class="col-6 text-center">제목</th>
				  <th class="col-2">작성자</th>
				  <th class="col-2 text-center">작성일</th>
				  <th class="col-1 text-center">조회</th>
				</tr>
			  </thead>
			  <tbody>
			  	<c:forEach items="${articleList}" var="article">		  	
					<tr>
					  <td class="text-truncate" style="vertical-align: middle;">
					  	<span>
					  		<%-- 
					  		<div class="badge badge-sm badge-success" style="background:red;">
					  			${article.acategoryno}
					  		</div>
					  		--%>
					  		${article.acategoryno}
					  	</span>
					  </td>
					  <td class="text-left text-truncate">
					  	<a id="atitle" 
					  	   href="/article/view?ano=${article.ano}&page=${scri.page}&perPageNum=${scri.perPageNum}&searchType=${scri.searchType}&searchDate=${scri.searchDate}&keyword=${scri.keyword}">
					  		<span style="color:#959595;">[${article.acategorynoref}]</span>
					  		<span>${article.atitle}</span>
					  	</a>
					  </td>
					  <td class="text-truncate">
					    <div class="filter">
							<a class="icon" href="#" data-bs-toggle="dropdown" style="color:black;">${article.mnickname}</a>
							<ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow">
							  <li><a class="dropdown-item" href="#">Today</a></li>
							  <li><a class="dropdown-item" href="#">This Month</a></li>
							  <li><a class="dropdown-item" href="#">This Year</a></li>
							</ul>
						</div>
						<!--  
					  	<span class="dropdown">
					  		${article.mnickname}
					  	</span>
					  	-->
					  </td>
					  <td class="text-center text-truncate">
					  	<span>
					  		<fmt:formatDate value="${article.ainsertdate}" pattern="yyyy.MM.dd."></fmt:formatDate>
					  	</span>
					  </td>
					  <td class="text-center text-truncate">
					  	<span>${article.aviewcnt}</span>
					  </td>
					</tr>
			  	</c:forEach>
			  </tbody>
			</table>
	
			<nav aria-label="Page navigation example ">
			  <ul class="pagination pagination-sm justify-content-center">
			  	<c:if test="${pageMaker.prev}">
					<li class="page-item ms-1 me-1">
					  <a class="page-link" href="list${pageMaker.makeSearch(pageMaker.startPage - 1)}" aria-label="Previous">
						<span aria-hidden="true">&laquo; 이전</span>
					  </a>
					</li>
				</c:if>
				
				<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
					<li class="page-item ms-1 me-1 <c:out value="${idx == pageMaker.cri.page ? 'active' : ''}"/>">
						<a class="page-link" href="list${pageMaker.makeSearch(idx)}">${idx}</a>
					</li>
				</c:forEach>
				
				<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
					<li class="page-item ms-1 me-1">
					  <a class="page-link" href="list${pageMaker.makeSearch(pageMaker.endPage + 1)}" aria-label="Next">
						<span aria-hidden="true">다음 &raquo;</span>
					  </a>
					</li>
				</c:if>
			  </ul>
			</nav>
	
			<div class="container">
				<div style="width:100%; text-align:center;">
				  <div class="search" style="display:inline-block">
					<select class="form-select form-select-sm searchDate">
					  <option value="all" <c:out value="${scri.searchDate eq 'all' ? 'selected' : ''}"/>>전체기간</option>
					  <option value="1d" <c:out value="${scri.searchDate eq '1d' ? 'selected' : ''}"/>>1일</option>
					  <option value="1w" <c:out value="${scri.searchDate eq '1w' ? 'selected' : ''}"/>>1주</option>
					  <option value="1m" <c:out value="${scri.searchDate eq '1m' ? 'selected' : ''}"/>>1개월</option>
					  <option value="6m" <c:out value="${scri.searchDate eq '6m' ? 'selected' : ''}"/>>6개월</option>
					  <option value="1y" <c:out value="${scri.searchDate eq '1y' ? 'selected' : ''}"/>>1년</option>
					</select>
				  </div>
	
				  <div class="search" style="display:inline-block">
					<select class="form-select form-select-sm searchType">
					  <option value="c" <c:out value="${scri.searchType eq 'c' ? 'selected' : ''}"/>>게시글</option>
					  <option value="t" <c:out value="${scri.searchType eq 't' ? 'selected' : ''}"/>>제목만</option>
					  <option value="w" <c:out value="${scri.searchType eq 'w' ? 'selected' : ''}"/>>글작성자</option>
					  <%-- 
					  <option value="n" <c:out value="${scri.searchType == null ? 'selected' : ''}"/>>댓글내용</option>
					  <option value="n" <c:out value="${scri.searchType == null ? 'selected' : ''}"/>>댓글작성자</option>
					  --%>
					</select>
				  </div>
	
				  <div style="display:inline-block">
					<div class="input-group">
					  <input type="text" id="keywordInput" name="keyword" class="form-control form-control-sm" 
					  		 value="${scri.keyword}" placeholder="검색어를 입력해주세요">
					  <button class="btn btn-success btn-sm" type="button" id="searchBtn">검색</button>
					</div>
				  </div>
				</div>
			</div>
		
		</form>
		
		<div id="writeBtn" class="btn btn-success btn-sm mt-2">글쓰기</div>

	</div>

  </main><!-- End #main -->

<c:import url="/footer"></c:import>

</body>
</html>