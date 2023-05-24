package com.ssafy.attraction.model.service;

import java.util.List;

import com.ssafy.attraction.model.MyTripDto;

public interface IAttractionService {
	List<MyTripDto> getMyAttractions(MyTripDto mdto) throws Exception;
	boolean addAttraction(MyTripDto mdto) throws Exception;
	int getMyTripMax(String id) throws Exception;
	List<Integer> getMyTripAll(String id) throws Exception;
    void deleteMyTripAll(MyTripDto myTripDto) throws Exception;
	void deleteMyTrip(int no) throws Exception;
    void addMyTripAll(MyTripDto[] list) throws Exception;

}
