package io.github.yajuhua.invidious.wrapper.pojo.dto;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class InstanceDetail {

    @SerializedName("flag")
    private String flag;
    @SerializedName("region")
    private String region;
    @SerializedName("stats")
    private StatsDTO stats;
    @SerializedName("cors")
    private Boolean cors;
    @SerializedName("api")
    private Boolean api;
    @SerializedName("type")
    private String type;
    @SerializedName("uri")
    private String uri;
    @SerializedName("monitor")
    private MonitorDTO monitor;

    @NoArgsConstructor
    @Data
    public static class StatsDTO {
        @SerializedName("version")
        private String version;
        @SerializedName("software")
        private StatsDTO.SoftwareDTO software;
        @SerializedName("openRegistrations")
        private Boolean openRegistrations;
        @SerializedName("usage")
        private StatsDTO.UsageDTO usage;
        @SerializedName("metadata")
        private StatsDTO.MetadataDTO metadata;
        @SerializedName("playback")
        private StatsDTO.PlaybackDTO playback;

        @NoArgsConstructor
        @Data
        public static class SoftwareDTO {
            @SerializedName("name")
            private String name;
            @SerializedName("version")
            private String version;
            @SerializedName("branch")
            private String branch;
        }

        @NoArgsConstructor
        @Data
        public static class UsageDTO {
            @SerializedName("users")
            private StatsDTO.UsageDTO.UsersDTO users;

            @NoArgsConstructor
            @Data
            public static class UsersDTO {
                @SerializedName("total")
                private Integer total;
                @SerializedName("activeHalfyear")
                private Integer activeHalfyear;
                @SerializedName("activeMonth")
                private Integer activeMonth;
            }
        }

        @NoArgsConstructor
        @Data
        public static class MetadataDTO {
            @SerializedName("updatedAt")
            private Integer updatedAt;
            @SerializedName("lastChannelRefreshedAt")
            private Integer lastChannelRefreshedAt;
        }

        @NoArgsConstructor
        @Data
        public static class PlaybackDTO {
            @SerializedName("totalRequests")
            private Integer totalRequests;
            @SerializedName("successfulRequests")
            private Integer successfulRequests;
            @SerializedName("ratio")
            private Double ratio;
        }
    }

    @NoArgsConstructor
    @Data
    public static class MonitorDTO {
        @SerializedName("token")
        private String token;
        @SerializedName("url")
        private String url;
        @SerializedName("alias")
        private String alias;
        @SerializedName("last_status")
        private Integer lastStatus;
        @SerializedName("uptime")
        private Integer uptime;
        @SerializedName("down")
        private Boolean down;
        @SerializedName("down_since")
        private Object downSince;
        @SerializedName("up_since")
        private String upSince;
        @SerializedName("error")
        private Object error;
        @SerializedName("period")
        private Integer period;
        @SerializedName("apdex_t")
        private Integer apdexT;
        @SerializedName("string_match")
        private String stringMatch;
        @SerializedName("enabled")
        private Boolean enabled;
        @SerializedName("published")
        private Boolean published;
        @SerializedName("disabled_locations")
        private List<?> disabledLocations;
        @SerializedName("recipients")
        private List<?> recipients;
        @SerializedName("last_check_at")
        private String lastCheckAt;
        @SerializedName("next_check_at")
        private String nextCheckAt;
        @SerializedName("created_at")
        private String createdAt;
        @SerializedName("mute_until")
        private String muteUntil;
        @SerializedName("favicon_url")
        private String faviconUrl;
        @SerializedName("custom_headers")
        private MonitorDTO.CustomHeadersDTO customHeaders;
        @SerializedName("http_verb")
        private String httpVerb;
        @SerializedName("http_body")
        private String httpBody;
        @SerializedName("ssl")
        private MonitorDTO.SslDTO ssl;

        @NoArgsConstructor
        @Data
        public static class CustomHeadersDTO {
        }

        @NoArgsConstructor
        @Data
        public static class SslDTO {
            @SerializedName("tested_at")
            private String testedAt;
            @SerializedName("expires_at")
            private String expiresAt;
            @SerializedName("valid")
            private Boolean valid;
            @SerializedName("error")
            private Object error;
        }
    }
}

