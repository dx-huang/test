package test;

import java.util.*;

/**
 * @Author:hdx
 * @Date:2022/4/7 10:29
 * @Description:
 */
public class Test1 {

    private static List<Integer> signInList = new ArrayList<>();

    public static void main(String[] args) {
        signIn(1);
        signIn(2);
        signIn(4);
        signIn(5);
        System.out.println(signInDays());
        System.out.println(signInSituation());
        signIn(3); //补签
        System.out.println(signInSituation());
    }

    /**
     * 签到/补签
     */
    public static void signIn(Integer data) {
        signInList.add(data);
        Collections.sort(signInList);
    }

    /**
     * 查看当月签到的累计天数
     */
    public static int signInDays() {
        return signInList.size();
    }

    /**
     * 查看签到的整体情况
     */
    public static String signInSituation() {
        StringBuilder builder = new StringBuilder();
        for (Integer data : signInList) {
            builder.append(data + ",");
        }
        return builder.substring(0, builder.length() - 1);
    }







}
