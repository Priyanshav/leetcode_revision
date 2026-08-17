class Node{
     int key, val;
     Node next, prev;
    Node(){
        key = val = -1;
        next = prev = null;
    }
    Node(int k, int value){
        key = k;
        val = value;
        prev = next = null;
    }
}

class LRUCache {
    HashMap<Integer, Node> map;
    private int cap;
    private Node head;
    private Node tail;

    public void deleteNode(Node node){
        Node nextNode = node.next;
        Node prevNode = node.prev;
        nextNode.prev = prevNode;
        prevNode.next = nextNode;
    }
    public void insertAfterHead(Node node){
        Node currAfterHead = head.next;
        head.next = node;
        currAfterHead.prev = node;
        node.prev = head;
        node.next = currAfterHead;
    }
    public LRUCache(int capacity) {
        cap = capacity;
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);
        int val = node.val;
        deleteNode(node);
        insertAfterHead(node);
        return val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            deleteNode(node);
            insertAfterHead(node);
            return;
        }
        if(map.size() == cap){
            Node node = tail.prev;
            map.remove(node.key);
            deleteNode(node);
        }
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        insertAfterHead(newNode);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */