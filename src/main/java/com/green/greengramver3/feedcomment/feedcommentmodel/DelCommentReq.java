package com.green.greengramver3.feedcomment.feedcommentmodel;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.beans.ConstructorProperties;

@Getter
@Setter
public class DelCommentReq {
    private long feedCommentId;
    private long signedUserId;

    @ConstructorProperties({"feed_comment_id", "signed_user_id"})
    public DelCommentReq(long feedCommentId, long signedUserId){
        this.feedCommentId = feedCommentId;
        this.signedUserId = signedUserId;
    }
}
