package questions.String;

public class LongestNonPalindromicSubstring {
    public int solve(String str) {
        int n = str.length();
        boolean isSame = false;
        for (int i = 1; i < n; i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                isSame = true;
            } else {
                isSame = false;
                break;
            }
        }

        if (isSame) return 0;

        if (isPalindrome(str)) return n - 1;
        return n;
    }
    private boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
