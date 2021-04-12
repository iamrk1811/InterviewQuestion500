package questions.String;

public class AnagramSubstringSearch {
//   Q - https://www.geeksforgeeks.org/anagram-substring-search-search-permutations/
    public int solve(String text, String pat) {
        int[] hash = new int[256];

        // Create the frequency hash table for pattern
        for (int i = 0; i < pat.length(); i++) {
            hash[pat.charAt(i)]++;
        }

        int res = 0;

        int left = 0, right = 0, count = pat.length();

        while (right < text.length()) {
            if (hash[text.charAt(right++)]-- >= 1) count--;

            if (count == 0) res++;

            if (right - left == pat.length() && hash[text.charAt(left++)]++ >= 0) count++;
        }
        return res;
    }
}
