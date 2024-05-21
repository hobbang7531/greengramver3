package com.green.greengramver3.userfollow;

import com.green.greengramver3.common.ResultDto;
import com.green.greengramver3.userfollow.userfollowmodel.FollowReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("api/user/follow")
@RestController
public class UserFollowController {
    private final UserFollowService service;

    @PostMapping
    public ResultDto<Integer> postFollow(@RequestBody FollowReq p){
        int result = service.postFollow(p);

        return ResultDto.<Integer>builder().
                statusCode(HttpStatus.OK).
                resultMsg(HttpStatus.OK.toString()).
                resultData(result).
                build();
    }

    @DeleteMapping
    public ResultDto<Integer> delFollow(@ParameterObject @ModelAttribute FollowReq p){
        int result = service.delFollow(p);

        return ResultDto.<Integer>builder().
                statusCode(HttpStatus.OK).
                resultMsg(HttpStatus.OK.toString()).
                resultData(result).
                build();
    }
}
