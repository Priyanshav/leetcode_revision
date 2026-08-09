/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        // Map<Node, Node> map = new HashMap<>();
        // Node temp = head;
        // while(temp != null){
        //     Node newNode = new Node(temp.val);
        //     map.put(temp, newNode);
        //     temp = temp.next;
        // }
        // temp = head;
        // while(temp != null){
        //     Node copyNode = map.get(temp);
        //     copyNode.next = map.get(temp.next);
        //     copyNode.random = map.get(temp.random);
        //     temp = temp.next;
        // }
        // return map.get(head);
        Node temp = head;
        while(temp != null){
            Node newNode = new Node(temp.val);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = temp.next.next;
        }
        temp = head;
        while(temp != null){
            Node copyNode = temp.next;
            if(temp.random != null) copyNode.random = temp.random.next;
            else copyNode.random = null;
            temp = temp.next.next;
        }
        temp = head;
        Node dummy = new Node(-1);
        Node dHead = dummy;
        while(temp != null){
            dHead.next = temp.next;
            temp.next = temp.next.next;
            temp = temp.next;
            dHead = dHead.next;
        }
        return dummy.next;
    }
}