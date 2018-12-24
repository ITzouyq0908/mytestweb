package generic.design_pattern.test1.abstractfactory;

/**
 * @Author: zouyongqi
 * @Description:
 * @Date: Created in 上午12:42 2018/12/20
 */
public class AbstractSenderSmsFactory implements Provider {
    @Override
    public AbstradtSender produce() {
        return new AbstractSmsSender();
    }
}
