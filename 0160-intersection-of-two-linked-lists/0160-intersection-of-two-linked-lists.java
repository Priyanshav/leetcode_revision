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
        Map<ListNode, Integer> map = new HashMap<>();
        ListNode temp1 = head1;

        while(temp1 != null){
            map.put(temp1, 1);
            temp1 = temp1.next;
        }
        ListNode temp2 = head2;
        while(temp2 != null){
            if(map.containsKey(temp2)) return temp2;
            temp2 = temp2.next;
        }
        return null;
    }
}