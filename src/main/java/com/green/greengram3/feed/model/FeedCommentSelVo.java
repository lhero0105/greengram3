package com.green.greengram3.feed.model;

import lombok.Data;

@Data
public class FeedCommentSelVo {
    private int ifeedComment;
    private String comment;
    private String createdAt;
    private String writerIuser;
    private String writerNm;
    private String writerPic;
}
