package leetcode.editor.cn.Arrays;

;

/**
 * 螺旋矩阵 II
 *
 * @author solisamicus
 * @date 2024-12-09 11:14:51
 */
public class P59_SpiralMatrixIi {

    public static void main(String[] args) {
        Solution solution = new P59_SpiralMatrixIi().new Solution();

        int n = 3;
        int[][] nums = solution.generateMatrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
    }

    class Solution {
        public int[][] generateMatrix(int n) {
            int[][] nums = new int[n][n];
            // loop row: [startY, endY)
            // loop column: [startX, endX)
            int startX = 0, startY = 0;
            int endX = n - 1, endY = n - 1;
            int i, j;
            int count = 1;
            int loop = 1;
            // top: [startX, startY] => [startX, endY - 1]
            // right: [startX, endY - 1] => [endX - 1, endY - 1]
            // bottom: [endX - 1, endY - 1] => [endX - 1, startY)
            // left: [endX - 1, startY) => (startX, startY)
            while (loop <= n / 2) {
                for (j = startY; j < endY; j++)
                    nums[startX][j] = count++;
                for (i = startX; i < endX; i++)
                    nums[i][j] = count++;
                for (; j > startY; j--)
                    nums[i][j] = count++;
                for (; i > startX; i--)
                    nums[i][j] = count++;
                startX++;
                startY++;
                endX--;
                endY--;
                loop++;
            }
            if (n % 2 == 1) nums[startX][startY] = count;
            return nums;
        }
    }

}