package com.ssafy.board.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.board.model.BoardDto;
import com.ssafy.board.model.mapper.BoardMapper;
import com.ssafy.util.PageNavigation;
import com.ssafy.util.SizeConstant;

@Service
public class BoardServiceImpl implements IBoardService {

	private BoardMapper boardMapper;

	public BoardServiceImpl(BoardMapper boardMapper) {
		super();
		this.boardMapper = boardMapper;
	}

	@Override
	@Transactional
	public void write(BoardDto boardDto) throws Exception {
		boardMapper.write(boardDto);
	}

	@Override
	@Transactional(readOnly = true)
	public List<BoardDto> boardlist(Map<String, String> map) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		String key = map.get("key");
		if("userid".equals(key))
			key = "b.user_id";
		param.put("key", key == null ? "" : key);
		param.put("word", map.get("word") == null ? "" : map.get("word"));
		int pgNo = Integer.parseInt(map.get("pgno") == null ? "1" : map.get("pgno"));
		int start = pgNo * SizeConstant.LIST_SIZE - SizeConstant.LIST_SIZE;
		param.put("start", start);
		param.put("listsize", SizeConstant.LIST_SIZE);
		if(map.get("type").equals("notice"))return boardMapper.noticelist(param); // 공지사항 
		return boardMapper.boardlist(param); // 일반
	}
	
	@Override
	public PageNavigation makePageNavigation(Map<String, String> map) throws Exception {
		PageNavigation pageNavigation = new PageNavigation();

		int naviSize = SizeConstant.NAVIGATION_SIZE;
		int sizePerPage = SizeConstant.LIST_SIZE;
		int pgNo = Integer.parseInt(map.get("pgno") == null ? "1" : map.get("pgno"));
		int currentPage = pgNo;
		pageNavigation.setCountPerPage(sizePerPage);
		pageNavigation.setCurrentPage(currentPage);
		pageNavigation.setNaviSize(naviSize);
		Map<String, Object> param = new HashMap<String, Object>();
		String key = map.get("key");
		if ("userid".equals(key))
			key = "user_id";
		param.put("key", key == null ? "" : key);
		param.put("word", map.get("word") == null ? "" : map.get("word"));
		param.put("isnotice", map.get("type").equals("notice") ? 1 : 0);
		int totalCount = boardMapper.getTotalArticleCount(param);
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
	@Transactional
	public BoardDto detail(int article_no) throws Exception {
		boardMapper.updateHit(article_no);
		return boardMapper.detail(article_no);
	}
	
	@Override
	@Transactional
	public void update(BoardDto boardDto) throws Exception {
		boardMapper.update(boardDto);
	}

	@Override
	@Transactional
	public void delete(int article_no) throws Exception {
		boardMapper.delete(article_no);
	}

	@Override
	@Transactional(readOnly = true)
	public List<BoardDto> noticelist(Map<String, String> map) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		String key = map.get("key");
		
		if("userid".equals(key)) key = "b.user_id"; param.put("key", key == null ? ""
		: key); param.put("word", map.get("word") == null ? "" : map.get("word"));
		 
		int pgNo = Integer.parseInt(map.get("pgno") == null ? "1" : map.get("pgno"));
		int start = pgNo * SizeConstant.LIST_SIZE - SizeConstant.LIST_SIZE;
		param.put("start", start);
		param.put("listsize", SizeConstant.LIST_SIZE);
		
		return boardMapper.noticelist(param);
	}

	@Override
	@Transactional
	public void recommend(int articleNo, String userId) throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("articleNo", articleNo);
		param.put("userId", userId);
		boardMapper.addRecommendation(param);
		boardMapper.updateRecommendationCount(param);
	}

	@Override
	public void updateCommentCount(int articleNo) throws Exception {
		boardMapper.decreaseCommentCount(articleNo);
	}
	
}
