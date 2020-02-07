/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第N个节点
 *
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/description/
 *
 * algorithms
 * Medium (34.12%)
 * Likes:    675
 * Dislikes: 0
 * Total Accepted:    117K
 * Total Submissions: 313.4K
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 
 * 示例：
 * 
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 
 * 
 * 说明：
 * 
 * 给定的 n 保证是有效的。
 * 
 * 进阶：
 * 
 * 你能尝试使用一趟扫描实现吗？
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) {
            return head;
        }
        ListNode pre_del = null;
        ListNode del_node = null;
        ListNode tmp = head;
        int step = 1;
        while(tmp != null) {
            if(step == n) {
                if(del_node == null) {
                    del_node = head;
                } else {
                    pre_del = del_node;
                    del_node = del_node.next;
                }
            } else {
                step++;
            }
            tmp = tmp.next;
        }
        if(pre_del != null) {
            pre_del.next = del_node.next;
        } else {
            head = head.next;
        }
        
        return head;
    }
}
// @lc code=end

