/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层次遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/description/
 *
 * algorithms
 * Medium (60.97%)
 * Likes:    391
 * Dislikes: 0
 * Total Accepted:    83K
 * Total Submissions: 136.1K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * 
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 返回其层次遍历结果：
 * 
 * [
 * ⁠ [3],
 * ⁠ [9,20],
 * ⁠ [15,7]
 * ]
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> r = new ArrayList<>();
        if(root == null) {
            return r;
        }
        Queue<TreeNode> l = new LinkedList<>();
        l.add(root);
        while(!l.isEmpty()) {
            List<Integer> line = new ArrayList<>();
            int curLine = l.size();
            for(int i = 0; i < curLine; i++) {
                TreeNode node = l.poll();
                line.add(node.val);
                if(node.left != null) {
                    l.add(node.left);
                }
                if(node.right != null) {
                    l.add(node.right);
                }
            }
            r.add(line);
        }
        return r;
    }
}
// @lc code=end

