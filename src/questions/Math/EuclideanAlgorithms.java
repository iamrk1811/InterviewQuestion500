package questions.Math;

public class EuclideanAlgorithms {
//    Q - https://www.geeksforgeeks.org/euclidean-algorithms-basic-and-extended/
    public int basic(int a, int b) {
        if (b == 0) {
            return a;
        }
        return basic(b, a % b);
    }

    public int extended(int a, int b, int x, int y) {
        if (b == 0) {
            x = 1;
            y = 0;
            return a;
        }

        int x1 = 1, y1 = 1;
        int gcd = extended(b, a % b, x1, y1);

        x = y1;
        y = x1 - y1 * (a / b);

        return gcd;
    }
}
