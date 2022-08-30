package LeetCode.二.链表;

/**
 * @Author:hdx
 * @Date:2021/12/21 12:45
 * @Description:
 *  剑指 Offer 35. 复杂链表的复制
 *  请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 */
public class copyRandomList {

    public Node copyRandomList(Node head) {
        Node newHead = head;
        Node secondNode = null;
        while (head != null) {
            Node node = new Node(head.val,head.next,head.random);
            secondNode.next = node;
            secondNode = node;

            head = head.next;
        }

        return newHead;
    }
}
