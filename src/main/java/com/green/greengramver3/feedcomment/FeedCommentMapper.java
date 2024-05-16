package com.green.greengramver3.feedcomment;

import com.green.greengramver3.feedcomment.feedcommentmodel.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FeedCommentMapper {
    int postComment(PostCommentReq p);
    List<GetCommentRes> getComment(long feedId);
    int delComment(DelCommentReq p);
}