package com.ssafy.attraction.model;

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


    public int getContent_id() {
		return content_id;
	}
	public void setContent_id(int content_id) {
		this.content_id = content_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getUser_mytrip_no() {
		return user_mytrip_no;
	}
	public void setUser_mytrip_no(int user_mytrip_no) {
		this.user_mytrip_no = user_mytrip_no;
	}

	


    @Override
    public String toString() {
        return "MyTripDto [content_id=" + content_id + ", user_id=" + user_id + ", user_mytrip_no=" + user_mytrip_no
                + "]";
    }


    public int getNo() {
        return no;
    }


    public void setNo(int no) {
        this.no = no;
    }

	
	
}
