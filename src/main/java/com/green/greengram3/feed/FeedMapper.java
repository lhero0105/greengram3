package com.green.greengram3.feed;

import com.green.greengram3.feed.model.FeedInsProcDto;
import com.green.greengram3.feed.model.FeedSelDto;
import com.green.greengram3.feed.model.FeedSelVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FeedMapper {
    int insFeed(FeedInsProcDto pDto);
    List<FeedSelVo> selFeed(FeedSelDto dto);
}
