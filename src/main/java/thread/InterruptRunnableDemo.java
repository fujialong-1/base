package thread;

/**
 * @Author: Jialong Fu
 * @Date: 2022/4/29 10:50
 */
public class InterruptRunnableDemo extends Thread {
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            // ... 单次循环代码
            System.out.println("hello");
        }
        System.out.println("done ");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new InterruptRunnableDemo();
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
