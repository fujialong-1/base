package network.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @Author: Jialong Fu
 * @Date: 2022/5/14 11:03
 */
public class SocketTest {

    public static void main(String[] args) throws IOException {
        try (Socket s = new Socket("time-a.nist.gov", 13)) {
            try (Scanner in = new Scanner(s.getInputStream(), String.valueOf(StandardCharsets.UTF_8))) {
                while (in.hasNextLine()) {
                    String line = in.nextLine();
                    System.out.println(line);
                }
            }
        }
    }
}
