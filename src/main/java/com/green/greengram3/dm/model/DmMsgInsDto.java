package com.green.greengram3.dm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Getter
@AllArgsConstructor
@ToString
public class DmMsgInsDto {
    private int idm;
    @JsonIgnore
    private int seq;
    private int loginedIuser;
    private String msg;
}
