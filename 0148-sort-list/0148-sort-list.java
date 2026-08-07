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
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode middle = findMiddle(head);
        ListNode right = middle.next;
        middle.next = null;
        ListNode left = head;

        left = sortList(left);
        right = sortList(right);

        return merge(left, right);
    }
    public ListNode findMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode();
        ListNode dHead = dummy;
        ListNode t1 = l1;
        ListNode t2 = l2;
        while(t1 != null && t2 != null){
            if(t1.val < t2.val){
                dHead.next = t1;
                t1 = t1.next;
            }
            else{
                dHead.next = t2;
                t2 = t2.next;
            }
            dHead = dHead.next;
        }
        while(t1 != null){
            dHead.next = t1;
            t1 = t1.next;
            dHead = dHead.next;
        }
        while(t2 != null){
            dHead.next = t2;
            t2 = t2.next;
            dHead = dHead.next;
        }
        return dummy.next;
    }
}