package questions.Greedy;

import java.util.Arrays;

public class JobSequencingProblem {
//    Q - https://www.geeksforgeeks.org/job-sequencing-problem/
    static class Job {
        public int id;
        public int deadline;
        public int profit;
        public Job(int id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }
    public int[] solve(Job[] arr) {
        Arrays.sort(arr, (a, b) -> (b.profit - a.profit));

        int maxdeadline = 0;
        for (int i = 0; i < arr.length; i++) maxdeadline = Math.max(maxdeadline, arr[i].deadline);

        int[] sequenceArr = new int[maxdeadline + 1];


        int countJob = 0, totalProfit = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = arr[0].deadline; j >= 1; j--) {
                if (sequenceArr[j] == -1) {
                    sequenceArr[j] = i;
                    countJob++;
                    totalProfit += arr[i].profit;
                    break;
                }
            }
        }

        int[] res = new int[2];
        res[0] = countJob;
        res[1] = totalProfit;
        return res;
    }
}
