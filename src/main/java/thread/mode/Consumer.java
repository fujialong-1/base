package thread.mode;

/**
 * @Author: Jialong Fu
 * @Date: 2022/4/28 21:57
 */
public class Consumer extends Thread {
    MyBlockingQueue<String> queue;

    public Consumer(MyBlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String task = queue.take();
                System.out.println("handle task " + task);
                Thread.sleep((int)(Math.random()*100));
            }
        } catch (InterruptedException e) {
        }
    }
}
