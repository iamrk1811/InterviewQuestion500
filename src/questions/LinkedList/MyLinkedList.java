package questions.LinkedList;

public class MyLinkedList{
    ListNode head = null;
    ListNode tail = null;
    public int size = 0;
    public void add(ListNode node) {
        if (this.head == null) {
            this.head = node;
            this.size++;
            return;
        }
        ListNode temp = this.head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        this.size++;
    }
    public int delete() {
        if (head == null) {
            return -1;
        }
        if (head.next == null) {
            int deletedData = head.data;
            head = null;
            this.size--;
            return deletedData;
        }
        ListNode node = this.head;
        while (node.next.next != null) {
            node = node.next;
        }
        int deletedData = node.next.data;
        node.next = null;
        this.size--;

        return deletedData;
    }
    public void add(int data) {
        ListNode node = this.head;
        if (head == null) {
            head = new ListNode(data, null);
            tail = head;
        } else {
            while (node.next != null) {
                node = node.next;
            }
            ListNode newNode = new ListNode(data, null);
            tail = newNode;
            node.next = newNode;
        }
        this.size++;
    }
    public String toString() {
        StringBuilder res = new StringBuilder();
        ListNode temp = this.head;

        while (temp != null) {
            res.append(temp.data + "->");
            temp = temp.next;
        }
        res.append("NULL");
        return res.toString();
    }
    public static void display(ListNode node) {
        ListNode temp = node;
        StringBuilder res = new StringBuilder();
        while (temp != null) {
            res.append(temp.data + "->");
            temp = temp.next;
        }
        res.append("NULL");
        System.out.println(res);
    }
    public ListNode getHead() {
        return this.head;
    }
}
