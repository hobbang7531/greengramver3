package com.green.greengramver3.feed.feedmodel;

import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
public class PostFeedPicDto {
    private long feedId;
    @Builder.Default
    private List<String> fileNames = new ArrayList();
}
