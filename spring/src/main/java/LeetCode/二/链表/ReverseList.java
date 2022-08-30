package LeetCode.二.链表;


/**
 * @Author:hdx
 * @Date:2021/12/8 17:16
 * @Description:
 *  剑指 Offer 24. 反转链表
 *  定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 *
 */
public class ReverseList {

    //1.迭代法
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    //   输入: 1->2->3->4->5->NULL
    //   输出: 5->4->3->2->1->NULL
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }




    private static void printListNode(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        printListNode(node1);
        System.out.println("========");
        ReverseList list = new ReverseList();
        ListNode resultNode = list.reverseList2(node1);
        printListNode(resultNode);
    }
}
