package com.green.greengram3.feed.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class FeedInsProcDto {
    private int ifeed;
    private int iuser;
    private String contents;
    private String location;
}
