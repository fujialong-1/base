package regex;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;


/**
 * @Author: Jialong Fu
 * @Date: 2022/5/25 21:08
 */
public class HrefMatch {

    public static void main(String[] args) {

        // 定位一个Web页面上的所有超文本引用，并打印它们。

        try {
            // get URL string from command line or use default
            String urlString;
            if (args.length > 0) urlString = args[0];
            else urlString = "https://www.runoob.com/java/java-regular-expressions.html";

            // read contents of url
            InputStream in = new URL(urlString).openStream();
            StringBuilder sb = new StringBuilder();
            byte[] data = new byte[1024];
            int len = 0;
            while ((len = in.read(data)) != -1) {
                sb.append(new String(data, 0, len, StandardCharsets.UTF_8));
            }
            String input = new String(sb);

            // search for all occurrences of pattern
            String patternString = "<a\\s+href\\s*=\\s*(\"[^\"]*\"|[^\\s>]*)\\s*>";
            Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                System.out.println(input.substring(matcher.start(), matcher.end()));
            }
        } catch (IOException | PatternSyntaxException e) {
            e.printStackTrace();
        }
    }
}
