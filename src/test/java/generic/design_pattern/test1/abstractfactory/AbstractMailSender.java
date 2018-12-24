package generic.design_pattern.test1.abstractfactory;

/**
 * @Author: zouyongqi
 * @Description:
 * @Date: Created in 上午12:37 2018/12/20
 */
public class AbstractMailSender implements AbstradtSender {
    @Override
    public void send() {
        System.out.println("this is abstract mailsender!");
    }
}
