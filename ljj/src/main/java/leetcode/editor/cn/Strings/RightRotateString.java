package leetcode.editor.cn.Strings;

import java.util.Scanner;

public class RightRotateString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        scanner.nextLine();
        String s = scanner.nextLine();
        String rotatedString = rightRotate(s, k);
        System.out.println(rotatedString);
        scanner.close();
    }

    public static String rightRotate(String s, int k) {
        int length = s.length();
        k = k % length;
        return s.substring(length - k) + s.substring(0, length - k);
    }
}
