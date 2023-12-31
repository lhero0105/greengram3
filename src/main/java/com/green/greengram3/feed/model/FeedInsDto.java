package com.green.greengram3.feed.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class FeedInsDto {
    //@JsonIgnore
    @Schema(hidden = true)
    private int ifeed;
    private int iuser;
    private String contents;
    private String location;
    private List<String> pics;
}
