package LeetCode.一.栈与队列;

import java.util.Stack;

/**
 * @Author:hdx
 * @Date:2021/12/7 13:58
 * @Description: 剑指 Offer 09. 用两个栈实现队列
 *  剑指 Offer 09. 用两个栈实现队列
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * 示例 1：
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 *
 * 示例 2：
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 */
public class CQueue {

    /**
     * 方法一
     * 执行用时：235 ms , 在所有 Java 提交中击败了 7.91%的用户
     * 内存消耗：46.1 MB, 在所有 Java 提交中击败了 95.66%的用户
     */
//    private Stack<Integer> stack1;
//    private Stack<Integer> stack2;
//
//    public CQueue() {
//        this.stack1 = new Stack();
//        this.stack2 = new Stack();
//    }
//
//    public void appendTail(int value) {
//        if (stack2 != null && stack2.size() > 0) {
//            while (stack2.size() > 0) {
//                stack1.push(stack2.pop());
//            }
//        }
//        stack1.push(value);
//        while (stack1.size() > 0) {
//            stack2.push(stack1.pop());
//        }
//    }
//
//    public int deleteHead() {
//        if (stack2 != null && stack2.size() > 0) {
//            return stack2.pop();
//        }
//        return -1;
//    }

    //方法二

    /**
     * 方法二：
     * 执行用时：43 ms, 在所有 Java 提交中击败了 66.69%的用户
     * 内存消耗：46.6 MB, 在所有 Java 提交中击败了62.95%的用户
      */
//    private Stack<Integer> appendStack;
//    private Stack<Integer> deleteStack;
//
//    public CQueue() {
//        appendStack = new Stack<>();
//        deleteStack = new Stack<>();
//    }
//
//    public void appendTail(int value) {
//        appendStack.push(value);
//    }
//
//    public int deleteHead() {
//        if (deleteStack != null && deleteStack.size() > 0) {
//            return deleteStack.pop();
//        }else if (appendStack != null && appendStack.size() > 0) {
//            while (appendStack.size() > 0) {
//                deleteStack.push(appendStack.pop());
//            }
//            return this.deleteHead();
//        }
//        return -1;
//    }

    /**
     * 方法二升级版
     * 执行用时：61 ms, 在所有 Java 提交中击败了 16.41% 的用户
     * 内存消耗：46.4 MB, 在所有 Java 提交中击败了80.32%的用户
     */
//    private Stack<Integer> appendStack;
//    private Stack<Integer> deleteStack;
//
//    public CQueue() {
//        appendStack = new Stack<>();
//        deleteStack = new Stack<>();
//    }
//
//    public void appendTail(int value) {
//        appendStack.push(value);
//    }
//
//    public int deleteHead() {
//        if (!deleteStack.isEmpty()) {
//            return deleteStack.pop();
//        }else {
//            while (!appendStack.isEmpty()) {
//                deleteStack.push(appendStack.pop());
//            }
//            return deleteStack.isEmpty() ? -1 : deleteStack.pop();
//        }
//    }


    /**
     * 方法三:
     * 执行用时：44 ms, 在所有 Java 提交中击败了51.36%的用户
     * 内存消耗：45.6 MB , 在所有 Java 提交中击败了99.89%的用户
     */
    private Stack<Integer> stack1 = new Stack();
    private Stack<Integer> stack2 = new Stack();
    private Integer size = 0;

    public CQueue() {
        stack1 = new Stack();
        stack2 = new Stack();
    }

    public void appendTail(int value) {
        stack1.push(value);
        size++;
    }

    public int deleteHead() {
        if (size == 0) {
            return -1;
        }
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        size--;
        return stack2.pop();
    }




    public static void main(String[] args) {
        CQueue obj = new CQueue();
        System.out.println("1:"+obj.deleteHead());
        obj.appendTail(2);
        obj.appendTail(5);


        System.out.println("2:"+obj.deleteHead());
        System.out.println("3:"+obj.deleteHead());
        obj.appendTail(4);
        obj.appendTail(7);

        System.out.println("4:"+obj.deleteHead());
        System.out.println("5:"+obj.deleteHead());
        System.out.println("6:"+obj.deleteHead());
    }
}




/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
