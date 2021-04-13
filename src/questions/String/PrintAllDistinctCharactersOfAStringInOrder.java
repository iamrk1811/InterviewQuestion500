package questions.String;

public class PrintAllDistinctCharactersOfAStringInOrder {
//    Q  -https://www.geeksforgeeks.org/print-all-distinct-characters-of-a-string-in-order-3-methods/
    public String solve(String str) {
        int[] countArray = new int[256];

        StringBuilder res = new StringBuilder();

        for (char ch : str.toCharArray()) {
            countArray[ch]++;
        }

        for (int i = 0; i < str.length(); i++) {
            if (countArray[str.charAt(i)] == 1) {
                res.append(str.charAt(i));
            }
        }
        return res.toString();
    }
}
