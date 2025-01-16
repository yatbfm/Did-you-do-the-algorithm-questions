package leetcode.editor.cn.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 用队列实现栈
 *
 * @author solisamicus
 * @date 2024-12-16 10:36:20
 */
public class P225_ImplementStackUsingQueues {

    public static void main(String[] args) {
        MyStack myStack = new P225_ImplementStackUsingQueues().new MyStack();
        myStack.push(1); // stack is: [1]
        myStack.push(2); // stack is: [1, 2]
        System.out.println(myStack.top());      // return 2, stack is [1, 2]
        System.out.println(myStack.pop());      // return 2, stack is [1]
        System.out.println(myStack.empty());    // return false
    }

    class MyStack {

        Deque<Integer> deque;

        public MyStack() {
            deque = new ArrayDeque<>();
        }

        public void push(int x) {
            deque.addLast(x);
        }

        public int pop() {
            int size = deque.size();
            size--;
            for (int i = 0; i < size; i++)
                deque.addLast(deque.pollFirst());
            return deque.pollFirst();
        }

        public int top() {
            return deque.peekLast();
        }

        public boolean empty() {
            return deque.isEmpty();
        }
    }

}