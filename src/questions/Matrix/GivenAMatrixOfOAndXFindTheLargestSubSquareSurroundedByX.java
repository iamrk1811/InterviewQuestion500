package questions.Matrix;

import java.util.Arrays;

public class GivenAMatrixOfOAndXFindTheLargestSubSquareSurroundedByX {
    //    Q - https://www.geeksforgeeks.org/given-matrix-o-x-find-largest-subsquare-surrounded-x/
    public int solve(char[][] arr) {
        int[][] horizontal = new int[arr.length][arr[0].length];
        int[][] vertical = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (j == 0) {
                    if (arr[i][j] == 'O') {
                        horizontal[i][j] = 0;
                    } else {
                        horizontal[i][j] = 1;
                    }
                } else {
                    if (arr[i][j] == 'O') {
                        horizontal[i][j] = 0;
                    } else {
                        horizontal[i][j] = horizontal[i][j - 1] + 1;
                    }
                }
            }
        }
        for (int j = 0; j < arr[0].length; j++) {
            for (int i = 0; i < arr.length; i++) {
                if (i == 0) {
                    if (arr[i][j] == 'O') {
                        vertical[i][j] = 0;
                    } else {
                        vertical[i][j] = 1;
                    }
                } else {
                    if (arr[i][j] == 'O') {
                        vertical[i][j] = 0;
                    } else {
                        vertical[i][j] = vertical[i - 1][j] + 1;
                    }
                }
            }
        }
        int max = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = arr.length - 1; j >= 0; j--) {
                int small = Math.min(horizontal[i][j], vertical[i][j]);
                while (small > max) {
                    if (vertical[i][j - small + 1] >= small
                            && horizontal[i - small + 1][j] >= small) {
                        max = small;
                    }
                    small--;
                }
            }
        }
        return max;
    }
}
