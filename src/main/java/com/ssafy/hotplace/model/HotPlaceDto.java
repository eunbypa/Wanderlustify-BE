package com.ssafy.hotplace.model;

import lombok.Data;

@Data
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
}
