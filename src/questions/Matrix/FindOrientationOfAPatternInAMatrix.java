package questions.Matrix;

public class FindOrientationOfAPatternInAMatrix {
//    Q - https://www.geeksforgeeks.org/find-orientation-of-a-pattern-in-a-matrix/
    public String solve(char[][] matrix, char[] pattern) {
        StringBuilder res = new StringBuilder();
        String pat = new String(pattern);

        int N = matrix.length;


        for (int i = 0; i < N; i++) {
//            check for horizontal
            if (kmp(new String(matrix[i]), pat)) return "HORIZONTAL";

            StringBuilder vertical = new StringBuilder();
            for (int j = 0; j < N; j++) {
                vertical.append(matrix[j][i]);
            }

            if (kmp(vertical.toString(), pat)) return "VERTICAL";
        }
        return "NOT FOUND";
    }
    private boolean kmp(String text, String pattern) {
        String str = pattern + '#' + text;
        int[] lps = new int[str.length()];
        computeLps(str, lps);
        for (int val : lps) {
            if (val == pattern.length()) {
                return true;
            }
        }
        return false;
    }
    private void computeLps(String str, int[] lps) {
        int i = 1, len = 0;
        while (i < str.length()) {
            if (str.charAt(i) == str.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len > 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }
}
