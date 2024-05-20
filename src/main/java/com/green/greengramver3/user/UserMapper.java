package com.green.greengramver3.user;

import com.green.greengramver3.user.usermodel.*;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int postUser(SignUpReq p);
    User getUser(String uid);
    UserInfoGetRes selProfileUserInfo(UserInfoGetReq p);
}
