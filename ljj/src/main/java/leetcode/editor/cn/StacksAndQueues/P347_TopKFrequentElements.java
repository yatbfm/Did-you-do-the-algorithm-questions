package leetcode.editor.cn.StacksAndQueues;

import java.util.*;

/**
 * 前 K 个高频元素
 *
 * @author solisamicus
 * @date 2024-12-16 10:37:32
 */
public class P347_TopKFrequentElements {

    public static void main(String[] args) {
        Solution solution = new P347_TopKFrequentElements().new Solution();

        Solution2 solution2 = new P347_TopKFrequentElements().new Solution2();

        Solution3 solution3 = new P347_TopKFrequentElements().new Solution3();

        System.out.println(Arrays.toString(solution.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));

        System.out.println(Arrays.toString(solution.topKFrequent(new int[]{1}, 1)));

        System.out.println(Arrays.toString(solution2.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));

        System.out.println(Arrays.toString(solution2.topKFrequent(new int[]{1}, 1)));

        System.out.println(Arrays.toString(solution3.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));

        System.out.println(Arrays.toString(solution3.topKFrequent(new int[]{1}, 1)));
    }

    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> frequencyMap = new HashMap<>();
            for (int num : nums) {
                frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1); // {E: count(E)}
            }
            PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((pair1, pair2) -> pair1.getValue() - pair2.getValue());
            for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
                if (minHeap.size() == k) {
                    if (entry.getValue() > minHeap.peek().getValue()) {
                        minHeap.poll();
                        minHeap.offer(entry);
                    }
                } else minHeap.offer(entry);
            }
            int[] topK = new int[k];
            for (int i = 0; i < k; i++) {
                topK[i] = minHeap.poll().getKey();
            }
            return topK;
        }
    }

    class Solution2 {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1); // {e: count(e)}
            }
            PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((pair1, pair2) -> pair2.getValue() - pair1.getValue());
            for (Map.Entry<Integer, Integer> entry : map.entrySet())
                maxHeap.offer(entry);
            int[] topK = new int[k];
            for (int i = 0; i < k; i++) {
                topK[i] = maxHeap.poll().getKey();
            }
            return topK;
        }
    }

    class Solution3 {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> frequencyMap = new HashMap<>();
            for (int num : nums) {
                frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1); // {E: count(E)}
            }
            List<Map.Entry<Integer, Integer>> list = new ArrayList<>(frequencyMap.entrySet());
            Collections.sort(list, (o1, o2) -> o2.getValue() - o1.getValue());
            int[] topK = new int[k];
            for (int i = 0; i < k; i++) {
                topK[i] = list.get(i).getKey();
            }
            return topK;
        }
    }

}