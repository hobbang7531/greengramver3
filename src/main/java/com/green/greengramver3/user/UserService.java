package com.green.greengramver3.user;

import com.green.greengramver3.common.CustomFileUtils;
import com.green.greengramver3.user.usermodel.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;
    private final CustomFileUtils customFileUtils;

    @Transactional
    public int signUp(MultipartFile pic, SignUpReq p){
        String saveFileName = customFileUtils.makeRandomFileName(pic);
        p.setPic(saveFileName);
        String hashedPw = BCrypt.hashpw(p.getUpw(), BCrypt.gensalt());
        p.setUpw(hashedPw);

        int result = mapper.postUser(p);

        if(pic == null) { return result;}
        String path = String.format("user/%d", p.getUserId());
        customFileUtils.makeFolder(path);
        String target = String.format("%s/%s", path, saveFileName);
        try {
            customFileUtils.transferTo(pic,target);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return result;
    }

    public SignInRes signIn(SignInReq p){
        User user = mapper.getUser(p.getUid());
        if(user == null) {
            throw new RuntimeException("아이디를 확인해주세요");
        } else if(!BCrypt.checkpw(p.getUpw(), user.getUpw())){
            throw new RuntimeException("비밀번호를 확인해주세요");
        }
        return SignInRes.builder().
                userId(user.getUserId()).
                nm(user.getNm()).
                pic(user.getPic()).
                build();
    }

    public UserInfoGetRes selProfileUserInfo(UserInfoGetReq p){
        return mapper.selProfileUserInfo(p);
    }
}
