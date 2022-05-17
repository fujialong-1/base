package file.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

/**
 * @Author: Jialong Fu
 * @Date: 2022/5/17 17:24
 */
public class XmlTest {
    public static void main(String[] args) {
        ObjectMapper xmlMapper = new XmlMapper();
        try {
            // 序列化
            String xml = xmlMapper.writeValueAsString(new Simple());
            System.out.println(xml);
            // 反序列化
            Simple value = xmlMapper.readValue(xml, Simple.class);
            System.out.println(value);
//            xmlMapper.writeValue(new File("stuff.xml"), new Simple());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Simple {
    public int x = 1;
    public int y = 2;

    @Override
    public String toString() {
        return "Simple{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
