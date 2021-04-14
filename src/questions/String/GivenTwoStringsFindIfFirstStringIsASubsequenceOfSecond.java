package questions.String;

public class GivenTwoStringsFindIfFirstStringIsASubsequenceOfSecond {
//    Q - https://www.geeksforgeeks.org/given-two-strings-find-first-string-subsequence-second/
    public boolean solve(String a, String b) {
        int j = 0;
        for (int i = 0; i < b.length() && j < a.length(); i++) {
            if (a.charAt(j) == b.charAt(i))
                j++;
        }
        return j == a.length();
    }
}
