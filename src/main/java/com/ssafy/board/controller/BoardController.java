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
	public ResponseEntity<?> write(BoardDto boardDto, HttpSession session,
			RedirectAttributes redirectAttributes) throws Exception {
		logger.debug("write boardDto : {}", boardDto);
		UserDto userDto = (UserDto) session.getAttribute("loginUser");
		boardDto.setUserId(userDto.getId());
		boardService.write(boardDto);
		HashMap<String,Object> result = new HashMap<String, Object>();
		result.put("pgno", "1");
		result.put("key", "");
		result.put("word", "");
		/*
		 * redirectAttributes.addAttribute("pgno", "1");
		 * redirectAttributes.addAttribute("key", "");
		 * redirectAttributes.addAttribute("word", "");
		 */
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<?> list(@RequestParam Map<String, String> map) throws Exception {
		logger.debug("list parameter pgno : {}", map.get("pgno"));
		List<BoardDto> list = boardService.boardlist(map);
		PageNavigation pageNavigation = boardService.makePageNavigation(map);
		HashMap<String,Object> result = new HashMap<String, Object>();
		result.put("list", list);
		result.put("navigation", pageNavigation);
		result.put("pgno", map.get("pgno"));
		result.put("key", map.get("key"));
		result.put("word", map.get("word"));
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@GetMapping("/{articleno}")
	public ResponseEntity<?> view(@PathVariable("articleno") int articleNo, @RequestParam Map<String, String> map)
			throws Exception {
		BoardDto boardDto = boardService.detail(articleNo);
		logger.debug("view board : {}", boardDto);
		HashMap<String,Object> result = new HashMap<String, Object>();
		result.put("board", boardDto);
		result.put("pgno", map.get("pgno"));
		result.put("key", map.get("key"));
		result.put("word", map.get("word"));
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@PutMapping("/")
	public ResponseEntity<?> modify(@RequestBody BoardDto boardDto, @RequestParam Map<String, String> map) throws Exception {
		logger.debug("modify boardDto : {}", boardDto);
		boardService.update(boardDto);
		HashMap<String,Object> result = new HashMap<String, Object>();
		result.put("board", boardDto);
		result.put("pgno", map.get("pgno"));
		result.put("key", map.get("key"));
		result.put("word", map.get("word"));
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@DeleteMapping("/{articleno}")
	public ResponseEntity<?> delete(@PathVariable("articleno") int articleNo, @RequestParam Map<String, String> map
			) throws Exception {
		logger.debug("delete articleNo : {}", articleNo);
		boardService.delete(articleNo);
		HashMap<String,Object> result = new HashMap<String, Object>();
		result.put("pgno", map.get("pgno"));
		result.put("key", map.get("key"));
		result.put("word", map.get("word"));
		/*
		 * redirectAttributes.addAttribute("pgno", map.get("pgno"));
		 * redirectAttributes.addAttribute("key", map.get("key"));
		 * redirectAttributes.addAttribute("word", map.get("word"));
		 */
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

}
