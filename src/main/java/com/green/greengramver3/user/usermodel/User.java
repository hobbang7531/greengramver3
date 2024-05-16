package com.green.greengramver3.user.usermodel;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
    private long userId;
    private String uid;
    private String upw;
    private String nm;
    private String pic;
    private String createdAt;
    private String updatedAt;
}
