/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 *
 * https://leetcode-cn.com/problems/merge-intervals/description/
 *
 * algorithms
 * Medium (40.50%)
 * Likes:    300
 * Dislikes: 0
 * Total Accepted:    57K
 * Total Submissions: 140.8K
 * Testcase Example:  '[[1,3],[2,6],[8,10],[15,18]]'
 *
 * 给出一个区间的集合，请合并所有重叠的区间。
 * 
 * 示例 1:
 * 
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 
 * 
 * 示例 2:
 * 
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 
 */

// @lc code=start
import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length < 1) {
            return intervals;
        }
        // sort
        for(int i = 0; i < intervals.length; i++) {
            for(int j = i + 1; j < intervals.length; j++) {
                if(intervals[i][0] > intervals[j][0]) {
                    int[] tmp = intervals[i];
                    intervals[i] = intervals[j];
                    intervals[j] = tmp;
                }
            }
        }
        // merge
        Stack<int[]> list = new Stack<>();
        list.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++) {
            int[] t = list.peek();
            int b = t[1];
            int e = intervals[i][0];
            if(b >= e) {
                int[] item = new int[2];
                item[0] = t[0];
                item[1] = intervals[i][1] > t[1] ? intervals[i][1] : t[1];
                list.pop();
                list.add(item);
            } else {
                list.add(intervals[i]);
            }
            
        }
        return list.toArray(new int[list.size()][]);
    }
}
// @lc code=end

