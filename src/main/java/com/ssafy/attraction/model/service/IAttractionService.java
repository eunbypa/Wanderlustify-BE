package com.ssafy.attraction.model.service;

import java.util.List;

import com.ssafy.attraction.model.MyTripDto;

public interface IAttractionService {
	List<String> getMyAttractions(MyTripDto mdto) throws Exception;
	boolean addAttraction(MyTripDto mdto) throws Exception;
	int getMyTripMax(String id) throws Exception;
	List<Integer> getMyTripAll(String id) throws Exception;

}
