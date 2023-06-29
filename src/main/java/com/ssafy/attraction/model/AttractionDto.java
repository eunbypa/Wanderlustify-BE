package com.ssafy.attraction.model;

import lombok.Data;

@Data
public class AttractionDto {
	private int contentId;
	private int contentTypeId;
	private String title;
	private String addr1;
	private String addr2 ;
	private String zipcode ;
	private String tel;
	private String firstImage;
	private String firstImage2;
	private int readcount;
	private int sidoCode;
	private int gugunCode;
	private double latitude;
	private double longitude;
	private String mLevel;
	public AttractionDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AttractionDto(int contentId, int contentTypeId, String title, String addr1, String addr2, String zipcode,
			String tel, String firstImage, String firstImage2, int readcount, int sidoCode, int gugunCode,
			double latitude, double longitude, String mLevel) {
		super();
		this.contentId = contentId;
		this.contentTypeId = contentTypeId;
		this.title = title;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.zipcode = zipcode;
		this.tel = tel;
		this.firstImage = firstImage;
		this.firstImage2 = firstImage2;
		this.readcount = readcount;
		this.sidoCode = sidoCode;
		this.gugunCode = gugunCode;
		this.latitude = latitude;
		this.longitude = longitude;
		this.mLevel = mLevel;
	}
	}
