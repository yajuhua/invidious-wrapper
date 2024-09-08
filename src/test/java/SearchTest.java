import io.github.yajuhua.invidious.wrapper.Invidious;
import io.github.yajuhua.invidious.wrapper.api.Search;
import io.github.yajuhua.invidious.wrapper.pojo.dto.SearchDTO;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;

import static org.testng.AssertJUnit.assertFalse;

/**
 * 测试search接口
 */
public class SearchTest {
    @BeforeTest
    public void setProxy(){
        String osName = System.getProperty("os.name");
        if (osName.startsWith("Win")){
            Proxy proxy = new Proxy(Proxy.Type.HTTP,new InetSocketAddress(10809));
            Invidious.proxy = proxy;
        }
    }

    @Test
    public void getByUserId() throws Exception {
        String userId = "UCMUnInmOkrWN4gof9KlhNmQ";
        List<SearchDTO> searchDTOS = Search.get(userId);
        assertFalse(userId+"没有搜索到",searchDTOS.isEmpty());
    }

    @Test
    public void getByUserName() throws Exception {
        String userName = "@laogao";
        List<SearchDTO> searchDTOS = Search.get(userName);
        assertFalse(userName+"没有搜索到",searchDTOS.isEmpty());
    }
}
