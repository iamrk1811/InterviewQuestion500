package questions.StackAndQueue;

import java.security.PublicKey;
import java.util.Arrays;

public class HowToEfficientlyImplementKStacksInASingleArray {
    //    Q - https://www.geeksforgeeks.org/efficiently-implement-k-stacks-single-array/
    int[] data;
    int[] top;
    int[] next;
    int free = 0;

    public HowToEfficientlyImplementKStacksInASingleArray(int n, int k) {
        data = new int[n];
        next = new int[n];
        top = new int[k];

        Arrays.fill(top, -1);
        for (int i = 0; i < n - 1; i++) next[i] = i + 1;
        next[n - 1] = -1;
    }

    public void push(int stackNumber, int val) {
        if (free == -1) {
            System.out.println("Stack is full");
            return;
        }

        int index = free;
        data[index] = val;

        free = next[index];

        next[index] = top[stackNumber];
        top[stackNumber] = index;

    }

    public int pop(int stackNumber) {
        if (top[stackNumber] == -1) {
            System.out.println("Stack is empty");
            return -1;
        }
        int index = top[stackNumber];
        top[stackNumber] = next[index];
        next[index] = free;
        free = index;

        return data[index];
    }
}
