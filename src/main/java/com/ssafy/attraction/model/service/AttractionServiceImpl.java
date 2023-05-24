package com.ssafy.attraction.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.attraction.model.AttractionDto;
import com.ssafy.attraction.model.MyTripDto;
import com.ssafy.attraction.model.mapper.AttractionMapper;

@Service
public class AttractionServiceImpl implements IAttractionService {
	
	private AttractionMapper adao;
	
	@Autowired
	public AttractionServiceImpl(AttractionMapper adao) {
        this.adao = adao;
    }


	@Override
	public List<MyTripDto> getMyAttractions(MyTripDto mdto) throws Exception {
		return adao.getMyAttractions(mdto);
	}
	

	@Override
	public boolean addAttraction(MyTripDto mdto) throws Exception {
		return adao.addAttraction(mdto);
	}


	@Override
	public int getMyTripMax(String id) throws Exception {
		return adao.getMyTripMax(id);
	}


	@Override
	public List<Integer> getMyTripAll(String id) throws Exception {
		return adao.getMyTripAll(id);
	}


	@Override
	public void deleteMyTripAll(MyTripDto myTripDto) throws Exception {
		adao.deleteMyTripAll(myTripDto);
	}


	@Override
	public void deleteMyTrip(int no) throws Exception {
		adao.deleteMyTrip(no);
	}
	

}
