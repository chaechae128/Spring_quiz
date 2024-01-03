<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>북마크 추가</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">

<%--AJAX를 사용하려면 jquery 원본 필요 --%>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>

</head>
<body>
	<div class="container">
		<h1>즐겨 찾기 추가하기</h1>
		<div>제목</div>
		<input type="text" id="name" class="col-11 form-control"><br>
		<div>주소</div>
		<div class="form-inline">
			<input type="text" id="url" class="col-10 form-control" >
			<button class="btn btn-info ml-3 col-1" type="button" id="urlCheckBtn">중복확인</button>
		</div>
		<small id="duplicationText" class="text-danger d-none">중복된 url 입니다</small>
		<small id="availableUtlText" class="text-success d-none">저장 가능한 url 입니다.</small>
		<input type="button" id="addBtn" class="btn btn-success col-12 mt-3" value="추가"><br>
	</div>
	
	<script>
		$(document).ready(function() {
			//중복확인 버튼 클릭
			$('#urlCheckBtn').on('click', function(){
				//하위 태그 초기화
				$('#urlStatusArea').empty();
				
				let url = $("#url").val().trim();
				if(!url) {
					alert("주소를 입력하세요");
					return false;
				}
				
				$.ajax({
					//request
					type:"POST" //주소가 길기 때문
					,url:"/lesson06/quiz01/is-duplication-url"
					,data:{"url":url}
					//response
					,success:function(data) { //data: JSON String =>dictionary
						if(data.is_duplication) {
							//중복일 때
							$('#duplicationText').removeClass("d-none");
							$('#availableUtlText').addClass("d-none");
						} else {
							$('#availableUtlText').removeClass("d-none");
							$('#duplicationText').addClass("d-none");
						}
					}
					,error:function(request, status, error){
						alert("url 중복확인에 실패했습니다.");
					}
				});
			});
			
			//추가 버튼 클릭
			$("#addBtn").on('click', function() {
				//alert("클릭");
				
				//validation
				let name = $("#name").val().trim();
				if(name.length < 1) {
					alert("이름을 입력하세요");
					return false; // 서브밋x
				}
				
				let url = $("#url").val().trim();
				if(!url) {
					alert("주소를 입력하세요");
					return false;
				}
				 if(url.startsWith("http://") == false && url.startsWith("https://") == false){
					alert("주소 형식이 잘못 되었습니다.");
					return false;
				} 
				 
				$.ajax({
					//request 
					type:"POST"
					, url:"/lesson06/quiz01/add-bookMark"
					, data:{"name":name, "url":url}
				
					//response - call back 함수  
					, success:function(data) { //data: JSON String => jquery ajax함수가 parsing 과정 거친 후 => dictionary가 됨
						//alert(data.code);
						if(data.code == 200) {  //혹은 data.result == "성공"
							location.href = "/lesson06/quiz01/after-add-bookMark-view"
						}
					}
					, error:function(request, status, error){
						alert(request);
						alert(status);
						alert(error);
					}
				});//ajax끝
			});//click
			
		});//document
	</script>
</body>
</html>