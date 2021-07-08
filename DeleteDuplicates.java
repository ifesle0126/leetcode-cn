import java.util.*;


public class DeleteDuplicates {

    /**
    * 
    * @param head ListNode类 
    * @return ListNode类
    */
    public ListNode deleteDuplicates (ListNode head) {
        // write code here
        ListNode node = head;
        ListNode preNode = new ListNode(-1);
        preNode.next = head;
        ListNode re = preNode;
        while (node != null && node.next != null) {
            if (node.val == node.next.val) {
                ListNode tmp = node.next;
                while (tmp != null && node.val == tmp.val) {
                    tmp = tmp.next;
                }
                preNode.next = tmp;
                node = tmp;
            } else {
                preNode = node;
                node = node.next;
            }
        }
        return re.next;
    }

}
