package com.green.greengramver3.userfollow.userfollowmodel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.BindParam;

@Getter
@Setter
public class FollowReq {
    @BindParam("signed_user_id")
    private long signedUserId;

    @BindParam("to_user_id")
    private long toUserId;
}
