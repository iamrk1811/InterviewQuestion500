package questions.StackAndQueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class HowToImplementStackUsingPriorityQueueOrHeap {
    //    Q - https://www.geeksforgeeks.org/implement-stack-using-priority-queue-or-heap/
    static class Pair implements Comparable<Pair> {
        int data;
        int arrivalTime;

        public Pair(int data, int arrivalTime) {
            this.data = data;
            this.arrivalTime = arrivalTime;
        }

        @Override
        public int compareTo(Pair o) {
            return this.arrivalTime - o.arrivalTime;
        }
    }

    PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
    int currentArrivalTime = 0;

    public void push(int data) {
        pq.add(new Pair(data, currentArrivalTime));
        currentArrivalTime++;
    }
    public int pop() {
        if (pq.size() == 0) return -1;
        Pair pair = pq.remove();
        return pair.data;
    }
}
