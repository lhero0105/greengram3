package com.green.greengram3.feed;

import com.green.greengram3.feed.model.FeedDelDto;
import com.green.greengram3.feed.model.FeedFavDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FeedFavMapper {
    int insFeedFav(FeedFavDto dto);
    int delFeedFav(FeedFavDto dto);
    int delFeedFavByFeed(FeedDelDto dto); //방법 1
    int delFeedFavAll(FeedDelDto dto); //방법 2
}
