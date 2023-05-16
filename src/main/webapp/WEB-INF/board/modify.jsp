<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<%@ include file="../common/header.jsp" %>
<%@ include file="../common/nav.jsp" %>
<%@ include file="../common/confirm.jsp" %>
<%-- 
<div class="row justify-content-center">
        <div class="col-lg-8 col-md-10 col-sm-12">
          <h2 class="my-3 py-3 shadow-sm bg-light text-center">
            <mark class="sky">글수정</mark>
          </h2>
        </div>
        <div class="col-lg-8 col-md-10 col-sm-12">
          <form id="form-modify" method="POST" action="">
          	<input type="hidden" name="action" value="modify">
          	<input type="hidden" name="articleno" value="${article.articleNo}">
            <div class="mb-3">
              <label for="subject" class="form-label">제목 : </label>
              <input type="text" class="form-control" id="subject" name="subject" value="${article.subject}" />
            </div>
            <div class="mb-3">
              <label for="content" class="form-label">내용 : </label>
              <textarea class="form-control" id="content" name="content" rows="7">${article.content}</textarea>
            </div>
            <div class="col-auto text-center">
              <button type="button" id="btn-modify" class="btn btn-outline-primary mb-3">
                글수정
              </button>
              <button type="button" id="btn-list" class="btn btn-outline-danger mb-3">
                목록으로이동...
              </button>
            </div>
          </form>
        </div>
      </div>
    </div> 
    --%>
    <!-- ======= About Us Section ======= -->
      <section id="about" class="about" style="background-color: #f5f9fc; padding-bottom: 60px">
        <div class="container" data-aos="fade-up">
          <div class="row no-gutters" style="background-color: white">
            <div class="p-5">
            <!-- ===== update start ===== -->
          <div class="modal-header mb-3">
            <h4 class="modal-title">
              <label class="fw-bold border-bottom border-warning border-5">글 수정</label>
            </h4>
          </div>
<div>

             <form id="form-modify" method="POST" action="">
          	<input type="hidden" name="pgno" value="${pgno}">
		    <input type="hidden" name="key" value="${key}">
		   	<input type="hidden" name="word" value="${word}">
            <input type="hidden" name="articleNo" value="${board.articleNo}">
            <div class="mb-3">
                <label for="id" class="form-label">작성자:</label>
                <input
                  type="text"
                  class="form-control"
                  id="id"
                  value="${board.userId}"
                  name="userId"
                  readonly="readonly"
                />
              </div>
              <div class="mb-3">
                <label for="subject" class="form-label">제목:</label>
                <input type="text" class="form-control" id="subject" name="subject" value="${board.subject}" />
              </div>
              <div class="mb-3 row">
              <div class="col-md-6">
              <label for="hit" class="form-label">조회수:</label>
              <input type="text" class="form-control" id="hit" value="${board.hit}" name="hit" readonly="readonly" />
              </div>
              <div class="col-md-6">
              <label for="date" class="form-label">작성일:</label>
              <input type="text" class="form-control" id="date" value="${board.date}" name="date" readonly="readonly" />
              </div>
              </div>
              <div class="mb-3">
                <label for="content" class="form-label">내용:</label>
                <textarea class="form-control" rows="10" id = "content" name="content">${board.content}</textarea>
              </div>
              <div class="modal-footer">
            <button type="button" id="btn-modify" 
              class="btn btn-outline-primary btn-sm me-1"
            >
              수정
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
    <script>
      /* document.querySelector("#btn-modify").addEventListener("click", function () {
        if (!document.querySelector("#subject").value) {
          alert("제목 입력!!");
          return;
        } else if (!document.querySelector("#content").value) {
          alert("내용 입력!!");
          return;
        } else {
          let form = document.querySelector("#form-modify");
          form.setAttribute("action", "${root}/board");
          form.submit();
        }
      });
      document.querySelector("#btn-list").addEventListener("click", function () {
        location.href = "${root}/board?action=list&pgno=1&key=&word=";
      }); */
      document.querySelector("#btn-modify").addEventListener("click", function () {
          if (!document.querySelector("#subject").value) {
            alert("제목 입력!!");
            return;
          } else if (!document.querySelector("#content").value) {
            alert("내용 입력!!");
            return;
          } else {
            let form = document.querySelector("#form-modify");
            form.setAttribute("action", "${root}/board/update");
            form.submit();
          }
        });
        
        document.querySelector("#btn-list").addEventListener("click", function () {
         	if(confirm("취소를 하시면 작성중인 글은 삭제됩니다.\n취소하시겠습니까?")) {
         		let form = document.querySelector("#form-param");
            	form.setAttribute("action", "${root}/board/board");
              form.submit();
        	}
        });
    </script>
<%@ include file="../common/footer.jsp" %>