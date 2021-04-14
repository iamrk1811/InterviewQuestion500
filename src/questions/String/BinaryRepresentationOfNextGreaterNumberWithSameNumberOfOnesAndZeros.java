package questions.String;

public class BinaryRepresentationOfNextGreaterNumberWithSameNumberOfOnesAndZeros {
//    Q - https://www.geeksforgeeks.org/binary-representation-next-greater-number-number-1s-0s/
    public String solve(String str) {
        int deep = -1;
        for (int i = str.length() - 1; i >= 1; i--) {
            if (Integer.parseInt(str.charAt(i) + "") > Integer.parseInt(str.charAt(i - 1) + "")) {
                deep = i - 1;
                break;
            }
        }

        if (deep == -1) return str;

        int justGreater = -1;
        for (int i = deep; i < str.length(); i++) {
            if ((Integer.parseInt(str.charAt(i) + "") > Integer.parseInt(str.charAt(deep) +""))) {
                justGreater = i;
                break;
            }
        }

//        swap values
        char[] chars = str.toCharArray();
        char temp = chars[deep];
        chars[deep] = chars[justGreater];
        chars[justGreater] = temp;

//        Reverse
        int left = justGreater + 1, right = str.length() - 1;
        while (left <= right) {
            char ch = chars[left];
            chars[left] = chars[right];
            chars[right] = ch;
            left++;
            right--;
        }

        return new String(chars);
    }
}
