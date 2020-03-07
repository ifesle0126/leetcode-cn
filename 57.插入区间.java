import java.util.*;

/*
 * @lc app=leetcode.cn id=57 lang=java
 *
 * [57] 插入区间
 *
 * https://leetcode-cn.com/problems/insert-interval/description/
 *
 * algorithms
 * Hard (37.01%)
 * Likes:    110
 * Dislikes: 0
 * Total Accepted:    16.7K
 * Total Submissions: 45.2K
 * Testcase Example:  '[[1,3],[6,9]]\n[2,5]'
 *
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * 
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * 
 * 示例 1:
 * 
 * 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出: [[1,5],[6,9]]
 * 
 * 
 * 示例 2:
 * 
 * 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出: [[1,2],[3,10],[12,16]]
 * 解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals == null || intervals.length < 1) {
            int[][] ints = new int[1][];
            ints[0] = newInterval;
            return ints;
        }

        int b = 0;
        int e = intervals.length - 1;
        int n = newInterval[0];
        while(b <= e) {
            int m = (b + e) / 2;
            if(n < intervals[m][0]) {
                e = m - 1;
            } else {
                b = m + 1;
            }
        }
        List<int[]> list = new ArrayList<>();
        int i = 0;
        if (b == 0) {
            list.add(newInterval);
        } else {
            list.add(intervals[0]);
            i = 1;
        }
        while (i < intervals.length || i == b) {
            int[] pre = list.get(list.size() - 1);
            int[] suf;
            if(i == b) {
                suf = newInterval;
                b = -1;
            } else {
                suf = intervals[i];
                i++;
            }
            if(suf[0] <= pre[0]) {
                int[] newPre = new int[]{suf[0], Math.max(suf[1], pre[1])};
                list.set(list.size() - 1, newPre);
            } else if (suf[0] > pre[0] && suf[0] <= pre[1]) {
                int[] newPre = new int[]{pre[0], Math.max(suf[1], pre[1])};
                list.set(list.size() - 1, newPre);
            } else {
                list.add(suf);
            }

        }
        return list.toArray(new int[list.size()][]);
    }
}
// @lc code=end

