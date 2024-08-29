package io.github.yajuhua.invidious.wrapper;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.github.yajuhua.invidious.wrapper.downloader.DefaultDownloader;
import io.github.yajuhua.invidious.wrapper.downloader.Downloader;
import io.github.yajuhua.invidious.wrapper.downloader.Request;
import io.github.yajuhua.invidious.wrapper.downloader.Response;
import io.github.yajuhua.invidious.wrapper.pojo.dto.InstanceDetail;
import lombok.extern.slf4j.Slf4j;

import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Slf4j
public class Invidious {
    /**
     * 设置网络代理
     */
    public static Proxy proxy;
    private static String api;
    private static Downloader downloader;
    public static void setApi(String api) {
        Invidious.api = api;
    }
    public static List<String> instanceUriList;
    static {
        try {
            instanceUriList = getInstanceHostList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 初始化时设置下载器(可选)
     * @param downloader
     */
    public static void init(final Downloader downloader){
        Invidious.downloader = downloader;
    }

    /**
     * 获取下载器
     * @return
     */
    public static Downloader getDownloader(){
        if (Invidious.downloader == null){
            //默认下载器
            return new DefaultDownloader();
        }
        return Invidious.downloader;
    }

    /**
     * 获取instance列表细节
     * @param api
     * @return
     * @throws Exception
     */
    public static List<InstanceDetail> getInstanceDetails(String api) throws Exception {
        Gson gson = new Gson();
        List<InstanceDetail> instanceDetails = new ArrayList<>();
        Request get = Request.builder()
                .url(api)
                .httpMethod("GET")
                .build();
        Response response = getDownloader().execute(get);
        if (response.getResponseCode() != 200){
            throw new Exception("无法获取invidous实例列表: " + response.getResponseMessage());
        }
        if (response.getResponseBody() == null && api != null){
            instanceDetails.add(InstanceDetail.builder().uri(api).build());
            return instanceDetails;
        }
        JsonArray a1 = gson.fromJson(response.getResponseBody(), JsonArray.class);

        for (JsonElement e : a1) {
            JsonArray a2 = e.getAsJsonArray();
            JsonObject asJsonObject = a2.get(1).getAsJsonObject();
            InstanceDetail detail = gson.fromJson(asJsonObject, InstanceDetail.class);
            instanceDetails.add(detail);
        }
        return instanceDetails;
    }

    /**
     * 获取目前状态最佳的实例API
     * @param api
     * @return
     */
    public static String getBestInvidiousAPI(String api) throws Exception {
        List<InstanceDetail> collect = null;
        List<InstanceDetail> instanceDetails = getInstanceDetails(api);
        if (instanceDetails.size() == 1){
            //使用默认的
            return instanceDetails.get(0).getUri();
        }
        try {
            collect = instanceDetails.stream().filter(new Predicate<InstanceDetail>() {
                @Override
                public boolean test(InstanceDetail instanceDetail) {
                    InstanceDetail.StatsDTO stats = instanceDetail.getStats();
                    if (stats == null){
                        return false;
                    }
                    InstanceDetail.StatsDTO.PlaybackDTO playback = stats.getPlayback();
                    if (playback == null){
                        return false;
                    }
                    Double ratio = playback.getRatio();
                    if (ratio == null){
                        return false;
                    }
                    return true;
                }
            }).filter(new Predicate<InstanceDetail>() {
                @Override
                public boolean test(InstanceDetail instanceDetail) {
                    return (instanceDetail.getMonitor().getLastStatus() != null) && instanceDetail.getMonitor()
                            .getLastStatus() == 200;
                }
            }).sorted(new Comparator<InstanceDetail>() {
                @Override
                public int compare(InstanceDetail o1, InstanceDetail o2) {
                    return Double.compare(o1.getStats().getPlayback().getRatio(), o2.getStats()
                            .getPlayback().getRatio());
                }
            }).collect(Collectors.toList());
            if (collect.isEmpty()){return null;}
        } catch (Exception e) {
            return getInstanceDetails(api).get(0).getUri();
        }

        return collect.get(collect.size() - 1).getUri() + "/";
    }

    /**
     * 获取最佳API
     * @return
     */
    public static String getBestInvidiousAPI() throws Exception {
        return getBestInvidiousAPI("https://api.invidious.io/instances.json?sort_by=type,health");
    }

    /**
     * 获取实例列表中的uri
     * @return
     * @throws Exception
     */
    public static List<String> getInstanceUriList() throws Exception {
        List<InstanceDetail> instanceDetails = getInstanceDetails("https://api.invidious.io/instances.json?sort_by=type,health");
        List<InstanceDetail> httpsInvidious = instanceDetails.stream().filter(new Predicate<InstanceDetail>() {
            @Override
            public boolean test(InstanceDetail instanceDetail) {
                return instanceDetail.getType().equalsIgnoreCase("https")
                        && instanceDetail.getApi() != null && instanceDetail.getCors() != null;
            }
        }).collect(Collectors.toList());

        List<String> uriList = httpsInvidious.stream().map(InstanceDetail::getUri).collect(Collectors.toList());
        return uriList;
    }

    /**
     * 获取实例列表中的主机
     * @return
     */
    public static List<String> getInstanceHostList() throws Exception {
        if (instanceUriList != null && !instanceUriList.isEmpty()){
            return instanceUriList;
        }else {
            List<String> hostList = new ArrayList<>();
            for (String uri : getInstanceUriList()) {
                try {
                    URL url = new URL(uri);
                    hostList.add(url.getHost());
                } catch (MalformedURLException e) {
                    log.error("获取host失败",e);
                }
            }
            return hostList;
        }
    }
}
