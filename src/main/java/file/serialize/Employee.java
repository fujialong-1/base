package file.serialize;

import java.io.Serializable;

/**
 * @Author: Jialong Fu
 * @Date: 2022/5/10 21:08
 */
public class Employee implements Serializable {

    private String name;
    private double salary;
    private int year;
    private int month;
    private int day;

    public Employee(String name, double salary, int year, int month, int day) {
        this.name = name;
        this.salary = salary;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}
