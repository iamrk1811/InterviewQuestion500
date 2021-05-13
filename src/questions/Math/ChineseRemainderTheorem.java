package questions.Math;

public class ChineseRemainderTheorem {
//    Q - https://www.geeksforgeeks.org/chinese-remainder-theorem-set-1-introduction/
    public int solve(int[] arr, int[] rem) {
        int k = arr.length;
        int x = 1;

        while (true) {
            int j = 0;
            for (; j < k; j++) {
                if (x % arr[j] != rem[j])
                    break;
            }

            if (j == k)
                return x;

            x++;
        }
    }
}
