package questions.SearchAndSorting;

public class FindCommonElementsInThreeSortedArrays {
//    Q - https://www.geeksforgeeks.org/find-common-elements-three-sorted-arrays/
    public void solve(int[] arr1, int[] arr2, int[] arr3) {
        int i = 0, j = 0, k = 0;

        while (i < arr1.length && j < arr2.length && k < arr3.length) {
            if (arr1[i] == arr2[j] && arr2[j] == arr3[k])
            {   System.out.println(arr1[i]+" ");   i++; j++; k++; }

            // x < y
            else if (arr1[i] < arr2[j])
                i++;

                // y < z
            else if (arr2[j] < arr3[k])
                j++;

                // We reach here when x > y and z < y, i.e., z is smallest
            else
                k++;

            int prev = arr1[i - 1];
            while (i < arr1.length && prev == arr1[i]) {
                i++;
            }
            prev = arr2[j - 1];
            while (j < arr2.length && prev == arr2[j] ) {
                j++;
            }
            prev = arr3[k - 1];
            while (k < arr3.length && prev == arr3[k]) {
                k++;
            }
        }
    }
}
