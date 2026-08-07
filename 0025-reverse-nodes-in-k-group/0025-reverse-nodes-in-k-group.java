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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prev = null;

        while(temp != null){
            ListNode kthNode = findKth(temp, k);
            if(kthNode == null){
                if(prev != null){
                    prev.next = temp;
                    break;
                }
            }
            ListNode front = kthNode.next;
            kthNode.next = null;
            reverse(temp);
            if(temp == head) head = kthNode;
            else prev.next = kthNode;
            prev = temp;
            temp = front;
        }
        return head;
    }
    public ListNode findKth(ListNode head, int k){
        ListNode temp = head;
        k -= 1;
        while(temp != null && k > 0){
            temp = temp.next;
            k--;
        }
        return temp;
    }
    public ListNode reverse(ListNode head){
        ListNode temp = head;
        ListNode prev = null;
        while(temp != null){
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }
}