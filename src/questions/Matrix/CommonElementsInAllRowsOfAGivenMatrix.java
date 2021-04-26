package questions.Matrix;

import javax.swing.plaf.IconUIResource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CommonElementsInAllRowsOfAGivenMatrix {
    //    Q - https://www.geeksforgeeks.org/common-elements-in-all-rows-of-a-given-matrix/
    static class Pair {
        int count = 0;
        int rowIndex = -1;
        Pair(int count, int rowIndex) {
            this.count = count;
            this.rowIndex = rowIndex;
        }
    }

    public ArrayList<Integer> solve(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Integer, Pair> map = new HashMap<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (map.containsKey(matrix[i][j])) {
                    Pair pair = map.get(matrix[i][j]);
                    if (pair.rowIndex != i) {
                        pair.count++;
                        pair.rowIndex = i;
                        map.put(matrix[i][j], pair);
                    }
                } else {
                    map.put(matrix[i][j], new Pair(1, i));
                }
            }
        }
        for (int key : map.keySet()) {
            if (map.get(key).count >= matrix.length)
                res.add(key);
        }
        return res;
    }
}
