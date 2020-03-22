/*
 * @lc app=leetcode.cn id=1022 lang=java
 *
 * [1022] 从根到叶的二进制数之和
 *
 * https://leetcode-cn.com/problems/sum-of-root-to-leaf-binary-numbers/description/
 *
 * algorithms
 * Easy (59.18%)
 * Likes:    38
 * Dislikes: 0
 * Total Accepted:    5K
 * Total Submissions: 8.4K
 * Testcase Example:  '[1,0,1,0,1,0,1]'
 *
 * 给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。例如，如果路径为 0 -> 1 -> 1
 * -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
 * 
 * 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
 * 
 * 以 10^9 + 7 为模，返回这些数字之和。
 * 
 * 
 * 
 * 示例：
 * 
 * 
 * 
 * 输入：[1,0,1,0,1,0,1]
 * 输出：22
 * 解释：(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中的结点数介于 1 和 1000 之间。
 * node.val 为 0 或 1 。
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;


class Solution {

    // class TreeNode {
    //     int val;
    //     TreeNode left;
    //     TreeNode right;
    //     TreeNode(int x) { val = x; }
    // }

    public int sumRootToLeaf(TreeNode root) {

        List<List<Integer>> lists = new ArrayList<>();
        trace(root, lists, new ArrayDeque<>());

        int sum = 0;
        for (List<Integer> list : lists) {
            sum += list2Int(list);
        }
        return sum;
    }

    private int list2Int(List<Integer> list) {
        int r = 0;
        for (Integer i : list) {
            r = (r * 2 + i);
        }
        return r;
    }

    private void trace(TreeNode node, List<List<Integer>> lists, Deque<Integer> list) {

        list.add(node.val);
        if (node.left == null && node.right == null) {
            lists.add(new ArrayList<>(list));
            return;
        }
        if (node.left != null) {
            trace(node.left, lists, list);
            list.removeLast();
        }
        if (node.right != null) {
            trace(node.right, lists, list);
            list.removeLast();
        }
        
    }
}
// @lc code=end

