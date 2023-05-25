package com.ssafy.hotplace.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.board.model.BoardDto;
import com.ssafy.hotplace.model.HotPlaceDto;
import com.ssafy.util.PageNavigation;

public interface IHotPlaceService {
	void write(HotPlaceDto hotplaceDto) throws Exception;
	List<HotPlaceDto> hotplaceList(Map<String, String> map) throws Exception;
	PageNavigation makePageNavigation(Map<String, String> map) throws Exception;
	HotPlaceDto detail(int hotplaceNo) throws Exception;
	void delete(int hotplaceNo) throws Exception;
	void update(HotPlaceDto hotplaceDto) throws Exception;
	void recommend(int hotplaceNo, String userId) throws Exception;
    void writeFile(Map<String, Object> params) throws Exception;
	List<HotPlaceDto> hotplaceTOP3() throws Exception;
	List<HotPlaceDto> getRecommendList(String userId) throws Exception;
}
