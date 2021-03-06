<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드 테스트</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

<script>
	$(document).ready(function() {
		$(".fileDrop").on("dragenter dragover", function(event) {
			event.preventDefault();
		});
		
		$(".fileDrop").on("drop", function(event) {
			event.preventDefault();
			const files = event.originalEvent.dataTransfer.files;
			const file = files[0];
			console.log(file);
			
			const formData = new FormData();
			formData.append("file", file);
			
			$.ajax({
				url: "/uploadAjax",
				method: "post",
				data: formData,
				dataType: "text",
				processData: false,
				contentType: false,
				success: function(data) {
					let str = "";
					if(checkImageType(data)) {
						/*
						str = `
							<div>
								<a href="/upload/displayFile?fileName=${"${getImageLink(data)}"}">
									<img src="/upload/displayFile?fileName=${"${data}"}">
								</a>
							</div>
						`;
						*/
						str = `
							<img src="/upload/displayFile?fileName=${"${data}"}" style="width:100px; height:100px; border-radius:50px;">
						`;
					}
					
					$(".fileDrop").html(str);
				}
			});
		});
		
		$("#file").on("change", function(e) {
			//const files = event.originalEvent.dataTransfer.files;
			//const file = files[0];
			const file = $("#file")[0].files[0];
			console.log(file);
			const fileName = file.name;
			let ext = fileName.substring(fileName.lastIndexOf(".") + 1);
			ext = ext.toLowerCase();
			
			if(ext != "jpg" && ext != "jpeg" && ext != "gif" && ext != "png" && ext != "bmp") {
				alert("썸네일은 이미지만 가능합니다.");
				return;
			}
			
			const formData = new FormData();
			formData.append("file", file);
			
			$.ajax({
				url: "/uploadAjax",
				method: "post",
				data: formData,
				dataType: "text",
				processData: false,
				contentType: false,
				success: function(data) {
					let str = "";
					if(checkImageType(data)) {
						
						//str = `
						//	<div>
						//		<a href="/upload/displayFile?fileName=${"${getImageLink(data)}"}">
						//			<img src="/upload/displayFile?fileName=${"${data}"}">
						//		</a>
						//	</div>
						//`;
						
						str = `
							<img id="profileImg" src="/upload/displayFile?fileName=${"${data}"}" style="width:100px; height:100px; border-radius:50%;">
						`;
						$("#profile").val(data);
					}
					
					$(".uploadedList").html(str);
				}
			});			
		});
		
	});
	
	function getOriginalName(fileName) {
		if(checkImageType(fileName)) {
			return;
		}
		
		const idx = fileName.indexOf("_") + 1;
		return fileName.substr(idx);
	}
	
	function getImageLink(fileName) {
		if(!checkImageType(fileName)) {
			return;
		}
		
		const front = fileName.substr(0, 12);
		const end = fileName.substr(14);
		
		return front + end; 
	}
	
	function checkImageType(fileName) {
		const pattern = /jpg|gif|png|jped/i;
		return fileName.match(pattern);
	}
	
	function onClickUpload() {
		let myInput = document.getElementById("file");
		myInput.click();
	}
	
	function removeImage() {
		console.log("remove");
		$("#profileImg").attr("src", "/upload/displayFile?fileName=/default.png")
		$("#profile").val("default.png");		
	}
</script>
<style>
	.fileDrop {
		width:600px;
		height:200px;
		border:1px dotted blue;
	}
	
	small {
		margin-left:3px;
		font-weight:bold;
		color:gray;
	}
</style>
</head>
<body>
	<h1>파일 업로드 하기</h1>
	
	<form method="post" action="/upload">
		<input type="hidden" name="profile" id="profile" value="default.png">
		<div>아이디</div>
		<input type="text" name="id"> <br>
		<div>이름</div>
		<input type="text" name="name"> <br>
		<div>파일</div>
		<div class="fileDrop"></div>
		<div class="uploadedList" style="width:100px; height:100px; border-radius:50%; background:gray;">
			<img id="profileImg" src="/upload/displayFile?fileName=/default.png" 
				 style="width:100px; height:100px; border-radius:50%;">
		</div>
		<input type="file" id="file" name="file" accept="image/*" style="display:none;">
		<input type="button" onclick="onClickUpload()" value="이미지 변경">
		<input type="button" onclick="removeImage()" value="삭제">
		<br>
		<input type="submit" value="업로드">
	</form>
</body>
</html>