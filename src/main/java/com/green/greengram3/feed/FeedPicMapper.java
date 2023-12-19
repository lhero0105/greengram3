package com.green.greengram3.feed;

import com.green.greengram3.feed.model.FeedDelDto;
import com.green.greengram3.feed.model.FeedInsDto;
import com.green.greengram3.feed.model.FeedPicInsProcDto;
import com.green.greengram3.feed.model.FeedPicList;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FeedPicMapper {
    int insFeedPic(FeedPicInsProcDto pDto);
    int insFeedPics(FeedInsDto dto);// test용
    List<String> selFeedPic(int ifeed);
    int delFeedPicsAll(FeedDelDto dto);

    //List<FeedPicList> selFeedPic(List<Integer> ifeeds);
    //int delFeedPicByFeed(FeedDelDto dto); 방법 1
}
