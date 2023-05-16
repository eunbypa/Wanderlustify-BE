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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.attraction.model.AttractionDto;
import com.ssafy.attraction.model.MyTripDto;
import com.ssafy.attraction.model.service.AttractionServiceImpl;
import com.ssafy.attraction.model.service.IAttractionService;
import com.ssafy.user.model.UserDto;

@Controller
@RequestMapping("/attraction")
public class AttractionController {
	private static final Logger logger = LoggerFactory.getLogger(AttractionController.class);

	private final IAttractionService aservice;
	
	

	
	@Autowired
	public AttractionController(IAttractionService aservice) {
        this.aservice = aservice;
    }

    @GetMapping
	public String init(Model model) {
		logger.info("Welcome attraction! .");
		List<Integer> list = new ArrayList<>();

		// model.addAttribute("sidos", sservice.getSidos());
		return "trips/search";
	}

	@GetMapping("/myTrip")
	public String myTrip() {

		return "trips/mytrip";
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


	@GetMapping("/hotplace")
	public String hotplace() {
		return "trips/hotplace";
	}
	






	// @GetMapping("/search")
	// public ResponseEntity<?> search(@RequestParam String areaCode, @RequestParam String contentTypeId, @RequestParam String sigunguCode, Model model) {

	// 	int sido_code = Integer.parseInt(areaCode);
	// 	int contentType = contentTypeId == null ? -1 : Integer.parseInt(contentTypeId);
	// 	int gugunCode = Integer.parseInt(sigunguCode);
		
		
	// 	List<AttractionDto> attractions = aservice.getAttractions(sido_code, contentType, gugunCode);
	// 	return new ResponseEntity<List<AttractionDto>>(attractions, HttpStatus.OK);
	// }

	// @GetMapping("gugun")
	// public ResponseEntity<?> gugun(@RequestParam String sidoCode) {
	// 	String sido = sidoCode;
	// 	List<GuGunDto> guguns = gservice.getGuGuns(Integer.parseInt(sido));
		
	// 	return new ResponseEntity<List<GuGunDto>>(guguns, HttpStatus.OK);
	// }


	
	// 	} else if (action.equalsIgnoreCase("addMyTrip")) {
	// 		int contentId = Integer.parseInt(request.getParameter("contentId"));
	// 		UserDto userinfo = (UserDto) request.getSession().getAttribute("loginUser");
	// 		System.out.println(userinfo);
	// 		tservice.addAttraction(new MyTripDto(contentId, userinfo.getId()));
	// 	}

}
