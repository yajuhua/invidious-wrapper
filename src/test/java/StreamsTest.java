import io.github.yajuhua.invidious.wrapper.Invidious;
import io.github.yajuhua.invidious.wrapper.api.Playlist;
import io.github.yajuhua.invidious.wrapper.api.Streams;
import io.github.yajuhua.invidious.wrapper.pojo.dto.PlaylistDTO;
import io.github.yajuhua.invidious.wrapper.pojo.dto.StreamsDTO;
import io.github.yajuhua.invidious.wrapper.pojo.dto.commons.VideoDTO;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertNotNull;

public class StreamsTest {
    @BeforeTest
    public void setProxy(){
        String osName = System.getProperty("os.name");
        if (osName.startsWith("Win")){
            Proxy proxy = new Proxy(Proxy.Type.HTTP,new InetSocketAddress(10809));
            Invidious.proxy = proxy;
        }
    }

    @Test
    public void get() throws Exception {
        String id = "UCAr4MVsPBKjhg5eLDDpbDFg";
        StreamsDTO streamsDTO = Streams.get(id);
        assertNotNull("无法获取streams",streamsDTO);
    }

    /**
     * 获取最近三集
     * @throws Exception
     */
    @Test
    public void getRecent() throws Exception {
        String id = "UCAr4MVsPBKjhg5eLDDpbDFg";
        List<VideoDTO> recent = Streams.getRecent(id, 3);
        assertFalse("获取最近3集失败",recent.isEmpty());
    }

    /**
     * 获取最近三集
     * @throws Exception
     */
    @Test
    public void getLatest() throws Exception {
        String id = "UCAr4MVsPBKjhg5eLDDpbDFg";
        VideoDTO latest = Streams.getLatest(id);
        assertNotNull("无法获取最新视频",latest);
    }
}
