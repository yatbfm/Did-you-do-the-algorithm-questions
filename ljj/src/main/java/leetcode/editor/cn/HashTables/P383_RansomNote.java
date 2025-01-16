package leetcode.editor.cn.HashTables;

/**
 * 赎金信
 *
 * @author solisamicus
 * @date 2024-12-11 10:50:34
 */
public class P383_RansomNote {

    public static void main(String[] args) {
        Solution solution = new P383_RansomNote().new Solution();

        System.out.println(solution.canConstruct("a", "b"));

        System.out.println(solution.canConstruct("aa", "ab"));

        System.out.println(solution.canConstruct("aa", "aab"));
    }

    class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            int[] record = new int[26];
            for (char c : ransomNote.toCharArray())
                record[c - 'a']++;
            for (char c : magazine.toCharArray())
                record[c - 'a']--;
            for (int i = 0; i < 26; i++) {
                if (record[i] > 0)
                    return false;
            }
            return true;
        }
    }

}