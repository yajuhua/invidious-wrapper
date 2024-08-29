import io.github.yajuhua.invidious.wrapper.Invidious;
import io.github.yajuhua.invidious.wrapper.api.Playlist;
import io.github.yajuhua.invidious.wrapper.pojo.dto.PlaylistDTO;
import io.github.yajuhua.invidious.wrapper.pojo.dto.commons.VideoDTO;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertNotNull;

public class PlaylistTest {
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
        String id = "PL4URKQHTymln_XUnkjGqmn9cjEPrQFMNW";
        PlaylistDTO playlistDTO = Playlist.get(id);
        assertNotNull("无法获取playlist",playlistDTO);
    }

    /**
     * 获取最近三集
     * @throws Exception
     */
    @Test
    public void getRecent() throws Exception {
        String id = "PL4URKQHTymln_XUnkjGqmn9cjEPrQFMNW";
        List<VideoDTO> recent = Playlist.getRecent(id, 3);
        assertFalse("获取最近3集失败",recent.isEmpty());
    }

    /**
     * 获取最近三集
     * @throws Exception
     */
    @Test
    public void getLatest() throws Exception {
        String id = "PL4URKQHTymln_XUnkjGqmn9cjEPrQFMNW";
        VideoDTO latest = Playlist.getLatest(id);
        assertNotNull("无法获取最新视频",latest);
    }
}
