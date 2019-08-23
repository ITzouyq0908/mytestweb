package generic.design_pattern.test1.factory;

import generic.design_pattern.test1.Sender;

/**
 * @Author: zouyongqi
 * @Description:
 * @Date: Created in 下午10:05 2018/12/19
 */
public class FactoryTest {
    public static void main(String[] args) {
        SendFactory factory = new SendFactory();
        Sender sender = factory.produce("sms");
        sender.sender();

        SenderFactory sf = new SenderFactory();
        Sender s1 = sf.getMailSender();
        s1.sender();

        Sender s2 = SenderFactory.produceMail();
        s2.sender();
    }
}
