package com.green.greengram3.feed;

import com.green.greengram3.feed.model.FeedDelDto;
import com.green.greengram3.feed.model.FeedPicInsProcDto;
import com.green.greengram3.feed.model.FeedPicList;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FeedPicMapper {
    int insFeedPic(FeedPicInsProcDto pDto);
    List<String> selFeedPic(int ifeed);

    //List<FeedPicList> selFeedPic(List<Integer> ifeeds);
    //int delFeedPicByFeed(FeedDelDto dto); 방법 1
    int delFeedPicsAll(FeedDelDto dto);
}
