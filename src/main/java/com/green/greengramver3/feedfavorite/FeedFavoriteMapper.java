package com.green.greengramver3.feedfavorite;

import com.green.greengramver3.feedfavorite.feedfavoritemodel.ToggleFavorite;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FeedFavoriteMapper {
    int insFeedFavorite(ToggleFavorite p);
    int delFeedFavorite(ToggleFavorite p);
}
