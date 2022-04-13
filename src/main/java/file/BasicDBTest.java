package file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * BasicDB测试
 * @Author: Jialong Fu
 * @Date: 2022/4/12 16:53
 */
public class BasicDBTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Student s1 = new Student("Zhangsan", 18, 98.0);
        Student s2 = new Student("Lisi", 19, 99.0);
        Student s3 = new Student("Wangwu", 20, 100.0);

        List<Student> studentList = new ArrayList<>();

        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);

        writeStudents(studentList);
        List<Student> students = readStudents();
        for (Student student : students) {
            System.out.println(student);
        }

        // saveStudents(students);

    }

    public static void writeStudents(List<Student> students) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream("students.dat")));
        try {
            out.writeObject(students);
        } finally {
            out.close();
        }
    }

    public static List<Student> readStudents() throws IOException,
            ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(
                new FileInputStream("students.dat")));
        try {
            return (List<Student>) in.readObject();
        } finally {
            in.close();
        }
    }

}


