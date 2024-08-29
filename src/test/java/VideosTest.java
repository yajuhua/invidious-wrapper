import io.github.yajuhua.invidious.wrapper.Invidious;
import io.github.yajuhua.invidious.wrapper.api.Video;
import io.github.yajuhua.invidious.wrapper.api.Videos;
import io.github.yajuhua.invidious.wrapper.pojo.dto.VideosDTO;
import io.github.yajuhua.invidious.wrapper.pojo.dto.commons.VideoDTO;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;

import static org.testng.AssertJUnit.*;

public class VideosTest {
    @BeforeTest
    public void setProxy(){
        String osName = System.getProperty("os.name");
        if (osName.startsWith("Win")){
            Proxy proxy = new Proxy(Proxy.Type.HTTP,new InetSocketAddress(10809));
            Invidious.proxy = proxy;
        }
    }

    /**
     * 比较两个视频的发布时间
     * @throws Exception
     */
    @Test
    public void equalPublicDate() throws Exception {
        String vid1 = "oXaxcSBRWVA";//这个发布时间晚于下面的
        String vid2 = "kp3DpFXJJ_U";
        Integer integer = Video.equalPublicDate(vid1, vid2);
        assertTrue("视频日期比较失败",integer == 1);
    }

    @Test
    public void get() throws Exception {
        String id = "UCAr4MVsPBKjhg5eLDDpbDFg";
        VideosDTO videosDTO = Videos.get(id);
        assertNotNull("无法获取videos",videosDTO);
    }

    /**
     * 获取最近三集
     * @throws Exception
     */
    @Test
    public void getRecent() throws Exception {
        String id = "UCAr4MVsPBKjhg5eLDDpbDFg";
        List<VideoDTO> recent = Videos.getRecent(id, 3);
        assertFalse("获取最近3集失败",recent.isEmpty());
    }

    /**
     * 获取最近三集
     * @throws Exception
     */
    @Test
    public void getLatest() throws Exception {
        String id = "UCAr4MVsPBKjhg5eLDDpbDFg";
        VideoDTO latest = Videos.getLatest(id);
        assertNotNull("无法获取最新视频",latest);
    }
}
