package com.green.greengramver3.feedfavorite;

import com.green.greengramver3.feedfavorite.feedfavoritemodel.ToggleFavorite;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class FeedFavoriteService {
    private final FeedFavoriteMapper mapper;

    public int toggleFavorite(ToggleFavorite p){
        if(mapper.delFeedFavorite(p) == 1) { return 0; }
        return mapper.insFeedFavorite(p);
    }
}
