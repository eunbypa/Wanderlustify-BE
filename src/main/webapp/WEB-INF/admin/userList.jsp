<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<%@ include file="../common/header.jsp" %>
<%@ include file="../common/nav.jsp" %>
<%-- <c:set var="cnt" value="0"/>
<h1 class = "d-flex flex-row justify-content-center mt-3 ">전체 회원 목록</h1>
<hr>
<div class = "container mt-3">
<c:forEach var = "user" items = "${users}">
<c:if test="${cnt%3 eq 0}"><hr class = "border border-4 border-dark"></c:if>
<div class = "border border-3 bg-light mt-2 mb-2 " style = "margin-left: 70px; display:inline-block; height: 180px; width: 300px;">
<div>&nbsp;회원 유형 : 
<c:if test ="${user.isAdmin eq true}">관리자&nbsp;</c:if>
<c:if test ="${user.isAdmin eq false}">일반 회원&nbsp;</c:if>
</div>
<div>&nbsp;회원 이름 : ${user.name}&nbsp;</div>
<div>&nbsp;회원 아이디 : ${user.id}&nbsp;</div>
<div>&nbsp;회원 비밀번호 : ${user.password}&nbsp;</div>
<div>&nbsp;회원 이메일 : ${user.email}&nbsp;</div>
<c:if test ="${user.flag eq 0}"><div>&nbsp;회원 상태 : 가입&nbsp;</div></c:if>
<c:if test ="${user.flag eq 1}">회원 상태 : 탈퇴&nbsp;</c:if>
</div>
<c:set var="cnt" value="${cnt + 1}"/>
</c:forEach>
</div>  --%>
 <section id="about" class="about" style="background-color: #f5f9fc; padding-bottom: 60px">
        <div class="container" data-aos="fade-up">
          <div class="row no-gutters" style="background-color: white">
            <div class="p-5 text-center">
              <h3 class="my-5 fw-bold">회원목록</h3>
              <div class="w-75 mx-auto mb-3">
              <div class="col-md-7 offset-5">
              
              <form class="d-flex justify-content-center" id="form-search"
								action="">
								<input type="hidden" name="pgno" value="1" /> <select
									name="key" id="key"
									class="form-select form-select-sm ms-5 me-1 w-50"
									aria-label="검색조건">
									<option selected>검색조건</option>
									<option value="userName">이름</option>
					                  <option value="userId">아이디</option>
					                  <option value="email">이메일</option>
								</select>
								<div class="input-group input-group-sm justify-conent-center"
									style="width: 300px;">
									<input type="text" name="word" id="word" class="form-control"
										placeholder="검색어..." />
									<button id="btn-search" class="btn btn-dark" type="button">검색</button>

								</div>

							</form>
              </div>
            </div>
              <table class="table w-75 m-auto mb-3">
                <thead class="table-dark">
                  <tr>
                  	<th>번호</th>
                    <th>이름</th>
                    <th>아이디</th>
                    <th>이메일</th>
                    <th>가입일자</th>
                    <th></th>
                  </tr>
                </thead>
                <tbody id="userinfo">
                <c:forEach var="user" items="${users}" varStatus="vs">
                <tr>
                <td>${vs.count}</td>
                <td>${user.name}</td>
                <td>${user.id}</td>
                <td>${user.email}</td>
                <td>${user.joinDate}</td>
                <td><form id="form-del" method="get" action="${root}/admin/deleteUser">
                <input type="hidden" name="userId" value="${user.id}" />
                <button class="btn btn-outline-danger btn-sm" id="btn-del" onClick="alert('탈퇴 완료되었습니다.')">삭제</button>
                </form>
                </td>
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
    <form id="form-no-param" method="get" action="${root}/member/detail">
      <input type="hidden" name="pgno" value="${pgno}">
      <input type="hidden" name="key" value="${key}">
      <input type="hidden" name="word" value="${word}">
      <input type="hidden" id="userid" name="userId" value="">
    </form>
      </section>
      <!-- End About Us Section -->
      <script>
    
    document.querySelector("#btn-search").addEventListener("click", function () {
  	  let form = document.querySelector("#form-search");
        form.setAttribute("action", "${root}/admin/user");
        form.submit();
    });
    
    let pages = document.querySelectorAll(".page-link");
    pages.forEach(function (page) {
      page.addEventListener("click", function () {
     	  document.querySelector("#pgno").value = this.parentNode.getAttribute("data-pg");
        let form = document.querySelector("#form-param");
        form.setAttribute("action", "${root}/admin/user");
        form.submit();
      });
    });
    </script>
<%@ include file="../common/footer.jsp" %>