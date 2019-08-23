package generic.base.volatiletest;

/**
 * @Author: zouyongqi
 * @Description:
 * @Date: Created in 17:21 2019-05-07
 */
public class VolatileTest {
    /*volatile*/ boolean running = true;

    void method() {
        System.out.println("start...");
        while (running) {

        }
        System.out.println("end");
    }

    public static void main(String[] args) {
        VolatileTest vt = new VolatileTest();
        new Thread(vt::method, "t1").start();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        vt.running = false;
    }
}
