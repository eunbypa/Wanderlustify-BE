<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</main>
    <!-- Footer-->

    <!-- 로그인 modal -->
    <div class="modal fade" id="loginModal" tabindex="-1" aria-labelledby="loginModalLabel" aria-hidden="true">
      <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
          <div class="modal-header">
            <h1 class="modal-title fs-5" id="loginModalLabel">로그인</h1>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            <form id = "form-login" action ="" method = "POST">
              <p>아이디 : </p>
              <input
                  type="text"
                  class="form-control"
                  id="loginId"
                  placeholder="아이디"
                  name="id"
                />
                <p class = "mt-3">비밀번호 : </p>
              <input
                  type="password"
                  class="form-control"
                  id="loginPassword"
                  placeholder="비밀번호"
                  name="password"
                />
            </form>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-primary"  onclick="login()">로그인</button>
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
          </div>
        </div>
      </div>
    </div>
    <!-- 회원가입 modal -->
    <div class="modal fade" id="signupModal" tabindex="-1" aria-labelledby="signupModalLabel" aria-hidden="true">
      <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
          <div class="modal-header">
            <h1 class="modal-title fs-5" id="signupModalLabel">회원가입</h1>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            <form id = "form-join" action ="" method ="POST">
              <p>이름 : </p>
              <input
                  type="text"
                  class="form-control"
                  id="name"
                  placeholder="이름"
                  name="name"
                />
                <p class = "mt-3">아이디 : </p>
              <input
                  type="text"
                  class="form-control"
                  id="id"
                  placeholder="아이디"
                  name="id"
                  onkeyup="checkId(this.value);"
                />
                <div id ="idcheck-result"></div>
                <p class = "mt-3">비밀번호 : </p>
              <input
                  type="password"
                  class="form-control"
                  id="password"
                  placeholder="비밀번호"
                  name="password"
                />
                <!--
                <p class = "mt-3">비밀번호확인 : </p>
                <input
                type="password"
                class="form-control"
                id="passwordConfirm"
                placeholder="비밀번호확인"
                name="passwordConfirm"
                />
                -->
                <p class = "mt-3">이메일 : </p>
                <input
                type="email"
                class="form-control"
                id="email"
                placeholder="이메일"
                name="email"
                />
            </form>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-primary" onclick="signUp();">회원 가입</button>
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
          </div>
        </div>
      </div>
    </div>
    <!-- 회원정보 보기 modal -->
    <div class="modal fade" id="userInfoModal" tabindex="-1" aria-labelledby="userInfoModalLabel" aria-hidden="true">
      <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
          <div class="modal-header">
            <h1 class="modal-title fs-5" id="userInfoModalLabel">회원정보</h1>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            <div>
              <ul id = "user-info-list">
				<div id = "uname">
				</div>
				<div id = "uid">
				</div>
				<div id = "upwd">
				</div>
				<div id = "uemail">
				</div>
				<div id = "udate">
				</div>
              </ul>
            </div>
          </div>
          <div class="modal-footer">
            <!-- <button type="button" class="btn btn-primary" onclick="setUserInfo();" data-bs-toggle="modal" data-bs-target="#userInfoModifyModal">회원 정보 수정</button>
            <button type="button" class="btn btn-danger" data-bs-dismiss="modal" data-bs-toggle="modal" data-bs-target="#userSecessionModal">회원 탈퇴</button>  -->
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
          </div>
        </div>
      </div>
    </div>
    <!-- 회원정보 수정 modal -->
    <div class="modal fade" id="userInfoModifyModal" tabindex="-1" aria-labelledby="userInfoModifyModalLabel" aria-hidden="true">
      <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
          <div class="modal-header">
            <h1 class="modal-title fs-5" id="userInfoModifyModalLabel">회원정보수정</h1>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            <form id = "form-modify" action ="" method ="POST">
              <p>이름 : </p>
              <input
                  type="text"
                  class="form-control"
                  id="userModName"
                  placeholder="이름"
                  name="name"
                />
                <p class = "mt-3">아이디 : </p>
              <input
                  type="text"
                  class="form-control"
                  id="userModId"
                  placeholder="아이디"
                  name="id"
                  readonly
                />
                <p class = "mt-3">비밀번호 : </p>
              <input
                  type="password"
                  class="form-control"
                  id="userModPassword"
                  placeholder="비밀번호"
                  name="password"
                />
                <!--
                <p class = "mt-3">비밀번호확인 : </p>
                <input
                type="password"
                class="form-control"
                id="passwordConfirm"
                placeholder="비밀번호확인"
                name="passwordConfirm"
                />
                -->
                <p class = "mt-3">이메일 : </p>
                <input
                type="email"
                class="form-control"
                id="userModEmail"
                placeholder="이메일"
                name="email"
                />
            </form>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-primary" onclick="modifyUserInfo();">회원 정보 수정</button>
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
          </div>
        </div>
      </div>
    </div>
    <!-- 회원 정보 삭제(탈퇴)modal -->
    <div class="modal fade" id="userSecessionModal" tabindex="-1" aria-labelledby="userSecessionModalLabel" aria-hidden="true">
      <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
          <div class="modal-header">
            <h1 class="modal-title fs-5" id="userSecessionModalLabel">회원탈퇴</h1>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            <div>
              회원 탈퇴를 하면 사용자님의 모든 정보가 삭제됩니다.
              <br>
              계속하시겠습니까?
            </div>
          </div>
          <div class="modal-footer">
            <button class="btn btn-danger" onclick ="deleteUser();" data-bs-dismiss="modal">회원탈퇴</button>
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
          </div>
        </div>
      </div>
    </div>
    <!-- 전체회원정보 보기 modal -->
    <div class="modal fade" id="usersInfoModal" tabindex="-1" aria-labelledby="usersInfoModalLabel" aria-hidden="true">
      <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
          <div class="modal-header">
            <h1 class="modal-title fs-5" id="usersInfoModalLabel">회원 목록</h1>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            <div id = "users-info-list">

            </div>
          </div>
          <div class="modal-footer">
            <!--
            <button type="button" class="btn btn-primary" onclick ="closeUserInfo();" data-bs-toggle="modal" data-bs-target="#userInfoModifyModal">회원 정보 수정</button>
            <button type="button" class="btn btn-primary" data-bs-dismiss="modal" data-bs-toggle="modal" data-bs-target="#userSecessionModal">회원 탈퇴</button> 
          -->
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
          </div>
        </div>
      </div>
    </div>
    <!-- Bootstrap core JS-->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Core theme JS-->
    <script src="/js/main.js"></script>
    <%-- <script src="/js/search.js"></script> --%>
    <script type="text/javascript">
    var isUseId;
  //아이디 중복 체크
    function checkId(e){
    	isUseId = false;
    	//let form = document.querySelector("#form-join");
    	let userid = e;
    	//console.log(userid);
    	 	let resultDiv = document.querySelector("#idcheck-result");
    	 	if(userid.length < 4 || userid.length > 16) {
    		 	resultDiv.setAttribute("class", "mb-3 text-dark");
    		 	resultDiv.textContent = "아이디는 4자 이상 16자 이하 입니다.";
    		 	isUseId = false;
    	 	} else {
    		 	fetch("${root}/user/checkId?userId=" + userid)
       		.then(response => response.text())
       		.then(data => {
    	 		if(data == 0) {
    	   			resultDiv.setAttribute("class", "mb-3 text-primary");
           			resultDiv.textContent = userid + "는 사용할 수 있습니다.";
           			isUseId = true;
    	 		} else {
    	   			resultDiv.setAttribute("class", "mb-3 text-danger");
    		       	resultDiv.textContent = userid + "는 사용할 수 없습니다.";
    		     	isUseId = false;
    	 		}
    		   });
    	 	}
    }
  
  //회원가입
    async function signUp(){
        //console.log("회원가입");
        let name = document.getElementById("name").value;
        let id = document.getElementById("id").value;
        let password = document.getElementById("password").value;
        let email = document.getElementById("email").value;
        if(name == '' || id == '' || password == ''|| email == ''){
            alert("입력되지 않은 정보가 존재합니다.");
            return;
        }
        if(!isUseId){
        	alert("해당 아이디는 사용불가합니다.");
            return;
        }
        let joininfo = {
       	     id: document.querySelector("#id").value,
       	     name: document.querySelector("#name").value,
       	     password: document.querySelector("#password").value,
       	     email: document.querySelector("#email").value,
      	};
       let config = {
      	     method: "POST",
      	     headers: {
      	       "Content-Type": "application/json",
      	     },
      	   	body: JSON.stringify(joininfo),
      	};
       let response = await fetch("${root}/user/join", config);
       let data = await response.json();
        // 회원가입 완료
        alert("회원가입이 완료되었습니다.");
        // 인풋값 초기화
        document.getElementById("name").value = '';
        document.getElementById("id").value= '';
        document.getElementById("password").value= '';
        document.getElementById("email").value= '';
 		location.href = "${root}/";	
    }
 	// 로그인
 	
 	/* document.getElementById("login2").addEventListener("click", login); */
 	
    async function login(){
        let id = document.getElementById("loginId").value;
        let password = document.getElementById("loginPassword").value;
        // 빈칸 존재시
        if(id == '' || password == ''){
            alert("입력되지 않은 정보가 존재합니다.");
            return;
        }
        let logininfo = {
        	     id: document.querySelector("#loginId").value,
        	     password: document.querySelector("#loginPassword").value,
       	};
        let config = {
       	     method: "POST",
       	     headers: {
       	       "Content-Type": "application/json",
       	     },
       	   	body: JSON.stringify(logininfo),
       	};
        let response = await fetch("${root}/user/loginUser", config);
        if (response.ok) {
        	let data = await response.json();
       		location.href = "${root}/";	
        } else {
        	alert("로그인 실패 : " + response.status);
        }
     
    }
  //로그아웃
    function logout(){
        alert("로그아웃 되었습니다.");
        
    }
  //관리자가 아닌 일반 회원
  //회원 정보 조회
  function showUserInfo(){
	  fetch("${root}/user/showUserInfo?userId=${loginUser.id}")
 		.then(response => response.json())
 		.then(data => {
 			console.log(data);
 			let resultDiv = document.querySelector("#uname");
 			resultDiv.textContent = "이름 : "+data["name"];
 			resultDiv = document.querySelector("#uid");
 			resultDiv.textContent = "아이디 : "+data["id"];
 			resultDiv = document.querySelector("#upwd");
 			resultDiv.textContent = "비밀번호 : "+data["password"];
 			resultDiv = document.querySelector("#uemail");
 			resultDiv.textContent = "이메일 : "+data["email"]; 
 			resultDiv = document.querySelector("#udate");
 			resultDiv.textContent = "가입일 : "+data["joinDate"]; 
		   });
  }
  //회원 정보 수정 창에 유저 정보 세팅
  function setUserInfo(){
	  fetch("${root}/user/showUserInfo?userId=${loginUser.id}")
		.then(response => response.json())
		.then(data => {
			  document.querySelector("#userModName").value = data["name"];
			  document.querySelector("#userModId").value = data["id"];
			  document.querySelector("#userModPassword").value = data["password"];
			  document.querySelector("#userModEmail").value = data["email"];
		});
  }
  
//회원 정보 수정
  function modifyUserInfo(){
	  let form = document.querySelector("#form-modify");
      form.setAttribute("action", "${root}/user/modifyUserInfo");
      form.submit();
      alert("회원정보가 수정되었습니다.");
  }
  //회원 정보 삭제
  function deleteUser(){
	  alert("탈퇴 완료되었습니다.");
	  location.href = "${root}/user/deleteUserInfo?userId=${loginUser.id}";
  }

  //관리자
  //전체 회원 관리
  //전체 회원 정보 보기
  function showUsersInfo(){
	  
  }
    </script>
  </body>
</html>