package com.ssafy.attraction.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.attraction.model.AttractionDto;
import com.ssafy.attraction.model.MyTripDto;

@Mapper
public interface AttractionMapper {
	List<AttractionDto> getAttractions(int sido_code, int contentTypeId, int gugunCode) throws Exception;
	List<String> getMyAttractions(String user_id) throws Exception;
	boolean addAttraction(MyTripDto mdto) throws Exception;

}
