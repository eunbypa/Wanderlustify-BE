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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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


	@PostMapping("/addMyTrip")
	public ResponseEntity<?> addMyTrip(@RequestBody MyTripDto myTripDto, HttpSession session) throws Exception {
		logger.info("Welcome addmytrip! .");
		aservice.addAttraction(myTripDto);
		return new ResponseEntity<>(HttpStatus.OK);

	}


	@GetMapping("/getMyTrip/{id}/{user_mytrip_no}")
	public ResponseEntity<?> getMyTrip(@PathVariable("id") String id, @PathVariable("user_mytrip_no") int user_mytrip_no  ,HttpSession session) throws Exception {
		List<MyTripDto> list = aservice.getMyAttractions(new MyTripDto(id, user_mytrip_no));
		logger.info("Welcome getMytrip {}", list);
		return new ResponseEntity<List<MyTripDto>>(list, HttpStatus.OK);
	}

	// 유저가 등록한 여행계획 중 가장 큰 번호
	@GetMapping("/getMyTripMax/{id}")
	public ResponseEntity<?> getMyTripMax(@PathVariable("id") String id) throws Exception {
		int max = aservice.getMyTripMax(id);
		logger.info("Welcome getMyTripMax {}", max);

		return new ResponseEntity<Integer>(max, HttpStatus.OK);
		
	}

	// 유저가 등록한 여행계획
	@GetMapping("/getMyTripAll/{id}")
	public ResponseEntity<?> getMyTripCount(@PathVariable("id") String id) throws Exception { 
		List<Integer> list = aservice.getMyTripAll(id);
		logger.info("Welcome getMyTripAll {}", list);

		return new ResponseEntity<List<Integer>>(list, HttpStatus.OK);
	}

	// 유저가 여행계획 삭제(전체)
	@DeleteMapping("/deleteMyTripAll/{id}/{trip_no}")
	public ResponseEntity<?> deleteMyTripAll(@PathVariable("id") String id, @PathVariable("trip_no") int trip_no) throws Exception {
		aservice.deleteMyTripAll(new MyTripDto(id, trip_no));
		return new ResponseEntity<>(HttpStatus.OK);

	}

	// 유저가 여행계획 삭제(개별)
	@DeleteMapping("/deleteMyTrip/{no}")
	public ResponseEntity<?> deleteMyTrip(@PathVariable("no") int no) throws Exception {
		aservice.deleteMyTrip(no);
		return new ResponseEntity<>(HttpStatus.OK);
	}


}
