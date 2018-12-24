package generic.jvm.test1;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zouyongqi
 * @Description:
 * @Date: Created in 上午10:59 2018/11/30
 */
public class StringOomMock {
    static String base = "string";

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            String str = base + base;
            base = str;
            list.add(str.intern());
        }
    }
}
