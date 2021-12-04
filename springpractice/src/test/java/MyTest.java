import com.xsj.springpractice.PostProcessorMain;
import com.xsj.springpractice.pojo.MyJavaBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author xsj
 * @create 2021-02-24 11:05
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes=PostProcessorMain.class)
public class MyTest {
    @Autowired
    private MyJavaBean myJavaBean;

    @Test
    public void contextLoad(){
//        System.out.println("===============下面输出结果============");
//        System.out.println("描述：" + myJavaBean.getDesc());
//        System.out.println("备注：" + myJavaBean.getRemark());
//        new HashMap();
//        new ConcurrentHashMap<>()
//        new LinkedList<>()
    }
}
