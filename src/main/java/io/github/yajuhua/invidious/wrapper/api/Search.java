package io.github.yajuhua.invidious.wrapper.api;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.github.yajuhua.invidious.wrapper.pojo.dto.SearchDTO;
import io.github.yajuhua.invidious.wrapper.utils.Http;

import java.lang.reflect.Type;
import java.util.List;

/**
 * /api/v1/search?type=channel&q=
 */
public class Search {
    /**
     * 搜索接口
     * @param q 用户id或用户名
     * @return
     */
    public static List<SearchDTO> get(String q) throws Exception {
        String json = Http.get("/api/v1/search?type=channel&q=" + q);
        Gson gson = new Gson();
        // 定义List<String>的类型
        Type listType = new TypeToken<List<SearchDTO>>(){}.getType();
        List<SearchDTO> searchDTOS =  gson.fromJson(json,listType);
        return searchDTOS;
    }
}
