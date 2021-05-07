package questions.LinkedList;

public class JosephusCircleImplementation {
//    Q - https://www.geeksforgeeks.org/josephus-circle-using-circular-linked-list/
    public int solve(int n, int k) {
        if (n == 1) return 0;
        int x = solve(n - 1, k);
        int y = (x + k) % n;
        return y;
    }
}
