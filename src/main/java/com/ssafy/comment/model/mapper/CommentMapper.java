package com.ssafy.comment.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.comment.model.CommentDto;

@Mapper
public interface CommentMapper {
	void write(CommentDto commentDto) throws Exception;
	List<CommentDto> commentList(int articleNo) throws Exception;
	void delete(int commentNo) throws Exception;
	void update(CommentDto commentDto) throws Exception;
	int getTotalCommentCount(int articleNo) throws Exception;
	void updateCommentCount(Map<String, Object> param)  throws Exception;
}
