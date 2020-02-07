/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 *
 * https://leetcode-cn.com/problems/4sum/description/
 *
 * algorithms
 * Medium (35.61%)
 * Likes:    375
 * Dislikes: 0
 * Total Accepted:    54K
 * Total Submissions: 145.9K
 * Testcase Example:  '[1,0,-1,0,-2,2]\n0'
 *
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c
 * + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * 
 * 注意：
 * 
 * 答案中不可以包含重复的四元组。
 * 
 * 示例：
 * 
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * 
 * 满足要求的四元组集合为：
 * [
 * ⁠ [-1,  0, 0, 1],
 * ⁠ [-2, -1, 1, 2],
 * ⁠ [-2,  0, 0, 2]
 * ]
 * 
 * 
 */
import java.util.*;


// @lc code=start
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(nums);

        for(int j = 0; j < nums.length; j++) {
            int t = target - nums[j];
            if(j == 0 || (j > 0 && nums[j] != nums[j - 1])) {
                for(int i = j + 1; i < nums.length - 2; i++) {
                    if(i == j + 1 || (i > j + 1 && nums[i] != nums[i-1])) {
                        int n1 = nums[i];
                        int b = i + 1;
                        int e = nums.length - 1;
                        while(b < e) {
                            int n2 = nums[b];
                            int n3 = nums[e];
                            if(n1 + n2 + n3 == t) {
                                list.add(new ArrayList<>(Arrays.asList(nums[j], n1, n2, n3)));
                                while (b < e && nums[b] == nums[b+1]) b++;
                                while (b < e && nums[e] == nums[e-1]) e--;
                                b++;
                                e--;
                            } else if (n2 + n3 < t - n1) {
                                b++;
                            } else {
                                e--;
                            }
                        }
                    }
                }
            }
        }

        
        return list;
    }
}
// @lc code=end

