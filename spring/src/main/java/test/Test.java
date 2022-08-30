package test;

import spring.test.A;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.*;

/**
 * @Author:hdx
 * @Date:2022/1/15 10:55
 * @Description:
 */
public class Test {



    //在进行BigDecimal计算时，记得使用String类型的构造器，不推荐使用double类型的构造器（可能还是会出现精度问题）
//    public static void main(String[] args) {
//        List<Integer> data = new ArrayList<>();
//        data.add(1);
//        data.add(3);
//        data.add(4);
//        data.add(5);
//        Integer sort = 3;
//        List<Integer> sortList = new ArrayList<>();
//        checkGroupSort(sort,sortList,data);
//        data.forEach(System.out::println);
//        System.out.println("==========");
//        sortList.forEach(System.out::println);
//        System.out.println(sortList.size() == 0);


//    }

    public static void main(String[] args) {
//        String a = "h5";
//        System.out.println(a.contains("H"));

        HashMap map = new HashMap();
        Object put = map.put("hi", "hahaha");
        Object put1 = map.put("hi", "hello");
        System.out.println(put);
        System.out.println(put1);
        System.out.println(Thread.currentThread().getName());
        test1();

    }

    public static void test1() {
        System.out.println(Thread.currentThread().getName());
    }


//    public static String test() {
//        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));
//        for (Integer i : list) {
//            if (i == 3) {
//                continue;
//            }
//            System.out.println(i);
//        }
//        return "结束";
//    }

//    public static void main(String[] args) {
//        // 1.length  返回字符串的长度 返回类型：int
//        String s1 = "玛卡巴卡";
//        int length = s1.length();
//        System.out.println(length); //输出：4
//
//        // 2.equals 判断两个字符串是否相等 返回类型：boolean  注：equals比较的是数值，==比较的是引用地址
//        String s2 = "唔西迪西";
//        String s3 = "汤姆布利柏";
//        String s4 = "唔西迪西";
//        boolean result1 = s2.equals(s3);
//        boolean result2 = s2.equals(s4);
//        System.out.println(result1); //输出：false
//        System.out.println(result2); //输出：true
//
//        // 3.substring 截取字符串 返回类型：String
//        String s5 = "玛卡巴卡";
//        String result3 = s5.substring(1);   //从某个开始到结尾
//        String result4 = s5.substring(1,3); //左闭右开
//        System.out.println(result3); //输出：卡巴卡
//        System.out.println(result4); //输出：卡巴
//
//        // 4.split 按照某个表达式对字符串进行拆分 返回类型：String数组
//        String s6 = "玛卡巴卡/唔西迪西/汤姆布利柏";
//        String[] result5 = s6.split("/");
//        for (String s : result5) {
//            System.out.print(s + " "); //输出:玛卡巴卡 唔西迪西 汤姆布利柏
//        }
//        System.out.println();
//
//        // 5.replace 替换字符  返回类型：String
//        String s7 = "玛卡巴卡";
//        String result6 = s7.replaceFirst("卡", "西"); //替换字符出现的第一个
//        String result7 = s7.replace("卡", "西");
//        String result8 = s7.replace("玛卡", "西");
//        System.out.println(result6); //输出: 玛西巴卡
//        System.out.println(result7); //输出:玛西巴西
//        System.out.println(result8); //输出:西巴卡
//
//        // 6.concat 拼接字符串 返回类型：String  注:需要频繁拼接字符串时,用StringBuilder、StringBuffer的append()方法
//        String s8 = "唔西";
//        String result9 = s8.concat("迪西");
//        System.out.println(result9); //输出:唔西迪西
//
//        // 7. matches 正则表达式  返回类型：boolean
//        String s9 = "汤姆布利柏";
//        boolean result10 = s9.matches("汤姆.*"); //以汤姆开头
//        boolean result11 = s9.matches("姆汤.*"); //以姆汤开头
//        System.out.println(result10); //输出:true
//        System.out.println(result11); //输出:false
//
//        // 8.trim 去除字符串前后的多余空格 返回类型：String
//        String s10 = " 玛卡巴卡 ";
//        String result12 = s10.trim();
//        System.out.println(s10);       //输出: 玛卡巴卡
//        System.out.println(result12);  //输出:玛卡巴卡
//
//        // 9.hashCode 输出字符串的hash码  返回类型：int
//        String s11 = "玛卡巴卡";
//        int result13 = s11.hashCode();
//        System.out.println(result13); //输出：902944147
//
//        // 10.compareTo 如果字符一样，比较的是unicode编码；如果不一样比较的是字符数 返回类型：int
//        String s12 = "abcd";
//        String s13 = "abca";
//        String s14 = "ab";
//        int result14 = s12.compareTo(s13);
//        int result15= s12.compareTo(s14);
//        System.out.println(result14); //输出:3    d的unicode编码比a的unicode编码大3
//        System.out.println(result15); //输出:2    abcd比ab多两个字符
//
//        // 11.toCharArray 将字符串变成char数组  返回类型：char数组
//        String s15 = "唔西迪西";
//        char[] result16 = s15.toCharArray();
//        for (char c : result16) {
//            System.out.print(c + " "); //输出：唔 西 迪 西
//        }
//        System.out.println();
//
//        // 12.indexOf 找寻单字符/多字符在字符串出现的索引位置 不存在返回-1  返回类型：int
//        // 13.lastIndexOf 找寻单字符/多字符在字符串最后一次出现的索引位置 不存在返回-1  返回类型：int
//        String s16 = "abcdeabcde";
//        int result17 = s16.indexOf(100);
//        int result18 = s16.indexOf('d');
//        int result19 = s16.indexOf("cd");
//        int result20 = s16.indexOf('b', 3);
//        int result21 = s16.indexOf("cd",3);
//        int result22 = s16.lastIndexOf('d'); //方法参数同上
//        System.out.println(result17); //输出：3
//        System.out.println(result18); //输出：3
//        System.out.println(result19); //输出：2
//        System.out.println(result20); //输出：6
//        System.out.println(result21); //输出：7
//        System.out.println(result22); //输出：8
//
//        // 14.isEmpty 判断是否为空字符串  返回类型：boolean
//        String s17 = " ";
//        String s18 = "";
//        boolean result23 = s17.isEmpty();
//        boolean result24 = s18.isEmpty();
//        System.out.println(result23); //输出：false
//        System.out.println(result24); //输出：true
//
//        // 15.charAt 返回索引对应的字符  返回类型：char
//        String s19 = "玛卡巴卡";
//        char result25 = s19.charAt(2);
//        System.out.println(result25); //输出：巴
//
//        // 16.codePointAt 返回索引对应的unicode编码 返回类型：int
//        String s20 = "abcd";
//        int result26 = s20.codePointAt(2);
//        System.out.println(result26);  //输出：99  c对应的编码为99
//
//        // 17.contains 判断字符串是否包含有给定的字符串  返回类型：boolean
//        String s21 = "玛卡巴卡";
//        boolean result27 = s21.contains("巴卡");
//        System.out.println(result27); //输出：true
//
//        //18.toUpperCase 字符串变大写 返回类型：String
//        //19.toLowerCase 字符串变小写 返回类型：String
//        String s22 = "hello";
//        String s23 = "WORLD";
//        String result28 = s22.toUpperCase();
//        String result29 = s23.toLowerCase();
//        System.out.println(result28); //输出：HELLO
//        System.out.println(result29); //输出：world
//
//        // 20.getBytes 得到编码格式的字节数组  返回类型：byte数组
//        try {
//            byte[] result30 = "玛卡".getBytes("GBK");
//            for (byte b : result30) {
//                System.out.print(b + " ");  //输出：-62 -22 -65 -88
//            }
//            String result31 = new String(result30, "GBK");
//            System.out.println(result31);  //输出：玛卡
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//    }




   private static void checkGroupSort(Integer sort,List<Integer> sortList,List<Integer> data) {
        if (Objects.equals(sort,6)) {
            return;
        }
       boolean contains = data.contains(sort);
       if (contains) {
           sortList.add(sort);
           checkGroupSort(++sort,sortList,data);
       }
    }



    /**
     * 加
     */
    public static Double add(Double d1,Double d2) {
        BigDecimal b1 = new BigDecimal(d1.toString());
        BigDecimal b2 = new BigDecimal(d2.toString());
        return b1.add(b2).doubleValue();
    }

    /**
     * 减
     */
    public static Double subtract(Double d1,Double d2) {
        BigDecimal b1 = new BigDecimal(d1.toString());
        BigDecimal b2 = new BigDecimal(d2.toString());
        return b1.subtract(b2).doubleValue();
    }

    /**
     * 乘
     */
    public static Double multiply(Double d1,Double d2) {
        BigDecimal b1 = new BigDecimal(d1.toString());
        BigDecimal b2 = new BigDecimal(d2.toString());
        return b1.multiply(b2).doubleValue();
    }

    /**
     * 除
     */
    public static Double divide(Double d1,Double d2) {
        BigDecimal b1 = new BigDecimal(d1.toString());
        BigDecimal b2 = new BigDecimal(d2.toString());
        return b1.divide(b2).doubleValue();
    }


}
