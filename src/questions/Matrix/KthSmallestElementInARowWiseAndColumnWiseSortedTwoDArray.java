package questions.Matrix;

import java.util.PriorityQueue;

public class KthSmallestElementInARowWiseAndColumnWiseSortedTwoDArray {
    //    Q - https://www.geeksforgeeks.org/kth-smallest-element-in-a-row-wise-and-column-wise-sorted-2d-array-set-1/
    static class Node implements Comparable<Node> {
        int row;
        int col;
        int value;

        Node(int value, int row, int col) {
            this.row = row;
            this.col = col;
            this.value = value;
        }

        @Override
        public int compareTo(Node other) {
            return this.value - other.value;
        }
    }

    public int solve(int[][] mat, int k) {
        int n = mat.length;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(new Node(mat[0][i], 0, i));
        }
        for (int i = 1; i <= k - 1; i++) {
            Node current = pq.remove();

            int row = current.row;
            int col = current.col;
            int nextValue = row + 1 < n ? mat[row + 1][col] : Integer.MAX_VALUE;

            pq.add(new Node(nextValue, row + 1, col));
        }

        return pq.peek().value;
    }

}
