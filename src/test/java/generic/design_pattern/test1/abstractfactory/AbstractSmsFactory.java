package generic.design_pattern.test1.abstractfactory;

/**
 * @Author: zouyongqi
 * @Description:
 * @Date: Created in 下午5:28 2019/1/4
 */
public class AbstractSmsFactory implements Provider {
    @Override
    public AbstractSender produce() {
        return new AbstractSmsSender();
    }
}
