package jdbc;

/**
 * @Author: Jialong Fu
 * @Date: 2022/5/25 16:18
 */
public class Student {

    private long id;
    private String name;
    private int gender;
    private int grade;
    private int score;



    public Student(long id, String name, int gender, int grade, int score) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.grade = grade;
        this.score = score;
    }

}
