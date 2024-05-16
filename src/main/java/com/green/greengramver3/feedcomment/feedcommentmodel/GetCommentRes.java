package com.green.greengramver3.feedcomment.feedcommentmodel;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GetCommentRes {
    private long feedCommentId;
    private long writerId;
    private long feedId;
    private String writerNm;
    private String writerPic;
    private String comment;
    private String createdAt;
    private String updatedAt;
}
