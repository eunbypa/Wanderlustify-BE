package com.ssafy.user.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.user.model.UserDto;
import com.ssafy.util.PageNavigation;

public interface IUserService {
	void joinUser(UserDto userDto)  throws Exception; // 회원 가입
	int checkId(String userId)  throws Exception; // 아이디 중복 체크
	UserDto loginUser(UserDto userDto)  throws Exception; // 로그인한 유저 정보 반환
	UserDto getUserInfo(String userId)  throws Exception; // 회원 정보 조회
	List<UserDto> getUsersInfo(Map<String,String> map)  throws Exception; // 전체 회원 정보 조회
	void modifyUserInfo(UserDto userDto)  throws Exception; // 회원 정보 수정
	void deleteUser(String userId)  throws Exception; // 회원 탈퇴
	PageNavigation makePageNavigation(Map<String, String> map) throws Exception;
	 void saveRefreshToken(String userid, String refreshToken) throws Exception; // 리프레시 토큰 저장
	 Object getRefreshToken(String userid) throws Exception;
	 void deleRefreshToken(String userid) throws Exception;
	 void changePassword(UserDto userDto) throws Exception; // 비밀번호 변경
    UserDto findEmail(String userId);
	
}
