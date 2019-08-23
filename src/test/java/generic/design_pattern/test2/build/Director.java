package generic.design_pattern.test2.build;

/**
 * @Author: zouyongqi
 * @Description:
 * @Date: Created in 23:03 2019-05-14
 */
public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void construct() {
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
    }
}
