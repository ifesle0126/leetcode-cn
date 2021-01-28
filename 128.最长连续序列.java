import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=128 lang=java
 *
 * [128] 最长连续序列
 *
 * https://leetcode-cn.com/problems/longest-consecutive-sequence/description/
 *
 * algorithms
 * Hard (52.65%)
 * Likes:    657
 * Dislikes: 0
 * Total Accepted:    95K
 * Total Submissions: 180.4K
 * Testcase Example:  '[100,4,200,1,3,2]'
 *
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 
 * 
 * 
 * 进阶：你可以设计并实现时间复杂度为 O(n) 的解决方案吗？
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 
 * -10^9 
 * 
 * 
 */
import java.util.*;

// @lc code=start
class Solution {


    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    /**
     * wrong
     * @param nums
     * @return
     */
    // public int longestConsecutive(int[] nums) {

    //     if (nums == null || nums.length < 1) {
    //         return 0;
    //     }

    //     Map<Integer, Integer> map = new HashMap<>();
    //     int maxLen = 1;
    //     for (int num : nums) {
    //         if (map.containsKey(num)) {
    //             continue;
    //         }
    //         map.put(num, 1);
    //         int left = num - 1;
    //         int right = num + 1;
    //         if (map.containsKey(left)) {
    //             maxLen = Math.max(maxLen, merger(map, left, num));
    //         }
    //         if (map.containsKey(right)) {
    //             maxLen = Math.max(maxLen, merger(map, num, right));
    //         }
    //     }
    //     return maxLen;
    // }

    // public int merger(Map<Integer, Integer> map, int less, int more) {
    //     int lenMin = less - map.get(less) + 1;
    //     int lenMax = more + map.get(more) - 1;
    //     int len = lenMax - lenMin + 1;
    //     map.put(less, len);
    //     map.put(more, len);
    //     return len;
    // }
}
// @lc code=end

