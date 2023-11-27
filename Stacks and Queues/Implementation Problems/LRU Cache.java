// Algorithm: 

// 1. Define a doubly linked list, initially havign a head and tail nodes with 0 values.
// DLL will store the key, value pairs. 

// 2. Also declare a hashmap where we will storing the key and the corresponding node. 

// 3.Now whenever there is a put query simply put the new key value pair node right after the head position. Note: if the cache size has reached the max limit then we will need to remove the LRU cache before adding the new cache, for this we will always remove the node just before the tail node. 

// We are maintaining the order of recently used to least recently used from left to right, i.e from head to the tail. 

// If there is a put operation and the key alreday exists then we need to remove the key value pair node from the DLL and place it right after the head as it has become the most recently used cache, also we need to update the value of this key in the hashmap. 

// 4. For the get operation simply check if the key is present in the hashmap or not. If present return the value of the key, also as it is recently used we have to remove it from the DLL and place it right after the head node, its address will change so make the corresponding change in the hashmap also.
// if the key is not present simply return -1; 

// 5. for implementint the insert and delete operations we need to make sure we do all the opreations in O(1). Just play with the linnks and our job is done.

class LRUCache {
    Node head = new Node(0, 0), tail = new Node(0, 0);
    Map < Integer, Node > map = new HashMap();
    int capacity;

    public LRUCache(int _capacity) {
        capacity = _capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        if (map.size() == capacity) {
            remove(tail.prev);
        }
        insert(new Node(key, value));
    }

    private void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node) {
        map.put(node.key, node);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    class Node {
        Node prev, next;
        int key, value;
        Node(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }
}