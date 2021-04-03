package questions.SearchAndSorting;

public class MajorityElement {
//    Q - https://www.geeksforgeeks.org/majority-element/
//    N/2
    public int solve(int[] arr) {
        int count = 1;
        int element = arr[0];

        for (int i = 1; i < arr.length; i++){
            if (arr[i] == element)
                count++;
            else {
                count--;
                if (count == 0) {
                    count = 1;
                    element = arr[i];
                }
            }
        }

        int check = 0;
        for (int val : arr) {
            if (val == element)
                check++;
        }

        if (check > arr.length / 2)
            return element;
        return -1;
    }
}
