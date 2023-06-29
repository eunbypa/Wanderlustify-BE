package com.ssafy.board.model;

import lombok.Data;

@Data
public class BoardDto {
	
	private int articleNo;
	private String userId;
	private String userName;
	private String subject;
	private String content;
	private int hit;
	private int recommendation;
	private int comment;
	private String date;
	private int isnotice;
		
}
