package io.github.yajuhua.invidious.wrapper.api;

import com.google.gson.Gson;
import io.github.yajuhua.invidious.wrapper.pojo.dto.VideosDTO;
import io.github.yajuhua.invidious.wrapper.pojo.dto.commons.VideoDTO;
import io.github.yajuhua.invidious.wrapper.utils.Http;

import java.util.Collections;
import java.util.List;

/**
 * /api/v1/channels/ID/videos
 */
public class Videos {
    public static VideosDTO get(String id) throws Exception {
        String url = "/api/v1/channels/" + id + "/videos";
        String json = Http.get(url);
        Gson gson = new Gson();
        return gson.fromJson(json,VideosDTO.class);
    }

    /**
     * 获取最近几集
     * @param id
     * @param count
     * @return
     */
    public static List<VideoDTO> getRecent(String id, Integer count) throws Exception {
        VideosDTO videosDTO = get(id);
        List<VideoDTO> videos = videosDTO.getVideos();
        if (videos == null || videos.isEmpty() || videos.size() < 2){
            return videos;
        }
        Collections.reverse(videos);
        return videos.subList(videos.size() - count, videos.size());
    }

    /**
     * 获取最新一期视频
     * @param id
     * @return
     */
    public static VideoDTO getLatest(String id) throws Exception {
        VideosDTO videosDTO = get(id);
        List<VideoDTO> videos = videosDTO.getVideos();
        if (videos == null || videos.isEmpty()){
            throw new Exception("无法获取最新一期直播");
        }
        return videos.get(0);
    }
}
