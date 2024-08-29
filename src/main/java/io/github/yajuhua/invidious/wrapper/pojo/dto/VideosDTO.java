package io.github.yajuhua.invidious.wrapper.pojo.dto;

import com.google.gson.annotations.SerializedName;
import io.github.yajuhua.invidious.wrapper.pojo.dto.commons.VideoDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * /api/v1/channels/ID/videos/
 */
@NoArgsConstructor
@Data
public class VideosDTO {

    @SerializedName("videos")
    private List<VideoDTO> videos;
    @SerializedName("continuation")
    private String continuation;
}
