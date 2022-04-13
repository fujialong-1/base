package file;

import java.io.Serializable;

/**
 * @Author: Jialong Fu
 * @Date: 2022/4/13 21:09
 */
public class Student implements Serializable {

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

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}

