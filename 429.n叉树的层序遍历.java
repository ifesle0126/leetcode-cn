/*
 * @lc app=leetcode.cn id=429 lang=java
 *
 * [429] N叉树的层序遍历
 *
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/description/
 *
 * algorithms
 * Medium (64.66%)
 * Likes:    68
 * Dislikes: 0
 * Total Accepted:    14.8K
 * Total Submissions: 22.8K
 * Testcase Example:  '[1,null,3,2,4,null,5,6]\r'
 *
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 * 
 * 例如，给定一个 3叉树 :
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 返回其层序遍历:
 * 
 * [
 * ⁠    [1],
 * ⁠    [3,2,4],
 * ⁠    [5,6]
 * ]
 * 
 * 
 * 
 * 
 * 说明:
 * 
 * 
 * 树的深度不会超过 1000。
 * 树的节点总数不会超过 5000。
 * 
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
import java.util.*;

class Solution {

    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> r = new ArrayList<>();
        if(root == null) {
            return r;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()) {
            List<Integer> line = new ArrayList<>();
            Queue<Node> next = new LinkedList<>();
            for(Node n: queue) {
                line.add(n.val);
                next.addAll(n.children);
            }
            r.add(line);
            queue = next;
        }
        return r;
    }
}
// @lc code=end

