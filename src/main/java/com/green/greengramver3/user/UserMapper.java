package com.green.greengramver3.user;

import com.green.greengramver3.user.usermodel.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.multipart.MultipartFile;

@Mapper
public interface UserMapper {
    int postUser(SignUpReq p);
    User getUser(String uid);
    UserInfoGetRes selProfileUserInfo(UserInfoGetReq p);
    int updProfilePic(UserProfilePatchReq p);
}
