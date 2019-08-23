package generic.base.threadlocal;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: zouyongqi
 * @Description:
 * @Date: Created in 下午9:37 2019/4/27
 */
public class ThreadLocalDemo {

    public static void main(String[] args) {
        int threads = 3;
        CountDownLatch countDownLatch = new CountDownLatch(threads);
        InnerClass innerClass = new InnerClass();
        for (int i = 0; i <= threads; i++) {
            new Thread(() -> {
                for (int j = 0; j < 4; j++) {
                    innerClass.add(String.valueOf(j));
                    innerClass.print();
                }
                innerClass.set("hello world");
                countDownLatch.countDown();
            }, "thread -" + i).start();
        }
    }

    private static class InnerClass {

        public void add(String newStr) {
            StringBuilder sb = Counter.counter.get();
            Counter.counter.set(sb.append(newStr));
        }

        public void print() {
            System.out.printf("Thread name:%s, ThreadLocal hashcode:%s," +
                            " Instance hashcode:%s, Value:%s",
                    Thread.currentThread().getName(),
                    Counter.counter.hashCode(),
                    Counter.counter.get().hashCode(),
                    Counter.counter.get().toString());
        }

        public void set(String str) {
            Counter.counter.set(new StringBuilder(str));
            System.out.printf("Set, Thread name:%s, ThreadLocal hashcode:%s, " +
                            "Instance hashcode:%s, Value:%s",
                    Thread.currentThread().getName(),
                    Counter.counter.hashCode(),
                    Counter.counter.get().hashCode(),
                    Counter.counter.get().toString());
        }
    }

    private static class Counter {

        private static ThreadLocal<StringBuilder> counter = new ThreadLocal<StringBuilder>() {
            @Override
            protected StringBuilder initialValue() {
                return new StringBuilder();
            }
        };
    }
}
