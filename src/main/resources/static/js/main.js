
/*const adminId ="ssafy";
const adminPW ="1234";
//로그인한 아이디 저장
var curLoginId; */
//윈도우 로드 시 로그인 상태인 유저가 존재하는지 확인
function init(){
    let loginUser = localStorage.getItem("login");
    if(!(loginUser === null)){
        curLoginId = loginUser;
        if(loginUser === adminId){
            document.getElementById("admin").setAttribute("style","display: inline;");
        }else{
            document.getElementById("userInfo").setAttribute("style","display: inline;");
        }
        document.getElementById("login").setAttribute("style","display: none;");
        document.getElementById("logout").setAttribute("style","display: inline;");
        document.getElementById("signUp").setAttribute("style","display: none;");
    }
}
/*//회원가입
function signUp(){
    console.log("회원가입");
    let name = document.getElementById("name").value;
    let id = document.getElementById("id").value;
    let password = document.getElementById("password").value;
    let email = document.getElementById("email").value;
    if(name == '' || id == '' || password == ''|| email == ''){
        alert("입력되지 않은 정보가 존재합니다.");
        return;
    }
    let form = document.querySelector("#form-join");
    form.setAttribute("action", "${root}/user");
    form.submit();
    // 회원가입 완료
    alert("회원가입이 완료되었습니다.");
    // 인풋값 초기화
    document.getElementById("name").value = '';
    document.getElementById("id").value= '';
    document.getElementById("password").value= '';
    document.getElementById("email").value= '';
}*/
/*let userList = localStorage.getItem("users");
*/

//관리자가 아닌 일반 회원
//회원 정보 조회
function showUserInfo(){
   /* let userList = localStorage.getItem("users");
    userList = JSON.parse(userList);
        for (i = 0; i < userList.length; i++) {
            if(userList[i]["userId"] === curLoginId){
                let userInfo = document.getElementById("user-info-list");
                userInfo.innerHTML= `
                    <li>이름 : ${userList[i]["userName"]}</li>
                    <li>아이디 : ${userList[i]["userId"]}</li>
                    <li>비밀번호 : ${userList[i]["userPW"]}</li>
                    <li>이메일 : ${userList[i]["userEmail"]}</li>
                `;
                return;
            }
    } */
}

//회원 정보 수정
function modifyUserInfo(){
    /*let name = document.getElementById("userModName").value;
    let id = document.getElementById("userModId").value;
    let password = document.getElementById("userModPassword").value;
    let email = document.getElementById("userModEmail").value;
    if(name == '' || id == '' || password == ''|| email == ''){
        alert("입력되지 않은 정보가 존재합니다.");
        return;
    }
    let userList = localStorage.getItem("users");
    userList = JSON.parse(userList);
    let curUserIdx;
    for (i = 0; i < userList.length; i++) {
        if(userList[i]["userId"] === curLoginId){
            curUserIdx = i;
        }
        if(!(userList[i]["userId"] === curLoginId) && userList[i]["userId"] === id){
            alert("중복된 아이디입니다. 다른 아이디로 변경해주세요.");
            return;
        }
    } 
    // 관리자 계정의 아이디로는 회원가입 불가능 
    if(adminId === id){
        alert("중복된 아이디입니다. 다른 아이디로 변경해주세요.");
        return;
    }
    // 유저 삭제
    userList.splice(curUserIdx, 1);
    // 유저 객체
    const user={
        userName: name,
        userId: id,
        userPW: password,
        userEmail: email,
    };
    userList.push(user);
    const usersJson = JSON.stringify(userList);
    localStorage.setItem("users", usersJson);

    // 회원정보 수정 완료
    alert("회원정보가 수정되었습니다.");
    // 인풋값 초기화
    document.getElementById("name").value = '';
    document.getElementById("id").value= '';
    document.getElementById("password").value= '';
    document.getElementById("email").value= '';*/
}
//회원 정보 삭제
function deleteUser(){
   /* let userList = localStorage.getItem("users");
    userList = JSON.parse(userList);
    let curUserIdx;
    for (i = 0; i < userList.length; i++) {
        if(userList[i]["userId"] === curLoginId){
            curUserIdx = i;
        }
    } 
    // 유저 삭제
    userList.splice(curUserIdx, 1);
    const usersJson = JSON.stringify(userList);
    localStorage.setItem("users", usersJson);
    alert("회원 탈퇴가 완료되었습니다.");
    document.getElementById("login").setAttribute("style","display: inline;");
    document.getElementById("logout").setAttribute("style","display: none;");
    document.getElementById("userInfo").setAttribute("style","display: none;");
    document.getElementById("admin").setAttribute("style","display: none;");
    document.getElementById("signUp").setAttribute("style","display: inline;");*/
}

//관리자
//전체 회원 관리
//전체 회원 정보 보기
function showUsersInfo(){
    /*let userList = localStorage.getItem("users");
    let userListHTML = document.getElementById("users-info-list");
    if(userList === null){
        userListHTML.innerHTML = "가입한 회원이 존재하지 않습니다..";
    }
    else{
        userList = JSON.parse(userList);
        for (i = 0; i < userList.length; i++) {
            let div1 = document.createElement('div');
            let ul1 = document.createElement('ul');
            ul1.innerHTML = `
                <li>이름 : ${userList[i]["userName"]}</li>
                <li>아이디 : ${userList[i]["userId"]}</li>
                <li>비밀번호 : ${userList[i]["userPW"]}</li>
                <li>이메일 : ${userList[i]["userEmail"]}</li>
            `;
            div1.appendChild(ul1);
            div1.setAttribute("style", "background-color: aliceblue;");
            userListHTML.appendChild(div1);
        } 
    }*/
}

