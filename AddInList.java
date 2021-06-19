import java.util.*;


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class AddInList {

    /**
     * 
     * @param head1 ListNode类 
     * @param head2 ListNode类 
     * @return ListNode类
     */
    public ListNode addInList (ListNode head1, ListNode head2) {
        // write code here
        Stack<Integer> stack1 = new Stack<>();
        while (head1 != null) {
            stack1.push(head1.val);
            head1 = head1.next;
        }
        Stack<Integer> stack2 = new Stack<>();
        while (head2 != null) {
            stack2.push(head2.val);
            head2 = head2.next;
        }
        int step = 0;
        ListNode node = new ListNode(-1);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int num1 = stack1.isEmpty() ? 0 : stack1.pop();
            int num2 = stack2.isEmpty() ? 0 : stack2.pop();
            int tmp = num1 + num2 + step;
            int num = tmp % 10;
            step = tmp / 10;
            
            ListNode newNode = new ListNode(num);
            newNode.next = node.next;
            node.next = newNode;
        }
        if(step > 0) {
            ListNode newNode = new ListNode(step);
            newNode.next = node.next;
            node.next = newNode;
        }

        return node.next;
    }
    
}
