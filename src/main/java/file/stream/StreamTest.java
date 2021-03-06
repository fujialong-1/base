package file.stream;

import java.io.*;
import java.nio.charset.Charset;

/**
 * 测试流的一些基本用法
 * 参考知乎资料：https://blog.csdn.net/u014263388/article/details/52098719
 * @Author: Jialong Fu
 * @Date: 2022/4/10 16:20
 */
public class StreamTest {

    public static void main(String[] args) throws IOException {

        StreamTest st = new StreamTest();

    }

    /**
     * 将字符写入磁盘文件
     * @throws IOException
     */
    public static void writeTest() throws IOException {

        OutputStream outputStream = new FileOutputStream("hello.txt");
        try {
            String data = "hello";
            byte[] bytes = data.getBytes(Charset.forName("UTF-8"));
            outputStream.write(bytes);
        } finally {
            outputStream.close();
        }

    }

    /**
     * 将磁盘文件读到内存
     * @throws IOException
     */
    public static void readTest() throws IOException {

        InputStream inputStream = new FileInputStream("hello.txt");
        try {
            byte[] buf = new byte[1024];
            int bytesRead = inputStream.read(buf);
            String data = new String(buf, 0, bytesRead, "UTF-8");
            System.out.println(data);
        } finally {
            inputStream.close();
        }
    }

    /**
     * 文件复制
     * try-with-resources
     * @throws IOException
     */
    public static void copyFile(File source, File desc) throws IOException {
        try (InputStream in = new FileInputStream(source);
             OutputStream out = new FileOutputStream(desc)) {
            byte[] buf = new byte[1024];
            int bytesRead;
            // 流似乎是连续的
            while ((bytesRead = in.read(buf)) > 0) {
                out.write(buf, 0, bytesRead);
            }
        }
    }
}
