package test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author:hdx
 * @Date:2021/11/17 9:54
 * @Description:
 */
public class test {
    public static void main(String[] args) {
        User user1 = new User(1001,"小张");
        User user2 = new User(1002,"小黄");
        User user3 = new User(1001,"小李");
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);

//        List<Integer> result = users.stream().map(User::getId).collect(Collectors.toList());
//
//        System.out.println(result);



    }




}
