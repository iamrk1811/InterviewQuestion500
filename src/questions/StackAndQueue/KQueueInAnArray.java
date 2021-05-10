package questions.StackAndQueue;

import java.util.Arrays;

public class KQueueInAnArray {
//    Q - https://www.geeksforgeeks.org/efficiently-implement-k-queues-single-array/
    int[] data;
    int[] front;
    int[] rear;
    int[] next;
    int free = 0;

    public KQueueInAnArray(int k, int size) {
        this.data = new int[size];
        this.next = new int[size];
        this.front = new int[k];
        this.rear = new int[k];

        Arrays.fill(front, -1);
        Arrays.fill(rear, -1);

        for (int i = 0; i < data.length - 1; i++) next[i] = i + 1;
        next[data.length - 1] = -1;
    }
    public void add(int value, int queueNumber) {
        if (free ==-1) {
            System.out.println("Queue is Full");
            return;
        }

        int i = free;

        free = next[free];

        if (front[queueNumber] == -1) {
            front[queueNumber] = rear[queueNumber] = i;
        } else {
            next[rear[queueNumber]] = i;
            rear[queueNumber] = i;
        }

        next[i] = -1;

        data[i] = value;
    }
    public int remove(int queueNumber) {
        if (front[queueNumber] == -1) {
            System.out.println("Stack is Empty");
            return -1;
        }

        int frontIndex = front[queueNumber];

        next[frontIndex] = free;
        free = frontIndex;

        return data[frontIndex];
    }
}
