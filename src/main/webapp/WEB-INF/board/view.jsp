<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<%@ include file="../common/header.jsp" %>
<%@ include file="../common/nav.jsp" %>

<%-- <div class="row justify-content-center">
	<c:if test="${article eq null}">
		<script>
		alert("글이 삭제되었거나 부적절한 URL 접근입니다.");
		location.href = "${root}/board?action=list";
		</script>
	</c:if>
      <div class="row justify-content-center">
        <div class="col-lg-8 col-md-10 col-sm-12">
          <h2 class="my-3 py-3 shadow-sm bg-light text-center">
            <mark class="sky">글보기</mark>
          </h2>
        </div>
        <div class="col-lg-8 col-md-10 col-sm-12">
          <div class="row my-2">
            <h2 class="text-secondary px-5">${article.articleNo}. ${article.subject}</h2>
          </div>
          <div class="row">
            <div class="col-md-8">
              <div class="clearfix align-content-center">
                <img
                  class="avatar me-2 float-md-start bg-light p-2"
                  src="https://raw.githubusercontent.com/twbs/icons/main/icons/person-fill.svg"
                />
                <p>
                  <span class="fw-bold">${article.userId}</span> <br />
                  <span class="text-secondary fw-light"> ${article.registerTime} 조회 : ${article.hit} </span>
                </p>
              </div>
            </div>
            <div class="col-md-4 align-self-center text-end">댓글 : 17</div>
            <div class="divider mb-3"></div>
            <div class="text-secondary">
              ${article.content}
            </div>
            <div class="divider mt-3 mb-3"></div>
            <div class="d-flex justify-content-end">
              <button type="button" id="btn-list" class="btn btn-outline-primary mb-3">
                글목록
              </button>
              <c:if test="${loginUser.id eq article.userId}">
              <button type="button" id="btn-mv-modify" class="btn btn-outline-success mb-3 ms-1">
                글수정
              </button>
              <button type="button" id="btn-delete" class="btn btn-outline-danger mb-3 ms-1">
                글삭제
              </button>
              </c:if>
            </div>
          </div>
        </div>
      </div>
    </div> --%>
    <!-- ======= About Us Section ======= -->
	<section id="about" class="about"
		style="background-color: #f5f9fc; padding-bottom: 60px">
		<div class="container" data-aos="fade-up">
			<div class="row no-gutters" style="background-color: white">
				<div class="p-5">
					<!-- ===== update start ===== -->
					
						<div class="modal-header mb-3">
							<h4 class="modal-title">
								<label class="fw-bold border-bottom border-warning border-5">글
									보기</label>
							</h4>
						</div>
						<div>
							<div class="mb-3">
								<label for="id" class="form-label">작성자:</label> <input
									type="text" class="form-control" id="id"
									value="${board.userId}" name="userId" readonly="readonly" />
							</div>
							<div class="mb-3">
								<label for="subject" class="form-label">제목:</label> <input
									type="text" class="form-control" id="subject"
									value="${board.subject}" name="subject" readonly="readonly" />
							</div>
							<div class="mb-3 row">
								<div class="col-md-6">
									<label for="hit" class="form-label">조회수:</label> <input
										type="text" class="form-control" id="hit" value="${board.hit}"
										name="hit" readonly="readonly" />
								</div>
								<div class="col-md-6">
									<label for="date" class="form-label">작성일:</label> <input
										type="text" class="form-control" id="date"
										value="${board.date}" name="date" readonly="readonly" />
								</div>
							</div>
							<div class="mb-3">
								<label for="content" class="form-label">내용:</label>
								<textarea class="form-control" rows="10" name="content"
									readonly="readonly">${board.content}</textarea>
							</div>
						</div>
					<div class="d-flex justify-content-end">
						<button type="button" id="btn-list"
							class="btn btn-outline-dark btn-sm me-1">글목록</button>
						<c:if test="${loginUser.id eq board.userId}">
							<button type="button" id="btn-mv-modify"
								class="btn btn-outline-primary btn-sm">수정</button>
							<button type="button" id="btn-delete"
								class="btn btn-outline-danger btn-sm ms-1">삭제</button>
							<form id="form-no-param" method="get" action="${root}/board">
								<input type="hidden" id="npgno" name="pgno" value="${pgno}">
								<input type="hidden" id="nkey" name="key" value="${key}">
								<input type="hidden" id="nword" name="word" value="${word}">
								<input type="hidden" id="articleno" name="articleno"
									value="${board.articleNo}">
							</form>
							<script>
		      		document.querySelector("#btn-mv-modify").addEventListener("click", function () {
				    	let form = document.querySelector("#form-no-param");
				   		form.setAttribute("action", "${root}/board/update");
				    	form.submit();
				  	});
				      
					document.querySelector("#btn-delete").addEventListener("click", function () {
						if(confirm("정말 삭제하시겠습니까?")) {
							let form = document.querySelector("#form-no-param");
				      	  	form.setAttribute("action", "${root}/board/delete");
				          	form.submit();
						}
					});
				  </script>
						</c:if>
					</div>
				</div>
				<!-- update end -->
			</div>
		</div>
	</section>
	<!-- End About Us Section -->
	<form id="form-param" method="get" action="">
	<input type="hidden" id="pgno" name="pgno" value="${pgno}"> <input
		type="hidden" id="key" name="key" value="${key}"> <input
		type="hidden" id="word" name="word" value="${word}">
</form>
    <script>
      /* document.querySelector("#btn-list").addEventListener("click", function () {
        location.href = "${root}/board?action=list";
      });
      document.querySelector("#btn-mv-modify").addEventListener("click", function () {
        alert("글수정하자!!!");
        location.href = "${root}/board?action=mvmodify&articleno=${article.articleNo}";
      });
      document.querySelector("#btn-delete").addEventListener("click", function () {
        alert("글삭제하자!!!");
        location.href = "${root}/board?action=delete&articleno=${article.articleNo}";
      }); */
      document.querySelector("#btn-list").addEventListener("click", function () {
      	  let form = document.querySelector("#form-param");
      	  form.setAttribute("action", "${root}/board/board");
            form.submit();
        });
    </script>
<%@ include file="../common/footer.jsp" %>