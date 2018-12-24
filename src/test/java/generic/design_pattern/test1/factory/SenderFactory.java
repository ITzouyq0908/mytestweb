package generic.design_pattern.test1.factory;

/**
 * @Author: zouyongqi
 * @Description:
 * @Date: Created in 下午10:08 2018/12/19
 */
public class SenderFactory {
    public Sender getMailSender() {
        return new MailSender();
    }

    public Sender getSmsSender() {
        return new SmsSender();
    }

    public static Sender produceSms() {
        return new SmsSender();
    }

    public static Sender produceMail() {
        return new MailSender();
    }
}
