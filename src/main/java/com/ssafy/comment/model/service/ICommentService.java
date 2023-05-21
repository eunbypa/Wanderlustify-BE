package com.ssafy.comment.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.comment.model.CommentDto;

public interface ICommentService {
	void write(CommentDto commentDto) throws Exception;
	List<CommentDto> commentList(int articleNo) throws Exception;
	void delete(int commentNo, int articleNo) throws Exception;
	void update(CommentDto commentDto) throws Exception;
}
