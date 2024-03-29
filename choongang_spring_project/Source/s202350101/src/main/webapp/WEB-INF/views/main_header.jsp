<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
	<div class="container-fluid">
		<a class="navbar-brand" href="/main">PMS</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarCollapse">
			<ul class="navbar-nav me-auto mb-2 mb-md-0">
			<!-- <li class="nav-item">
	            <a class="nav-link active" aria-current="page" href="#">Home</a>
	          </li>
	          <li class="nav-item">
	            <a class="nav-link" href="#">Link</a>
	          </li>
	          <li class="nav-item">
	            <a class="nav-link disabled" aria-disabled="true">Disabled</a>
	          </li> -->
	        </ul>
			<ul class="nav nav-pills">
				<li class="nav-item">
					<a class="nav-link px-2 link-light" aria-current="page" href="#">${userInfo.user_name }</a>
				</li>
			</ul>
			<div class="dropdown text-end">
				<a href="#" class="d-block link-body-emphasis text-decoration-none dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
					<img src="https://github.com/mdo.png" alt="mdo" width="32" height="32" class="rounded-circle">
				</a>
				<ul class="dropdown-menu text-small" style="">
					<li><a class="dropdown-item" href="#">채팅창</a></li>
					<li><a class="dropdown-item" href="mypage_main">내 정보 설정</a></li>
					<li><hr class="dropdown-divider"></li>
					<li><a class="dropdown-item" href="user_logout">로그아웃</a></li>
				</ul>
			</div>
			<div class="d-flex" role="search" style="margin-left:10px">        
				<input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
				<button class="btn btn-outline-secondary" type="submit">Search</button>
			</div>
		</div>
	</div>
</nav>