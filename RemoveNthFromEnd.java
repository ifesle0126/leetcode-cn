import java.util.*;


class ListNode {
    int val;
    ListNode next = null;
}
public class RemoveNthFromEnd {

    public static void main(String[] args) {
        
    }
    

    public ListNode removeNthFromEnd (ListNode head, int n) {
        ListNode node = head;
        ListNode pre = null;
        n++;
        while (node != null) {
            node = node.next;
            n--;
            if (n == 0) {
                pre = head;
            } else if (pre != null) {
                pre = pre.next;
            }
        }
        if (pre == null) {
            head = head.next;
        } else if (pre.next != null) {
            pre.next = pre.next.next;
        } 
        return head;
    }

}
