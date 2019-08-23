package generic.thread.test1;

import java.util.concurrent.CyclicBarrier;

/**
 * @Author: zouyongqi
 * @Description:
 * 1）CountDownLatch和CyclicBarrier都能够实现线程之间的等待，只不过它们侧重点不同：
 *  CountDownLatch一般用于某个线程A等待若干个其他线程执行完任务之后，它才执行；
 *  而CyclicBarrier一般用于一组线程互相等待至某个状态，然后这一组线程再同时执行；
 *  另外，CountDownLatch是不能够重用的，而CyclicBarrier是可以重用的。
 * 2）Semaphore其实和锁有点类似，它一般用于控制对某组资源的访问权限。
 * @Date: Created in 上午2:38 2019/1/5
 */
public class CyclicBarrierTest {
    public static void main(String[] args) {
        int N = 4;
//        CyclicBarrier barrier = new CyclicBarrier(N);
        //如果说想在所有线程写入操作完之后，进行额外的其他操作可以为CyclicBarrier提供Runnable参数
        CyclicBarrier barrier = new CyclicBarrier(N, new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " run other process");
            }
        });
        for (int i = 0; i < N; i++) {
            new Writer(barrier).start();

        }
    }

    static class Writer extends Thread {
        private CyclicBarrier cyclicBarrier;

        public Writer(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println("线程"+Thread.currentThread().getName()+"正在写入数据...");
            try {
//                Thread.sleep(1000);
                System.out.println("wring...");
                System.out.println("线程"+Thread.currentThread().getName()+"写入数据完毕，等待其他线程写入完毕");
                cyclicBarrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("所有线程写入完毕，继续处理其他任务...");
        }
    }
}
