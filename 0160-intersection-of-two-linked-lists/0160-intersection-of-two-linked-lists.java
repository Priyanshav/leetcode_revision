/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode head1, ListNode head2) {
        // Map<ListNode, Integer> map = new HashMap<>();
        // ListNode temp1 = head1;

        // while(temp1 != null){
        //     map.put(temp1, 1);
        //     temp1 = temp1.next;
        // }
        // ListNode temp2 = head2;
        // while(temp2 != null){
        //     if(map.containsKey(temp2)) return temp2;
        //     temp2 = temp2.next;
        // }
        // return null;
        // int l1 = 0;
        // int l2 = 0;
        // ListNode temp1 = head1;
        // ListNode temp2 = head2;
        // while(temp1 != null){
        //     l1++;
        //     temp1 = temp1.next;
        // }
        // while(temp2 != null){
        //     l2++;
        //     temp2 = temp2.next;
        // }
        // if(l1 > l2) return moveAhead(head1, head2, l1-l2);
        // else return moveAhead(head2, head1, l2-l1);
        if(head1 == null || head2 == null) return null;
        ListNode t1 = head1;
        ListNode t2 = head2;
        while(t1 != t2){
            t1 = t1.next;
            t2 = t2.next;
            if(t1 == t2) return t1;
            if(t1 == null) t1 = head2;
            if(t2 == null) t2 = head1;
        }
        return t1;
    }

    // public ListNode moveAhead(ListNode LL1, ListNode LL2, int N){
    //     ListNode temp1 = LL1;
    //     ListNode temp2 = LL2;
    //     for(int i = 0; i < N; i++) temp1 = temp1.next;
    //     while(temp1 != null && temp2 != null){
    //         if(temp1 == temp2) return temp1;
    //         temp1 = temp1.next;
    //         temp2 = temp2.next;
    //     }
    //     return null;
    // }
}