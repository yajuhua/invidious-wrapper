package io.github.yajuhua.invidious.wrapper.api;

import com.google.gson.Gson;
import io.github.yajuhua.invidious.wrapper.pojo.dto.ChannelDTO;
import io.github.yajuhua.invidious.wrapper.utils.Http;

/**
 * /api/v1/channels/ID
 */
public class Channel {
    public static ChannelDTO get(String id) throws Exception {
        String url = "/api/v1/channels/" + id;
        String json = Http.get(url);
        Gson gson = new Gson();
        return gson.fromJson(json, ChannelDTO.class);
    }
}
