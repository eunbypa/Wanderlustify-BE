package com.ssafy.board.model;

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
	
	public int getArticleNo() {
		return articleNo;
	}
	
	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public int getHit() {
		return hit;
	}
	
	public void setHit(int hit) {
		this.hit = hit;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}

	public int getIsnotice() {
		return isnotice;
	}

	public void setIsnotice(int isnotice) {
		this.isnotice = isnotice;
	}

	
	public Object getRecommendation() {
		return this.recommendation;
	}

	public void setRecommendation(int recommendation) {
		this.recommendation = recommendation;
	};

	public Object getComment() {
		return this.comment;
	}

	public void setComment(int comment) {
		this.comment = comment;
	};
	
	@Override
	public String toString() {
		return "BoardDto [articleNo=" + articleNo + ", userId=" + userId + ", userName=" + userName + ", subject="
				+ subject + ", content=" + content + ", hit=" + hit + ", recommendation=" + recommendation +
				 ", comment=" + comment +", date=" + date + "]";
	}
	
}
