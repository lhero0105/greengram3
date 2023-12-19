package com.green.greengram3.feed;

import com.green.greengram3.common.ResVo;
import com.green.greengram3.feed.model.FeedInsDto;
import com.green.greengram3.user.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when; // 모키토에 있는 스테틱 메소드 임포트

@ExtendWith(SpringExtension.class)
// service에서는 @ExtendWith 로 스프링컨테이너가 객체화 됩니다.
// 아래 애를 빈등록합니다.
@Import({ FeedService.class })
class FeedServiceTest {

    @MockBean
    // 주솟값이 있는것처럼 꾸며 진짜가 있는것 처럼 속입니다.
    private FeedMapper mapper;
    @MockBean
    private FeedPicMapper feedPicMapper;
    @MockBean
    private FeedFavMapper feedFavMapper;
    @MockBean
    private FeedCommentMapper feedCommentMapper;
    // 목 빈이 하나라도 없으면 빈 등록이 안되기에 꼭 다 적어야 합니다.

    @Autowired // 빨간 줄 무시
    private FeedService service;


    @Test
    void postFeed(){
        // 가짜기에 그냥 호출하면 에러나 이상한 값이 올거기에
        when(mapper.insFeed(any())).thenReturn(1);
        // 값이 아무거나 들어 갈 때 1값을 리턴해 줘
        when(feedPicMapper.insFeedPic(any())).thenReturn(3);

        FeedInsDto dto = new FeedInsDto();
        dto.setIfeed(100);
        ResVo vo = service.postFeed(dto);
        assertEquals(dto.getIfeed(), vo.getResult());

        // 진짜로 이 메소드 호출했는지 검증할 때 사용
        verify(mapper).insFeed(any());
        verify(feedPicMapper).insFeedPic(any());

        FeedInsDto dto2 = new FeedInsDto();
        dto2.setIfeed(200);
        ResVo vo2 = service.postFeed(dto2);
        assertEquals(dto2.getIfeed(), vo2.getResult());

    }
}