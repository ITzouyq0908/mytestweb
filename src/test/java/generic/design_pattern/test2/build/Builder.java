package generic.design_pattern.test2.build;

/**
 * @Author: zouyongqi
 * @Description:
 * @Date: Created in 22:58 2019-05-14
 */
public interface Builder {
    void buildPartA();
    void buildPartB();
    void buildPartC();

    Product getResult();
}
