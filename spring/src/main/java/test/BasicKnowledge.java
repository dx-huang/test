package test;

import java.util.List;

/**
 * @Author:hdx
 * @Date:2022/3/10 11:28
 * @Description: java数据类型基础
 */
public class BasicKnowledge {


    public static void main(String[] args) {
        //1.整数类型 默认为int类型
        // Byte byte类型 一个字节 8bit -2的7次方~2的7次方-1
        Byte b1 = -128;
        Byte b2 = 127;
        byte b3 = -128;
        byte b4 = 127;
        // Short short类型 两个字节 16bit -2的15次方~2的15次方-1
        Short s1 = -32768;
        Short s2 = 32767;
        short s3 = -32768;
        short s4 = 32767;
        // Integer int类型 四个字节 32bit -2的31次方~2的31次方-1
        Integer i1 = -2147483648;
        Integer i2 = 2147483647;
        int i3 = -2147483648;
        int i4 = 2147483647;
        //Long long类型 八个字节 64bit -2的63次方~2的63次方-1
        //Long类型在赋值，由于整数类型默认为int类型，所以一定要加L或l来声明是Long类型
        //long类型在int的范围内不用加L或l，int会自动转为long类型，编译可以通过
        //而超过int的范围不加L 系统会自动识别为int常量 而这个数字又超过了int类型的范围 所以会编译不通过
//        Long l1 = 9527; //编译报错
        Long l2 = 9527L;//编译不报错
        long l3 = 9527; //编译不报错
//        long l4 = 2147483648; //超过int类型范围，编译报错
//        long l5 = 2147483648L; //声明为long类型 编译不报错
        /** 为什么Long类型需要加后面加L或l?
            因为java语言在默认的情况下是用int类型。
         **/
        //2.浮点类型 默认为double类型
        //Float float类型 四个字节 32bit 单精度 -2的31次方~2的31次方-1
        float f0 = 7; //int类型转化成float类型
        float f1 = 7F;
//        float f2 = 7.;//编译报错，浮点默认double类型
        float f3 = 7.F;
//        float f4 = 8.0; //编译报错
        float f5 = 8.0F;
//        float f6 = 12.9867;//编译报错
        float f7 = 12.9867F;

        //Double double类型 八个字节 64bit 双精度 -2的63次方~2的63次方-1
        // 7是一个int字面量，而7D 7.和8.0是double字面量
        double d0 = 7;
        double d1 = 7D; //加D或d一般用于整数，表示double类型
        double d2 = 7.;
        double d3 = 8.0;
        double d4 = 8.D;
        double d5 = 12.9867;



        //3.字符类型
        //Character char 两个字节 16bit 只能用单个字符，用单引号括起来
        Character c1 = 'a';
        Character c2 = '字';
        char c3 = 'b';
        char c4 = '符';
//       char c5 = 'ab'; //编译报错
//       char c6 = '字符'; //编译报错

        //ASCII值 1对应49 A对应65 a对应97
        char c7 = 97; // int类型自动转化成char类型
        System.out.println(c7); //输出：a
        char c8 = 'a' + 1; // 输出:b 97+1=98 对应ASCII值为b
        char c9 = 'A' + '1'; //输出：r  65+49=114 对应ASCII值为r

        //4.布尔类型
        //Boolean boolean 1bit 只能取值true、false
        Boolean bl1 = true;
        boolean bl2 = false;









    }

}
