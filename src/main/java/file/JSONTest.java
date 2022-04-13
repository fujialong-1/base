package file;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


/**
 * @Author: Jialong Fu
 * @Date: 2022/4/13 21:08
 */
public class JSONTest {

    public static void main(String[] args) throws JsonProcessingException {

        Student s1 = new Student("张三", 18, 99.0d);
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        // 序列化
        String str = mapper.writeValueAsString(s1);
        System.out.println(str);

        // 反序列化
        Student s2 = mapper.readValue(str, Student.class);
        System.out.println(s2);
        /*{
            "name" : "张三",
                "age" : 18,
                "score" : 99.0
        }*/

    }

}
