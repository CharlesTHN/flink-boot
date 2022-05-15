import com.intsmaze.dubbo.provider.DubboService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ：intsmaze
 * @date ：Created in 2021/1/26 22:19
 * @description： https://www.cnblogs.com/intsmaze/
 * @modified By：
 */
public class ConsumerClient {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"dubbo-consumer.xml"});
        context.start();
        int i=0;
        while (true) {
            i++;
            DubboService demoService = (DubboService) context.getBean("dubboService"); // 获取远程服务代理
            String hello = demoService.flinkDealMess("world："+i); // 执行远程方法
            System.out.println(hello); // 显示调用结果
            Thread.sleep(1000);
        }
    }
}
