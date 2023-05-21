package com.ssafy.board.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.board.model.BoardDto;

@Mapper
public interface BoardMapper {

	void write(BoardDto boardDto) throws SQLException;

	List<BoardDto> boardlist(Map<String, Object> param) throws SQLException;
	
	List<BoardDto> noticelist(Map<String, Object> param) throws SQLException;
	
	int getTotalArticleCount(Map<String, Object> param) throws SQLException;
	
	BoardDto detail(int article_no) throws SQLException;

	void updateHit(int article_no) throws SQLException;
	
	void update(BoardDto boardDto) throws SQLException;

	void delete(int article_no) throws SQLException;
	
	void decreaseCommentCount(int article_no) throws SQLException;

	void updateRecommendationCount(Map<String, Object> param) throws SQLException;

	void addRecommendation(Map<String, Object> param) throws SQLException;
}