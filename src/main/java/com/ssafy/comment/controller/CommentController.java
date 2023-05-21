package com.ssafy.comment.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssafy.comment.model.CommentDto;
import com.ssafy.comment.model.service.ICommentService;
import com.ssafy.user.model.UserDto;

@RestController
@CrossOrigin("*")
@RequestMapping("/comment")
public class CommentController {
	private final Logger logger = LoggerFactory.getLogger(CommentController.class);
	private ICommentService commentService;
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	public CommentController(ICommentService commentService) {
		super();
		this.commentService = commentService;
	}
	
	@PostMapping("/")
	public ResponseEntity<?> write(@RequestBody CommentDto commentDto){
		logger.debug("write commentDto : {}", commentDto);
		HttpStatus status = null;
		try {
			commentService.write(commentDto);
			status = HttpStatus.OK;
		} catch (Exception e) {
			logger.error("댓글 작성 실패 : {}", e);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<>(status);
	}

	@GetMapping("/{articleno}")
	public ResponseEntity<?> list(@PathVariable("articleno") int articleNo) {
		logger.debug("list parameter articleno : {}", articleNo);
		HttpStatus status = null;
		Map<String, Object> resultMap = new HashMap<>();
		List<CommentDto> list = null;
		try {
			list = commentService.commentList(articleNo);
			if(list == null) { // 댓글이 없음
				resultMap.put("message", FAIL);
				status = HttpStatus.ACCEPTED;
			}else {
				resultMap.put("list", list);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.OK;
			}
		} catch (Exception e) {
			logger.error("댓글 목록 가져오기 실패 : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<>(resultMap, status);
	}

	@PutMapping("/")
	public ResponseEntity<?> modify(@RequestBody CommentDto commentDto) {
		logger.debug("modify commentDto : {}", commentDto);
		HttpStatus status = null;
		HashMap<String,Object> resultMap = new HashMap<String, Object>();
		try {
			commentService.update(commentDto);
			resultMap.put("comment", commentDto);
			resultMap.put("message", SUCCESS);
			status = HttpStatus.OK;
		} catch (Exception e) {
			logger.error("댓글 수정 실패 : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<>(resultMap, status);
	}

	@DeleteMapping("/{commentno}")
	public ResponseEntity<?> delete(@PathVariable("commentno") int commentNo){
		logger.debug("delete commentNo : {}", commentNo);
		HttpStatus status = null;
		HashMap<String,Object> resultMap = new HashMap<String, Object>();
		try {
			commentService.delete(commentNo);
			resultMap.put("message", SUCCESS);
			status = HttpStatus.OK;
		} catch (Exception e) {
			logger.error("댓글 삭제 실패 : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		return new ResponseEntity<>(resultMap, status);
	}
}
