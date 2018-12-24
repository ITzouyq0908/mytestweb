package generic.design_pattern.test1.abstractfactory;

/**
 * @Author: zouyongqi
 * @Description:
 * @Date: Created in 上午12:43 2018/12/20
 */
public class AbstractFactoryTest {
    public static void main(String[] args) {
        AbstractSenderMailFactory asmf = new AbstractSenderMailFactory();
        AbstradtSender s1 = asmf.produce();
        s1.send();;

        AbstractSenderSmsFactory assm = new AbstractSenderSmsFactory();
        AbstradtSender s2 = assm.produce();
        s2.send();
    }
}
