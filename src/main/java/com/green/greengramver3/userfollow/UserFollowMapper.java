package com.green.greengramver3.userfollow;

import com.green.greengramver3.userfollow.userfollowmodel.*;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserFollowMapper {
    int postFollow(FollowReq p);
    GetFollowRes getFollow(FollowReq p);
    int delFollow(FollowReq p);
}
