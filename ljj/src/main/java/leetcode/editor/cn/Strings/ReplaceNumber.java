package leetcode.editor.cn.Strings;

import java.util.Scanner;

public class ReplaceNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                result.append("number");
            } else {
                result.append(c);
            }
        }
        System.out.println(result.toString());
        scanner.close();
    }
}
