package com.ssafy.board.model.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.board.model.BoardDto;
import com.ssafy.util.PageNavigation;

public interface IBoardService {

	void write(BoardDto boardDto) throws Exception;
	List<BoardDto> boardlist(Map<String, String> map) throws Exception;
	List<BoardDto> noticelist(Map<String, String> map) throws Exception;
	PageNavigation makePageNavigation(Map<String, String> map) throws Exception;
	BoardDto detail(int articleNo) throws Exception;
	void delete(int articleNo) throws Exception;
	void update(BoardDto boardDto) throws Exception;
	void recommend(int articleNo, String userId) throws Exception;
}
