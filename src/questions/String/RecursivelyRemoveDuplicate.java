package questions.String;

public class RecursivelyRemoveDuplicate {
    public String solve(String s) {
        return removeDuplicate(s, '\0');
    }
    String removeDuplicate(String s, char lastRemoved) {
//        base case
        if (s.length() == 0 || s.length() == 1)
            return s;

        if (s.charAt(0) == s.charAt(1)) {
            lastRemoved = s.charAt(0);

            while (s.length() > 1 && s.charAt(0) == s.charAt(1)) {
                s = s.substring(1, s.length());
            }

            s = s.substring(1, s.length());
            return removeDuplicate(s, lastRemoved);
        }

        String remainingString = removeDuplicate(s.substring(1, s.length()), lastRemoved);

        if (remainingString.length() > 0 && remainingString.charAt(0) == s.charAt(0)) {
            lastRemoved = remainingString.charAt(0);
            return remainingString.substring(1, remainingString.length());
        }

        if (remainingString.length() == 0 && lastRemoved == s.charAt(0)) {
            return remainingString;
        }

        return s.charAt(0) + remainingString;
    }
}
