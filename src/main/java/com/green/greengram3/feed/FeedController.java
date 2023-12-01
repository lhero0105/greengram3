package com.green.greengram3.feed;

import com.green.greengram3.common.Const;
import com.green.greengram3.common.ResVo;
import com.green.greengram3.feed.model.FeedFavDto;
import com.green.greengram3.feed.model.FeedInsDto;
import com.green.greengram3.feed.model.FeedSelDto;
import com.green.greengram3.feed.model.FeedSelVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/feed")
@Tag(name = "피드 API", description = "피드 관련 처리")
@Slf4j
public class FeedController {
    private final FeedService service;

    @Operation(summary = "피드 등록", description = "피드 등록 처리")
    @PostMapping
    public ResVo postFeed(@RequestBody FeedInsDto dto){
        return service.postFeed(dto);
    }

    @Operation(summary = "피드 리스트", description = "피드 추가 처리")
    @GetMapping
    public List<FeedSelVo> selFeedAll(FeedSelDto dto){
        FeedSelDto dto1 = new FeedSelDto();
        dto1.setLoginedIuser(dto.getLoginedIuser());
        dto1.setStartIdx((dto.getPage()-1)* Const.FEED_COUNT_PER_PAGE);
        dto1.setRowCount(Const.FEED_COUNT_PER_PAGE);
        return service.selFeedAll(dto1);
/*        return service.selFeedAll(FeedSelDto.builder()
                        .startIdx((dto.getPage()-1)* Const.FEED_COUNT_PER_PAGE)
                        .rowCount(Const.FEED_COUNT_PER_PAGE)
                        .build());*/
    }
    @GetMapping("/fav")
    public ResVo toggleFeedFav(FeedFavDto dto){
        return service.feedFavToggle(dto);
    }
}
