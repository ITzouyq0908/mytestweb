package generic.test.loadNum;

/**
 * @Author: zouyongqi
 * @Description:
 * @Date: Created in 下午8:33 2018/9/27
 */
public class Parent {
    {
        System.out.println("parent test1");
    }

    static {
        System.out.println("parent static test1");
    }

    public Parent() {
        System.out.println("parent construct test1");
    }
}
