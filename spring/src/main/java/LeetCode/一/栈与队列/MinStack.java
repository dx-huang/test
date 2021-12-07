package LeetCode.一.栈与队列;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author:hdx
 * @Date:2021/12/7 17:13
 * @Description:  剑指 Offer 30. 包含min函数的栈
 *定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * 示例:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinStack {

    /**
     * 方法一：
     * 执行用时：24 ms, 在所有 Java 提交中击败了7.37%的用户
     * 内存消耗：40.1 MB, 在所有 Java 提交中击败了80.74%的用户
     */
//    private Stack<Integer> stack;
//    private Integer minNum;
//    private Deque<Integer> minQueue = new LinkedList();
//
//
//    /** initialize your data structure here. */
//    public MinStack() {
//        stack = new Stack<>();
//    }
//
//    public void push(int x) {
//        if (stack.isEmpty() || x < minNum) {
//            minNum = x;
//            minQueue.addFirst(minNum);
//        }
//        stack.add(x);
//    }
//
//    public void pop() {
//        Integer result = stack.pop();
//        if (result.equals(minNum) && !stack.contains(minNum)) {
//            minQueue.pop();
//            minNum = minQueue.peekFirst();
//        }
//    }
//
//    public int top() {
//        return stack.peek();
//    }
//
//    public int min() {
//        return minNum;
//    }


    /**
     * 方法二：
     * 执行用时：24 ms, 在所有 Java 提交中击败了7.37%的用户
     * 内存消耗：40 MB, 在所有 Java 提交中击败了85.74%的用户
     */
    private Stack<Integer> stack;
    private Stack<Integer> minStack;


    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        if (minStack.empty() || minStack.peek() >= x) {
            minStack.add(x);
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.pop().equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }


    public static void main(String[] args) {
        MinStack obj = new MinStack();

        obj.push(512);
        obj.push(-1024);
        obj.push(-1024);
        obj.push(512);
        obj.pop();
        System.out.println(obj.min());
        obj.pop();
        System.out.println(obj.min());
        obj.pop();
        System.out.println(obj.min());
    }

}




/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
