<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<%@ include file="../common/header.jsp" %>
<%@ include file="../common/nav.jsp" %>
<%@ include file="../common/confirm.jsp" %>
<!-- <div class="row justify-content-center">
        <div class="col-lg-8 col-md-10 col-sm-12">
          <h2 class="my-3 py-3 shadow-sm bg-light text-center">
            <mark class="sky">글쓰기</mark>
          </h2>
        </div>
        <div class="col-lg-8 col-md-10 col-sm-12">
          <form id="form-register" method="POST" action="">
          	<input type="hidden" name="action" value="write">
            <div class="mb-3">
              <label for="subject" class="form-label">제목 : </label>
              <input
                type="text"
                class="form-control"
                id="subject"
                name="subject"
                placeholder="제목..."
              />
            </div>
            <div class="mb-3">
              <label for="content" class="form-label">내용 : </label>
              <textarea class="form-control" id="content" name="content" rows="7"></textarea>
            </div>
            <div class="col-auto text-center">
              <button type="button" id="btn-register" class="btn btn-outline-primary mb-3">
                글작성
              </button>
              <button type="reset" class="btn btn-outline-danger mb-3">초기화</button>
            </div>
          </form>
        </div>
      </div>
    </div> -->
      <!-- ======= About Us Section ======= -->
      <section id="about" class="about" style="background-color: #f5f9fc; padding-bottom: 60px">
        <div class="container" data-aos="fade-up">
          <div class="row no-gutters" style="background-color: white">
            <div class="p-5">
            <!-- ===== update start ===== -->
          <div class="modal-header mb-3">
            <h4 class="modal-title">
              <label class="fw-bold border-bottom border-warning border-5">글 작성</label>
            </h4>
          </div>
<div>
              <form id="form-register" method="POST" enctype="multipart/form-data" action="">
          	<input type="hidden" name="pgno" value="1">
		    <input type="hidden" name="key" value="">
		    <input type="hidden" name="word" value="">
            <div class="mb-3">
                <label for="id" class="form-label">작성자:</label>
                <input
                  type="text"
                  class="form-control"
                  id="id"
                  value="${loginUser.id}"
                  name="userId"
                  readonly="readonly"
                />
              </div>
              <c:if test="${loginUser.isAdmin ne false}">
              <div class="mb-3">
                <input type="checkbox" name="isnotice" value='1'/>
				<input type="hidden" name="isnotice" value='0'/>
      			<label for="isnotice">공지</label>
              </div>
              </c:if>
              <div class="mb-3">
                <label for="subject" class="form-label">제목:</label>
                <input type="text" class="form-control" id="subject" name="subject" />
              </div>
              <div class="mb-3">
                <label for="content" class="form-label">내용:</label>
                <textarea class="form-control" rows="10" id="content" name="content"></textarea>
              </div>

          <div class="modal-footer">
            <button
              type="button"
              id="btn-register"
              class="btn btn-outline-primary btn-sm me-1"
            >
              쓰기
            </button>
            <button type="button" id="btn-list" class="btn btn-outline-dark btn-sm">
              목록으로이동
            </button>
          </div>
           </form>
           </div>
        </div>
    <!-- update end -->
            </div>
          </div>
      </section>
      <!-- End About Us Section -->
    <!-- End #main -->
 <form id="form-param" method="get" action="">
      <input type="hidden" id="pgno" name="pgno" value="${pgno}">
      <input type="hidden" id="key" name="key" value="${key}">
      <input type="hidden" id="word" name="word" value="${word}">
    </form>
    <script>
     /*  document.querySelector("#btn-register").addEventListener("click", function () {
        if (!document.querySelector("#subject").value) {
          alert("제목 입력!!");
          return;
        } else if (!document.querySelector("#content").value) {
          alert("내용 입력!!");
          return;
        } else {
          let form = document.querySelector("#form-register");
          form.setAttribute("action", "${root}/board");
          form.submit();
        }
      }); */
      document.querySelector("#btn-register").addEventListener("click", function () {
          if (!document.querySelector("#subject").value) {
            alert("제목 입력!!");
            return;
          } else if (!document.querySelector("#content").value) {
            alert("내용 입력!!");
            return;
          } else {
            let form = document.querySelector("#form-register");
            form.setAttribute("action", "${root}/board/write");
            form.submit();
          }
        });
        
        document.querySelector("#btn-list").addEventListener("click", function () {
          	if(confirm("취소를 하시면 작성한 글은 삭제됩니다.\n취소하시겠습니까?")) {
          		let form = document.querySelector("#form-param");
             	form.setAttribute("action", "${root}/board/board");
                form.submit();
         	}
          });
    </script>
<%@ include file="../common/footer.jsp" %>