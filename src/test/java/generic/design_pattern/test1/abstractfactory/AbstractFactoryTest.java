package generic.design_pattern.test1.abstractfactory;

/**
 * @Author: zouyongqi
 * @Description:
 * @Date: Created in 下午5:30 2019/1/4
 */
public class AbstractFactoryTest {
    public static void main(String[] args) {
        AbstractEmailFactory emailFactory = new AbstractEmailFactory();
        AbstractSender s = emailFactory.produce();
        s.sender();

        int ret = 1024 * 1024;
        Runtime runtime = Runtime.getRuntime();
        System.out.println("MAX_MEMORY: " + ((double)runtime.maxMemory()/ret) + "m");
        System.out.println("TOTAL_MEMORY: " + ((double)runtime.totalMemory()/ret) + "m");
        System.out.println("FREE_MEMORY: " + ((double)runtime.freeMemory()/ret) + "m");

    }
}
