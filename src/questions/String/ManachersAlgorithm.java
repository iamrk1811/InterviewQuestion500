package questions.String;

public class ManachersAlgorithm {
    public int solve(String str) {
        // modify the string to make LPS array
        StringBuilder lpsString = new StringBuilder();

        lpsString.append("@"); // starting point

        for (char ch : str.toCharArray()) {
            lpsString.append("#");
            lpsString.append(ch);
        }

        lpsString.append("#$"); // end point

        int res = manachers(lpsString.toString());
        return res;
    }
    private int manachers(String str) {
        int[] lps = new int[str.length()];
        int c = 0, r = 0;

        for (int i = 1; i < str.length() - 1; i++) {

            // calculate mirror
            int mirror = c - (i - c);

            // this is kick start
            if (i < r) {
                lps[i] = Math.min(lps[mirror], r - i);
            }
            // try to expand
            while (str.charAt(i + 1 + lps[i]) == str.charAt(i - 1 - lps[i])) {
                lps[i]++;
            }

            // update the values
            if (i + lps[i] > r) {
                c = i;
                r = i + lps[i];
            }
        }
        int max = 0;
        for (int val : lps) {
            max = Math.max(max, val);
        }
        return max;
    }
}
