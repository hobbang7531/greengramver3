package com.green.greengramver3.user.usermodel;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignInRes {
    private long userId;
    private String nm;
    private String pic;
}
