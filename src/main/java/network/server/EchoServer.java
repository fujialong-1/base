package network.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @Author: Jialong Fu
 * @Date: 2022/5/14 11:32
 */
public class EchoServer {
    public static void main(String[] args) throws IOException {

        try (ServerSocket serverSocket = new ServerSocket(8189)) {

            try (Socket accept = serverSocket.accept()) {
                InputStream inputStream = accept.getInputStream();
                OutputStream outputStream = accept.getOutputStream();
                try (Scanner in = new Scanner(inputStream, String.valueOf(StandardCharsets.UTF_8))) {
                    PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(outputStream,
                            String.valueOf(StandardCharsets.UTF_8)), true);
                    printWriter.println("hello! Enter BYE to exit.");

                    boolean done = false;
                    while (!done && in.hasNextLine()) {
                        String line = in.nextLine();
                        printWriter.println("Echo:" + line);
                        if (line.trim().equals("BYE")) done = true;
                    }
                }
            }
        }
    }
}
