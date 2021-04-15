package questions.String;

public class NumberOfSubsequencesOfTheFormAiBjCk {
//    Q - https://www.geeksforgeeks.org/number-subsequences-form-ai-bj-ck/
    public int solve(String s)
    {
        long a = 0;
        long ab = 0;
        long abc = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'a') {
                a = (2 * a + 1) % 1000000007;
            } else if (ch == 'b') {
                ab = (2 * ab + a) % 1000000007;
            } else if (ch == 'c') {
                abc = (2 * abc + ab) % 1000000007;
            }
        }
        return (int)(abc % 1000000007);
    }
}
