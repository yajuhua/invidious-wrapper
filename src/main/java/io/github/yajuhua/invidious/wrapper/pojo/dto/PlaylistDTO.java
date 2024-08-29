package io.github.yajuhua.invidious.wrapper.pojo.dto;

import com.google.gson.annotations.SerializedName;
import io.github.yajuhua.invidious.wrapper.pojo.dto.commons.VideoDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * /api/v1/playlist/ID
 */
@NoArgsConstructor
@Data
public class PlaylistDTO {

    @SerializedName("type")
    private String type;
    @SerializedName("title")
    private String title;
    @SerializedName("playlistId")
    private String playlistId;
    @SerializedName("playlistThumbnail")
    private String playlistThumbnail;
    @SerializedName("author")
    private String author;
    @SerializedName("authorId")
    private String authorId;
    @SerializedName("authorUrl")
    private String authorUrl;
    @SerializedName("subtitle")
    private Object subtitle;
    @SerializedName("authorThumbnails")
    private List<AuthorThumbnailsDTO> authorThumbnails;
    @SerializedName("description")
    private String description;
    @SerializedName("descriptionHtml")
    private String descriptionHtml;
    @SerializedName("videoCount")
    private Integer videoCount;
    @SerializedName("viewCount")
    private Integer viewCount;
    @SerializedName("updated")
    private Integer updated;
    @SerializedName("isListed")
    private Boolean isListed;
    @SerializedName("videos")
    private List<VideoDTO> videos;

    @NoArgsConstructor
    @Data
    public static class AuthorThumbnailsDTO {
        @SerializedName("url")
        private String url;
        @SerializedName("width")
        private Integer width;
        @SerializedName("height")
        private Integer height;
    }
}
