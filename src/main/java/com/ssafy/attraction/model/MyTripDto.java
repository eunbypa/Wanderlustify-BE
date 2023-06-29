package com.ssafy.attraction.model;

import lombok.Data;

@Data
public class MyTripDto {
	private int content_id;
	private String user_id;
	private int user_mytrip_no; 
	private int no;
	public MyTripDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public MyTripDto(int content_id, String user_id, int user_mytrip_no) {
        this.content_id = content_id;
        this.user_id = user_id;
        this.user_mytrip_no = user_mytrip_no;
    }

    public MyTripDto(int content_id, int no) {
		this.content_id = content_id;
		this.no = no;
	}

	public MyTripDto(int content_id, int user_mytrip_no, int no) {
        this.content_id = content_id;
        this.user_mytrip_no = user_mytrip_no;
        this.no = no;
    }


    public MyTripDto(String user_id, int user_mytrip_no) {
        this.user_id = user_id;
        this.user_mytrip_no = user_mytrip_no;
    }
	
}
