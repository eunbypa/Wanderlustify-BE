package com.ssafy.hotplace.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.board.model.mapper.BoardMapper;
import com.ssafy.hotplace.model.HotPlaceDto;
import com.ssafy.hotplace.model.mapper.HotPlaceMapper;
import com.ssafy.util.PageNavigation;
import com.ssafy.util.SizeConstant;

@Service
public class HotPlaceServiceImpl implements IHotPlaceService {
	
	private HotPlaceMapper hotplaceMapper;

	
	public HotPlaceServiceImpl(HotPlaceMapper hotplaceMapper) {
		super();
		this.hotplaceMapper = hotplaceMapper;
	}

	@Override
	@Transactional
	public void write(HotPlaceDto hotplaceDto) throws Exception {
		// TODO Auto-generated method stub
		hotplaceMapper.write(hotplaceDto);
	}

	@Override
	@Transactional(readOnly = true)
	public List<HotPlaceDto> hotplaceList(Map<String, String> map) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		String key = map.get("key");
		if("username".equals(key))
			key = "name";
		param.put("sort", map.get("sort"));
		param.put("key", key == null ? "" : key);
		param.put("word", map.get("word") == null ? "" : map.get("word"));
		int pgNo = Integer.parseInt(map.get("pgno") == null ? "1" : map.get("pgno"));
		int start = pgNo * SizeConstant.HOT_PLACE_LIST_SIZE - SizeConstant.HOT_PLACE_LIST_SIZE;
		param.put("start", start);
		param.put("listsize", SizeConstant.HOT_PLACE_LIST_SIZE);
		return hotplaceMapper.hotplaceList(param);
	}
	@Override
	@Transactional(readOnly = true)
	public List<HotPlaceDto> hotplaceTOP3() throws Exception {
		
		return hotplaceMapper.hotplaceTOP3();
	}

	@Override
	public PageNavigation makePageNavigation(Map<String, String> map) throws Exception {
		PageNavigation pageNavigation = new PageNavigation();

		int naviSize = SizeConstant.NAVIGATION_SIZE;
		int sizePerPage = SizeConstant.HOT_PLACE_LIST_SIZE;
		int pgNo = Integer.parseInt(map.get("pgno") == null ? "1" : map.get("pgno"));
		int currentPage = pgNo;
		pageNavigation.setCountPerPage(sizePerPage);
		pageNavigation.setCurrentPage(currentPage);
		pageNavigation.setNaviSize(naviSize);
		Map<String, Object> param = new HashMap<String, Object>();
		String key = map.get("key");
		if ("username".equals(key))
			key = "u.name";
		param.put("key", key == null ? "" : key);
		param.put("word", map.get("word") == null ? "" : map.get("word"));
		int totalCount;
		if ("u.name".equals(key)) totalCount = hotplaceMapper.getTotalCountWithJoin(param);
		else totalCount = hotplaceMapper.getTotalCount(param);
		pageNavigation.setTotalCount(totalCount);
		int totalPageCount = (totalCount - 1) / sizePerPage + 1;
		pageNavigation.setTotalPageCount(totalPageCount);
		boolean startRange = currentPage <= naviSize;
		pageNavigation.setStartRange(startRange);
		boolean endRange = (totalPageCount - 1) / naviSize * naviSize < currentPage;
		pageNavigation.setEndRange(endRange);
		pageNavigation.makeNavigator();

		return pageNavigation;
	}

	@Override
	@Transactional(readOnly = true)
	public HotPlaceDto detail(int hotplaceNo) throws Exception {
		// TODO Auto-generated method stub
		return hotplaceMapper.detail(hotplaceNo);
	}

	@Override
	@Transactional
	public void delete(int hotplaceNo) throws Exception {
		// TODO Auto-generated method stub
		hotplaceMapper.delete(hotplaceNo);
	}

	@Override
	@Transactional
	public void update(HotPlaceDto hotplaceDto) throws Exception {
		// TODO Auto-generated method stub
		hotplaceMapper.update(hotplaceDto);
	}

	@Override
	@Transactional
	public void recommend(int hotplaceNo) throws Exception {
		// TODO Auto-generated method stub
		hotplaceMapper.updateRecommendationCount(hotplaceNo);
	}

	@Override
	public void writeFile(Map<String, Object> params) throws Exception{
		// TODO Auto-generated method stub
		hotplaceMapper.writeFile(params);
	}

}
