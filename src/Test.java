import java.util.*;

public class Test {
    public static void giveMeString(String str) {
        String[] strArray = str.split(" ");
        StringBuilder res = new StringBuilder();

        for (String temp : strArray) {
            char firstChar = temp.charAt(0);
            if (firstChar >= 97)
                firstChar -= 32;
            String newString = firstChar + temp.substring(1);

            res.append(newString);
        }

        System.out.println(res);
    }
    public void test() {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while (t-- > 0) {
            int n = scn.nextInt();

            int mod = 2;
            boolean isPrime = true;
            while (mod <= n / 2) {
                if (n % mod == 0) {
                    System.out.println("Not prime");
                    isPrime = false;
                    break;
                }
                mod++;
            }
            if (isPrime)
                System.out.println("Prime");
        }
    }
}
