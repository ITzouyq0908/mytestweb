package generic.design_pattern.test1.factory;

import generic.design_pattern.test1.MailSender;
import generic.design_pattern.test1.Sender;
import generic.design_pattern.test1.SmsSender;

/**
 * @Author: zouyongqi
 * @Description:
 * @Date: Created in 下午9:50 2018/12/19
 */
public class SendFactory {
    public Sender produce(String type) {
        if("mail".equals(type)){
            return new MailSender();
        } else if ("sms".equals(type)) {
            return new SmsSender();
        } else {
            System.out.println("类型错误!");
            return null;
        }
    }
}
