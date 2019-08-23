package generic.design_pattern.test1.abstractfactory;

/**
 * @Author: zouyongqi
 * @Description:
 * @Date: Created in 下午5:29 2019/1/4
 */
public class AbstractEmailFactory implements Provider {
    @Override
    public AbstractSender produce() {
        return new AbstractMailSender();
    }
}
