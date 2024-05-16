package com.green.greengramver3.feed;

import com.green.greengramver3.common.CustomFileUtils;
import com.green.greengramver3.common.GlobalConst;
import com.green.greengramver3.feed.feedmodel.*;
import com.green.greengramver3.feedcomment.feedcommentmodel.GetCommentRes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class FeedService {
    private final FeedMapper mapper;
    private final CustomFileUtils customFileUtils;

    @Transactional
    public PostFeedRes postFeed(List<MultipartFile> pics, PostFeedReq p){
        int result = mapper.postFeed(p);
        PostFeedPicDto dto = PostFeedPicDto.builder().feedId(p.getFeedId()).build();

        String path = String.format("feed/%d", p.getFeedId());
        customFileUtils.makeFolder(path);

        try {
            for(MultipartFile pic : pics){
                String saveFileName = customFileUtils.makeRandomFileName(pic);
                dto.getFileNames().add(saveFileName);
                String target = String.format("%s/%s", path, saveFileName);
                customFileUtils.transferTo(pic, target);
            }
            int affectedRows = mapper.postPic(dto);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Feed 등록 오류");
        }
        return PostFeedRes.builder().
                feedId(p.getFeedId()).
                pics(dto.getFileNames()).
                build();
    }

    public List<GetFeedRes> getFeed(GetFeedReq p){
        List<GetFeedRes> list = mapper.getFeed(p);

        for(GetFeedRes res : list){
            List<String> pics = mapper.getFeedPicsByFeedId(res.getFeedId());
            res.setPics(pics);
            List<GetCommentRes> comList = mapper.getFeedCommentTopBy4ByFeedId(res.getFeedId());
            log.info("comList {}", comList);
            if(comList.size() == GlobalConst.FEED_PER_COMMENT_SIZE){
                res.setIsMoreComment(1);
                comList.remove(comList.size() -1);
            }
            res.setComments(comList);
        }
        return list;
    };
}
