package questions.Greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class GreedyAlgorithmToFindMinimumNumberOfCoins {
    //    Q - https://www.geeksforgeeks.org/greedy-algorithm-to-find-minimum-number-of-coins/
    int[] notes = {1, 2, 5, 10, 20, 50, 100, 500, 1000};

    public ArrayList<Integer> solve(int V) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = notes.length - 1; i >= 0; i--) {
            while (V >= notes[i]) {
                V -= notes[i];
                res.add(notes[i]);
            }
        }
        return res;
    }
}
