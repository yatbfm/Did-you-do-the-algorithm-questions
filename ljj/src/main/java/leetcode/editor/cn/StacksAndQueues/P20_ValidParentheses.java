package leetcode.editor.cn.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 有效的括号
 *
 * @author solisamicus
 * @date 2024-12-16 10:36:57
 */
public class P20_ValidParentheses {

    public static void main(String[] args) {
        Solution solution = new P20_ValidParentheses().new Solution();
        System.out.println(solution.isValid("()"));     // true
        System.out.println(solution.isValid("()[]{}")); // true
        System.out.println(solution.isValid("(]"));     // false
        System.out.println(solution.isValid("([])"));   // true
    }

    class Solution {
        public boolean isValid(String s) {
            Deque<Character> stack = new ArrayDeque<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(') stack.push(')');
                else if (c == '[') stack.push(']');
                else if (c == '{') stack.push('}');
                else if (stack.isEmpty() || stack.peek() != c) return false;
                else stack.pop();
            }
            return stack.isEmpty();
        }
    }

}