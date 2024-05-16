package com.green.greengramver3.feedcomment.feedcommentmodel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.transaction.annotation.Transactional;

@Getter
@Setter
@Transactional
public class PostCommentReq {
    @JsonIgnore private long feedCommentId;
    private long userId;
    private long feedId;
    private String comment;
}
