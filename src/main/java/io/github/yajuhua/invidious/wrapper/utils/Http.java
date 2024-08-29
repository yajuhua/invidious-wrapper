package io.github.yajuhua.invidious.wrapper.utils;

import io.github.yajuhua.invidious.wrapper.Invidious;
import io.github.yajuhua.invidious.wrapper.downloader.Request;
import io.github.yajuhua.invidious.wrapper.downloader.Response;

public class Http {

    /**
     * 发送GET请求
     * @param url
     * @return
     */
    public static String get(String url) throws Exception {
        Request get = Request.builder()
                .url(url)
                .httpMethod("GET")
                .build();
        Response response = Invidious.getDownloader().execute(get);
        if (response.getResponseCode() != 200){
            throw new Exception(response.getResponseMessage());
        }
        return response.getResponseBody();
    }
}
