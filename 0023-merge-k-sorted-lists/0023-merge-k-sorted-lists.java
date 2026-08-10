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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        ListNode head = lists[0];
        if(lists.length == 1) return head;
        for(int i = 1; i < lists.length; i++){
            head = merge2Lists(head, lists[i]);
        }
        return head;
    }
    public ListNode merge2Lists(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode();
        ListNode dHead = dummy;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                dHead.next = l1;
                l1 = l1.next;
            }else{
                dHead.next = l2;
                l2 = l2.next;
            }
            dHead = dHead.next;
        } 
        while(l1 != null){
            dHead.next = l1;
            l1 = l1.next;
            dHead = dHead.next;
        }
        while(l2 != null){
            dHead.next = l2;
            l2 = l2.next;
            dHead = dHead.next;
        }
        return dummy.next;
    }

}