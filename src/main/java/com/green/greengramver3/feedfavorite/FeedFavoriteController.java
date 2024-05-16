package com.green.greengramver3.feedfavorite;

import com.green.greengramver3.common.ResultDto;
import com.green.greengramver3.feedfavorite.feedfavoritemodel.ToggleFavorite;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("api/feed/favorite")
public class FeedFavoriteController {
    private final FeedFavoriteService service;

    @GetMapping
    public ResultDto<Integer> toggleFavorite(@ModelAttribute ToggleFavorite p){
        int result= service.toggleFavorite(p);

        return ResultDto.<Integer>builder().
                statusCode(HttpStatus.OK).
                resultMsg(result == 1 ? "좋아요" : "좋아요 취소").
                resultData(result).
                build();
    }
}
