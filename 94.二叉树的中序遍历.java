/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/description/
 *
 * algorithms
 * Medium (70.23%)
 * Likes:    402
 * Dislikes: 0
 * Total Accepted:    105.7K
 * Total Submissions: 150.5K
 * Testcase Example:  '[1,null,2,3]'
 *
 * 给定一个二叉树，返回它的中序 遍历。
 * 
 * 示例:
 * 
 * 输入: [1,null,2,3]
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  3
 * 
 * 输出: [1,3,2]
 * 
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
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


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


/**
 * 栈实现
 */
class Solution2 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.add(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            list.add(node.val);
            root = node.right;
        }
        return list;
    }

}


/**
 * 递归实现
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        inorderTraversal(root, list);
        return list;
    }

    public void inorderTraversal(TreeNode node, List<Integer> list) {
        if(node == null) {
            return;
        }
        inorderTraversal(node.left, list);
        list.add(node.val);
        inorderTraversal(node.right, list);
    }
}
// @lc code=end

