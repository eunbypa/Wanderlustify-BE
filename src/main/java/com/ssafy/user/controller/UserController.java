package com.ssafy.user.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.user.model.UserDto;
import com.ssafy.user.model.service.IUserService;
import com.ssafy.user.model.service.UserServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	private IUserService uservice;

	public UserController(IUserService uservice) {
		super();
		this.uservice = uservice;
	}

	@PostMapping(value = "/")
	public ResponseEntity<?> join(@RequestBody UserDto userDto, Locale locale) throws Exception {
		logger.info("Welcome join!  {}.", userDto);
		uservice.joinUser(userDto);

		return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
	}

	@GetMapping(value = "/check/{userId}")
	public ResponseEntity<?> checkId(@PathVariable("userId") String userId, Locale locale, Model model) throws Exception {
		logger.info("Welcome checkId!  {}.", userId);
		int cnt = uservice.checkId(userId);
		return new ResponseEntity<Integer>(cnt, HttpStatus.OK);
	}

	@PostMapping(value = "/login")
	public ResponseEntity<?> login(@RequestBody UserDto userDto, HttpSession session, Locale locale, Model model) throws Exception {
		logger.info("Welcome login!  {}.", userDto);
		UserDto loginUser = uservice.loginUser(userDto);
		if(loginUser != null) {
			session.setAttribute("loginUser", loginUser);
			return new ResponseEntity<UserDto>(uservice.getUserInfo(userDto.getId()), HttpStatus.OK);
		}
		return new ResponseEntity<UserDto>(uservice.getUserInfo(userDto.getId()), HttpStatus.BAD_REQUEST);
	}

	@GetMapping(value = "/logout")
	public String logout(HttpSession session, Locale locale, Model model) throws Exception {
		logger.info("Welcome logout!  {}.");
		session.invalidate();
		return "redirect:/";
	}

	@GetMapping(value = "/{userId}")
	public ResponseEntity<?> showUserInfo(@PathVariable("userId") String userId, Locale locale, Model model) throws Exception {
		logger.info("Welcome showUserInfo!  {}.");
		return new ResponseEntity<UserDto>(uservice.getUserInfo(userId), HttpStatus.OK);
	}
	@PutMapping(value = "/")
	public ResponseEntity<?> modifyUserInfo(UserDto userDto, HttpSession session, Locale locale, Model model) throws Exception {
		logger.info("Welcome modifyUserInfo!  {}.");
		uservice.modifyUserInfo(userDto);
		session.setAttribute("loginUser", userDto);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	@DeleteMapping(value = "/{userId}")
	public ResponseEntity<?> deleteUserInfo(@PathVariable("userId") String userId, HttpSession session, Locale locale, Model model) throws Exception {
		logger.info("Welcome deleteUserInfo!  {}.");
		uservice.deleteUser(userId);
		session.invalidate();
		return new ResponseEntity<Void>(HttpStatus.OK); // 회원 탈퇴시 메인페이지로 이동
	}
}
