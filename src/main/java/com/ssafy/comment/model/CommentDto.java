package com.ssafy.comment.model;

import lombok.Data;

@Data
public class CommentDto {
    private int commentNo;
    private int articleNo;
    private String userId;
    private String userName;
    private String content;
    private String date;
}
