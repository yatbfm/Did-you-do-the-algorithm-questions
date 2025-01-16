package leetcode.editor.cn.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 删除字符串中的所有相邻重复项
 *
 * @author solisamicus
 * @date 2024-12-16 10:37:09
 */
public class P1047_RemoveAllAdjacentDuplicatesInString {

    public static void main(String[] args) {
        Solution solution = new P1047_RemoveAllAdjacentDuplicatesInString().new Solution();
        System.out.println(solution.removeDuplicates("abbaca")); // ca
        System.out.println(solution.removeDuplicates("azxxzy")); // ay
    }

    class Solution {
        public String removeDuplicates(String s) {
            Deque<Character> stack = new ArrayDeque<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (!stack.isEmpty() && stack.peek() == c)
                    stack.pop();
                else
                    stack.push(c);
            }
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty())
                sb.insert(0, stack.pop());
            return sb.toString();
        }
    }

}