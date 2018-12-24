package generic.test.loadNum;

/**
 * @Author: zouyongqi
 * @Description:
 * @Date: Created in 下午8:36 2018/9/27
 */
public class Child extends Parent {
    {
        System.out.println("child test1");
    }

    static {
        System.out.println("child static test1");
    }

    public Child() {
        System.out.println("child construct test1");
    }
}
