package generic.design_pattern.test1.singleton;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: zouyongqi
 * @Description:
 * @Date: Created in 下午11:30 2019/1/4
 */
public class SingletonTest {
    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(100);


    }

    public static void countdownLunchTest() {
        final CountDownLatch latch = new CountDownLatch(2);

        new Thread(){
            @Override
            public void run() {
                try {
                    System.out.println("子线程 " + Thread.currentThread().getName()+"正在执行");
                    Thread.sleep(3000);
                    System.out.println("子线程 " + Thread.currentThread().getName()+"执行完成");
                    latch.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                try {
                    System.out.println("子线程 " + Thread.currentThread().getName()+"正在执行");
                    Thread.sleep(3000);
                    System.out.println("子线程 " + Thread.currentThread().getName()+"执行完成");
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }.start();

        try {
            System.out.println("等待两个线程执行完毕...");
            latch.await();
            System.out.println("两个线程执行完毕");
            System.out.println("继续执行主线程");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
