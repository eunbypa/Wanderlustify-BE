package com.ssafy.attraction.model;

public class AttractionDto {
	private int content_id;
	private int content_type_id;
	private String title;
	private String addr1;
	private String addr2 ;
	private String zipcode ;
	private String tel;
	private String first_image;
	private String first_image2;
	private int readcount;
	private int sido_code;
	private int gugun_code;
	private double latitude;
	private double longitude;
	private String mlevel;
	public AttractionDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AttractionDto(int content_id, int content_type_id, String title, String addr1, String addr2, String zipcode,
			String tel, String first_image, String first_image2, int readcount, int sido_code, int gugun_code,
			double latitude, double longitude, String mlevel) {
		super();
		this.content_id = content_id;
		this.content_type_id = content_type_id;
		this.title = title;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.zipcode = zipcode;
		this.tel = tel;
		this.first_image = first_image;
		this.first_image2 = first_image2;
		this.readcount = readcount;
		this.sido_code = sido_code;
		this.gugun_code = gugun_code;
		this.latitude = latitude;
		this.longitude = longitude;
		this.mlevel = mlevel;
	}
	public int getContent_id() {
		return content_id;
	}
	public void setContent_id(int content_id) {
		this.content_id = content_id;
	}
	public int getContent_type_id() {
		return content_type_id;
	}
	public void setContent_type_id(int content_type_id) {
		this.content_type_id = content_type_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getFirst_image() {
		return first_image;
	}
	public void setFirst_image(String first_image) {
		this.first_image = first_image;
	}
	public String getFirst_image2() {
		return first_image2;
	}
	public void setFirst_image2(String first_image2) {
		this.first_image2 = first_image2;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public int getSido_code() {
		return sido_code;
	}
	public void setSido_code(int sido_code) {
		this.sido_code = sido_code;
	}
	public int getGugun_code() {
		return gugun_code;
	}
	public void setGugun_code(int gugun_code) {
		this.gugun_code = gugun_code;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getMlevel() {
		return mlevel;
	}
	public void setMlevel(String mlevel) {
		this.mlevel = mlevel;
	}
	
	@Override
	public String toString() {
		return "AttractionDto [content_id=" + content_id + ", content_type_id=" + content_type_id + ", title=" + title
				+ ", addr1=" + addr1 + ", addr2=" + addr2 + ", zipcode=" + zipcode + ", tel=" + tel + ", first_image="
				+ first_image + ", first_image2=" + first_image2 + ", readcount=" + readcount + ", sido_code="
				+ sido_code + ", gugun_code=" + gugun_code + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", mlevel=" + mlevel + "]";
	}
}
