package questions.Greedy;

public class GreedyAlgorithmForEgyptianFraction {
    //    Q - https://www.geeksforgeeks.org/greedy-algorithm-egyptian-fraction/
    public void solution(int nr, int dr) {
        if (nr == 0 || dr == 0) return;
        if (dr % nr == 0) {
            System.out.print("1/" + dr / nr);
            return;
        }
        if (nr % dr == 0) {
            System.out.print(nr / dr);
            return;
        }

        if (nr > dr) {
            System.out.print(nr / dr + "+");
            solution(nr % dr, dr);
            return;
        }
        int n = dr / nr + 1;
        System.out.print("1/" + n + "+");
        solution(nr * n - dr, dr * n);
    }
}
