package questions.SearchAndSorting;

import java.util.Arrays;

public class MergeTwoSortedArraysWithoutExtraSpace {
//    Q - https://www.geeksforgeeks.org/merge-two-sorted-arrays-o1-extra-space/
    public void solve(int[] arr1, int[] arr2) {
        int i, j, gap = arr1.length + arr2.length;

        for (gap = nextGap(gap); gap > 0; gap = nextGap(gap)) {
            for (i = 0; i + gap < arr1.length; i++) {
                if (arr1[i] > arr1[i + gap]) {
                    swap(arr1, arr2, i, i + gap);
                }
            }

            for (j = gap > arr1.length ? gap - arr1.length : 0; i < arr1.length && j < arr2.length; i++, j++) {
                if (arr1[i] > arr1[j]) {
                    swap(arr1, arr2, i, j);
                }
            }

            if (j < arr2.length) {
                for (j = 0; j + gap < arr2.length; j++) {
                    if (arr2[j] > arr2[j + gap]) {
                        swap(arr2, arr2, j, j + gap);
                    }
                }
            }
        }
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
    private int nextGap(int gap) {
        if (gap <= 1)
            return 0;
        return gap / 2 + gap % 2;
    }
    private void swap(int[] arr1, int[] arr2, int i, int j) {
        int temp = arr1[i];
        arr1[i] = arr2[j];
        arr2[j] = temp;
    }
}
