package stream;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Jialong Fu
 * @Date: 2022/5/25 16:30
 */
public class CountLongWords {

    public static void main(String[] args) throws IOException {


        String contents = new String(Files.readAllBytes(Paths.get("src/main/java/stream/alice30.txt")), StandardCharsets.UTF_8);
        String[] splitWords = contents.split("\\PL+");
        List<String> words = Arrays.asList(splitWords);

        // 计数
        long count = 0;
        for (String word: words) {
            if (word.length() > 12) count++;
        }
        System.out.println("文件中单词长度大于12的个数为：" + count);

        count = words.stream().filter(w -> w.length() > 12).count();
        System.out.println("文件中单词长度大于12的个数为：" + count);

        count = words.parallelStream().filter(w -> w.length() > 12).count();
        System.out.println("文件中单词长度大于12的个数为：" + count);
    }
}
