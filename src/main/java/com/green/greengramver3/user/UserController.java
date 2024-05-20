package com.green.greengramver3.user;

import com.green.greengramver3.common.ResultDto;
import com.green.greengramver3.user.usermodel.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService service;

    @PostMapping("sign-up")
    public ResultDto<Integer> signUp(@RequestPart(required = false) MultipartFile pic, @RequestPart SignUpReq p){
        log.info("pic : {}", pic);
        log.info("req : {}", p);
        int result = service.signUp(pic, p);

        return ResultDto.<Integer>builder().
                statusCode(HttpStatus.OK).
                resultMsg("회원가입 성공").
                resultData(result).
                build();
    }

    @PostMapping("sign-in")
    public ResultDto<SignInRes> signIn(@RequestBody SignInReq p){
        log.info("req : {}", p);
        SignInRes result = service.signIn(p);

        return ResultDto.<SignInRes>builder().
                statusCode(HttpStatus.OK).
                resultData(result).
                resultMsg("로그인 성공").
                build();

    }

    @GetMapping("profile")
    public ResultDto<UserInfoGetRes> selProfileUserInfo(@ParameterObject @ModelAttribute UserInfoGetReq p){
        UserInfoGetRes result = service.selProfileUserInfo(p);

        return ResultDto.<UserInfoGetRes>builder().
                statusCode(HttpStatus.OK).
                resultMsg(HttpStatus.OK.toString()).
                resultData(result).
                build();
    }
}
