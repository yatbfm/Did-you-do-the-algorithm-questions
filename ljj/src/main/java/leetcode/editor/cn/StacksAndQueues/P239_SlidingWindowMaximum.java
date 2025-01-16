package leetcode.editor.cn.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * 滑动窗口最大值
 *
 * @author solisamicus
 * @date 2024-12-16 10:37:25
 */
public class P239_SlidingWindowMaximum {

    public static void main(String[] args) {
        Solution solution = new P239_SlidingWindowMaximum().new Solution();

        System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));

        System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[]{1}, 1)));
    }

    /**
     * deque.isEmpty()    // 判断队列是否为空
     * <p>
     * deque.peek()       // 获取队首元素
     * deque.peekFirst()  // 同peek()，获取队首元素
     * deque.peekLast()   // 获取队尾元素
     * <p>
     * deque.poll()       // 移除并返回队首元素
     * deque.pollFirst()  // 同poll()，移除并返回队首元素
     * deque.pollLast()   // 移除并返回队尾元素
     * <p>
     * deque.offer(e)     // 在队尾插入元素
     * deque.offerFirst(e)// 在队首插入元素
     * deque.offerLast(e) // 在队尾插入元素
     * deque.add(e)       // 在队尾插入元素，等同于offer(e)
     * deque.addFirst(e)  // 在队首插入元素，等同于offerLast(e)
     * deque.addLast(e)   // 在队尾插入元素，等同于offerLast(e)
     */
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;                            // 数组长度
            int[] result = new int[n - k + 1];              // 滑动串口最大值数组
            int index = 0;                                  // 滑动串口最大值数组索引
            ArrayDeque<Integer> deque = new ArrayDeque<>(); // 队列
            for (int i = 0; i < n; i++) {
                while (!deque.isEmpty() && deque.peekFirst() < i - k + 1)     // 检查队列头节点范围
                    deque.pollFirst();
                while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) // 检查单调性
                    deque.pollLast();
                deque.addLast(i);
                if (i >= k - 1)
                    result[index++] = nums[deque.peekFirst()];
            }
            return result;
        }
    }

}