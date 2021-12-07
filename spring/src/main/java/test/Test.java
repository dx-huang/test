package test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author:hdx
 * @Date:2021/12/7 9:53
 * @Description:
 */
public class Test {

    private static Deque<Integer> queue = new LinkedList<>();


    public static void main(String[] args) {
       queue.add(3);
        System.out.println(queue.peekFirst());

    }
}
