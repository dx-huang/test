package LeetCode.二.链表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @Author:hdx
 * @Date:2021/12/8 14:34
 * @Description:
 *
 * 剑指 Offer 06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 示例 1：
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *
 */
public class ReversePrint {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */

    /**
     * 方法一: 借助栈
     * 执行用时： 1 ms, 在所有 Java 提交中击败了 69.27%的用户
     * 内存消耗：39 MB , 在所有 Java 提交中击败了51.67%的用户
     */
//    public int[] reversePrint(ListNode head) {
//        if (head == null) return new int[]{};
//        Stack<Integer> stack = new Stack<>();
//        stack.add(head.val);
//        while (head.next != null) {
//            stack.add(head.next.val);
//            head = head.next;
//        }
//        System.out.println("stack:" + stack);
//        int[] result = new int[stack.size()];
//        for (int i = 0; i < result.length; i++) {
//            result[i] = stack.pop();
//        }
//        Arrays.stream(result).forEach(System.out::println);
//        return result;
//    }

    /**
     * 方法二:
     * 执行用时：1 ms, 在所有 Java 提交中击败了69.27%的用户
     * 内存消耗：38.9 MB, 在所有 Java 提交中击败了58.66%的用户
     */
    public int[] reversePrint(ListNode head) {
        ListNode node = head;
        Integer len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        int[] result = new int[len];
        node = head;
        while (node != null) {
            result[len - 1] = node.val;
            len--;
            node = node.next;
        }
        return result;
    }




    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        ReversePrint print = new ReversePrint();
        int[] ints = print.reversePrint(null);
        Arrays.stream(ints).forEach(System.out::println);

    }

}
