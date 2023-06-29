package com.ssafy.comment.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.comment.model.CommentDto;
import com.ssafy.comment.model.mapper.CommentMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements ICommentService {

	private final CommentMapper commentMapper;
	


	@Override
	@Transactional
	public void write(CommentDto commentDto) throws Exception {
		// TODO Auto-generated method stub
		commentMapper.write(commentDto);
		Map<String, Object> param = new HashMap<>();
		param.put("count", 1);
		param.put("articleNo", commentDto.getArticleNo());
		commentMapper.updateCommentCount(param); // 댓글 작성 시 게시글의 댓글 수 1 증가
	}

	@Override
	@Transactional(readOnly = true)
	public List<CommentDto> commentList(int articleNo) throws Exception {
		// TODO Auto-generated method stub
		return commentMapper.commentList(articleNo);
	}

	@Override
	@Transactional
	public void delete(int commentNo) throws Exception {
		// TODO Auto-generated method stub
		commentMapper.delete(commentNo);
		// Map<String, Object> param = new HashMap<>();
		// param.put("count", -1);
		//  param.put("articleNo", articleNo);
		// commentMapper.updateCommentCount(param); // 댓글 작성 시 게시글의 댓글 수 1 증가
	}

	@Override
	@Transactional
	public void update(CommentDto commentDto) throws Exception {
		// TODO Auto-generated method stub
		commentMapper.update(commentDto);
	}

}
