package questions.String;

public class CountOfWordsWhoseIthLetterIsEitherIMinusOneIthOrIPlusOne {
//    Q - https://www.geeksforgeeks.org/count-words-whose-th-letter-either-1-th-th-i1-th-letter-given-word/
    public int solve(String str) {
        int count = 1;
        int n = str.length();
        if (n == 1) return count;

//        for first character
        if (str.charAt(0) == str.charAt(1))
            count *= 1;
        else
            count *= 2;


        for (int i = 1; i < n - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1) && str.charAt(i) == str.charAt(i - 1)) {
                count *= 1;
            } else if (str.charAt(i) == str.charAt(i + 1) || str.charAt(i) == str.charAt(i - 1) || str.charAt(i - 1) == str.charAt(i + 1)) {
                count *= 2;
            } else {
                count *= 3;
            }
        }

//        for the last character
        if (str.charAt(n - 1) == str.charAt(n - 2))
            count *= 1;
        else
            count *= 2;


        return count;
    }
}
