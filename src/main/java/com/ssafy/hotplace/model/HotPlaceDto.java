package com.ssafy.hotplace.model;

public class HotPlaceDto {
    private int hotplaceNo;
    private String userId;
    private String userName;
    private String title;
    private String content;
    private String address;
    private int recommendation;
    private String saveFolder;
    private String originalFile;
    private String saveFile;
	private String date;
	public int getHotplaceNo() {
		return hotplaceNo;
	}
	public void setHotplaceNo(int hotplaceNo) {
		this.hotplaceNo = hotplaceNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSaveFolder() {
		return saveFolder;
	}
	public void setSaveFolder(String saveFolder) {
		this.saveFolder = saveFolder;
	}
	public String getOriginalFile() {
		return originalFile;
	}
	public void setOriginalFile(String originalFile) {
		this.originalFile = originalFile;
	}
	public String getSaveFile() {
		return saveFile;
	}
	public void setSaveFile(String saveFile) {
		this.saveFile = saveFile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getRecommendation() {
		return recommendation;
	}
	public void setRecommendation(int recommendation) {
		this.recommendation = recommendation;
	}
	@Override
	public String toString() {
		return "HotPlaceDto [hotplaceNo=" + hotplaceNo + ", userId=" + userId + ", userName=" + userName + ", title="
				+ title + ", content=" + content + ", address=" + address + ", date =" + date + ", recommendation=" + recommendation
				+ ", saveFolder=" + saveFolder + ", originalFile=" + originalFile + ", saveFile=" + saveFile + "]";
	}
    
}
