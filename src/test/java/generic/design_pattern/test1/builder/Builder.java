package generic.design_pattern.test1.builder;

import generic.design_pattern.test1.MailSender;
import generic.design_pattern.test1.Sender;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zouyongqi
 * @Description:
 * @Date: Created in 22:14 2019-05-09
 */
public class Builder {
    private List<Sender> list = new ArrayList<Sender>();

    public void productMailSender(int count) {
        for (int i = 0; i < count; i++) {
             list.add(new MailSender());
        }
    }
    public void productSmsSender(int count) {
        for (int i = 0; i < count; i++) {
            list.add(new MailSender());
        }
    }
}
