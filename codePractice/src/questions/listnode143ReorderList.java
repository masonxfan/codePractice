package questions;

public class listnode143ReorderList {
	public void reorderList(ListNode head) {
        ListNode cur = head;
        while(cur != null){
            ListNode pretail = cur;
            ListNode tail = null;
            while(pretail.next != null){
                if(pretail.next.next == null){
                    tail = pretail.next;
                    pretail.next = null;
                    break;
                }
                pretail = pretail.next;
            }
            if(tail == null) break;
            ListNode temp = cur.next;
            cur.next = tail;
            cur.next.next = temp;
            cur = temp;
        }
    }
}
