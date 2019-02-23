/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
 *
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/description/
 *
 * algorithms
 * Easy (52.15%)
 * Total Accepted:    41.8K
 * Total Submissions: 80.1K
 * Testcase Example:  '[1,2,4]\n[1,3,4]'
 *
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * 
 * 示例：
 * 
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 
 * 
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 != null) {
            return l2;
        }
        if(l2 == null && l1 != null) {
            return l1;
        }
        ListNode h = null;
        ListNode curr = null;
        while(l1!=null && l2!=null) {
            int l1_i = l1.val;
            int l2_i = l2.val;
            ListNode tmp;
            if(l1_i < l2_i) {
                tmp = new ListNode(l1_i);
                l1 = l1.next;
            } else {
                tmp = new ListNode(l2_i);
                l2 = l2.next;
            }
            if (h == null) {
                h = tmp;
                curr = tmp;
            } else {
                curr.next = tmp;
                curr = curr.next;
            }
        }
        if(l1!=null) {
            curr.next = l1;
        }
        if(l2!=null) {
            curr.next = l2;
        }
        return h;
    }
}
