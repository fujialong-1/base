package file;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * 测试用java处理一些常用类型文件
 * @Author: Jialong Fu
 * @Date: 2022/4/13 21:26
 */
public class AnotherFileTest {

    public static void main(String[] args) throws IOException {

        // protertiesFileTest();
        // CSVFileTest();
        ExcelFileTest();

    }

    /**
     * 处理属性文件
     * java.util.Properties
     * @throws IOException
     */
    public static void protertiesFileTest() throws IOException {
        Properties prop = new Properties();
        prop.load(new FileInputStream("config.properties"));
        String host = prop.getProperty("db.host");
        System.out.println(host);
        int port = Integer.valueOf(prop.getProperty("db.port", "3306"));
        System.out.println(port);
    }

    /**
     * 处理CSV文件
     * @throws IOException
     */
    public static void CSVFileTest() throws IOException {
        CSVFormat format = CSVFormat.newFormat(';');
        Reader reader = new FileReader("万县.csv");
        try{
            for(CSVRecord record : format.parse(reader)){
                int fieldNum = record.size();
                for(int i=0; i<fieldNum; i++){
                    System.out.print(record.get(i)+" ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            reader.close();
        }
    }

    public static void ExcelFileTest() throws IOException {

        Student s1 = new Student("Zhangsan", 18, 98.0);
        Student s2 = new Student("Lisi", 19, 99.0);
        Student s3 = new Student("Wangwu", 20, 100.0);

        List<Student> studentList = new ArrayList<>();

        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);

        Workbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet();
        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);
            Row row = sheet.createRow(i);
            row.createCell(0).setCellValue(student.getName());
            row.createCell(1).setCellValue(student.getAge());
            row.createCell(2).setCellValue(student.getScore());
        }
        OutputStream out = new FileOutputStream("student.xls");
        wb.write(out);
        out.close();
        wb.close();
    }

}
