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
		  <hr style="border:1px solid black;">
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
				  </th>
				  <td class="text-left text-truncate">
				  	<a id="atitle" href="/article/view/${article.ano}">
				  		<span style="color:#959595;">[${article.acategorynoref}]</span>
				  		<span>${article.atitle}</span>
				  	</a>
				  </td>
				  <td class="text-truncate">
				  	<span>${article.awriter}</span>
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
				  <a class="page-link" href="list${pageMaker.makeQuery(pageMaker.startPage - 1)}" aria-label="Previous">
					<span aria-hidden="true">&laquo; 이전</span>
				  </a>
				</li>
			</c:if>
			
			<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">			
				<li class="page-item ms-1 me-1">
					<a class="page-link" href="list${pageMaker.makeQuery(idx)}">${idx}</a>
				</li>
			</c:forEach>
			
			<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
				<li class="page-item ms-1 me-1">
				  <a class="page-link" href="list${pageMaker.makeQuery(pageMaker.endPage + 1)}" aria-label="Next">
					<span aria-hidden="true">다음 &raquo;</span>
				  </a>
				</li>
			</c:if>
		  </ul>
		</nav>

		<div class="container">
			<div style="width:100%; text-align:center;">
			  <div style="display:inline-block">
				<select class="form-select form-select-sm">
				  <option selected>전체기간</option>
				  <option value="1">1일</option>
				  <option value="2">1주</option>
				  <option value="3">1개월</option>
				  <option value="3">6개월</option>
				  <option value="3">1년</option>
				</select>
			  </div>

			  <div style="display:inline-block">
				<select class="form-select form-select-sm">
				  <option selected>게시글</option>
				  <option value="1">제목만</option>
				  <option value="2">글작성자</option>
				  <option value="3">댓글내용</option>
				  <option value="3">댓글작성자</option>
				</select>
			  </div>

			  <div style="display:inline-block">
				<div class="input-group">
				  <input type="text" class="form-control form-control-sm" placeholder="검색어를 입력해주세요" aria-label="Recipient's username" aria-describedby="button-addon2">
				  <button class="btn btn-success btn-sm" type="button" id="button-addon2">검색</button>
				</div>
			  </div>
			</div>
		<div>
		
		<div id="writeBtn" class="btn btn-success btn-sm">글쓰기</div>

	</div>

  </main><!-- End #main -->

<c:import url="/footer"></c:import>

</body>
</html>