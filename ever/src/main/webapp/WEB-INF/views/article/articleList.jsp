<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	
	.ellipsis:before {
		content: '';
		display: inline-block;
	}
</style>
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
			  <span style="float:left; margin-top:7px;">3,000,000개의 글</span>
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
			  <th class="col-7 text-center">제목</th>
			  <th class="col-2">작성자</th>
			  <th scope="col">작성일</th>
			  <th class="col-1">조회</th>
			</tr>
		  </thead>
		  <tbody>
			<tr>
			  <td class="ellipsis" style="vertical-align: middle;"><span><div class="badge badge-sm badge-success" style="background:red;">공지</div></span></th>
			  <td class="text-left ellipsis"><span class="">[내가 싼 똥] 핸님들은 뭔가 애착인형같은거 있나여ggggggggggggggggggggggggg</span></td>
			  <td class="ellipsis"><span>김단향</span></td>
			  <td class="ellipsis"><span>2019.09.30.</span></td>
			  <td class="ellipsis"><span>2.2만</span></td>
			</tr>
			<tr>
			  <td class="ellipsis" style="font-size:12px; vertical-align: middle;"><span>유저게시판</span></th>
			  <td class="text-left ellipsis"><span class="">[내가 싼 똥] 핸님들은 뭔가 애착인형같은거 있나여ggggggggggggggggggggggggg</span></td>
			  <td class="ellipsis"><span>김단향</span></td>
			  <td class="ellipsis"><span>2019.09.30.</span></td>
			  <td class="ellipsis"><span>2.2만</span></td>
			</tr>
			<tr>
			  <td class="ellipsis"><span><div class="badge badge-sm badge-success" style="background:red;">공지</div></span></th>
			  <td class="text-left ellipsis"><span class="">[내가 싼 똥] 핸님들은 뭔가 애착인형같은거 있나여ggggggggggggggggggggggggg</span></td>
			  <td class="ellipsis"><span>김단향</span></td>
			  <td class="ellipsis"><span>2019.09.30.</span></td>
			  <td class="ellipsis"><span>2.2만</span></td>
			</tr>
		  </tbody>
		</table>

		<nav aria-label="Page navigation example ">
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

	</div>

  </main><!-- End #main -->

<c:import url="/footer"></c:import>

</body>
</html>