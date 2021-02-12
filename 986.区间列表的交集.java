/*
 * @lc app=leetcode.cn id=986 lang=java
 *
 * [986] 区间列表的交集
 *
 * https://leetcode-cn.com/problems/interval-list-intersections/description/
 *
 * algorithms
 * Medium (66.25%)
 * Likes:    130
 * Dislikes: 0
 * Total Accepted:    13.2K
 * Total Submissions: 20K
 * Testcase Example:  '[[0,2],[5,10],[13,23],[24,25]]\n[[1,5],[8,12],[15,24],[25,26]]'
 *
 * 给定两个由一些 闭区间 组成的列表，firstList 和 secondList ，其中 firstList[i] = [starti, endi] 而
 * secondList[j] = [startj, endj] 。每个区间列表都是成对 不相交 的，并且 已经排序 。
 * 
 * 返回这 两个区间列表的交集 。
 * 
 * 形式上，闭区间 [a, b]（其中 a ）表示实数 x 的集合，而 a  。
 * 
 * 两个闭区间的 交集 是一组实数，要么为空集，要么为闭区间。例如，[1, 3] 和 [2, 4] 的交集为 [2, 3] 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：firstList = [[0,2],[5,10],[13,23],[24,25]], secondList =
 * [[1,5],[8,12],[15,24],[25,26]]
 * 输出：[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：firstList = [[1,3],[5,9]], secondList = []
 * 输出：[]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：firstList = [], secondList = [[4,8],[10,12]]
 * 输出：[]
 * 
 * 
 * 示例 4：
 * 
 * 
 * 输入：firstList = [[1,7]], secondList = [[3,10]]
 * 输出：[[3,7]]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 
 * firstList.length + secondList.length >= 1
 * 0 i < endi 
 * endi < starti+1
 * 0 j < endj 
 * endj < startj+1
 * 
 * 
 */
import java.util.*;
// @lc code=start
class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> ans = new ArrayList();
        int i = 0, j = 0;
    
        while (i < firstList.length && j < secondList.length) {
          // Let's check if A[i] intersects B[j].
          // lo - the startpoint of the intersection
          // hi - the endpoint of the intersection
          int lo = Math.max(firstList[i][0], secondList[j][0]);
          int hi = Math.min(firstList[i][1], secondList[j][1]);
          if (lo <= hi)
            ans.add(new int[]{lo, hi});
    
          // Remove the interval with the smallest endpoint
          if (firstList[i][1] < secondList[j][1])
            i++;
          else
            j++;
        }
    
        return ans.toArray(new int[ans.size()][]);
    }
}
// @lc code=end

