package com.ssafy.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.user.model.UserDto;
import com.ssafy.user.model.service.IUserService;
import com.ssafy.user.model.service.UserServiceImpl;
import com.ssafy.util.PageNavigation;

@Controller
@RequestMapping("/admin")
public class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	private IUserService uservice;

	public AdminController(IUserService uservice) {
		super();
		this.uservice = uservice;
	}
	
	@GetMapping("/user")
	@ResponseBody
	public ModelAndView user(@RequestParam Map<String, String> map) throws Exception {
		logger.debug("list parameter pgno : {}", map.get("pgno"));
		ModelAndView mav = new ModelAndView();
		List<UserDto> list = uservice.getUsersInfo(map);
		PageNavigation pageNavigation = uservice.makePageNavigation(map);
		mav.addObject("users", list);
		mav.addObject("navigation", pageNavigation);
		mav.addObject("pgno", map.get("pgno"));
		mav.addObject("key", map.get("key"));
		mav.addObject("word", map.get("word"));
		mav.setViewName("admin/userList");
		return mav;
	}
	
	
	@GetMapping("/deleteUser")
	public String deleteUserInfo(String userId, Model model) throws Exception {
		logger.info("Welcome deleteUser!  {}.");
		uservice.deleteUser(userId);
		return "redirect:/admin/user?pgno=1&key=&word=";
	}
	
}
