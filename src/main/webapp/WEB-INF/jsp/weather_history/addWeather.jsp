<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>날씨 정보</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="/css/weather_history/add_weather.css">
</head>
<body>
	<div class="container" id="wrap">
		<div class="d-flex main">
			<div class="col-2 menu">
				<img src="/img/foot_logo.png" alt="기상청 로고" class="" width=80px>
				<nav class="mt-3">
					<ul class="nav">
						<li class="nav-item"><a href="#" class="nav-link text-white">날씨</a></li>
						<li class="nav-item"><a href="#" class="nav-link text-white">날씨입력</a></li>
						<li class="nav-item"><a href="#" class="nav-link text-white">테마날씨</a></li>
						<li class="nav-item"><a href="#" class="nav-link text-white">관측기후</a></li>
					</ul>
				</nav>
			</div>
			<div class="col-10">
				<div class="display-4">날씨 입력</div>
				<form method="post" action="" class="mt-3">
					<div class="d-flex">
						<label for="date">날짜</label>
						<input type="text" id="date" name="date" class="form-control">
						<label for="weather">날씨</label>
						<select class="form-control">
							<option>맑음</option>
							<option>구름조금</option>
							<option>흐림</option>
							<option>비</option>
						</select>
						<label for="microDust">미세먼지</label>
						<select class="form-control">
							<option>좋음</option>
							<option>보통</option>
							<option>나쁨<option>
							<option>매우나쁨</option>
						</select>
					</div>
					<div class="d-flex m-3 align-item-center">
						<div class="input-group mb-3">
							<label for="temperatures">기온</label>
							<input type="text" class="form-control ml-2">
		  					<div class="input-group-append">
		    					<span class="input-group-text" id="temperatures">℃</span>
		  					</div>
						</div>
						<div class="input-group mb-3">
							<label for="precipitation">강수량</label>
							<input type="text" class="form-control ml-2">
		  					<div class="input-group-append">
		    					<span class="input-group-text" id="precipitation">mm</span>
		  					</div>
						</div>
						<div class="input-group mb-3">
							<label for="windSpeed">기온</label>
							<input type="text" class="form-control ml-2">
		  					<div class="input-group-append">
		    					<span class="input-group-text" id="windSpeed">km/h</span>
		  					</div>
						</div>
					</div>
					

				</form>
				
			</div>
		</div>
		<footer class="d-flex align-items-center" id="footer">
			<img src="/img/foot_logo.png" alt="기상청 로고" class="m-3 col-2">
			<div class="text-secondary">
				<small>서울 (07062) 서울특별시 동작구 여의대방로16길 61</small>
				<p>Copyright@2022 KMA. All Rights RESERVED.
				<p>
			</div>
		</footer>
	</div>
</body>
</html>