package thread;

import org.apache.poi.ss.usermodel.Workbook;

/**
 * @Author: Jialong Fu
 * @Date: 2022/4/29 9:57
 */
public class MyLatch {
    private int count;

    public MyLatch(int count) {
        this.count = count;
    }

    public synchronized void await() throws InterruptedException {
        while (count > 0) {
            wait();
        }
    }

    public synchronized void countDown() {
        count--;
        if (count <= 0) {
            notifyAll();
        }
    }

    static class Worker extends Thread {
        MyLatch latch;

        public Worker(MyLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                Thread.sleep((int) (Math.random() * 1000));
                this.latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        int workerNum = 100;
        MyLatch latch = new MyLatch(workerNum);
        Worker[] workers = new Worker[workerNum];
        for (int i = 0; i < workerNum; i++) {
            workers[i] = new Worker(latch);
            workers[i].start();
        }
        latch.await();

        System.out.println("collect worker results");

    }

}
