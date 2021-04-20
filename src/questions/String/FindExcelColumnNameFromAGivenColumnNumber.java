package questions.String;

public class FindExcelColumnNameFromAGivenColumnNumber {
//    Q - https://www.geeksforgeeks.org/find-excel-column-name-given-number/
    public String solve(int n){

        String ans = "";

        while (n > 0) {
            int mod = n % 26;

            if (mod == 0) {
                ans = 'Z' + ans;
                n = n / 26 - 1;
            } else {
                ans = (char) ('A' + (mod - 1)) + ans;
                n /= 26;
            }
        }

        return ans;
    }
}
