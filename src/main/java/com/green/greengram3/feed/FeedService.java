package com.green.greengram3.feed;

import com.green.greengram3.common.Const;
import com.green.greengram3.common.ResVo;
import com.green.greengram3.feed.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class FeedService {
    private final FeedMapper mapper;
    private final FeedPicMapper feedPicMapper;
    private final FeedFavMapper feedFavMapper;
    private final FeedCommentMapper feedCommentMapper;

    public ResVo postFeed(FeedInsDto dto){
        FeedInsProcDto pDto = FeedInsProcDto.builder()
                .iuser(dto.getIuser())
                .contents(dto.getContents())
                .location(dto.getLocation())
                .build();
        int affectedRow1 = mapper.insFeed(pDto);
        log.info("affectedRow1 : {}", affectedRow1);
        FeedPicInsProcDto pPDto = FeedPicInsProcDto.builder()
                .ifeed(pDto.getIfeed())
                .pics(dto.getPics())
                .build();
        int affectedRow2 = feedPicMapper.insFeedPic(pPDto);
        log.info("affectedRow2 : {}", affectedRow2);
        return new ResVo(pDto.getIfeed());
    }
    public List<FeedSelVo> selFeedAll(FeedSelDto dto){
        List<FeedSelVo> list = mapper.selFeed(dto);

/*        List<Integer> ifeed = new ArrayList();
        Map<Integer, FeedSelVo> hashMap = new HashMap();
        for ( FeedSelVo vo : list ) {
            ifeed.add(vo.getIfeed());
            hashMap.put(vo.getIfeed(), vo);
        }
        log.info("-----------------------");
        List<FeedPicList> pics = feedPicMapper.selFeedPic(ifeed);
        // 원하는 모든 ifeed에 해당하는 각각의 객체들을 저장합니다.
        for ( FeedPicList pic : pics ) {
            FeedSelVo vo = hashMap.get(pic.getIfeed()); // ifeed에 해당하는 주솟값 저장
            List<String> picList = vo.getPics();
        }*/
        FeedCommentSelProcDto fcDto = new FeedCommentSelProcDto();
        fcDto.setStardIdx(0);
        fcDto.setRowCount(Const.FEED_COMMENT_FIRST_CNT);

        for ( FeedSelVo vo : list ) {
            vo.setPics(feedPicMapper.selFeedPic(vo.getIfeed()));
            fcDto.setIfeed(vo.getIfeed());
            vo.setComments(feedCommentMapper.selFeedCommentAll(fcDto));

            if(vo.getComments().size() == Const.FEED_COMMENT_FIRST_CNT){
                vo.setIsMoreComments(1);
                vo.getComments().remove(vo.getComments().size() - 1);
            }
        }
        return list;
    }
    public ResVo feedFavToggle(FeedFavDto dto){
        int affectedRows = feedFavMapper.delFeedFav(dto);
        if(affectedRows == 1){
            return new ResVo(Const.FEED_FAV_DELETE);
        }
        feedFavMapper.insFeedFav(dto);
        return new ResVo(Const.FEED_FAV_ADD);
    }
}
