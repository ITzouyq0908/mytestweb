package generic.design_pattern.test1.abstractfactory;

/**
 * @Author: zouyongqi
 * @Description:
 * @Date: Created in 上午12:39 2018/12/20
 */
public class AbstractSenderMailFactory implements Provider {
    @Override
    public AbstractMailSender produce() {
        return new AbstractMailSender();
    }
}
