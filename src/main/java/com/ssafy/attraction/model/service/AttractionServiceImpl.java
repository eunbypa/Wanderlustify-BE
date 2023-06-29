package com.ssafy.attraction.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.attraction.model.AttractionDto;
import com.ssafy.attraction.model.MyTripDto;
import com.ssafy.attraction.model.mapper.AttractionMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AttractionServiceImpl implements IAttractionService {
	
	private final AttractionMapper attractionMapper;


	@Override
	@Transactional
	public List<MyTripDto> getMyAttractions(MyTripDto myTripDto) throws Exception {
		return attractionMapper.getMyAttractions(myTripDto);
	}
	

	@Override
	@Transactional
	public boolean addAttraction(MyTripDto myTripDto) throws Exception {
		return attractionMapper.addAttraction(myTripDto);
	}


	@Override
	@Transactional
	public int getMyTripMax(String id) throws Exception {
		return attractionMapper.getMyTripMax(id);
	}


	@Override
	@Transactional
	public List<Integer> getMyTripAll(String id) throws Exception {
		return attractionMapper.getMyTripAll(id);
	}


	@Override
	@Transactional
	public void deleteMyTripAll(MyTripDto myTripDto) throws Exception {
		attractionMapper.deleteMyTripAll(myTripDto);
	}


	@Override
	@Transactional
	public void deleteMyTrip(int no) throws Exception {
		attractionMapper.deleteMyTrip(no);
	}


	@Override
	@Transactional
	public void addMyTripAll(MyTripDto[] list) throws Exception {
		for (int i = 0; i < list.length; i++) {
			attractionMapper.addAttraction(list[i]);
		}
	}

	
	

}
