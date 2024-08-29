import io.github.yajuhua.invidious.wrapper.Invidious;
import io.github.yajuhua.invidious.wrapper.api.Channel;
import io.github.yajuhua.invidious.wrapper.api.Streams;
import io.github.yajuhua.invidious.wrapper.api.Video;
import io.github.yajuhua.invidious.wrapper.api.Videos;
import io.github.yajuhua.invidious.wrapper.pojo.dto.ChannelDTO;
import io.github.yajuhua.invidious.wrapper.pojo.dto.StreamsDTO;
import io.github.yajuhua.invidious.wrapper.pojo.dto.VideoDetailDTO;
import io.github.yajuhua.invidious.wrapper.pojo.dto.VideosDTO;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.InetSocketAddress;
import java.net.Proxy;

import static org.testng.AssertJUnit.assertNotNull;

public class ApiTest {

    @BeforeTest
    public void setProxy(){
        String osName = System.getProperty("os.name");
        if (osName.startsWith("Win")){
            Proxy proxy = new Proxy(Proxy.Type.HTTP,new InetSocketAddress(10809));
            Invidious.proxy = proxy;
        }
    }

    @Test
    public void getChannel() throws Exception {
        String id = "UCfX769yHKr7S8gz7UigOsbg";
        ChannelDTO channel = Channel.get(id);
        assertNotNull("Channel.get返回null",channel);
    }

    @Test
    public void getStreams() throws Exception {
        String id = "UCfX769yHKr7S8gz7UigOsbg";
        StreamsDTO streams = Streams.get(id);
        assertNotNull("Streams.get返回null",streams);
    }

    @Test
    public void getVideos() throws Exception {
        String id = "UCfX769yHKr7S8gz7UigOsbg";
        VideosDTO videos = Videos.get(id);
        assertNotNull("Videos.get返回null",videos);
    }

    @Test
    public void getVideo() throws Exception {
        String id = "X7bhPgS6N9Y";
        VideoDetailDTO video = Video.get(id);
        assertNotNull("Video.get返回null",video);
    }
}
