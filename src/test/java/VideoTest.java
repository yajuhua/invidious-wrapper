import io.github.yajuhua.invidious.wrapper.Invidious;
import io.github.yajuhua.invidious.wrapper.api.Video;
import io.github.yajuhua.invidious.wrapper.pojo.dto.VideoDetailDTO;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.InetSocketAddress;
import java.net.Proxy;

import static org.testng.AssertJUnit.*;

public class VideoTest {
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
        String videoId = "oXaxcSBRWVA";
        VideoDetailDTO videoDetailDTO = Video.get(videoId);
        assertNotNull("无法获取video详细信息",videoDetailDTO);
    }
}
