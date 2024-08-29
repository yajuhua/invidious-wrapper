package io.github.yajuhua.invidious.wrapper.pojo.dto.commons;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * streams / videos / playlist 共用的
 */
@NoArgsConstructor
@Data
public class VideoDTO {
    @SerializedName("type")
    private String type;
    @SerializedName("title")
    private String title;
    @SerializedName("videoId")
    private String videoId;
    @SerializedName("author")
    private String author;
    @SerializedName("authorId")
    private String authorId;
    @SerializedName("authorUrl")
    private String authorUrl;
    @SerializedName("authorVerified")
    private Boolean authorVerified;
    @SerializedName("videoThumbnails")
    private List<VideoThumbnailsDTO> videoThumbnails;
    @SerializedName("description")
    private String description;
    @SerializedName("descriptionHtml")
    private String descriptionHtml;
    @SerializedName("viewCount")
    private Integer viewCount;
    @SerializedName("viewCountText")
    private String viewCountText;
    @SerializedName("published")
    private Integer published;
    @SerializedName("publishedText")
    private String publishedText;
    @SerializedName("lengthSeconds")
    private Integer lengthSeconds;
    @SerializedName("liveNow")
    private Boolean liveNow;
    @SerializedName("premium")
    private Boolean premium;
    @SerializedName("isUpcoming")
    private Boolean isUpcoming;

    @NoArgsConstructor
    @Data
    public static class VideoThumbnailsDTO {
        @SerializedName("quality")
        private String quality;
        @SerializedName("url")
        private String url;
        @SerializedName("width")
        private Integer width;
        @SerializedName("height")
        private Integer height;
    }
}
