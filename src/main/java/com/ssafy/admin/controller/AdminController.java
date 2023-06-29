package com.ssafy.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.user.model.UserDto;
import com.ssafy.user.model.service.IUserService;
import com.ssafy.user.model.service.UserServiceImpl;
import com.ssafy.util.PageNavigation;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/admin")
public class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	private final IUserService uservice;
	
	@GetMapping("/users")
	public ResponseEntity<?> getUsers(@RequestParam Map<String, String> map){
		logger.debug("list parameter pgno : {}", map.get("pgno"));
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		if(map.get("pgno") == null) map.put("pgno", "1");
		List<UserDto> list = null;
		try {
			list = uservice.getUsersInfo(map);
			PageNavigation pageNavigation = uservice.makePageNavigation(map);
			resultMap.put("pgno", map.get("pgno"));
			resultMap.put("key",map.get("key"));
			resultMap.put("word",map.get("word"));
			resultMap.put("users", list);
			resultMap.put("navigation", pageNavigation);
			status = HttpStatus.OK;
		} catch (Exception e) {
			logger.error("회원 목록 불러오기 실패 : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<>(resultMap, status);
	}
	
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<?> deleteUserInfo(@PathVariable("userId") String userId) {
		logger.info("Welcome deleteUser!  {}.", userId);
		HttpStatus status = null;
		try {
			uservice.deleteUser(userId);
			uservice.deleRefreshToken(userId);
			status = HttpStatus.OK;
		} catch (Exception e) {
			logger.error("관리자 회원 강제 탈퇴 실패 : {}", e);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<>(status);
		// return "redirect:/admin/user?pgno=1&key=&word=";
	}
	
}
