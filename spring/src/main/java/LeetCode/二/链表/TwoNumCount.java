package LeetCode.二.链表;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author:hdx
 * @Date:2022/4/8 15:58
 * @Description: 两数相加
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
    * 示例 1：
     * 输入：l1 = [2,4,3], l2 = [5,6,4]
     * 输出：[7,0,8]
     * 解释：342 + 465 = 807.
    * 示例 2：
     * 输入：l1 = [0], l2 = [0]
     * 输出：[0]
    * 示例 3：
     * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
     * 输出：[8,9,9,9,0,0,0,1]
     * 提示：
     * 每个链表中的节点数在范围 [1, 100] 内
     * 0 <= Node.val <= 9
     * 题目数据保证列表表示的数字不含前导零
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-two-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoNumCount {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(9);
        ListNode node2 = new ListNode(9);
        ListNode node3 = new ListNode(9);
        ListNode node4 = new ListNode(9);
        ListNode node5 = new ListNode(9);
        ListNode node6 = new ListNode(9);
        ListNode node7 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        ListNode nodea = new ListNode(9);
        ListNode nodeb = new ListNode(9);
        ListNode nodec = new ListNode(9);
        ListNode noded = new ListNode(9);
        nodea.next = nodeb;
        nodeb.next = nodec;
        nodec.next = noded;

        ListNode node = twoNumCount(node1, nodea);
        printListNode(node);

    }

    public static void printListNode(ListNode node) {
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.val + "->");
            node = node.next;
        }
        System.out.println(sb.substring(0,sb.length()-2));
    }

    /**
     * 做法一
     */
    public static ListNode twoNumCount(ListNode l1,ListNode l2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        while (l1 != null) {
            list1.add(l1.val);
            l1 = l1.next;
        }
        while ((l2 != null)) {
            list2.add(l2.val);
            l2 = l2.next;
        }
        Queue<ListNode> queue = new LinkedList();
        Integer index = 0;
        boolean addFlag = false;
        while (index < list1.size()  || index < list2.size() || addFlag == true) {
            ListNode node = new ListNode();
            if (addFlag == true) {
                node.val = 1;
            }
            addFlag = false;
            if (index < list1.size() && index < list2.size()) {
                int addValue = node.val + list1.get(index) + list2.get(index);
                addFlag = setValue(node, addValue);
            }else if (index < list1.size()) {
                int addValue = node.val + list1.get(index);
                addFlag = setValue(node, addValue);
            }else if (index < list2.size()){
                int addValue = node.val + list2.get(index);
                addFlag = setValue(node, addValue);
            }
            queue.add(node);
            index++;
        }
        ListNode result = queue.poll();
        ListNode node = result;
        while (queue.peek() != null) {
             node.next = queue.poll();
             node = node.next;
        }
        return result;
    }

    public static boolean setValue(ListNode node,Integer addValue) {
        boolean addFlag = false;
        if (addValue >= 10) {
            addFlag = true;
            node.val = addValue % 10;
        }else {
            node.val = addValue;
        }
        return addFlag;
    }

    /**
     * 做法二
     */
    public static ListNode twoNumCount1(ListNode l1,ListNode l2) {
        ListNode pre = new ListNode(0);

        return null;
    }



}
