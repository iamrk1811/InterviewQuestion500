package questions.SearchAndSorting;

import java.util.Arrays;

public class MinimumNumberOfSwapsRequiredToSortAnArray {
//    Q - https://www.geeksforgeeks.org/minimum-number-swaps-required-sort-array/
static class Pair implements Comparable<Pair> {
    int value;
    int index;
    public Pair(int value, int index) {
        this.value = value;
        this.index = index;
    }
    @Override
    public int compareTo(Pair other) {
        if (this.value > other.value) return 1;
        else if (this.value == other.value) return 0;
        else return -1;
    }
}
    public int minSwaps(int nums[])
    {
        Pair[] arr = new Pair[nums.length];
        for (int i = 0; i < arr.length; i++) {
            Pair pair = new Pair(nums[i], i);
            arr[i] = pair;
        }


        Arrays.sort(arr);



        int ans = 0;
        int i = 0;
        while (i < nums.length){
            if (i == arr[i].index)
                i++;
            else {
                swap(arr, i, arr[i].index);
                ans++;
                for (int x = 0; x < arr.length; x++) {
                    System.out.println(arr[x].value + " : " + arr[x].index);
                }
            }
        }

        return ans;
    }
    private void swap(Pair[] arr, int i, int j) {
        Pair current = arr[i];
        arr[i] = arr[j];
        arr[j] = current;
    }
}
