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
        int left = newInterval[0];
        int right = newInterval[1];
        boolean placed = false;
        List<int[]> ansList = new ArrayList<int[]>();
        for (int[] interval : intervals) {
            if (interval[0] > right) {
                // 在插入区间的右侧且无交集
                if (!placed) {
                    ansList.add(new int[]{left, right});
                    placed = true;                    
                }
                ansList.add(interval);
            } else if (interval[1] < left) {
                // 在插入区间的左侧且无交集
                ansList.add(interval);
            } else {
                // 与插入区间有交集，计算它们的并集
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        if (!placed) {
            ansList.add(new int[]{left, right});
        }
        int[][] ans = new int[ansList.size()][2];
        for (int i = 0; i < ansList.size(); ++i) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }

    public int[][] insert3(int[][] intervals, int[] newInterval) {
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


    public int[][] insert2(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length < 1) {
            int[][] ints = new int[1][];
            ints[0] = newInterval;
            return ints;
        }
        Stack<int[]> stack = new Stack<>();
        stack.add(intervals[0]);
        int i = 1;
        int[] next = newInterval;
        boolean f = false;
        while (i < intervals.length || (intervals.length == 1 && next != null)) {
            int[] newInts = stack.pop();
            int[] tmp = null;
            if (intervals.length == 1 || intervals[i][0] > next[0]) {
                tmp = next;
                next = intervals.length == 1 ? null : intervals[i];
                f = true;
            } else {
                tmp = intervals[i];
                i++;
            }
            if (tmp[1] < newInts[0]) {
                stack.add(tmp);
                stack.add(newInts);
            } else if (tmp[0] > newInts[1]) {
                stack.add(newInts);
                stack.add(tmp);
            } else if (tmp[0] <= newInts[0] && tmp[1] <= newInts[1]) {
                stack.add(new int[]{tmp[0], newInts[1]});
            } else if (tmp[0] <= newInts[0] && tmp[1] >= newInts[1]) {
                stack.add(new int[]{tmp[0], tmp[1]});
            } else if (tmp[0] >= newInts[0] && tmp[1] <= newInts[1]) {
                stack.add(newInts);
            } else if (tmp[0] >= newInts[0] && tmp[1] >= newInts[1]) {
                stack.add(new int[]{newInts[0], tmp[1]});
            } 
        }
        if (!f) {
            int[] newInts = stack.pop();
            if (newInterval[1] < newInts[0]) {
                stack.add(newInterval);
                stack.add(newInts);
            } else if (newInterval[0] > newInts[1]) {
                stack.add(newInts);
                stack.add(newInterval);
            } else if (newInterval[0] <= newInts[0] && newInterval[1] <= newInts[1]) {
                stack.add(new int[]{newInterval[0], newInts[1]});
            } else if (newInterval[0] <= newInts[0] && newInterval[1] >= newInts[1]) {
                stack.add(new int[]{newInterval[0], newInterval[1]});
            } else if (newInterval[0] >= newInts[0] && newInterval[1] <= newInts[1]) {
                stack.add(newInts);
            } else if (newInterval[0] >= newInts[0] && newInterval[1] >= newInts[1]) {
                stack.add(new int[]{newInts[0], newInterval[1]});
            } 
        }
        return stack.toArray(new int[stack.size()][]);
    }
}
// @lc code=end

