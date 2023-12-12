package com.green.greengram3.dm;

import com.green.greengram3.common.ResVo;
import com.green.greengram3.dm.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/dm")
public class DmController {
    private final Dmservice service;
    // 무조건 방이 있는 것 만 요청이 들어옵니다. (idm을 받음)
    @GetMapping
    public List<DmSelVo> getDmAll(DmSelDto dto){
        return service.getDmAll(dto);
    }
    @PostMapping
    public DmSelVo postDm(@RequestBody DmInsDto dto){
        return service.postDm(dto);
    }


    //----------------------------- t_dm_msg
    @PostMapping("/msg")
    public ResVo postDmMsg(@RequestBody DmMsgInsDto dto) {
        log.info("dto : {}", dto);
        return service.postDmMsg(dto);
    }
    @GetMapping("/msg")
    public List<DmMsgSelVo> getMsgAll(DmMsgSelDto dto){
        log.info("dto : {}", dto);
        return service.getMsgAll(dto);
    }
    // page 2 가 넘어오면 방이 있단 소리니까 방이 있는지에 관한 분기문을 안씁니다

    @DeleteMapping("/msg")
    public ResVo delDmMsg(DmMsgDelDto dto){
        return service.delDmMsg(dto);
    }
}
