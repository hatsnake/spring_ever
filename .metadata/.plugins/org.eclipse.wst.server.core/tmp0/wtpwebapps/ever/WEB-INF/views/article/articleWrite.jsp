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
	
	<link href="https://www.jqueryscript.net/css/jquerysctipttop.css" rel="stylesheet" type="text/css">
	<link href="/tagsinput/tagsinput.css" rel="stylesheet" type="text/css">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/typeahead.js/0.11.1/typeahead.bundle.min.js"></script>
	<script src="/tagsinput/tagsinput.js"></script>

	<script>
		$(document).ready(function() {

			$("#writeBtn").on("click", function() {
				/*
				const count = $(".hashtag").length;
				let hashtagText = "";
				for(let i=0; i<count; i++) {
					hashtagText += $(".hashtag").get(i).textContent + ",";
				}
				
				$("#atag").val(hashtagText.slice(0, -1));
				*/
				
				const writeForm = $("#writeForm"); 
				writeForm.attr("action", "/article/write");
				writeForm.attr("method", "post");
				writeForm.submit();
			});
			
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
					    ['view', ['fullscreen', 'help', 'codeview']]
					  ],
				fontNames: ['Arial', 'Arial Black', 'Comic Sans MS', 'Courier New','맑은 고딕','궁서','굴림체','굴림','돋움체','바탕체'],
				fontSizes: ['8','9','10','11','12','14','16','18','20','22','24','28','30','36','50','72'],
				disableResizeEditor: true,
				callbacks: {
					/*
					onImageUpload: function(files, editor, welEditable) {
						for(let file of files) {
							if(file.size > 1024 * 1024 * 5) {
								alert("이미지는 5MB 미만입니다.");
								return;
							}
							if(file.name.substring(file.name.lastIndexOf(".") + 1).toUpperCase() != "JPG") {
								alert("JPG 이미지 형식만 가능합니다.");
							}
						}
						
						for(let file of files) {
							sendFile(file, this);
						}
					}	
					*/
					onImageUpload: function(files) {
						sendFile(files[0], this);
					}
					
				}
			});
			
			$(".note-statusbar").hide();
			
		});
		
		// 비동기로 파일을 저장하고 파일명을 이미지 태그에 url을 심어서 날린다.
		function sendFile(file, editor) {
			let data = new FormData();
			data.append("file", file);
			console.log(file);
			
			$.ajax({
				data: data,
				type: "post",
				url: "/article/uploadImage",
				contentType: false,
				processData: false,
				success: function(data) {
					console.log(data);
					console.log(editor);
					$(editor).summernote("editor.insertImage", data.url);
				}
			});
		}
		
		// 특수문자 입력 방지
		function characterCheck(obj){
		var regExp = /[ \{\}\[\]\/?.,;:|\)*~`!^\-_+┼<>@\#$%&\'\"\\\(\=]/gi; 
		// 허용할 특수문자는 여기서 삭제하면 됨
		// 지금은 띄어쓰기도 특수문자 처리됨 참고하셈
		if( regExp.test(obj.value) ){
			obj.value = obj.value.substring( 0 , obj.value.length - 1 ); // 입력한 특수문자 한자리 지움
			}
		}
	</script>
	<style>
		.container { margin: 150px auto; }
		h2 { margin:20px auto; font-size:14px;}
		.badge { margin: 2px 3px !important; background: #ecf0f1 !important;}
		.test { font-size:12px; background:#ecf0f1 !important; border-radius:3px; padding:1px !important; margin:1px !important;}	
	</style>
</head>
<body>

<c:import url="/header"></c:import>
<c:import url="/sidebar"></c:import>

<main id="main" class="main">

<div class="container" style="margin: 50px auto;">
	<div style="width:862px; margin:0 auto;">
		<div class="clearfix">
			<div class="float-start fw-bold fs-3" style="line-height:40px;">카페 글쓰기</div>
			<div id="writeBtn" class="float-end btn btn-success">등록</div>
		</div>
		<hr>
		<form id="writeForm" name="writeForm">
			<input type="hidden" name="awriter" value="${member.mno}">
			<input type="hidden" name="ainsertid" value="${member.mno}">
			<!-- hashTag 값 -->
			<input type="hidden" id="atag" name="atag">
			<div class="row mb-2">
				<select class="form-select me-2" name="acategoryno" style="width:630px; margin-left:12px;">
					<option value="1" selected>1</option>
					<option value="2">2</option>
					<option value="3">3</option>
				</select>
				<select class="form-select" name="acategorynoref" style="width:224px;">
					<option value="1" selected>1</option>
					<option value="2">2</option>
					<option value="3">3</option>
				</select>
			</div>
			<input type="text" class="form-control" name="atitle" id="atitle" placeholder="제목을 입력해 주세요.">
			<div class="mt-2">
				<textarea id="summernote" name="acontent"></textarea>
				<div>
					<input type="text" data-role="tagsinput" value="">
				</div>
			</div>
		</form>
	</div>
</div>

</main>

<c:import url="/footer"></c:import>

<script type="text/javascript">

  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-36251023-1']);
  _gaq.push(['_setDomainName', 'jqueryscript.net']);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();

</script>

</body>
</html>