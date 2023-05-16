<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<%@ include file="../common/header.jsp" %>
<%@ include file="../common/nav.jsp" %>
<%-- 
<div class="row justify-content-center">
	<div class="container row align-self-center">
	<div class = "row ">
		<div class = "col-1 offset-1 mt-2 p-0 bg-light" style = "text-align: center; height: 200px;">
			<div class = "bg-primary text-light">
        		<h5 class = "m-0 p-1">게시판 목록</h5>
        	 </div>
        	 <hr class = "m-0 p-0 border border-3 border-dark">
        	<c:if test ="${curLoc eq 'announce'}">
        	<div class = "m-0 bg-primary">
        		<a class = "p-2 text-light" href = "${root}/board/board?isnotice=1" style ="text-decoration: none; ">공지사항</a>
        	 </div>
        	 </c:if>
        	 <c:if test ="${curLoc ne 'announce'}">
        	<div class = "m-0 bg-light">
        		<a class = "p-2 text-dark" href = "${root}/board/board?isnotice=1" style ="text-decoration: none; ">공지사항</a>
        	 </div>
        	 </c:if>
        	 <hr class = "m-0 p-0 border border-2 border-dark">
        	 <c:if test ="${curLoc eq 'board'}">
        	<div class = "m-0 bg-primary">
        		<a class = "p-2 text-light" href = "${root}/board/board" style ="text-decoration: none; ">공유게시판</a>
        	 </div>
        	 </c:if>
        	 <c:if test ="${curLoc ne 'board'}">
        	<div class = "m-0 bg-light">
        		<a class = "p-2 text-dark" href = "${root}/board/board" style ="text-decoration: none; ">공유게시판</a>
        	 </div>
        	 </c:if>
        </div>
        <div class = "col-1">
        </div>
        <div class="col-9 justify-content-center">
        <div class ="">
        <div class="col-lg-8 col-md-10 col-sm-12">
          <h2 class="my-3 py-3 shadow-sm bg-light text-center">
            글목록
          </h2>
        </div>
        <div class="col-lg-8 col-md-10 col-sm-12">
          <div class="row align-self-center mb-2">
            <div class="col-md-2 text-start">
              <button type="button" id="btn-mv-register" class="btn btn-outline-primary btn-sm">
                글쓰기
              </button>
            </div>
            <div class="col-md-7 offset-3">
              <form class="d-flex" id="form-search" action="">
                <input type="hidden" name="action" value="list"/>
                <input type="hidden" name="pgno" value="1"/>
                <select
                  name="key"
                  id="key"
                  class="form-select form-select-sm ms-5 me-1 w-50"
                  aria-label="검색조건"
                >
                  <option selected>검색조건</option>
                  <option value="article_no">글번호</option>
                  <option value="subject">제목</option>
                  <option value="user_id">작성자</option>
                </select>
                <div class="input-group input-group-sm">
                  <input type="text" name="word" id="word" class="form-control" placeholder="검색어..." />
                  <button id="btn-search" class="btn btn-dark" type="button">검색</button>
                </div>
              </form>
            </div>
          </div>
          <table class="table table-hover">
            <thead>
              <tr class="text-center">
                <th scope="col">글번호</th>
                <th scope="col">제목</th>
                <th scope="col">작성자</th>
                <th scope="col">조회수</th>
                <th scope="col">작성일</th>
              </tr>
            </thead>
            <tbody>    
				<c:forEach var="article" items="${articles}">    
	              <tr class="text-center">
	                <th scope="row">${article.articleNo}</th>
	                <td class="text-start">
	                  <a
	                    href="#"
	                    class="article-title link-dark"
	                    data-no="${article.articleNo}"
	                    style="text-decoration: none"
	                  >
	                    ${article.subject}
	                  </a>
	                </td>
	                <td>${article.userId}</td>
	                <td>${article.hit}</td>
	                <td>${article.registerTime}</td>
	              </tr>            
				</c:forEach>   
            </tbody>
          </table>
        </div>
        <div class="row">
          ${navigation.navigator}
        </div>
      </div>
      </div>
      </div>
      </div>
      </div>
    </div>
    <form id="form-param" method="get" action="">
      <input type="hidden" id="p-action" name="action" value="">
      <input type="hidden" id="p-pgno" name="pgno" value="">
      <input type="hidden" id="p-key" name="key" value="">
      <input type="hidden" id="p-word" name="word" value="">
    </form> 
   --%>
   <!-- ======= About Us Section ======= -->
	<section id="about" class="about"
		style="background-color: #f5f9fc; padding-bottom: 60px">
		<div class="container" data-aos="fade-up">
		<div class = "container row align-self-center ">
		<div class = "row ">
		<div class = "col-3 m-0 p-0 bg-light">
		<div class = "m-0 bg-dark">
        		<a class = "p-2 text-light" href = "${root}/board/board?isnotice=1" style ="text-decoration: none; ">공지사항</a>
        	 </div>
        	 </div>
        	 <div class = "col-1 m-0 p-0 bg-light">
				<div class = "m-0 bg-light">
        		
        	 </div>
        	 </div>
        	 <div class = "col-3 m-0 p-0 bg-light">
        	 <div class = "m-0 bg-dark">
        		<a class = "p-2 text-light" href = "${root}/board/board?isnotice=0" style ="text-decoration: none; ">공유게시판</a>
        	 </div>
        	 </div>
        </div>
        </div>                    
		</div>
			<div class="row no-gutters" style="background-color: white">
				<div class="p-5 text-center">
					<h3 class="my-5 fw-bold">여행정보공유</h3>
					<div class="w-75 mx-auto mb-3 row">

						<div class="col-md-5 ps-0">
							<button type="button" id="btn-mv-register"
								class="btn btn-outline-dark btn-sm float-start">글쓰기</button>
						</div>
						<div class="col-md-7 pe-0">

							<form class="d-flex justify-content-center" id="form-search"
								action="">
								<input type="hidden" name="pgno" value="1" /> <select
									name="key" id="key"
									class="form-select form-select-sm ms-5 me-1 w-50"
									aria-label="검색조건">
									<option selected>검색조건</option>
									<option value="subject">제목</option>
									<option value="userid">작성자</option>
									<option value="content">내용</option>
								</select>
								<div class="input-group input-group-sm justify-conent-center"
									style="width: 300px;">
									<input type="text" name="word" id="word" class="form-control"
										placeholder="검색어..." />
									<button id="btn-search" class="btn btn-dark" type="button">검색</button>

								</div>

							</form>
							<%-- <button class="btn btn-outline-dark btn-sm float-end mt-3" onClick="location.href='${root}/board?action=board&key=${param.key}&word=${param.word}'">최신순 정렬</button>
              <button class="btn btn-outline-dark btn-sm float-end mt-3" onClick="location.href='${root}/board?action=sort&key=${param.key}&word=${param.word}'">추천순 정렬</button> --%>

						</div>
					</div>
					<table class="table w-75 m-auto mb-3">
						<thead class="table-dark">
							<tr>
								<th>글번호</th>
								<th>제목</th>
								<th>작성자</th>
								<th>조회수</th>
								<th>작성일</th>
							</tr>
						</thead>
						<tbody id="articleinfo">
							<c:forEach var="board" items="${boards}" varStatus="vs">
								<tr>
									<td>${vs.count}</td>
									<td><a href="#" class="article-title link-dark"
										data-no="${board.articleNo}" style="text-decoration: none">${board.subject}</a></td>
									<td>${board.userId}</td>
									<td>${board.hit}</td>
									<td>${board.date}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div>${navigation.navigator}</div>
			</div>
		</div>
		<form id="form-param" method="get" action="">
      <input type="hidden" name="pgno" id="pgno" value="${pgno}">
      <input type="hidden" name="key" value="${key}">
      <input type="hidden" name="word" value="${word}">
    </form>
    <form id="form-no-param" method="get" action="${root}/board/detail">
      <input type="hidden" name="pgno" value="${pgno}">
      <input type="hidden" name="key" value="${key}">
      <input type="hidden" name="word" value="${word}">
      <input type="hidden" id="articleno" name="articleno" value="">
    </form>
	</section>
	<!-- End About Us Section -->
    <script>
      /* 
      let titles = document.querySelectorAll(".article-title");
      titles.forEach(function (title) {
        title.addEventListener("click", function () {
          console.log(this.getAttribute("data-no"));
          location.href = "${root}/board?action=view&articleno=" + this.getAttribute("data-no");
        });
      });

      document.querySelector("#btn-mv-register").addEventListener("click", function () {
        location.href = "${root}/board?action=mvwrite";
      });
      
      document.querySelector("#btn-search").addEventListener("click", function () {
    	  let form = document.querySelector("#form-search");
          form.setAttribute("action", "${root}/board");
          form.submit();
      });
      
      let pages = document.querySelectorAll(".page-link");
      pages.forEach(function (page) {
        page.addEventListener("click", function () {
          console.log(this.parentNode.getAttribute("data-pg"));
          document.querySelector("#p-action").value = "list";
       	  document.querySelector("#p-pgno").value = this.parentNode.getAttribute("data-pg");
       	  document.querySelector("#p-key").value = "${param.key}";
       	  document.querySelector("#p-word").value = "${param.word}";
          document.querySelector("#form-param").submit();
        });
      }); 
      */
      let titles = document.querySelectorAll(".article-title");
      titles.forEach(function (title) {
        title.addEventListener("click", function () {
          document.querySelector("#articleno").value = this.getAttribute("data-no");
          document.querySelector("#form-no-param").submit();
        });
      });

      document.querySelector("#btn-mv-register").addEventListener("click", function () {
    	  let form = document.querySelector("#form-param");
          form.setAttribute("action", "${root}/board/write");
          form.submit();
      });
      
      document.querySelector("#btn-search").addEventListener("click", function () {
    	  let form = document.querySelector("#form-search");
          form.setAttribute("action", "${root}/board/board");
          form.submit();
      });
      
      let pages = document.querySelectorAll(".page-link");
      pages.forEach(function (page) {
        page.addEventListener("click", function () {
       	  document.querySelector("#pgno").value = this.parentNode.getAttribute("data-pg");
          let form = document.querySelector("#form-param");
          form.setAttribute("action", "${root}/board/board");
          form.submit();
        });
      });
    </script>
<%@ include file="../common/footer.jsp" %>