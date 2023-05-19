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

@RestController
@CrossOrigin("*")
@RequestMapping("/admin")
public class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	private IUserService uservice;

	public AdminController(IUserService uservice) {
		super();
		this.uservice = uservice;
	}
	
	@GetMapping("/users")
	public ResponseEntity<?> user(@RequestParam Map<String, String> map) throws Exception {
		logger.debug("list parameter pgno : {}", map.get("pgno"));
		if(map.get("pgno") == null) map.put("pgno", "1");
		List<UserDto> list = uservice.getUsersInfo(map);
		PageNavigation pageNavigation = uservice.makePageNavigation(map);
		HashMap<String, Object> map2 = new HashMap<>();
		map2.put("pgno", map.get("pgno"));
		map2.put("key",map.get("key"));
		map2.put("word",map.get("word"));
		map2.put("users", list);
		map2.put("navigation", pageNavigation);
		return new ResponseEntity<>(map2, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<?> deleteUserInfo(@PathVariable("userId") String userId, Model model) throws Exception {
		logger.info("Welcome deleteUser!  {}.");
		uservice.deleteUser(userId);
		HashMap<String, Object> map = new HashMap<>();
		map.put("pgno", 1);
		map.put("key","");
		map.put("word","");
		return new ResponseEntity<>(map, HttpStatus.OK);
		// return "redirect:/admin/user?pgno=1&key=&word=";
	}
	
}
