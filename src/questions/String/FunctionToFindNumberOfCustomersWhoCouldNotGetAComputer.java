package questions.String;

import java.util.HashMap;

public class FunctionToFindNumberOfCustomersWhoCouldNotGetAComputer {
//    Q - https://www.geeksforgeeks.org/function-to-find-number-of-customers-who-could-not-get-a-computer/
    public int solve(int n, String seq) {
        HashMap<Character, Boolean> map = new HashMap<>();

        int count = 0;
        for (char customer : seq.toCharArray()) {
            if (map.containsKey(customer) && map.get(customer)) {
                map.remove(customer);
                n++;
            } else if (map.containsKey(customer)) {
                map.remove(customer);
            } else {
                if (n == 0) {
                    count++;
                    map.put(customer, false);
                } else {
                    n--;
                    map.put(customer, true);
                }
            }
        }
        return count;
    }
}
