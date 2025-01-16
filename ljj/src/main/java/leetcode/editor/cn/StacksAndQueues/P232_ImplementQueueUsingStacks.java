package leetcode.editor.cn.StacksAndQueues;

import java.util.Stack;

/**
 * 用栈实现队列
 *
 * @author solisamicus
 * @date 2024-12-13 09:06:10
 */
public class P232_ImplementQueueUsingStacks {

    public static void main(String[] args) {
        MyQueue myQueue = new P232_ImplementQueueUsingStacks().new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(myQueue.peek());     // return 1, queue is [1, 2]
        System.out.println(myQueue.pop());      // return 1, queue is [2]
        System.out.println(myQueue.empty());    // return false
    }

    class MyQueue {

        Stack<Integer> stackIn;
        Stack<Integer> stackOut;

        public MyQueue() {
            stackIn = new Stack<>();
            stackOut = new Stack<>();
        }

        public void push(int x) {
            stackIn.push(x);
        }

        public int pop() {
            if (!stackOut.isEmpty()) return stackOut.pop();
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
            return stackOut.pop();
        }

        public int peek() {
            if (!stackOut.isEmpty()) return stackOut.peek();
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
            return stackOut.peek();
        }

        public boolean empty() {
            return stackIn.isEmpty() && stackOut.isEmpty();
        }
    }

}