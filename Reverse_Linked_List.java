public class ReverseLinkedList {
    
    public ListNode reverseList(ListNode head) {
        // return recursiveReverseList(head);
        return iterativeReverseList(head);
    }
    
    public ListNode recursiveReverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode node = recursiveReverseList(head.next);
        head.next.next = head;
        head.next= null;
        return node;
    }
    
    public ListNode iterativeReverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        
        while(current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    
}
