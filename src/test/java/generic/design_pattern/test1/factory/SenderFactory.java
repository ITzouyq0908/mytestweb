package generic.design_pattern.test1.factory;

import generic.design_pattern.test1.MailSender;
import generic.design_pattern.test1.Sender;
import generic.design_pattern.test1.SmsSender;

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
