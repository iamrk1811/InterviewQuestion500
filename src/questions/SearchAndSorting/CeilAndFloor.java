package questions.SearchAndSorting;

public class CeilAndFloor {
//    Q - https://www.geeksforgeeks.org/ceiling-in-a-sorted-array/
    public void ceil(int[] arr, int x) {
        int low = 0, high = arr.length - 1;

        int floor = -1, ceil = -1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == x) {
                System.out.println(arr[mid]);
                return;
            } else if (arr[mid] < x) {
                floor = arr[mid];
                low = mid + 1;
            } else {
                ceil = arr[mid];
                high = mid - 1;
            }
        }
        System.out.println(ceil);
        System.out.println(floor);
    }

}
