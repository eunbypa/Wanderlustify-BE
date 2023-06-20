# [Wanderlustify] 
## :page_facing_up: **API 명세서**
<br>

<details>
  <summary>
   관리자
  </summary>

  
## 1. AdminController <br>
- 회원 목록 조회<br>
  - 엔드포인트: GET /admin/users<br>
  - 요청 매개변수:<br>
    - pgno (선택적): 페이지 번호 (기본값: 1)<br>
    - key (선택적): 검색 키워드<br>
    - word (선택적): 검색어<br>
  - 응답:<br>
  성공 (HTTP 상태코드 200):<br>
    - pgno: 현재 페이지 번호<br>
    - key: 검색 키워드<br>
    - word: 검색어<br>
    - users: 회원 목록<br>
    - navigation: 페이지 네비게이션 정보<br>
  - 서버 오류 (HTTP 상태코드 500):<br>
    - message: 오류 메시지<br>
- 회원 정보 삭제<br>
  - 엔드포인트: DELETE /admin/{userId}<br>
  - 경로 변수:<br>
    - userId: 삭제할 회원의 ID<br>
  - 응답:<br>
    성공 (HTTP 상태코드 200)<br>
  - 서버 오류 (HTTP 상태코드 500)<br>
---
<회원 목록 조회 예시><br>
- 요청 <br>

```
GET /admin/users?pgno=1&key=&word=
```
- 응답

HTTP/1.1 200 OK<br>
Content-Type: application/json<br>
```
{
  "pgno": "1",
  "key": "",
  "word": "",
  "users": [
    {
      "id": 1,
      "username": "john_doe",
      "email": "john@example.com"
    },
    {
      "id": 2,
      "username": "jane_smith",
      "email": "jane@example.com"
    }
  ],
  "navigation": {
    "totalRecords": 100,
    "totalPages": 10,
    "currentPage": 1,
    "hasPreviousPage": false,
    "hasNextPage": true
  }
}
```

<회원 정보 삭제 예시><br>
- 요청<br>
HTTP/1.1 200 OK<br>
Content-Type: application/json<br>
```
DELETE /admin/1234
```
- 응답<br>

HTTP/1.1 200 OK<br>
</details>

<details>
  <summary>
   회원
  </summary>

## 2. UserController <br>

- 회원 가입<br>
  - URL: /user/<br>
  - Method: POST<br>
  - Request Body: UserDto<br>
  - Response:<br>
    HTTP Status: 200 (OK) 또는 500 (Internal Server Error)
  - Request Example: json<br>
```
{
  "username": "john_doe",
  "password": "password123",
  "email": "john@example.com"
}
```
  - - Response Example<br>
  HTTP Status: 200 (OK)<br>
- 아이디 중복 확인<br>
  - URL: /user/check/{userId}<br>
  - Method: GET<br>
  - Path Variable: userId (확인할 아이디)<br>
  - Response:<br>
     HTTP Status: 200 (OK)<br>
  - Body: 중복된 아이디인 경우 1, 중복되지 않은 아이디인 경우 0<br>
  - Response Example<br>
     - HTTP Status: 200 (OK)<br>
      - Body: 1 (중복된 아이디)<br>
- 비밀번호 찾기<br>
  - URL: /user/find/password/{userId}<br>
  - Method: GET<br>
  - Path Variable: userId (비밀번호를 찾을 아이디)<br>
  - Response:<br>
   HTTP Status: 200 (OK) 또는 500 (Internal Server Error)<br>
  - Response Example<br>
    HTTP Status: 200 (OK)<br>
- 로그인<br>
  - URL: /user/login<br>
  - Method: POST<br>
  - Request Body: UserDto<br>
  - Response:<br>
  HTTP Status: 202 (Accepted)<br>
  - Body: Access Token, Refresh Token, 메시지
  - Request Example<br>
json<br>
```
{
  "username": "john_doe",
  "password": "password123"
}
```
- - Response Example<br>
HTTP Status: 202 (Accepted)<br>
json<br>
```
{
  "access-token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
  "refresh-token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
  "message": "success"
}
```
- 비밀번호 변경<br>
  - URL: /user/password<br>
  - Method: PUT<br>
  - Request Body: UserDto<br>
  - Response:<br>
  HTTP Status: 202 (Accepted)<br>
  - Body: 메시지<br>
  - Request Example<br>
  json<br>
```
{
  "username": "john_doe",
  "password": "new_password"
}
```
- - Response Example<br>
HTTP Status: 202 (Accepted)<br>
json<br>
```
{
  "message": "success"
}
```
- 토큰 재발급<br>
  - URL: /user/refresh<br>
  - Method: POST<br>
  - Request Body: UserDto<br>
  - Response:<br>
  HTTP Status: 202 (Accepted)<br>
  - Body: Access Token, 메시지<br>
  - Request Example<br>
  json<br>
```
{
  "username": "john_doe",
  "refresh-token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
```
- - Response Example<br>
HTTP Status: 202 (Accepted)<br>
json<br>
```
{
  "access-token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
  "message": "success"
}
```
- 로그아웃<br>
  - URL: /user/logout/{userId}<br>
  - Method: GET<br>
  - Path Variable: userId (로그아웃할 사용자 아이디)<br>
  - Response:<br>
  HTTP Status: 202 (Accepted)<br>
  - Body: 메시지<br>
  - Response Example<br>
  HTTP Status: 202 (Accepted)<br>
  json<br>
```
{
  "message": "success"
}
```
- 유저 정보 조회<br>
  - URL: /user/{userId}<br>
  - Method: GET<br>
  - Path Variable: userId (조회할 유저 아이디)<br>
  - Response:<br>
  HTTP Status: 202 (Accepted) 또는 401 <br>(Unauthorized)<br>
  - Body: 유저 정보, 메시지<br>
  - Response Example<br>
  HTTP Status: 202 (Accepted)<br>
  json<br>
```
{
  "message": "success",
  "userInfo": {
    "username": "john_doe",
    "email": "john@example.com"
  }
}
```
- 유저 정보 수정<br>
  - URL: /user/<br>
  - Method: PUT<br>
  - Request Body: UserDto<br>
  - Response:<br>
  HTTP Status: 200 (OK)<br>
  - Body: 수정된 유저 정보, 메시지<br>
  - Request Example<br>
  json<br>
```
{
  "username": "john_doe",
  "email": "john@example.com"
}
```
- - Response Example<br>
HTTP Status: 200 (OK)<br>
json<br>
```
{
  "message": "success",
  "userInfo": {
    "username": "john_doe",
    "email": "john@example.com"
  }
}
```
- 유저 정보 삭제<br>
  - URL: /user/{userId}<br>
  - Method: DELETE<br>
  - Path Variable: userId (삭제할 유저 아이디)<br>
  - Response:<br>
  HTTP Status: 202 (Accepted)<br>
  - Body: 메시지<br>
  - Response Example<br>
  HTTP Status: 202 (Accepted)<br>
  json<br>
```
{
  "message": "success"
}
```
</details>

<details>
  <summary>
   게시판
  </summary>

## 3. BoardController <br>

- 게시글 작성<br>
  - URL: /board/<br>
  - Method: POST<br>
  - Request Body: BoardDto<br>
  - Response:<br>
  HTTP Status: 200 (OK) 또는 500 (Internal Server Error)<br>
  - Request Example<br>
  json<br>
```
{
  "title": "새로운 게시글",
  "content": "게시글 내용"
}
```
- - Response Example<br>
  HTTP Status: 200 (OK)<br>
- 게시글 목록 조회<br>
  - URL: /board/<br>
  - Method: GET<br>
  - Request Parameters:<br>
    - pgno (페이지 번호)<br>
    - type (검색 타입)<br>
    - sort (정렬 기준)<br>
    - key (검색 키워드)<br>
    - word (검색어)<br>
  - Response:<br>
    - HTTP Status: 200 (OK)<br>
  - Body: 게시글 목록, 페이징 정보, 검색 정보<br>
  - Response Example<br>
  HTTP Status: 200 (OK)<br>
  json<br>
```
{
  "list": [
    {
      "articleNo": 1,
      "title": "게시글 1",
      "content": "게시글 내용 1"
    },
    {
      "articleNo": 2,
      "title": "게시글 2",
      "content": "게시글 내용 2"
    }
  ],
  "type": "type",
  "sort": "sort",
  "navigation": {
    "startRange": 1,
    "endRange": 10,
    "currentPageNo": 1,
    "totalPageCount": 5,
    "totalArticleCount": 50,
    "hasPreviousPage": false,
    "hasNextPage": true
  },
  "pgno": "1",
  "key": "key",
  "word": "word",
  "message": "success"
}
```
- 게시글 상세 조회<br>
  - URL: /board/{articleno}<br>
  - Method: GET<br>
  - Path Variable: articleno (조회할 게시글 번호)<br>
  - Request Parameters:<br>
    - pgno (페이지 번호)<br>
    - key (검색 키워드)<br>
    - word (검색어)<br>
    - Response:<br>
  HTTP Status: 200 (OK)<br>
  - Body: 게시글 정보, 페이지 번호, 검색 정보<br>
  - Response Example<br>
  HTTP Status: 200 (OK)<br>
  json<br>
```
{
  "board": {
    "articleNo": 1,
    "title": "게시글 1",
    "content": "게시글 내용 1"
  },
  "pgno": "1",
  "key": "key",
  "word": "word",
  "message": "success"
}
```
- 게시글 수정<br>
  - URL: /board/<br>
  - Method: PUT<br>
  - Request Body: BoardDto<br>
  - Request Parameters:<br>
    - pgno (페이지 번호)<br>
    - key (검색 키워드)<br>
    - word (검색어)<br>
  - Response:<br>
  HTTP Status: 200 (OK)<br>
  - Body: 수정된 게시글 정보, 페이지 번호, 검색 정보<br>
  - Request Example<br>
  json<br>
```
{
  "articleNo": 1,
  "title": "수정된 게시글 1",
  "content": "수정된 게시글 내용 1"
}
```
- - Response Example<br>
HTTP Status: 200 (OK)<br>
json<br>
```
{
  "board": {
    "articleNo": 1,
    "title": "수정된 게시글 1",
    "content": "수정된 게시글 내용 1"
  },
  "pgno": "1",
  "key": "key",
  "word": "word",
  "message": "success"
}
```
- 게시글 삭제<br>
  - URL: /board/{articleno}<br>
  - Method: DELETE<br>
  - Path Variable: articleno (삭제할 게시글 번호)<br>
  - Response:<br>
  HTTP Status: 200 (OK)<br>
  - Body: 메시지<br>
  - Response Example<br>
  HTTP Status: 200 (OK)<br>
  json<br>
```
{
  "message": "success"
}
```
- 게시글 추천<br>
  - URL: /board/recommend/{articleno}<br>
  - Method: GET<br>
  - Path Variable: articleno (추천할 게시글 번호)<br>
  - Request Parameters:<br>
    - userId (사용자 아이디)<br>
  - Response:<br>
  HTTP Status: 200 (OK)<br>
  - Body: 메시지<br>
  - Response Example<br>
  HTTP Status: 200 (OK)<br>
  json<br>
```
{
  "message": "success"
}
```
- 댓글 수 갱신<br>
  - URL: /board/{articleno}<br>
  - Method: PUT<br>
  - Path Variable: articleno (게시글 번호)<br>
  - Response:<br>
  HTTP Status: 200 (OK)<br>
  - Body: 메시지<br>
  - Response Example<br>
  HTTP Status: 200 (OK)<br>
  json<br>
```
{
  "message": "success"
}
```
</details>

<details>
  <summary>
   여행
  </summary>

## 4. AttractionController <br>

- 나의 여행계획 추가 (1개)<br>
  - URL: /attraction/addMyTrip<br>
  - Method: POST<br>
  - Request Body: MyTripDto<br>
  - Response:<br>
  HTTP Status: 200 (OK)<br>
  - Request Example<br>
  json<br>
```
{
  "id": "user1",
  "user_mytrip_no": 1,
  "attractionName": "여행지 1",
  "attractionDescription": "여행지 설명"
}
```
- 나의 여행계획 추가 (전체)<br>
  - URL: /attraction/addMyTripAll<br>
  - Method: POST<br>
  - Request Body: MyTripDto[]<br>
  - Response:<br>
    HTTP Status: 200 (OK)<br>
  - Request Example<br>
  json<br>
```
[
  {
    "id": "user1",
    "user_mytrip_no": 1,
    "attractionName": "여행지 1",
    "attractionDescription": "여행지 설명"
  },
  {
    "id": "user1",
    "user_mytrip_no": 1,
    "attractionName": "여행지 2",
    "attractionDescription": "여행지 설명"
  }
]
```
- 나의 여행계획 조회<br>
  - URL: /attraction/getMyTrip/{id}/{user_mytrip_no}<br>
  - Method: GET<br>
  - Path Variables:<br>
    - id (사용자 아이디)<br>
    - user_mytrip_no (사용자 여행계획 번호)<br>
  - Response:<br>
  HTTP Status: 200 (OK)<br>
  - Body: 나의 여행계획 리스트<br>
  - Response Example<br>
  HTTP Status: 200 (OK)<br>
  json<br>
```
[
  {
    "id": "user1",
    "user_mytrip_no": 1,
    "attractionName": "여행지 1",
    "attractionDescription": "여행지 설명"
  },
  {
    "id": "user1",
    "user_mytrip_no": 1,
    "attractionName": "여행지 2",
    "attractionDescription": "여행지 설명"
  }
]
```
- 유저가 등록한 여행계획 중 가장 큰 번호 조회<br>
  - URL: /attraction/getMyTripMax/{id}<br>
  - Method: GET<br>
  - Path Variable: id (사용자 아이디)<br>
  - Response:<br>
    HTTP Status: 200 (OK)<br>
  - Body: 가장 큰 여행계획 번호<br>
  - Response Example<br>
  HTTP Status: 200 (OK)<br>
  json<br>
```
3
```
- 유저가 등록한 모든 여행계획 조회<br>
  - URL: /attraction/getMyTripAll/{id}<br>
  - Method: GET<br>
  - Path Variable: id (사용자 아이디)<br>
  - Response:<br>
    HTTP Status: 200 (OK)<br>
  - Body: 모든 여행계획 번호 리스트<br>
  - Response Example<br>
  HTTP Status: 200 (OK)<br>
  json<br>
```
[1, 2, 3]
```
- 유저가 여행계획 삭제 (전체)<br>
  - URL: /attraction/deleteMyTripAll/{id}/{trip_no}<br>
  - Method: DELETE<br>
  - Path Variables:<br>
    - id (사용자 아이디)<br>
    - trip_no (여행계획 번호)<br>
  - Response:<br>
  HTTP Status: 200 (OK)<br>
- 유저가 여행계획 삭제 (개별)<br>
  - URL: /attraction/deleteMyTrip/{no}<br>
  - Method: DELETE<br>
  - Path Variable: no (여행계획 번호)<br>
  - Response:<br>
  HTTP Status: 200 (OK)<br>
</details>

<details>
  <summary>
   핫플레이스
  </summary>

## 5. HotPlaceController <br>
- 핫플레이스 목록 조회<br>
  - URL: /hotplace/<br>
  - Method: GET<br>
  - Request Parameters:<br>
    - pgno (현재 페이지 번호)<br>
    - key (검색 키워드)<br>
    - word (검색어)<br>
  - Response:<br>
  HTTP Status: 200 (OK)<br>
  - Body:<br>
    - list (List<HotPlaceDto>): 핫플레이스 목록<br>
    - top3 (List<HotPlaceDto>): 상위 3개의 핫플레이스 목록<br>
    - navigation (PageNavigation): 페이지 네비게이션 정보<br>
    - sort (String): 정렬 기준<br>
    - pgno (String): 현재 페이지 번호<br>
    - key (String): 검색 키워드<br>
    - word (String): 검색어<br>
    - message (String): 요청 결과 메시지<br>
- 핫플레이스 상세 조회<br>
  - URL: /hotplace/{hotplaceno}<br>
  - Method: GET<br>
  - Path Variable: hotplaceno (핫플레이스 번호)<br>
  - Request Parameters:<br>
    - pgno (현재 페이지 번호)<br>
    - key (검색 키워드)<br>
    - word (검색어)<br>
  - Response:<br>
  HTTP Status: 200 (OK)<br>
  - Body:<br>
    - hotplace (HotPlaceDto): 핫플레이스 정보<br>
    - pgno (String): 현재 페이지 번호<br>
    - key (String): 검색 키워드<br>
    - word (String): 검색어<br>
    - message (String): 요청 결과 메시지<br>
- 핫플레이스 작성<br>
  - URL: /hotplace/<br>
  - Method: POST<br>
  - Request Body: HotPlaceDto 객체<br>
  Response:<br>
  HTTP Status: 200 (OK)<br>
  - Body:<br>
    - hotplace (HotPlaceDto): 작성된 핫플레이스 정보<br>
    - message (String): 요청 결과 메시지<br>
- 핫플레이스 수정<br>
  - URL: /hotplace/<br>
  - Method: PUT<br>
  - Request Body: HotPlaceDto 객체<br>
  - Request Parameters:<br>
  - pgno (현재 페이지 번호)<br>
  - key (검색 키워드)<br>
  - word (검색어)<br>
  - Response:<br>
  HTTP Status: 200 (OK)<br>
  - Body:<br>
    - hotplace (HotPlaceDto): 수정된 핫플레이스 정보<br>
    - pgno (String): 현재 페이지 번호<br>
    - key (String): 검색 키워드<br>
    - word (String): 검색어<br>
    - message (String): 요청 결과 메시지<br>
- 핫플레이스 삭제<br>
  - URL: /hotplace/{hotplaceno}<br>
  - Method: DELETE<br>
  - Path Variable: hotplaceno (핫플레이스 번호)<br>
  - Response:<br>
    HTTP Status: 200 (OK)<br>
  - Body:<br>
  - message (String): 요청 결과 메시지<br>
- 핫플레이스 추천 목록 조회
  - URL: /hotplace/list/recommend/{userId}
  - Method: GET
  - Path Variable: userId (사용자 ID)
  - Response:
  HTTP Status: 200 (OK)
  - Body:
    - list (List<HotPlaceDto>): 추천된 핫플레이스 목록
    - message (String): 요청 결과 메시지
- 핫플레이스 추천<br>
  - URL: /hotplace/recommend/{hotplaceNo}<br>
  - Method: GET<br>
  - Path Variable: hotplaceNo (핫플레이스 번호)<br>
  - Request Parameters:<br>
    - userId (사용자 ID)<br>
  - Response:<br>
  HTTP Status: 200 (OK)<br>
  - Body:<br>
    - message (String): 요청 결과 메시지<br>
- 핫플레이스 이미지 업로드<br>
  - URL: /hotplace/file<br>
  - Method: POST<br>
  - Request Parameters:<br>
    - hotplaceNo (핫플레이스 번호)<br>
    - upfile (파일)<br>
  - Response:<br>
  HTTP Status: 200 (OK)<br>
</details>

<details>
  <summary>
   댓글
  </summary>

## 6. CommentController <br>
- 댓글 작성<br>
  - URL: /comment/<br>
  - Method: POST<br>
  - Request Body: CommentDto 객체<br>
  - Response:<br>
  HTTP Status: 200 (OK)<br>
- 댓글 목록 조회<br>
  - URL: /comment/{articleno}<br>
  - Method: GET<br>
  - Path Variable: articleno (게시글 번호)<br>
  - Response:<br>
    HTTP Status: 200 (OK)<br>
  - Body:<br>
    - list (List<CommentDto>): 댓글 목록<br>
    - message (String): 요청 결과 메시지<br>
- 댓글 수정<br>
  - URL: /comment/<br>
  - Method: PUT<br>
  - Request Body: CommentDto 객체<br>
  - Response:<br>
  HTTP Status: 200 (OK)<br>
  - Body:<br>
    - comment (CommentDto): 수정된 댓글 정보<br>
    - message (String): 요청 결과 메시지<br>
- 댓글 삭제<br>
  - URL: /comment/{commentno}<br>
  - Method: DELETE<br>
  - Path Variable: commentno (댓글 번호)<br>
  - Response:<br>
  HTTP Status: 200 (OK)<br>
  - Body:<br>
    - message (String): 요청 결과 메시지<br>
</details>
