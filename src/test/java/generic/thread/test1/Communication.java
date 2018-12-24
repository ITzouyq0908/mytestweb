package generic.thread.test1;

/**
 * @Author: zouyongqi
 * @Description:
 * @Date: Created in 下午11:03 2018/12/4
 */
public class Communication {

    public static void main(String[] args) {
        boolean flag = true;


        Bussiness bussiness = new Bussiness();
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    if(flag){
                        bussiness.sub();
                    }
                }
            }
        }.start();

        while (true) {
            if (!flag) {
                bussiness.main();
            }
        }

    }


    private static class Bussiness {
        public synchronized void main() {
            for (int i = 0; i <= 5; i++) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":" + i);

            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            flag = false;
        }

        public synchronized void sub() {
            for (int i = 0; i <= 10; i++) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":" + i);
                
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            flag = true;
        }
    }
}
