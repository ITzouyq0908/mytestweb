package generic.design_pattern.test1.abstractfactory;

/**
 * @Author: zouyongqi
 * @Description:
 * @Date: Created in 上午12:38 2018/12/20
 */
public class AbstractSmsSender implements AbstradtSender {
    @Override
    public void send() {
        System.out.println("this is abstract smssender!");
    }
}
