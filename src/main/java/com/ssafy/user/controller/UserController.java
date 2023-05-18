package com.ssafy.user.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.jwt.model.service.JwtServiceImpl;
import com.ssafy.user.model.UserDto;
import com.ssafy.user.model.service.IUserService;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	private JwtServiceImpl jwtService;

	private IUserService uservice;

	public UserController(IUserService uservice, JwtServiceImpl jwtService) {
		super();
		this.uservice = uservice;
		this.jwtService = jwtService;
	}

	@PostMapping(value = "/")
	public ResponseEntity<?> join(@RequestBody UserDto userDto, Locale locale) throws Exception {
		logger.info("Welcome join!  {}.", userDto);
		uservice.joinUser(userDto);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@GetMapping(value = "/check/{userId}")
	public ResponseEntity<?> checkId(@PathVariable("userId") String userId, Locale locale, Model model) throws Exception {
		logger.info("Welcome checkId!  {}.", userId);
		int cnt = uservice.checkId(userId);
		return new ResponseEntity<Integer>(cnt, HttpStatus.OK);
	}

	@PostMapping(value = "/login")
	public ResponseEntity<?> login(@RequestBody UserDto userDto, HttpSession session, Locale locale, Model model) throws Exception {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		try {
			UserDto loginUser = uservice.loginUser(userDto);
			if (loginUser != null) {
				logger.debug("token : {}, memberDto : {}", loginUser);
				String accessToken = jwtService.createAccessToken("userid", loginUser.getId());// key, data
				String refreshToken = jwtService.createRefreshToken("userid", loginUser.getId());// key, data
				uservice.saveRefreshToken(userDto.getId(), refreshToken);
				logger.debug("로그인 accessToken 정보 : {}", accessToken);
				logger.debug("로그인 refreshToken 정보 : {}", refreshToken);
				resultMap.put("access-token", accessToken);
				resultMap.put("refresh-token", refreshToken);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			} else {
				resultMap.put("message", FAIL);
				status = HttpStatus.ACCEPTED;
			}
		} catch (Exception e) {
			logger.error("로그인 실패 : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
		
		// logger.info("Welcome login!  {}.", userDto);
		// UserDto loginUser = uservice.loginUser(userDto);
		// if(loginUser != null) {
		// 	session.setAttribute("loginUser", loginUser);
		// 	return new ResponseEntity<UserDto>(uservice.getUserInfo(userDto.getId()), HttpStatus.OK);
		// }
		// return new ResponseEntity<UserDto>(uservice.getUserInfo(userDto.getId()), HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/refresh")
	public ResponseEntity<?> refreshToken(@RequestBody UserDto memberDto, HttpServletRequest request)
			throws Exception {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		String token = request.getHeader("refresh-token");
		logger.debug("token : {}, memberDto : {}", token, memberDto);
		if (jwtService.checkToken(token)) {
			if (token.equals(uservice.getRefreshToken(memberDto.getId()))) {
				String accessToken = jwtService.createAccessToken("userid", memberDto.getId());
				logger.debug("token : {}", accessToken);
				logger.debug("정상적으로 액세스토큰 재발급!!!");
				resultMap.put("access-token", accessToken);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			}
		} else {
			logger.debug("리프레쉬토큰도 사용불!!!!!!!");
			status = HttpStatus.UNAUTHORIZED;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	@GetMapping(value = "/logout/{userid}")
	public ResponseEntity<?> removeToken(@PathVariable("userid") String userid) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		try {
			uservice.deleRefreshToken(userid);
			resultMap.put("message", SUCCESS);
			status = HttpStatus.ACCEPTED;
		} catch (Exception e) {
			logger.error("로그아웃 실패 : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);

	}
	// public String logout(HttpSession session, Locale locale, Model model) throws Exception {
	// 	logger.info("Welcome logout!  {}.");
	// 	session.invalidate();
	// 	return "redirect:/";
	// }

	//비밀번호는 어떻게 해야 할까
	@GetMapping(value = "/{userId}")
	public ResponseEntity<?> showUserInfo(@PathVariable("userId") String userId, Locale locale, Model model) throws Exception {
		logger.info("Welcome showUserInfo!  {}.");
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		try {
			UserDto userDto = uservice.getUserInfo(userId);
			resultMap.put("message", SUCCESS);
			resultMap.put("userInfo", userDto);
			status = HttpStatus.ACCEPTED;
		} catch (Exception e) {
			logger.error("유저 정보 가져오기 실패 : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
	
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
		// return new ResponseEntity<UserDto>(uservice.getUserInfo(userId), HttpStatus.OK);
	}
	@PutMapping(value = "/")
	public ResponseEntity<?> modifyUserInfo(@RequestBody UserDto userDto, Locale locale, Model model) throws Exception {
		logger.info("Welcome modifyUserInfo!  {}.", userDto);
		uservice.modifyUserInfo(userDto);
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("userInfo", uservice.getUserInfo(userDto.getId()));
		resultMap.put("message", SUCCESS);
		return new ResponseEntity<>(resultMap, HttpStatus.OK);
	}
	@DeleteMapping(value = "/{userId}")
	public ResponseEntity<?> deleteUserInfo(@PathVariable("userId") String userId, Locale locale, Model model) throws Exception {
		logger.info("Welcome deleteUserInfo!  {}.");
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		try {
			uservice.deleteUser(userId);
			uservice.deleRefreshToken(userId);
			resultMap.put("message", SUCCESS);
			status = HttpStatus.ACCEPTED;
		} catch (Exception e) {
			logger.error("회원 탈퇴 실패 : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
}
