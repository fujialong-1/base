package stream;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @Author: Jialong Fu
 * @Date: 2022/5/25 17:01
 */
public class CreatingStreams {

    public static <T> void show(String title, Stream<T> stream) {
        final int SIZE = 10;
        List<T> firstElements = stream
                .limit(SIZE + 1)
                .collect(Collectors.toList());
        System.out.println(title + ": ");
        for (int i = 0; i < firstElements.size(); i++) {
            if (i > 0) System.out.println(", ");
            if (i < SIZE) System.out.println(firstElements.get(i));
            else System.out.println("...");
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/main/java/stream/alice30.txt");
        // 将文件中的内容读到一个字符串中
        String contents = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
        Stream<String> words = Stream.of(contents.split("\\PL+"));
        show("words", words);
        Stream<String> song = Stream.of("gently", "down", "the", "stream");
        show("song", song);

        Iterable<Path> iterable = FileSystems.getDefault().getRootDirectories();
        Stream<Path> rootDirectories = StreamSupport.stream(iterable.spliterator(), false);
        show("rootDirectories", rootDirectories);
    }
}
