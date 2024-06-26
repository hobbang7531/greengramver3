package com.green.greengramver3.feed.feedmodel;

import com.green.greengramver3.common.GlobalConst;
import com.green.greengramver3.common.Paging;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.bind.annotation.BindParam;

@Getter
@Setter
@ToString
public class GetFeedReq extends Paging {
    private long feedId;
    private long signedUserId;
    private Long profileUserId;

    public GetFeedReq(Integer page, Integer size,
                      @BindParam("signed_user_id") long signedUserId,
                      @BindParam("profile_user_id") Long profileUserId){
        super(page, size == null ? GlobalConst.FEED_PAGING_SIZE : size);
        this.signedUserId = signedUserId;
        this.profileUserId = profileUserId;
    }
}
