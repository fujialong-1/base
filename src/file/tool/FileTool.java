package file.tool;

import file.stream.StreamTest;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @Author: Jialong Fu
 * @Date: 2022/4/11 19:45
 */
public class FileTool {

    /**
     * 通过关键词来查找文件或目录，以字符串的形式返回文件或目录的绝对路径
     * @param file 要查找的文件夹名称
     * @param keyword 要查找的关键词
     * @param result 结果保存
     */
    public static void findFileOrDirByName(File file, String keyword, List<String> result) {
        File[] files = file.listFiles();
        if (files == null) {
            return;
        }
        for (File fileItem : files) {
            String fileName = fileItem.getName();
            if (Pattern.matches(".*" + keyword + ".*", fileName)) {
                result.add(fileItem.getAbsolutePath());
            }
            if (fileItem.isDirectory()) {
                findFileOrDirByName(new File(fileItem.getAbsolutePath()), keyword, result);
            }
        }
    }

    public static void main(String[] args) {
        List<String> result = new ArrayList<>();
        File file = new File("E:/大论文");
        FileTool.findFileOrDirByName(file, "报告", result);
        for (String s : result) {
            System.out.println(s);
        }
    }

}
