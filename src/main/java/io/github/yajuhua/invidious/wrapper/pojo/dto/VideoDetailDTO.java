package io.github.yajuhua.invidious.wrapper.pojo.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * /api/v1/videos/ID
 */
@NoArgsConstructor
@Data
public class VideoDetailDTO {

    @SerializedName("type")
    private String type;
    @SerializedName("title")
    private String title;
    @SerializedName("videoId")
    private String videoId;
    @SerializedName("videoThumbnails")
    private List<VideoThumbnailsDTO> videoThumbnails;
    @SerializedName("storyboards")
    private List<StoryboardsDTO> storyboards;
    @SerializedName("description")
    private String description;
    @SerializedName("descriptionHtml")
    private String descriptionHtml;
    @SerializedName("published")
    private Integer published;
    @SerializedName("publishedText")
    private String publishedText;
    @SerializedName("keywords")
    private List<String> keywords;
    @SerializedName("viewCount")
    private Integer viewCount;
    @SerializedName("likeCount")
    private Integer likeCount;
    @SerializedName("dislikeCount")
    private Integer dislikeCount;
    @SerializedName("paid")
    private Boolean paid;
    @SerializedName("premium")
    private Boolean premium;
    @SerializedName("isFamilyFriendly")
    private Boolean isFamilyFriendly;
    @SerializedName("allowedRegions")
    private List<String> allowedRegions;
    @SerializedName("genre")
    private String genre;
    @SerializedName("genreUrl")
    private String genreUrl;
    @SerializedName("author")
    private String author;
    @SerializedName("authorId")
    private String authorId;
    @SerializedName("authorUrl")
    private String authorUrl;
    @SerializedName("authorVerified")
    private Boolean authorVerified;
    @SerializedName("authorThumbnails")
    private List<AuthorThumbnailsDTO> authorThumbnails;
    @SerializedName("subCountText")
    private String subCountText;
    @SerializedName("lengthSeconds")
    private Integer lengthSeconds;
    @SerializedName("allowRatings")
    private Boolean allowRatings;
    @SerializedName("rating")
    private Integer rating;
    @SerializedName("isListed")
    private Boolean isListed;
    @SerializedName("liveNow")
    private Boolean liveNow;
    @SerializedName("isPostLiveDvr")
    private Boolean isPostLiveDvr;
    @SerializedName("isUpcoming")
    private Boolean isUpcoming;
    @SerializedName("dashUrl")
    private String dashUrl;
    @SerializedName("adaptiveFormats")
    private List<AdaptiveFormatsDTO> adaptiveFormats;
    @SerializedName("formatStreams")
    private List<FormatStreamsDTO> formatStreams;
    @SerializedName("captions")
    private List<CaptionsDTO> captions;
    @SerializedName("recommendedVideos")
    private List<RecommendedVideosDTO> recommendedVideos;

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

    @NoArgsConstructor
    @Data
    public static class StoryboardsDTO {
        @SerializedName("url")
        private String url;
        @SerializedName("templateUrl")
        private String templateUrl;
        @SerializedName("width")
        private Integer width;
        @SerializedName("height")
        private Integer height;
        @SerializedName("count")
        private Integer count;
        @SerializedName("interval")
        private Integer interval;
        @SerializedName("storyboardWidth")
        private Integer storyboardWidth;
        @SerializedName("storyboardHeight")
        private Integer storyboardHeight;
        @SerializedName("storyboardCount")
        private Integer storyboardCount;
    }

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

    @NoArgsConstructor
    @Data
    public static class AdaptiveFormatsDTO {
        @SerializedName("init")
        private String init;
        @SerializedName("index")
        private String index;
        @SerializedName("bitrate")
        private String bitrate;
        @SerializedName("url")
        private String url;
        @SerializedName("itag")
        private String itag;
        @SerializedName("type")
        private String type;
        @SerializedName("clen")
        private String clen;
        @SerializedName("lmt")
        private String lmt;
        @SerializedName("projectionType")
        private String projectionType;
        @SerializedName("fps")
        private Integer fps;
        @SerializedName("container")
        private String container;
        @SerializedName("encoding")
        private String encoding;
        @SerializedName("audioQuality")
        private String audioQuality;
        @SerializedName("audioSampleRate")
        private Integer audioSampleRate;
        @SerializedName("audioChannels")
        private Integer audioChannels;
        @SerializedName("resolution")
        private String resolution;
        @SerializedName("qualityLabel")
        private String qualityLabel;
        @SerializedName("colorInfo")
        private ColorInfoDTO colorInfo;

        @NoArgsConstructor
        @Data
        public static class ColorInfoDTO {
            @SerializedName("primaries")
            private String primaries;
            @SerializedName("transferCharacteristics")
            private String transferCharacteristics;
            @SerializedName("matrixCoefficients")
            private String matrixCoefficients;
        }
    }

    @NoArgsConstructor
    @Data
    public static class FormatStreamsDTO {
        @SerializedName("url")
        private String url;
        @SerializedName("itag")
        private String itag;
        @SerializedName("type")
        private String type;
        @SerializedName("quality")
        private String quality;
        @SerializedName("bitrate")
        private String bitrate;
        @SerializedName("fps")
        private Integer fps;
        @SerializedName("container")
        private String container;
        @SerializedName("encoding")
        private String encoding;
        @SerializedName("resolution")
        private String resolution;
        @SerializedName("qualityLabel")
        private String qualityLabel;
        @SerializedName("size")
        private String size;
    }

    @NoArgsConstructor
    @Data
    public static class CaptionsDTO {
        @SerializedName("label")
        private String label;
        @SerializedName("language_code")
        private String languageCode;
        @SerializedName("url")
        private String url;
    }

    @NoArgsConstructor
    @Data
    public static class RecommendedVideosDTO {
        @SerializedName("videoId")
        private String videoId;
        @SerializedName("title")
        private String title;
        @SerializedName("videoThumbnails")
        private List<VideoThumbnailsDTO> videoThumbnails;
        @SerializedName("author")
        private String author;
        @SerializedName("authorUrl")
        private String authorUrl;
        @SerializedName("authorId")
        private String authorId;
        @SerializedName("authorVerified")
        private Boolean authorVerified;
        @SerializedName("lengthSeconds")
        private Integer lengthSeconds;
        @SerializedName("viewCountText")
        private String viewCountText;
        @SerializedName("viewCount")
        private Integer viewCount;

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
}
