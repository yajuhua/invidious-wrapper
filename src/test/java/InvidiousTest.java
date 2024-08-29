import io.github.yajuhua.invidious.wrapper.Invidious;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;

import static org.testng.AssertJUnit.assertFalse;

public class InvidiousTest {

  @BeforeTest
  public void setProxy(){
      String osName = System.getProperty("os.name");
      if (osName.startsWith("Win")){
          Proxy proxy = new Proxy(Proxy.Type.HTTP,new InetSocketAddress(10809));
          Invidious.proxy = proxy;
      }
  }

    /**
     * 获取所有可用实例主机
     */
  @Test
  public void getInstanceHostList() throws Exception {
      List<String> instanceUriList = Invidious.getInstanceUriList();
      assertFalse("未找到可用实例",instanceUriList.isEmpty());
  }

}
