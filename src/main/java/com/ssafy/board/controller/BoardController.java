package com.ssafy.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssafy.board.model.BoardDto;
import com.ssafy.board.model.service.IBoardService;
import com.ssafy.user.model.UserDto;
import com.ssafy.util.PageNavigation;

@RestController
@CrossOrigin("*")
@RequestMapping("/board")
public class BoardController {

	private final Logger logger = LoggerFactory.getLogger(BoardController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	private IBoardService boardService;

	public BoardController(IBoardService boardService) {
		super();
		this.boardService = boardService;
	}

	/*
	 * @GetMapping("/write") public String write(@RequestParam Map<String, String>
	 * map, Model model) { logger.debug("write call parameter {}", map);
	 * model.addAttribute("pgno", map.get("pgno")); model.addAttribute("key",
	 * map.get("key")); model.addAttribute("word", map.get("word")); return
	 * "board/write"; }
	 */

	@PostMapping("/")
	public ResponseEntity<?> write(@RequestBody BoardDto boardDto) {
		logger.debug("write boardDto : {}", boardDto);
		HttpStatus status = null;
		try {
			boardService.write(boardDto);
			status = HttpStatus.OK;
		} catch (Exception e) {
			logger.error("글쓰기 실패 : {}", e);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<>(status);
	}

	@GetMapping("/")
	public ResponseEntity<?> list(@RequestParam Map<String, String> map) {
		logger.debug("list parameter pgno : {}", map);
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		List<BoardDto> list = null;
		try {
			list = boardService.boardlist(map);
			PageNavigation pageNavigation = boardService.makePageNavigation(map);
			resultMap.put("list",list);
			resultMap.put("type",map.get("type"));
			resultMap.put("navigation", pageNavigation);
			resultMap.put("pgno", map.get("pgno"));
			resultMap.put("key", map.get("key"));
			resultMap.put("word", map.get("word"));
			resultMap.put("message", SUCCESS);
			status = HttpStatus.OK;
		} catch (Exception e) {
			logger.error("글 목록 불러오기 실패 : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<>(resultMap, status);
	}

	@GetMapping("/{articleno}")
	public ResponseEntity<?> view(@PathVariable("articleno") int articleNo, @RequestParam Map<String, String> map) {
		logger.debug("view articleNo : {}", articleNo);
		BoardDto boardDto = null;
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		try {
			boardDto = boardService.detail(articleNo);
			resultMap.put("board", boardDto);
			resultMap.put("pgno", map.get("pgno"));
			resultMap.put("key", map.get("key"));
			resultMap.put("word", map.get("word"));
			resultMap.put("message", SUCCESS);
			status = HttpStatus.OK;
		} catch (Exception e) {
			logger.error("글 상세보기 실패 : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		logger.debug("view board : {}", boardDto);
		return new ResponseEntity<>(resultMap, status);
	}

	@PutMapping("/")
	public ResponseEntity<?> modify(@RequestBody BoardDto boardDto, @RequestParam Map<String, String> map){
		logger.debug("modify boardDto : {}", boardDto);
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		try {
			boardService.update(boardDto);
			boardDto = boardService.detail(boardDto.getArticleNo());
			resultMap.put("board", boardDto);
			resultMap.put("pgno", map.get("pgno"));
			resultMap.put("key", map.get("key"));
			resultMap.put("word", map.get("word"));
			resultMap.put("message", SUCCESS);
			status = HttpStatus.OK;
		} catch (Exception e) {
			logger.error("글 수정 실패 : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<>(resultMap, status);
	}

	//글 삭제 map 매핑 관련 처리..
	@DeleteMapping("/{articleno}")
	public ResponseEntity<?> delete(@PathVariable("articleno") int articleNo, @RequestParam Map<String, String> map) {
		logger.debug("delete articleNo : {}", articleNo);
		// logger.debug("delete articleNo : {}", map);
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		try {
			boardService.delete(articleNo);
			// resultMap.put("pgno", map.get("pgno"));
			// resultMap.put("key", map.get("key"));
			// resultMap.put("word", map.get("word"));
			resultMap.put("message", SUCCESS);
			status = HttpStatus.OK;
		} catch (Exception e) {
			logger.error("글 삭제 실패 : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<>(resultMap, status);
	}


	//수정할 필요가 있을 듯함
	@GetMapping("/recommend/{articleNo}")
	public ResponseEntity<?> recommend(@PathVariable("articleNo") int articleNo, @RequestParam Map<String, String> map){
		logger.debug("recommend board : {}", articleNo);
		logger.debug("recommend board : {}", map);
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		try {
			boardService.recommend(articleNo, map.get("userId"));
			resultMap.put("message", SUCCESS);
			status = HttpStatus.OK;
		} catch (Exception e) {
			logger.error("글 추천 실패 : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<>(resultMap, status);
	}

	@PutMapping("/{articleNo}")
	public ResponseEntity<?> updateCommentCount(@PathVariable("articleNo") int articleNo){
		logger.debug("update Comment count : {}", articleNo);
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		try {
			boardService.updateCommentCount(articleNo);
			resultMap.put("message", SUCCESS);
			status = HttpStatus.OK;
		} catch (Exception e) {
			logger.error("글 댓글 수 갱신실패 : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<>(resultMap, status);
	}

}
