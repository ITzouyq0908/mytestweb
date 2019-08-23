package generic.design_pattern.test1.abstractfactory;

/**
 * @Author: zouyongqi
 * @Description:
 * @Date: Created in 下午5:45 2019/1/4
 */
public class AbstractMailSender implements AbstractSender {
    @Override
    public void sender() {
        System.out.println("this is AbstraceMailSender!");
    }
}
