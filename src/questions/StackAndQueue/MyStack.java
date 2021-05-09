package questions.StackAndQueue;

import questions.LinkedList.MyLinkedList;

public class MyStack {
    MyLinkedList list = new MyLinkedList();

    public void push(int data) {
        list.addFront(data);
    }

    public int peek() {
        return list.getHead().data;
    }

    public int pop() {
        int removedData = list.removeFront();
        return removedData;
    }

    public int size() {
        return list.size;
    }

    public boolean isEmpty() {
        return list.size == 0;
    }

    public String toString() {
        return list.toString();
    }
}
