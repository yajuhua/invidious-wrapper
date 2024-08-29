package io.github.yajuhua.invidious.wrapper.api;

import com.google.gson.Gson;
import io.github.yajuhua.invidious.wrapper.pojo.dto.PlaylistDTO;
import io.github.yajuhua.invidious.wrapper.pojo.dto.commons.VideoDTO;
import io.github.yajuhua.invidious.wrapper.utils.Http;

import java.util.Collections;
import java.util.List;

/**
 * /api/v1/playlists/ID
 */
public class Playlist {

    public enum Sort{
        /**
         * 根据发布时间升序，第一个是最旧的
         */
        ACSByTime,
        /**
         * 根据发布时间降序，第一个是最新的
         */
        DESCByTime
    }

    /**
     * /api/v1/playlist/ID响应json字符串转换成对象
     * @param id
     * @return
     * @throws Exception
     */
    public static PlaylistDTO get(String id) throws Exception {
        String url = "/api/v1/playlists/" + id;
        String json = Http.get(url);
        Gson gson = new Gson();
        return gson.fromJson(json, PlaylistDTO.class);
    }

    /**
     * 获取最近几集
     * @param id
     */
    public static List<VideoDTO> getRecent(String id, Integer count) throws Exception {
        List<VideoDTO> all = getAll(id);
        List<VideoDTO> sort = sort(all, Sort.ACSByTime);
        if (sort.size() < count){
            return sort;
        }else {
            return sort.subList(sort.size() - count,sort.size());
        }
    }

    /**
     * 获取最新的视频
     * @param id
     * @return
     */
    public static VideoDTO getLatest(String id) throws Exception {
        List<VideoDTO> all = getAll(id);
        List<VideoDTO> sort = sort(all, Sort.DESCByTime);
        if (!sort.isEmpty()) {
            return sort.get(0);
        }else {
            throw new Exception("无法获取playlist最新视频: " + id);
        }
    }

    /**
     * 获取全部视频
     */
    public static List<VideoDTO> getAll(String id) throws Exception {
        return get(id).getVideos();
    }

    /**
     * 排序
     * @param videosDTOList
     * @param sort
     * @return
     * @throws Exception
     */
    public static List<VideoDTO> sort(List<VideoDTO> videosDTOList,Sort sort) throws Exception {
        if (videosDTOList.isEmpty() || videosDTOList.size() < 2){
            return videosDTOList;
        }else {
            //比较发布时间
            String videoId1 = videosDTOList.get(0).getVideoId();
            String videoId2 = videosDTOList.get(1).getVideoId();
            Integer equalPublicDate = Video.equalPublicDate(videoId1, videoId2);

            switch (sort) {
                case DESCByTime:
                    if (equalPublicDate == -1){
                        Collections.reverse(videosDTOList);
                    }
                    break;
                case ACSByTime:
                    if (equalPublicDate == 1){
                        Collections.reverse(videosDTOList);
                    }
                    break;
            }

            return videosDTOList;
        }
    }
}
