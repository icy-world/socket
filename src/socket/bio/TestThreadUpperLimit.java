package socket.bio;

import java.util.concurrent.CountDownLatch;

/**
 * Created by root on 2018/1/14.
 *
 * 使用bio方式创建socket，会创建大量线程
 *
 * 测试java中能够创建的线程总数
 * CountDownLatch为java并发包中的类，它允许一个或多个线程一直等待，直到其他线程的操作执行完后再执行
 ****************************** 不能轻易尝试，居然差点死机。************************************
 */
public class TestThreadUpperLimit {
    public static void main(String[] args) {

        for (int i = 0;; i++) {
            System.out.println("i = " + i);
            new Thread(new HoldThread()).start();
        }
    }
}
class HoldThread extends Thread {
    CountDownLatch cdl = new CountDownLatch(1);
    public HoldThread() {
        this.setDaemon(true);
    }
    public void run() {
        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
