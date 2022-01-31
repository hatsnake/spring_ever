<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Document</title>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="/summernote/js/summernote-lite.js"></script>
	<script src="/summernote/js/lang/summernote-ko-KR.js"></script>
	<link rel="stylesheet" href="/summernote/css/summernote-lite.css">

	<script>
		$(document).ready(function() {
			//여기 아래 부분
			$('#summernote').summernote({
				  height: 300,                 // 에디터 높이
				  minHeight: null,             // 최소 높이
				  maxHeight: null,             // 최대 높이
				  focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
				  lang: "ko-KR",					// 한글 설정
				  placeholder: '최대 2048자까지 쓸 수 있습니다',	//placeholder 설정
				  toolbar: [
					    // [groupName, [list of button]]
					    ['fontname', ['fontname']],
					    ['fontsize', ['fontsize']],
					    ['style', ['bold', 'italic', 'underline','strikethrough', 'clear']],
					    ['color', ['forecolor','color']],
					    ['table', ['table']],
					    ['para', ['ul', 'ol', 'paragraph']],
					    ['height', ['height']],
					    ['insert',['picture','link','video']],
					    ['view', ['fullscreen', 'help']]
					  ],
				fontNames: ['Arial', 'Arial Black', 'Comic Sans MS', 'Courier New','맑은 고딕','궁서','굴림체','굴림','돋움체','바탕체'],
				fontSizes: ['8','9','10','11','12','14','16','18','20','22','24','28','30','36','50','72'],
					
			});
		});
	</script>
</head>
<body>

<c:import url="/header"></c:import>
<c:import url="/sidebar"></c:import>

<main id="main" class="main">

<div class="container">
	<div style="width:862px; margin:0 auto;">
		<form method="post">
			<textarea id="summernote" name="editordata"></textarea>
		</form>
	</div>
</div>

</main>

<c:import url="/footer"></c:import>

</body>
</html>