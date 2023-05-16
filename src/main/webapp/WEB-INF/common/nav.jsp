<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Enjoy Trip</title>
    <!-- Favicon-->
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="/css/search-style.css">
    
    <!-- Bootstrap icons-->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
      rel="stylesheet"
    />
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
      crossorigin="anonymous"
    />
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
      crossorigin="anonymous"
    ></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    <!-- Core theme CSS (includes Bootstrap)-->
    
    <script
      type="text/javascript"
      src="//dapi.kakao.com/v2/maps/sdk.js?appkey=834a88477220c4e7b24e8e874f5c05e7"
    ></script>
  </head>
  <body class="d-flex flex-column h-100">
    <main class="flex-shrink-0">
      <!-- Navigation-->
      <nav class="navbar navbar-expand-lg navbar-dark bg-primary bg-opacity-50">
        <div class="container px-5">
          <a class="navbar-brand" href="${root}/">Enjoy Trip</a>
          <button
            class="navbar-toggler"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
              <li class="nav-item"><a class="nav-link" href="${root}/">Home</a></li>
              <li class="nav-item"><a class="nav-link" href="${root}/attraction">지역별관광지</a></li>
              <c:if test="${not 
              empty loginUser}">
              <li class="nav-item"><a class="nav-link" href="${root}/attraction/myTrip"">나의여행계획</a></li>
              <li class="nav-item"><a class="nav-link" href="${root}/attraction/hotplace">핫플자랑하기</a></li>
              <li class="nav-item"><a class="nav-link" href="${root}/board/board?pgno=1">여행정보공유</a></li>
              <li class="nav-item" onclick="logout();"><a href='${root}/user/logout' class="nav-link">로그아웃</a></li>
              <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                  	회원정보
                </a>
                <ul class="dropdown-menu">
                  <li><a class="dropdown-item" href="" onclick="showUserInfo();" data-bs-toggle="modal" data-bs-target="#userInfoModal">회원정보보기</a></li>
                  <li><a class="dropdown-item" href="" onclick = "setUserInfo();" data-bs-toggle="modal" data-bs-target="#userInfoModifyModal">회원정보수정</a></li>
                  <c:if test="${loginUser.isAdmin eq false}">
                  <li><a class="dropdown-item" href="#" data-bs-toggle="modal" data-bs-target="#userSecessionModal">회원탈퇴</a></li>
               	  </c:if>
                </ul>
              </li>
              </c:if>
              <c:if test="${empty loginUser}">
              <li class="nav-item"><a class="nav-link" data-bs-toggle="modal" data-bs-target="#loginModal">로그인</a></li>
              <li class="nav-item"><a class="nav-link" data-bs-toggle="modal" data-bs-target="#signupModal">회원가입</a></li>
    		  </c:if>
    		  <c:if test="${loginUser.isAdmin eq true}">
              <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                  관리자
                </a>
                <ul class="dropdown-menu">
                  <!-- <li><a class="dropdown-item" href="#" onclick = "showUsersInfo();" data-bs-toggle="modal" data-bs-target="#usersInfoModal">전체회원정보보기</a></li> -->
                <li><a class="dropdown-item" href="${root}/admin/user?pgno=1">전체회원정보보기</a></li>
                </ul>
              </li>
              </c:if>
              <!--
              <li class="nav-item" id = "admin"><a class="nav-link">Admin</a></li>
              -->
            </ul>
          </div>
        </div>
      </nav>