package thread.mode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 生产者消费者模式
 * @Author: Jialong Fu
 * @Date: 2022/4/28 21:49
 */
public class MyBlockingQueue<E> {
    private Queue<E> queue = null;
    private int limit;

    public MyBlockingQueue(int limit) {
        this.limit = limit;
        queue = new ArrayDeque<>(limit);
    }

    public synchronized void put(E e) throws InterruptedException {
        while (queue.size() == limit) {
            wait();
        }
        queue.add(e);
        notifyAll();
    }

    public synchronized E take() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        E e = queue.poll();
        notifyAll();
        return e;
    }

    public static void main(String[] args) {
        MyBlockingQueue<String> queue = new MyBlockingQueue<>(1);
        new Producer(queue).start();
        new Consumer(queue).start();
    }
}
