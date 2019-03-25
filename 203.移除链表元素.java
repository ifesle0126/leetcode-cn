/*
 * @lc app=leetcode.cn id=203 lang=java
 *
 * [203] 移除链表元素
 *
 * https://leetcode-cn.com/problems/remove-linked-list-elements/description/
 *
 * algorithms
 * Easy (39.78%)
 * Total Accepted:    19K
 * Total Submissions: 47.8K
 * Testcase Example:  '[1,2,6,3,4,5,6]\n6'
 *
 * 删除链表中等于给定值 val 的所有节点。
 * 
 * 示例:
 * 
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
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

// public class ListNode {
//     int val;
//     ListNode next;
//     ListNode(int x) { val = x; }
// }

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        while(head != null && head.val==val) {
            head = head.next;
        }
        if (head == null) {
            return head;
        }
        ListNode preNode = null;
        ListNode currNode = head;
        while (currNode != null) {
            if(currNode.val == val) {
                preNode.next = currNode.next;
            } else {
                preNode = currNode;
            }
            currNode = currNode.next;
        }
        return head;
    }
}

