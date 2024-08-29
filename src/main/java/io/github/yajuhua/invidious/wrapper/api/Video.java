package io.github.yajuhua.invidious.wrapper.api;

import com.google.gson.Gson;
import io.github.yajuhua.invidious.wrapper.pojo.dto.VideoDetailDTO;
import io.github.yajuhua.invidious.wrapper.utils.Http;

/**
 * /api/v1/videos/ID
 */
public class Video {
    public static VideoDetailDTO get(String id) throws Exception {
        String url = "/api/v1/videos/" + id;
        String json = Http.get(url);
        Gson gson = new Gson();
        return gson.fromJson(json,VideoDetailDTO.class);
    }

    /**
     * 比较两个视频的发布时间，第一个大于第二个返回1，否则返回-1
     * @param videoId1
     * @param videoId2
     * @return
     * @throws Exception
     */
    public static Integer equalPublicDate(String videoId1,String videoId2) throws Exception {
        VideoDetailDTO video1 = get(videoId1);
        VideoDetailDTO video2 = get(videoId2);
        return video1.getPublished() > video2.getPublished()?1:-1;
    }
}
