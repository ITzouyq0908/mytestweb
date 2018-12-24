package generic.spring.test1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: zouyongqi
 * @Description:
 * @Date: Created in 上午1:44 2018/12/12
 */
public class BeanLifeCycle {
    public static void main(String[] args) {
        System.out.println("现在开始初始化容器");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("generic.spring.test1/beans.xml");
        Person person = (Person)ctx.getBean("person");
        System.out.println(person);

        System.out.println("现在开始关闭容器！");
        ((ClassPathXmlApplicationContext)ctx).registerShutdownHook();
    }
}
