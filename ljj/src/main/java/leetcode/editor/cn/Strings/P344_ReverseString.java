package leetcode.editor.cn.Strings;

/**
 * 反转字符串
 *
 * @author solisamicus
 * @date 2024-12-12 11:27:51
 */
public class P344_ReverseString {

    public static void main(String[] args) {
        Solution solution = new P344_ReverseString().new Solution();

        char[] input = new char[]{'h', 'e', 'l', 'l', 'o'};
        solution.reverseString(input);
        System.out.println(input);
    }

    class Solution {
        public void reverseString(char[] s) {
            int left = 0, right = s.length - 1;
            while (left < right) {
                char temp = s[left];
                s[left] = s[right];
                s[right] = temp;
                left++;
                right--;
            }
        }
    }

}