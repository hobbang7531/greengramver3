package com.green.greengramver3.feed.feedmodel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostFeedRes {
    private long feedId;
    private List<String> pics;
}
