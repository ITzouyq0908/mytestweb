package generic.thread.test1;

/**
 * @Author: zouyongqi
 * @Description:
 * @Date: Created in 上午3:21 2018/10/25
 */
public class TraditionThread {

    public static void main(String[] args) {


        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("2: " + Thread.currentThread().getName());
                }
            }
        });
        thread1.start();

        Thread thread = new Thread(){
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("1: " + Thread.currentThread().getName());
//                    System.out.println(this.getName());
                }
            }
        };
        thread.start();

        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("runnable: " + Thread.currentThread().getName());
                }
            }
        }){
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("thread: " + Thread.currentThread().getName());
                }
            }
        }.start();
    }
}
