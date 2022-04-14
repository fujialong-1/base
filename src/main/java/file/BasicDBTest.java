package file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * BasicDB测试
 * @Author: Jialong Fu
 * @Date: 2022/4/12 16:53
 */
public class BasicDBTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        readStudents("Zhangsan");

        /*Student s1 = new Student("Zhangsan", 18, 98.0);
        Student s2 = new Student("Lisi", 19, 99.0);
        Student s3 = new Student("Wangwu", 20, 100.0);

        List<Student> studentList = new ArrayList<>();

        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);*/



        /*writeStudents(studentList);
        List<Student> students = readStudents();
        for (Student student : students) {
            System.out.println(student);
        }*/

        // saveStudents(students);

    }

    private static byte[] toBytes(Student student) throws IOException {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        DataOutputStream dout = new DataOutputStream(bout);
        dout.writeUTF(student.getName());
        dout.writeInt(student.getAge());
        dout.writeDouble(student.getScore());
        return bout.toByteArray();
    }

    public static void saveStudents(Map<String, Student> students)
            throws IOException {
        BasicDB db = new BasicDB("./", "students");
        for (Map.Entry<String, Student> kv : students.entrySet()) {
            db.put(kv.getKey(), toBytes(kv.getValue()));
        }
        db.close();
    }

    public static void readStudents(String key) throws IOException {
        BasicDB db = new BasicDB("./", "students");
        byte[] bytes = db.get(key);
        String s = new String(bytes);
        System.out.println(s);
    }

    /*public static void writeStudents(List<Student> students) throws IOException {
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
    }*/

}
