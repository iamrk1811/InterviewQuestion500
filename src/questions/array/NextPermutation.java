package questions.array;

public class NextPermutation {
    public int[] solve(int[] nums) {
        int smallIndex = -1;
        for (int i = nums.length - 1; i >= 1; i--) {
            if (nums[i] > nums[i - 1]) {
                smallIndex = i - 1;
                break;
            }
        }

//         The arrangement is not possible
        if (smallIndex == -1) {
            int i = 0 , j = nums.length - 1;
            while(i < j) {
                swap(nums, nums, i, j);
                i++;
                j--;
            }

            return nums;
        }

        int nextLargeIndex = nums.length - 1;
        for (int i = nums.length - 1; i > smallIndex; i--) {
            if (nums[i] > nums[smallIndex]) {
                nextLargeIndex = i;
                break;
            }
        }

        swap(nums, nums, smallIndex, nextLargeIndex);


//         Only two element left no need to sort in decending
        if (nums.length - smallIndex == 2) return nums;

//         reverse the rest of the array
        for (int i = smallIndex + 1, j = nums.length - 1; i < j; i++, j--) {
            swap(nums, nums, i, j);
        }
        return nums;
    }
    private void swap(int[] a, int[] b, int i, int j) {

        int temp = a[i];
        a[i] = b[j];
        b[j] = temp;
    }
}
