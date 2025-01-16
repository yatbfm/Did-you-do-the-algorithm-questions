package leetcode.editor.cn.HashTables;

/**
 * 有效的字母异位词
 *
 * @author solisamicus
 * @date 2024-12-11 09:29:44
 */
public class P242_ValidAnagram {

    public static void main(String[] args) {
        Solution solution = new P242_ValidAnagram().new Solution();
        System.out.println(solution.isAnagram("anagram", "nagaram"));
        System.out.println(solution.isAnagram("rat", "car"));
    }

    class Solution {
        public boolean isAnagram(String s, String t) {
            int[] record = new int[26];
            for (char c : s.toCharArray())
                record[c - 'a']++;
            for (char c : t.toCharArray())
                record[c - 'a']--;
            for (int i = 0; i < 26; i++)
                if (record[i] != 0)
                    return false;
            return true;
        }
    }

}