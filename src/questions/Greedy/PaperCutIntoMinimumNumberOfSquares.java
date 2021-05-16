package questions.Greedy;

public class PaperCutIntoMinimumNumberOfSquares {
//    Q - https://www.geeksforgeeks.org/paper-cut-minimum-number-squares/
    public int solve(int a, int b) {
        if (a < b) {
            int t = a;
            a = b;
            b = t;
        }
        int res = 0;

        while (b > 0) {
            int rem = a % b;
            res += a / b;
            a = b;
            b = rem;
        }
        return res;
    }
}
