package com.ssafy.attraction.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional
	public List<MyTripDto> getMyAttractions(MyTripDto mdto) throws Exception {
		return adao.getMyAttractions(mdto);
	}
	

	@Override
	@Transactional
	public boolean addAttraction(MyTripDto mdto) throws Exception {
		return adao.addAttraction(mdto);
	}


	@Override
	@Transactional
	public int getMyTripMax(String id) throws Exception {
		return adao.getMyTripMax(id);
	}


	@Override
	@Transactional
	public List<Integer> getMyTripAll(String id) throws Exception {
		return adao.getMyTripAll(id);
	}


	@Override
	@Transactional
	public void deleteMyTripAll(MyTripDto myTripDto) throws Exception {
		adao.deleteMyTripAll(myTripDto);
	}


	@Override
	@Transactional
	public void deleteMyTrip(int no) throws Exception {
		adao.deleteMyTrip(no);
	}


	@Override
	@Transactional
	public void addMyTripAll(MyTripDto[] list) throws Exception {
		for (int i = 0; i < list.length; i++) {
			adao.addAttraction(list[i]);
		}
	}

	
	

}
