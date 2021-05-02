package questions.Backtracking;

import java.util.Arrays;

public class CrosswordPuzzle {
//    Q - https://www.hackerrank.com/challenges/crossword-puzzle/problem
    public void solve(char[][] matrix, String[] words) {
        solution(matrix, words, 0);
    }
    private void solution(char[][] matrix, String[] words, int index) {
        if (index == words.length) {
            for (char[] arr : matrix) {
                System.out.println(Arrays.toString(arr));
            }
            return;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '-' || words[index].charAt(0) == matrix[i][j]) {
                    if (canPlaceHorizontally(matrix, words[index], i, j)) {
                        boolean[] placedPosition = placeHorizontally(matrix, words[index], i, j);
                        solution(matrix, words, index + 1);
                        unplaceHorizontally(matrix, words[index], placedPosition, i, j);
                    }
                    if (canPlaceVertically(matrix, words[index], i, j)) {
                        boolean[] placedPosition = placeVertically(matrix, words[index], i, j);
                        solution(matrix, words, index + 1);
                        unplaceVeryically(matrix, words[index], placedPosition, i, j);
                    }
                }
            }
        }
    }
    private boolean[] placeVertically(char[][] matrix, String word, int row, int col) {
        boolean[] arr = new boolean[word.length()];
        for (int i = 0; i < word.length(); i++) {
            if (matrix[row + i][col] == '-') {
                arr[i] = true;
                matrix[row + i][col] = word.charAt(i);
            } else if (matrix[row + i][col] == word.charAt(i)) {
                arr[i] = false;
            }
        }
        return arr;
    }
    private boolean[] placeHorizontally(char[][] matrix, String word, int row, int col) {
        boolean[] arr = new boolean[word.length()];

        for (int i = 0; i < word.length(); i++) {
            if (matrix[row][col + i] == '-') {
                matrix[row][col + i] = word.charAt(i);
                arr[i] = true;
            } else if (matrix[row][col + i] == word.charAt(i)) {
                arr[i] = false;
            }
        }
        return arr;
    }
    private void unplaceHorizontally(char[][] matrix, String word, boolean[] arr, int row, int col) {
        for (int i = 0; i < word.length(); i++) {
            if (arr[i]) {
                matrix[row][col + i] = '-';
            }
        }
    }
    private void unplaceVeryically(char[][] matrix, String word, boolean[] arr, int row, int col) {
        for (int i = 0; i < word.length(); i++) {
            if (arr[i]) {
                matrix[row + i][col] = '-';
            }
        }
    }
    private boolean canPlaceVertically(char[][] matrix, String word, int row, int col) {
        if (row - 1 >= 0 && matrix[row - 1][col] == '-') {
            return false;
        } else if (row + word.length() < matrix.length && matrix[row + word.length()][col] == '-') {
            return false;
        }

        for (int i = 0; i < word.length(); i++) {
            if (row + i >= matrix.length) return false;
            if (matrix[row + i][col] == '-' || matrix[row + i][col] == word.charAt(i)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
    private boolean canPlaceHorizontally(char[][] matrix, String word, int row, int col) {
        if (col - 1 >= 0 && matrix[row][col - 1] == '-') {
            return false;
        } else if (col + word.length() < matrix[0].length && matrix[row][col + word.length()] == '-') {
            return false;
        }

        for (int i = 0; i < word.length(); i++) {
            if (col + i >= matrix[0].length) return false; // out the of matrix
            if (matrix[row][col + i] == word.charAt(i) || matrix[row][col + i] == '-') { // we can move ahead
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
