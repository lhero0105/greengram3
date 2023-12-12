package com.green.greengram3.dm;

import com.green.greengram3.common.ResVo;
import com.green.greengram3.dm.model.*;
import com.green.greengram3.user.UserMapper;
import com.green.greengram3.user.model.UserEntity;
import com.green.greengram3.user.model.UserSelDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class Dmservice {
    private final DmMapper mapper;
    private final UserMapper userMapper;

    public List<DmSelVo> getDmAll(DmSelDto dto){
        return mapper.selDmAll(dto);
    }

    public DmSelVo postDm(DmInsDto dto){
        Integer idm = mapper.selDmByIns(dto);
        if(idm != null){
            return null;
        }
        DmUserInsDto dmUserInsDto = new DmUserInsDto();
        int affectedRow1 = mapper.insDm(dmUserInsDto); // 방생성 후 idm가져옴
        dto.setIdm(dmUserInsDto.getIdm());
        log.info("dto : {}", dto);
        int affectedRow2 = mapper.postDm(dto);

        UserSelDto usDto = new UserSelDto();
        usDto.setIuser(dto.getOtherPersonIuser());
        UserEntity userEntity = userMapper.selUser(usDto);

        return DmSelVo.builder()
                .idm(dto.getIdm())
                .otherPersonIuser(userEntity.getIuser())
                .otherPersonNm(userEntity.getNm())
                .otherPersonPic(userEntity.getPic()).build();
    }

    public ResVo postDmMsg(DmMsgInsDto dto) {
        int affectedRows = mapper.insDmMsg(dto);
        return new ResVo(dto.getSeq());
    }

    public List<DmMsgSelVo> getMsgAll(DmMsgSelDto dto){
        List<DmMsgSelVo> list =  mapper.selDmMsgAll(dto);
        log.info("list : {}", list);
        Collections.reverse(list);
        log.info("list : {}", list);
        return list;
    }

    public ResVo delDmMsg(DmMsgDelDto dto){
        int affectedRows = mapper.delDmMsg(dto);
        log.info("affectedRows : {}", affectedRows);
        return new ResVo(affectedRows);
    }
}
