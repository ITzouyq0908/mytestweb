package generic.design_pattern.test1;

/**
 * @Author: zouyongqi
 * @Description:
 * @Date: Created in 下午9:49 2018/12/19
 */
public class SmsSender implements Sender {
    @Override
    public void sender() {
        System.out.println("this is SmsSender!");
    }
}
