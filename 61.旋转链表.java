/*
 * @lc app=leetcode.cn id=61 lang=java
 *
 * [61] 旋转链表
 *
 * https://leetcode-cn.com/problems/rotate-list/description/
 *
 * algorithms
 * Medium (39.94%)
 * Likes:    206
 * Dislikes: 0
 * Total Accepted:    45.2K
 * Total Submissions: 113.1K
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * 
 * 示例 1:
 * 
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 
 * 
 * 示例 2:
 * 
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
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

    // class ListNode {
    //     int val;
    //     ListNode next;
    //     ListNode(int x) { val = x; }
    // }


    public ListNode rotateRight(ListNode head, int n) {
        if (head==null||head.next==null) return head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode fast=dummy,slow=dummy;
    
        int i;
        for (i=0;fast.next!=null;i++)//Get the total length 
            fast=fast.next;
        
        for (int j=i-n%i;j>0;j--) //Get the i-n%i th node
            slow=slow.next;
        
        fast.next=dummy.next; //Do the rotation
        dummy.next=slow.next;
        slow.next=null;
        
        return dummy.next;
    }
    

    public ListNode rotateRight1(ListNode head, int k) {

        if(head == null || head.next == null || k <= 0) {
            return head;
        }

        int step = 0;
        ListNode node = head;
        ListNode preK = head;
        ListNode tail = head;
        while (node != null) {
            if(step <= k) {
                step++;
            } else {
                preK = preK.next;
            }
            tail = node;
            node = node.next;
            if(node == null && step <= k) {
                node = head;
            }
        }
        ListNode tmp = preK.next;
        if(tmp == null) {
            return head;
        }
        preK.next = node;
        tail.next = head;
        return tmp;
    }
}
// @lc code=end

