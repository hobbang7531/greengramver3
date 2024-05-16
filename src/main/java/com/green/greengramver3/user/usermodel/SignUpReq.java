package com.green.greengramver3.user.usermodel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpReq {
    @JsonIgnore private long userId;
    private String uid;
    private String upw;
    private String nm;
    private String pic;
}
