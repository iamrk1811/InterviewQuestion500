package questions.String;

public class MinFlipsOfContinuousCharactersToMakeAllCharactersSameInAString {
//    Q - https://www.geeksforgeeks.org/min-flips-of-continuous-characters-to-make-all-characters-same-in-a-string/
    public int solve(String str) {
        int res = 0;
        char last = ' ';
        for (int i = 0; i < str.length(); i++) {
            if (last != str.charAt(i))
                res++;
            last = str.charAt(i);
        }
        return res / 2;
    }
}
