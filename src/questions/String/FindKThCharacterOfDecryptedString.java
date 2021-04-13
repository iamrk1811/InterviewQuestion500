package questions.String;

public class FindKThCharacterOfDecryptedString {
//    Q - https://www.geeksforgeeks.org/find-kth-character-of-decrypted-string/
//    Q - https://leetcode.com/problems/decoded-string-at-index/submissions/
    public String solve(String s, int k) {
        long currentLength = 0;
//         Calculate the length of produce String
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                currentLength *=  ch - '0';
            } else {
                currentLength++;
            }
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                currentLength /= ch - '0';
                k %= currentLength;
            } else {
                if (k == 0 || k == currentLength) {
                    return "" + ch;
                }
                currentLength--;
            }
        }
        return null;
    }
}
