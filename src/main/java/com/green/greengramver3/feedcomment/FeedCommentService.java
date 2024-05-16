package com.green.greengramver3.feedcomment;

import com.green.greengramver3.common.GlobalConst;
import com.green.greengramver3.feedcomment.feedcommentmodel.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class FeedCommentService {
    private final FeedCommentMapper mapper;

    public long postComment(PostCommentReq p){
        long affectedRow = mapper.postComment(p);

        return p.getFeedCommentId();
    }

    public int delComment(DelCommentReq p){
        return mapper.delComment(p);
    }

    public List<GetCommentRes> getComment(long feedId){
        List<GetCommentRes> list = mapper.getComment(feedId);
        list.subList(0, GlobalConst.FEED_PER_COMMENT_SIZE -1).clear();
        return list;
    }
}
