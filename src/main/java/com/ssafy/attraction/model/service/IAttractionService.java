package com.ssafy.attraction.model.service;

import java.util.List;

import com.ssafy.attraction.model.AttractionDto;
import com.ssafy.attraction.model.MyTripDto;

public interface IAttractionService {
	List<AttractionDto> getAttractions(int sido_code, int contentTypeId, int gugunCode) throws Exception;
	List<String> getMyAttractions(String user_id) throws Exception;
	boolean addAttraction(MyTripDto mdto) throws Exception;

}
