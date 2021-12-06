package spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;

import javax.print.DocFlavor;
import java.math.BigDecimal;
import java.util.*;

/**
 * @Author:hdx
 * @Date:2021/10/11 15:45
 */
public class test {
    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//        Object a = context.getBean("a");
//        System.out.println(a);



    }


    public static String handleSensitiveInfo(String message) {
        if (message == null || message.length() == 0) return "";
        char[] chars = message.toCharArray();
        for (int i = 3; i < message.length() - 3; i++) {
            chars[i] = '*';
        }
        return new String(chars);
    }

}
