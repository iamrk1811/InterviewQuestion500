package questions.Math;

public class FermatsLastTheorem {
//    Q - https://www.geeksforgeeks.org/fermats-last-theorem/
    public boolean solve(int limit, int n) {
        if (n < 3) return false;

        for (int a = 1; a <= limit; a++) {
            for (int b = a; b <= limit; b++) {
                int a2b2 = (int) (Math.pow(a, n) + Math.pow(b, n));

                int c = (int) (Math.pow(a2b2, 1.0 / n));

                if (a2b2 == Math.pow(c, n)) {
                    return true;
                }
            }
        }
        return false;
    }
}
