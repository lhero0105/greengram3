package com.green.greengram3.dm;

import com.green.greengram3.common.ResVo;
import com.green.greengram3.dm.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Dmservice {
    private final DmMapper mapper;

    public List<DmSelVo> getDmAll(DmSelDto dto){
        return mapper.selDmAll(dto);
    }

    public ResVo postDmMsg(DmMsgInsDto dto) {
        int affectedRows = mapper.insDmMsg(dto);
        return new ResVo(dto.getSeq());
    }

    public List<DmMsgSelVo> getMsgAll(DmMsgSelDto dto){
        return mapper.selDmMsgAll(dto);
    }
}
