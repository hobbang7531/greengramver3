package com.green.greengramver3.feed;

import com.green.greengramver3.common.ResultDto;
import com.green.greengramver3.feed.feedmodel.GetFeedReq;
import com.green.greengramver3.feed.feedmodel.GetFeedRes;
import com.green.greengramver3.feed.feedmodel.PostFeedReq;
import com.green.greengramver3.feed.feedmodel.PostFeedRes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/feed")
@RequiredArgsConstructor
public class FeedController {
    private final FeedService service;

    @PostMapping
    public ResultDto<PostFeedRes> postFeed(@RequestPart List<MultipartFile> pics, @RequestPart PostFeedReq p){
        PostFeedRes result = service.postFeed(pics, p);

        return ResultDto.<PostFeedRes>builder().
                statusCode(HttpStatus.OK).
                resultMsg("Feed 등록 성공").
                resultData(result).
                build();
    }

    @GetMapping
    public ResultDto<List<GetFeedRes>> getFeed(@ParameterObject @ModelAttribute GetFeedReq p){
        log.info("p : {}", p);
        List<GetFeedRes> list = service.getFeed(p);

        return ResultDto.<List<GetFeedRes>>builder().
                statusCode(HttpStatus.OK).
                resultMsg(HttpStatus.OK.toString()).
                resultData(list).
                build();
    }
}