import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=506 lang=java
 *
 * [506] 相对名次
 *
 * https://leetcode-cn.com/problems/relative-ranks/description/
 *
 * algorithms
 * Easy (50.28%)
 * Likes:    25
 * Dislikes: 0
 * Total Accepted:    3.5K
 * Total Submissions: 6.9K
 * Testcase Example:  '[5,4,3,2,1]'
 *
 * 给出 N 名运动员的成绩，找出他们的相对名次并授予前三名对应的奖牌。前三名运动员将会被分别授予 “金牌”，“银牌” 和“ 铜牌”（"Gold
 * Medal", "Silver Medal", "Bronze Medal"）。
 * 
 * (注：分数越高的选手，排名越靠前。)
 * 
 * 示例 1:
 * 
 * 
 * 输入: [5, 4, 3, 2, 1]
 * 输出: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 * 解释: 前三名运动员的成绩为前三高的，因此将会分别被授予 “金牌”，“银牌”和“铜牌” ("Gold Medal", "Silver Medal"
 * and "Bronze Medal").
 * 余下的两名运动员，我们只需要通过他们的成绩计算将其相对名次即可。
 * 
 * 提示:
 * 
 * 
 * N 是一个正整数并且不会超过 10000。
 * 所有运动员的成绩都不相同。
 * 
 * 
 */
import java.util.*;



class Solution {

    public String[] findRelativeRanks(int[] nums) {

        Integer[] tmp = new Integer[nums.length];
        for(int i = 0; i < nums.length; i++) {
            tmp[i] = nums[i];
        }
        Arrays.sort(tmp);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        int len = nums.length;
        String[] re = new String[tmp.length];
        for(int i = 0; i < tmp.length; i++) {
            int index = map.get(tmp[i]);
            if(i == len - 1) {
                re[index] = "Gold Medal";
            } else if (i == len - 2) {
                re[index] = "Silver Medal";
            } else if (i == len - 3) {
                re[index] = "Bronze Medal";
            } else {
                re[index] = String.valueOf(len - i);
            }
        }
        return re;
    }
}

