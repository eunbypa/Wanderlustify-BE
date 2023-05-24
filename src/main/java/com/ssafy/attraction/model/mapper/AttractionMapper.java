package com.ssafy.attraction.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.attraction.model.MyTripDto;

@Mapper
public interface AttractionMapper {
	List<MyTripDto> getMyAttractions(MyTripDto mdto) throws Exception;
	boolean addAttraction(MyTripDto mdto) throws Exception;
	int getMyTripMax(String id) throws Exception;
	List<Integer> getMyTripAll(String id) throws Exception;
    void deleteMyTripAll(MyTripDto myTripDto) throws Exception;
	void deleteMyTrip(int no) throws Exception;
}
