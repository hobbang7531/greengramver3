package com.green.greengramver3.userfollow.userfollowmodel;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.BindParam;

import java.beans.ConstructorProperties;

@Getter
@Setter
public class FollowReq {
//    @Parameter(name = "from_user_id")
    private long fromUserId;

//    @Parameter(name = "to_user_id")
    private long toUserId;

    @ConstructorProperties({ "from_user_id", "to_user_id" })
    public FollowReq(long fromUserId, long toUserId) {
        this.fromUserId = fromUserId;
        this.toUserId = toUserId;
    }
}
