package file;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * BasicDB测试
 * @Author: Jialong Fu
 * @Date: 2022/4/12 16:53
 */
public class BasicDBTest {

    public static void main(String[] args) throws IOException {

        Student s1 = new Student("Zhangsan", 18, 98.0);
        Student s2 = new Student("Lisi", 19, 99.0);
        Student s3 = new Student("Wangwu", 20, 100.0);

        Map<String, Student> students = new HashMap<>();
        students.put(s1.getName(), s1);
        students.put(s2.getName(), s2);
        students.put(s3.getName(), s3);

        saveStudents(students);

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
        byte[] bytes = db.get("Zhangsan");

        db.close();
    }

}

class Student {

    String name;

    int age;

    Double score;

    public Student() {
    }

    public Student(String name, int age, Double score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}

