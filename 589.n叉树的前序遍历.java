import java.util.*;

import javax.xml.soap.Node;

/*
 * @lc app=leetcode.cn id=589 lang=java
 *
 * [589] N叉树的前序遍历
 *
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/description/
 *
 * algorithms
 * Easy (72.39%)
 * Likes:    66
 * Dislikes: 0
 * Total Accepted:    19.9K
 * Total Submissions: 27.5K
 * Testcase Example:  '[1,null,3,2,4,null,5,6]'
 *
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 * 
 * 例如，给定一个 3叉树 :
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 返回其前序遍历: [1,3,5,6,2,4]。
 * 
 * 
 * 
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
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


class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> r = new ArrayList<>();
        if(root == null) {
            return r;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            r.add(node.val);
            if(node.children != null) {
                for(int i = node.children.size() - 1 ; i >= 0; i --) {
                    stack.push(node.children.get(i));
                }
            }
        }
        return r;
    }

}

class Solution2 {
    public List<Integer> preorder(Node root) {
        List<Integer> r = new ArrayList<>();
        if(root == null) {
            return r;
        }
        return preorder(root, r);
    }

    public List<Integer> preorder(Node root, List<Integer> list) {
        if(root == null) {
            return list;
        }
        list.add(root.val);
        if(root.children == null) {
            return list;
        }
        for(Node node : root.children) {
            preorder(node, list);
        }
        return list;
    }
}
// @lc code=end

