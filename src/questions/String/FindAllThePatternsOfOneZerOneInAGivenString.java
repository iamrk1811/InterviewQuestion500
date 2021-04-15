package questions.String;

public class FindAllThePatternsOfOneZerOneInAGivenString {
//    Q - https://www.geeksforgeeks.org/find-patterns-101-given-string/
    public int solve(String s) {
        char last = s.charAt(0);
        int i = 1, count = 0;

        while (i < s.length()) {
            if (s.charAt(i) == '0'  && last == '1') {
                while (s.charAt(i) == '0') i++;

                if (s.charAt(i) == '1') count++;
            }
            last = s.charAt(i);
            i++;
        }
        return count;
    }
    public int solve2(String s) {
        boolean one = false, zero = false;

        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                if (one && zero)
                    count++;
                else
                    one = true;
            } else if (s.charAt(i) == '0') {
                if (one)
                    zero = true;
            } else {
                one = false;
                zero = false;
            }
        }
        return count;
    }
}
