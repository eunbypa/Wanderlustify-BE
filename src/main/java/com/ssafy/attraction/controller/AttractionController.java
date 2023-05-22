package com.ssafy.attraction.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.attraction.model.AttractionDto;
import com.ssafy.attraction.model.MyTripDto;
import com.ssafy.attraction.model.service.AttractionServiceImpl;
import com.ssafy.attraction.model.service.IAttractionService;
import com.ssafy.user.model.UserDto;

@RestController
@CrossOrigin("*")
@RequestMapping("/attraction")
public class AttractionController {
	private static final Logger logger = LoggerFactory.getLogger(AttractionController.class);

	private final IAttractionService aservice;
	
	

	
	@Autowired
	public AttractionController(IAttractionService aservice) {
        this.aservice = aservice;
    }


	@GetMapping("/addMyTrip")
	public ResponseEntity<?> addMyTrip(@RequestParam String contentId, HttpSession session) throws Exception {
		logger.info("Welcome addmytrip! .");
		UserDto userinfo = (UserDto) session.getAttribute("loginUser");
		System.out.println(contentId);
		aservice.addAttraction(new MyTripDto(Integer.parseInt(contentId), userinfo.getId()));
		return new ResponseEntity<>(HttpStatus.OK);

	}


	@GetMapping("/getMyTrip")
	public ResponseEntity<?> getMyTrip(HttpSession session) throws Exception {
		UserDto userinfo = (UserDto) session.getAttribute("loginUser");
		List<String> list = aservice.getMyAttractions(userinfo.getId());
		logger.info("Welcome getMytrip {}", list);

		return new ResponseEntity<List<String>>(list, HttpStatus.OK);
	}


}
