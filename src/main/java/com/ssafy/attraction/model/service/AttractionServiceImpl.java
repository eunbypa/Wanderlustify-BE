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
	public List<AttractionDto> getAttractions(int sido_code, int contentTypeId, int gugunCode) throws Exception {
		return adao.getAttractions(sido_code, contentTypeId, gugunCode);
	}

	@Override
	public List<String> getMyAttractions(String user_id) throws Exception {
		return adao.getMyAttractions(user_id);
	}
	

	@Override
	public boolean addAttraction(MyTripDto mdto) throws Exception {
		return adao.addAttraction(mdto);
	}
	

}
