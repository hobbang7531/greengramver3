package com.green.greengramver3.user.usermodel;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import java.beans.ConstructorProperties;

@Getter
public class UserInfoGetReq {
    @Schema(name = "signed_user_id")
    private long signedUserId;
    @Schema(name = "profile_user_id")
    private long profileUserId;

    @ConstructorProperties({"signed_user_id", "profile_user_id"})
    public UserInfoGetReq(long signedUserId, long profileUserId){
        this.signedUserId = signedUserId;
        this.profileUserId = profileUserId;
    }
}