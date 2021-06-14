import java.util.*;


/*
 * public class TreeNode {
 *   int val = 0;
 *   TreeNode left = null;
 *   TreeNode right = null;
 * }
 */



public class LowestCommonAncestor {
    
        /**
     * 
     * @param root TreeNode类 
     * @param o1 int整型 
     * @param o2 int整型 
     * @return int整型
     */
    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        if (root == null) {
            return -1;
        }

        boolean o1Left = find(root.left, o1);
        boolean o1Right = find(root.right, o1);
        boolean o2Left = find(root.left, o2);
        boolean o2Right = find(root.right, o2);
        if ((root.val == o1) && (o2Right || o2Left)) {
            return root.val;
        }
        if ((root.val == o2) && (o1Right || o1Left)) {
            return root.val;
        }
        if (o1Left && o2Right || o1Right && o2Left) {
            return root.val;
        }
        if (o1Left && o2Left) {
            return lowestCommonAncestor(root.left, o1, o2);
        }
        if (o1Right && o2Right) {
            return lowestCommonAncestor(root.right, o1, o2);
        }
        return -1;
    }


    public boolean find(TreeNode node, int val) {
        if(node == null) {
            return false;
        }
        if (node.val == val) {
            return true;
        }
        return find(node.left, val) || find(node.right, val);
    }
}
