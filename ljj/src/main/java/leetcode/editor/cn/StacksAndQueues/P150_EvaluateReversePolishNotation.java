package leetcode.editor.cn.StacksAndQueues;

import java.util.Stack;

/**
 * 逆波兰表达式求值
 *
 * @author solisamicus
 * @date 2024-12-16 10:37:16
 */
public class P150_EvaluateReversePolishNotation {

    public static void main(String[] args) {
        Solution solution = new P150_EvaluateReversePolishNotation().new Solution();
        System.out.println(solution.evalRPN(new String[]{"2", "1", "+", "3", "*"})); // 9
        System.out.println(solution.evalRPN(new String[]{"4", "13", "5", "/", "+"})); // 6
        System.out.println(solution.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"})); // 22
    }

    class Solution {
        public int evalRPN(String[] tokens) {
            Stack<Integer> stack = new Stack<>();
            for (String token : tokens) {
                switch (token) {
                    case "+":
                        stack.push(stack.pop() + stack.pop());
                        break;
                    case "-":
                        stack.push(-stack.pop() + stack.pop());
                        break;
                    case "*":
                        stack.push(stack.pop() * stack.pop());
                        break;
                    case "/":
                        int num1 = stack.pop();
                        int num2 = stack.pop();
                        stack.push(num2 / num1);
                        break;
                    default:
                        stack.push(Integer.parseInt(token));
                }
            }
            return stack.pop();
        }
    }

}