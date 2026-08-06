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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode tail = head;
        int len = 1;
        while(tail.next != null){
            len++;
            tail = tail.next;
        }
        if(k % len == 0) return head;
        ListNode temp = head;
        int count = 1;
        k = k % len;
        while(temp != null){
            if(count == len - k){
                tail.next = head;
                head = temp.next;
                temp.next = null;
            }
            count++;
            temp = temp.next;
        }
        return head;

    }
}