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
	<div>
		<h1>즐겨 찾기 추가하기</h1>
		<div>제목</div>
		<input type="text" id="name" name="name" class="col-12 form-control"><br>
		<div>주소</div>
		<input type="text" id="url" name="url" class="col-12 form-control" ><br>
		<input type="button" id="bookMarkBtn" class="btn btn-success col-12" value="추가"><br>
	</div>
	
	<script>
		$(document).ready(function() {
			$("#bookMarkBtn").on('click', function(){
				//alert("클릭");
				let name = $("#name").val();
				if(name == "") {
					alert("이름을 입력하세요");
					return false;
				}
				
				let url = $("#url").val();
				if(url == "" || url.startsWith('http') == false) {
					alert("정확한 url를 입력하세요");
					return false;
				}
				
				
				console.log(name);
				console.log(url);
				
				$.ajax({
					//request
					type:"post"
					,url:"/lesson06/quiz01/add-bookMark"
					,data:{"name":name, "url":url}
					//response
					,success:function(data) {
						alert(data);
						if(data =="성공") {
							location.href = "/lesson06/quiz01/after-add-bookMark-view"
						}
					}
					,error:function(request, status, error) {
						alert(request);
						alert(status);
						alert(error);
					}
				});
			}); //click
		});
	</script>
</body>
</html>