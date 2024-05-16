package com.green.greengramver3.feedcomment;

import com.green.greengramver3.common.ResultDto;
import com.green.greengramver3.feedcomment.feedcommentmodel.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/feed/comment")
public class FeedCommentController {
    private final FeedCommentService service;

    @PostMapping
    public ResultDto<Long> postComment(@RequestBody PostCommentReq p){
        long result = service.postComment(p);

        return ResultDto.<Long>builder().
                statusCode(HttpStatus.OK).
                resultMsg(HttpStatus.OK.toString()).
                resultData(result).
                build();
    }

    @DeleteMapping
    public ResultDto<Integer> delComment(@ParameterObject @ModelAttribute DelCommentReq p){
        int result = service.delComment(p);

        return ResultDto.<Integer>builder().
                statusCode(HttpStatus.OK).
                resultMsg(result == 0 ? "삭제 실패" : "삭제 성공").
                resultData(result).
                build();
    }

    @GetMapping
    public ResultDto<List<GetCommentRes>> getComment(@RequestParam(name="feed_id") long feedId){
        List<GetCommentRes> list = service.getComment(feedId);
        log.info("getComment: {}", list);

        return ResultDto.<List<GetCommentRes>>builder().
                statusCode(HttpStatus.OK).
                resultMsg(String.format("rows : %d", list.size())).
                resultData(list).
                build();
    }
}