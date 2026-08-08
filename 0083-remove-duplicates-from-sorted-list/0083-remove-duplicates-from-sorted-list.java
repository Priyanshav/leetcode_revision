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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode temp = head;
        ListNode prev = temp;
        while(prev != null && temp != null){
            if(prev.val == temp.val){
                temp = temp.next;
                prev.next = temp;
            }
            else{
                prev = temp;
                temp = temp.next;
            }
        }
        return head;
    }
}