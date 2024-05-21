package com.green.greengramver3.userfollow;

import com.green.greengramver3.userfollow.userfollowmodel.FollowReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserFollowService {
    private final UserFollowMapper mapper;

    public int postFollow(FollowReq p){
        return mapper.postFollow(p);
    }

    public int delFollow(FollowReq p){
        return mapper.delFollow(p);
    }
}
