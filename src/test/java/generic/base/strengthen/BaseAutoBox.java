package generic.base.strengthen;

/**
 * @Author: zouyongqi
 * @Description:
 * @Date: Created in 下午6:29 2019/3/21
 */
public class BaseAutoBox {

    public static void main(String[] args) {

        Integer a = 122;
        Integer b = 122;
        // -128 ~ 127 是相等的
        System.out.println(a == b);
    }
}
