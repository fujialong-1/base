package file.serialize;

import java.io.*;

/**
 * @Author: Jialong Fu
 * @Date: 2022/5/10 21:10
 */
public class Test1 {
    public static void main(String[] args) throws Exception {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("employee.dat"));
        Employee harry = new Employee("Harry Hacker", 50000d, 1989, 10, 1);
        Manager boss = new Manager("Carl Cracker", 80000d, 1987, 12, 15);
        out.writeObject(harry);
        out.writeObject(boss);
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("employee.dat"));
        Employee e1 = (Employee) in.readObject();
        Employee e2 = (Employee) in.readObject();
        System.out.println(e1);
        System.out.println(e2);
        out.close();
        in.close();
    }
}
