package com.green.greengram3.dm;

import com.green.greengram3.dm.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DmMapper {
    int insDm(DmUserInsDto dto);
    List<DmSelVo> selDmAll(DmSelDto dto);
    // -------------t_dm_user
    int insDmUser(DmUserInsDto dto);
    // --------------t_dm_msg
    int insDmMsg(DmMsgInsDto dto);
    List<DmMsgSelVo> selDmMsgAll(DmMsgSelDto dto);
}
