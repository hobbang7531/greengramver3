package com.green.greengramver3.userfollow.userfollowmodel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetFollowRes {
    private long fromUserId;
    private long toUserId;
    private String createdAt;
}
