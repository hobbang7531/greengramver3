package com.green.greengramver3.feed.feedmodel;

import com.green.greengramver3.feedcomment.feedcommentmodel.GetCommentRes;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
public class GetFeedRes {
    private long feedId;
    private long writerId;
    private String writerNm;
    private String writerPic;
    private String contents;
    private String location;
    private String createdAt;
    private int isFav;

    private List<String> pics;
    private List<GetCommentRes> comments;
    private int isMoreComment;
}
