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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null) return null;
        else if(list1 == null) return list2;
        else if(list2 == null) return list1;
        ListNode dummy = new ListNode();
        ListNode dHead = dummy;
        ListNode t1 = list1;
        ListNode t2 = list2;

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