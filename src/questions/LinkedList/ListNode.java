package questions.LinkedList;

public class ListNode {
    public int data;
    public ListNode prev = null;
    public ListNode next = null;
    public ListNode bottom = null;

    public ListNode() {
    }

    public ListNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public ListNode(int data, ListNode next) {
        this.data = data;
        this.next = next;
    }

    public ListNode(int data, ListNode next, ListNode bottom) {
        this.data = data;
        this.next = next;
        this.bottom = bottom;
    }
}
