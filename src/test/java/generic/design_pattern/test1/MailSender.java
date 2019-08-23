package generic.design_pattern.test1;

/**
 * @Author: zouyongqi
 * @Description:
 * @Date: Created in 下午9:48 2018/12/19
 */
public class MailSender implements Sender {
    @Override
    public void sender() {
        System.out.println("this is MailSender!");
    }
}
