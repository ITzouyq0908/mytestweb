package generic.thread.test1;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Author: zouyongqi
 * @Description: 定时器
 */
public class TimerTest {
    public static void main(String[] args) {
        timer();


    }

    /**
     * 定时器每隔2秒运行一次后，再隔4秒运行，依次交替运行
     */
    public static void timer() {
        new Timer().schedule(new MyTimeTasker(), 2000);
        while (true) {
            System.out.println(new Date().getSeconds());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class MyTimeTasker extends TimerTask {
        static int count = 0;
        @Override
        public void run() {
            count = (count+1)%2;
            System.out.println("run other interface");
            new Timer().schedule(new MyTimeTasker(), 2000+2000*count);
        }
    }
}
