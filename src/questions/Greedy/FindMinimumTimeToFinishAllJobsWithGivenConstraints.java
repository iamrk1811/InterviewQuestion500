package questions.Greedy;

public class FindMinimumTimeToFinishAllJobsWithGivenConstraints {
//    Q - https://www.geeksforgeeks.org/find-minimum-time-to-finish-all-jobs-with-given-constraints/
    public int solve(int[] jobs, int k, int t) {
        int totalTime = 0;
        int maxJob = 0;
        for (int val : jobs) {
            maxJob = Math.max(maxJob, val);
            totalTime += val;
        }

        int ans = totalTime;
        int start = 0, end = ans;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (mid >= maxJob && isItPossible(jobs, mid, k)) {
                ans = Math.min(mid, ans);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans * t;
    }
    private boolean isItPossible(int[] jobs, int mid, int k) {
        int countJob = 1;
        int currentTime = 0;

        for (int i = 0; i < jobs.length;) {
            if (currentTime + jobs[i] > mid) {
                currentTime = 0;
                countJob++;
            } else {
                currentTime += jobs[i];
                i++;
            }
        }
        return countJob <= k;
    }


}
