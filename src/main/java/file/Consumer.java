package file;

import java.io.IOException;
import java.util.Random;

/**
 * @Author: Jialong Fu
 * @Date: 2022/4/14 21:22
 */
public class Consumer {

    public static void main(String[] args) throws InterruptedException {
        try {
            BasicQueue queue = new BasicQueue("./", "task");
            Random rnd = new Random();
            while (true) {
                byte[] bytes = queue.dequeue();
                if (bytes == null) {
                    Thread.sleep(rnd.nextInt(1000));
                    continue;
                }
                System.out.println("consume: " + new String(bytes, "UTF-8"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
