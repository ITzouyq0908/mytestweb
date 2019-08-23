package generic.design_pattern.test2.build;

/**
 * @Author: zouyongqi
 * @Description:
 * @Date: Created in 23:24 2019-05-14
 */
public class BuildTest {
    public static void main(String[] args) {
        ConcreteBuilder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        director.construct();
        Product product = builder.getResult();

    }
}
