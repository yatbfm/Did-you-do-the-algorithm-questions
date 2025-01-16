package leetcode.editor.cn.Strings;

/**
 * 反转字符串中的单词
 *
 * @author solisamicus
 * @date 2024-12-12 12:21:55
 */
public class P151_ReverseWordsInAString {

    public static void main(String[] args) {
        Solution solution = new P151_ReverseWordsInAString().new Solution();

        System.out.println(solution.reverseWords("the sky is blue"));

        System.out.println(solution.reverseWords("  hello world  "));

        System.out.println(solution.reverseWords("a good   example"));
    }

    class Solution {
        public String reverseWords(String s) {
            char[] chars = s.toCharArray();
            chars = removeSpace(chars);
            reverse(chars, 0, chars.length - 1);
            int start = 0;
            for (int end = 0; end <= chars.length; end++) {
                if (end == chars.length || chars[end] == ' ') {
                    reverse(chars, start, end - 1);
                    start = end + 1;
                }
            }
            return new String(chars);
        }

        private void reverse(char[] chars, int left, int right) {
            while (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }

        private char[] removeSpace(char[] chars) {
            int slow = 0;
            int fast = 0;
            for (; fast < chars.length; fast++) {
                if (chars[fast] != ' ') {
                    if (slow != 0) {
                        chars[slow] = ' ';
                        slow++;
                    }
                    while (fast < chars.length && chars[fast] != ' ') {
                        chars[slow] = chars[fast];
                        fast++;
                        slow++;
                    }
                }
            }
            char[] newChars = new char[slow];
            System.arraycopy(chars, 0, newChars, 0, slow);
            return newChars;
        }
    }
}