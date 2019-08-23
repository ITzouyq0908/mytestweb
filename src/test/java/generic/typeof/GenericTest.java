package generic.typeof;

import java.util.ArrayList;

/**
 * @Author: zouyongqi
 * @Description:
 * @Date: Created in 下午3:28 2019/1/11
 */
public class GenericTest {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list1 = new ArrayList<String>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        System.out.println(list1.getClass() == list2.getClass());

        list2.getClass().getMethod("add", Object.class).invoke(list2, "abc");
        System.out.println(list2.get(0));

    }
}
