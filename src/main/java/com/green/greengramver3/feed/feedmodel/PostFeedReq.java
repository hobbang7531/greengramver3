package com.green.greengramver3.feed.feedmodel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostFeedReq {
    @JsonIgnore private long feedId;
    private long userId;
    private String contents;
    private String location;
}