import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=429 lang=java
 *
 * [429] N-ary Tree Level Order Traversal
 *
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/description/
 *
 * algorithms
 * Easy (60.37%)
 * Total Accepted:    4.7K
 * Total Submissions: 7.8K
 * Testcase Example:  '{"$id":"1","children":[{"$id":"2","children":[{"$id":"5","children":[],"val":5},{"$id":"6","children":[],"val":6}],"val":3},{"$id":"3","children":[],"val":2},{"$id":"4","children":[],"val":4}],"val":1}'
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
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
import java.util.*;

// class Node {
//     public int val;
//     public List<Node> children;

//     public Node() {}

//     public Node(int _val,List<Node> _children) {
//         val = _val;
//         children = _children;
//     }
// }


class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> listSet = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if(root == null || root.children == null ) {
            return listSet;
        }
        list.add(root.val);
        listSet.add(list);
        levelOrder(listSet, root.children);
        return listSet;
    }

    public void levelOrder(List<List<Integer>> listSet, List<Node> nodes) {
        if(nodes == null || nodes.size() < 1) {
            return;
        }
        List<Integer> list = new ArrayList<>();
        List<Node> listNode = new ArrayList<>();
        for(Node node : nodes) {
            list.add(node.val);
            listNode.addAll(node.children);
        }
        listSet.add(list);
        levelOrder(listSet, listNode);
    }
}

