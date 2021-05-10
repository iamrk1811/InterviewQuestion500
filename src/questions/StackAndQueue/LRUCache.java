package questions.StackAndQueue;

import java.util.HashMap;
class LRUCache2 {
    static class Node{
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    int capacity;
    HashMap<Integer, Node> map = new HashMap<>();
    Node head = null;
    Node end = null;

    public LRUCache2(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node n = map.get(key);
            delete(n);
            setHead(n);
            return n.value;
        }

        return -1;
    }
    public void put(int key, int value) {
        if(map.containsKey(key)){
            // update the old value
            Node old = map.get(key);
            map.remove(old);

            old.value = value;
            map.put(key, old);

            delete(old);
            setHead(old);
        }else{
            Node newNode = new Node(key, value);
            if(map.size()>=capacity){

                map.remove(end.key);
                // remove last node
                delete(end);
                setHead(newNode);

            }else{
                setHead(newNode);
            }

            map.put(key, newNode);
        }
    }
    public void delete(Node node){
        if(node.prev!=null){
            node.prev.next = node.next;
        }else{
            head = node.next;
        }

        if(node.next!=null){
            node.next.prev = node.prev;
        }else{
            end = node.prev;
        }

    }
    public void setHead(Node node){
        node.next = head;
        node.prev = null;

        if(head!=null)
            head.prev = node;

        head = node;

        if(end == null)
            end = head;

    }
}
public class LRUCache {
    //    Q - https://www.geeksforgeeks.org/lru-cache-implementation/
    //    Q - https://leetcode.com/problems/lru-cache/
    static class Node {
        int value;
        int key;

        public Node prev = null;
        public Node next = null;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    HashMap<Integer, Node> map = new HashMap<>();
    int capacity = 0;
    int count = 0;
    Node head = null, tail = null;

    public LRUCache(int cap) {
        this.capacity = cap;
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);

        tail.prev = head;
        head.next = tail;

        head.prev = null;
        tail.next = null;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);

            int result = node.value;

            deleteNode(node);
            addNodeToHead(node);

            return result;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;

            map.remove(key);
            map.put(key, node);

            deleteNode(node);
            addNodeToHead(node);
        } else {
            Node node = new Node(key, value);
            map.put(key, node);

            if (count < capacity) {
                count++;
                addNodeToHead(node);
            } else {
                map.remove(tail.prev.key);
                deleteNode(tail.prev);

                addNodeToHead(node);
            }
        }
    }

    public void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void addNodeToHead(Node node) {
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }
}
