package generic.design_pattern.test1.abstractfactory;

/**
 * @Author: zouyongqi
 * @Description:
 * @Date: Created in 下午5:25 2019/1/4
 */
public class AbstractSmsSender implements AbstractSender {
    @Override
    public void sender() {
        System.out.println("this is abstraceSmsSender!");
    }
}
