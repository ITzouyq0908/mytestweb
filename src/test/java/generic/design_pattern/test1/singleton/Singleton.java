package generic.design_pattern.test1.singleton;

/**
 * @Author: zouyongqi
 * @Description:
 * @Date: Created in 下午6:08 2019/1/4
 */
public class Singleton {

    private static Singleton instance;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if(instance == null) {
            synchronized (instance) {
                if(instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
