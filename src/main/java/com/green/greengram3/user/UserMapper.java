package com.green.greengram3.user;

import com.green.greengram3.user.model.UserFollowDto;
import com.green.greengram3.user.model.UserSelDto;
import com.green.greengram3.user.model.UserSignUpProcDto;
import com.green.greengram3.user.model.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int insUser(UserSignUpProcDto dDto);
    UserEntity selUser(UserSelDto dto);
    // 관리자가 범용적으로 관리할 떄 (로그인 할 때 포함)
    int delUserFollow(UserFollowDto dto);
    int insUserFollow(UserFollowDto dto);
}
