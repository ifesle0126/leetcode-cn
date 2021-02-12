/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
// class ListNode {
//     int val;
//     ListNode next;
//     ListNode() {}
//     ListNode(int val) { this.val = val; }
//     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
// }

class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m ==n) {
            return head;
        }
        ListNode first = null;
        ListNode last = null;
        ListNode node = head;
        for (int i = 1; i <=n; i++) {
            if (i + 1 == m) {
                first = node;
            } else if (i == n) {
                last = node;
            }
            node = node.next;
        }
        node = first == null ? head : first.next;
        ListNode tmp = last.next;
        ListNode lastTmp =  tmp;
        int i = 0;
        while (i <= n - m) {
            ListNode next = node.next;
            node.next = tmp;
            tmp = node;
            node = next;
            i++;
        }

        if (first == null) {
            head.next = lastTmp;
            return tmp;
        } else {
            first.next = last;
            return head;
        }
    }
}