package com.green.greengram3.feed;

import com.green.greengram3.BaseIntegrationTest;
import com.green.greengram3.common.ResVo;
import com.green.greengram3.feed.model.FeedInsDto;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// 진짜로 테스트 하기에 given when 을 쓸 필요 x
public class FeedIntegrationTest extends BaseIntegrationTest {

    @Test // 단위테스트를 수행하는메서드를 정의합니다.
    //@Rollback(value = false)
    public void postFeed() throws Exception{
        FeedInsDto dto =new FeedInsDto();
        dto.setIuser(3);
        dto.setContents("통합 테스트 작업 중");
        dto.setLocation("그린컴퓨터학원");
        List<String> pics = new ArrayList<>();
        pics.add("data:image/jpeg;base64,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");
        pics.add("data:image/jpeg;base64,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");
        pics.add("https://mblogthumb-phinf.pstatic.net/MjAxOTA1MDdfMTc5/MDAxNTU3MTk0ODg2NDAx.kRNxA5NmRzOlOkldDHJj_uYH_oh9KLhyf0iy_3wX7L0g.N8Ck31g1zioc5PrvS-obTJpSPtJxxaR-yFdsFz6Xjtcg.JPEG.maxlovely90/SE-dfebb49e-5750-4a7f-a1fc-de712ce44428.jpg?type=w800");
        dto.setPics(pics);

        String json = om.writeValueAsString(dto);
        System.out.println("json: " + json);

        MvcResult mr = mvc.perform( // 통신을 보냅니다.
                        MockMvcRequestBuilders
                                // json 타입 일 때, 쿼리스트링 땐 뺍니다.
                                .post("/api/feed") // post방식일 때 적습니다.
                                .contentType(MediaType.APPLICATION_JSON) // 날릴 때 json형식이면 이 문구가 필수 입니다. -> RequestBody
                                .content(json) // body부분에 josn타입이 박힙니다.
                )
                .andExpect(status().isOk()) // { "result": 5 }
                .andDo(print())
                .andReturn(); // 프린트로 찍어줍니다.

                String content = mr.getResponse().getContentAsString();
                // 응답을 스트링으로 받길 원합니다.

                ResVo vo = om.readValue(content, ResVo.class);
                // setter로 값을 넣어주어야 하여 기본생성자를 클래스에 만들어 주어야합니다.
                assertEquals(true, vo.getResult() > 0);
                // pk값이 0보다 큰게 맞는지 체크합니다.
    }
}