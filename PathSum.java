import java.util.*;


/**
 * 给定一个二叉树和一个值\ sum sum，请找出所有的根节点到叶子节点的节点值之和等于\ sum sum 的路径，
 * 例如：
 * 给出如下的二叉树，\ sum=22 sum=22，
 * 
 * 
 */

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
}

public class PathSum {

   /**
    * 
    * @param root TreeNode类 
    * @param sum int整型 
    * @return int整型ArrayList<ArrayList<>>
    */
    public ArrayList<ArrayList<Integer>> pathSum (TreeNode root, int sum) {
        // write code here
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        pathSum(root, lists, list, sum);
        return lists;
    }


    public void pathSum(TreeNode node, ArrayList<ArrayList<Integer>> lists, ArrayList<Integer> list, int sum) {
        if (node == null) {
            return;
        }
        if (node.val == sum && node.left == null && node.right == null) {
            list.add(node.val);
            lists.add(new ArrayList<>(list));
            list.remove(list.size() -1);
            return;
        }
        list.add(node.val);
        pathSum(node.left, lists, list, sum - node.val);
        pathSum(node.right, lists, list, sum - node.val);
        list.remove(list.size() - 1);    
    }
}
