package questions.Math;

public class EulerTotient {
//    Q - https://www.geeksforgeeks.org/eulers-totient-function/
    public int euler(int n) {
        int result = 1;
        for (int i = 2; i < n; i++) if (gcd(i, n) ==  1) result++;
        return result;
    }
    int gcd(int a, int b) {if (b == 0) return a; return gcd(b, a % b);}
}
