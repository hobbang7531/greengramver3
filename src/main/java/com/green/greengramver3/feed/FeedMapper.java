package com.green.greengramver3.feed;

import com.green.greengramver3.feed.feedmodel.*;
import com.green.greengramver3.feedcomment.feedcommentmodel.GetCommentRes;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FeedMapper {
    int postFeed(PostFeedReq p);
    int postPic(PostFeedPicDto pic);
    List<GetFeedRes> getFeed(GetFeedReq p);
    List<String> getFeedPicsByFeedId(long feedId);
    List<GetCommentRes> getFeedCommentTopBy4ByFeedId(long feedId);
}
