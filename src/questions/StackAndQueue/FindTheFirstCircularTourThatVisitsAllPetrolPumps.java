package questions.StackAndQueue;

public class FindTheFirstCircularTourThatVisitsAllPetrolPumps {
    //    Q - https://www.geeksforgeeks.org/find-a-tour-that-visits-all-stations/
    public int solve(int[] petrol, int[] distance) {
        int n = petrol.length;
        int tank = 0;
        for (int i = 0; i < n; i++)
            tank += petrol[i] - distance[i];

        if (tank < 0) return -1;

        int start = 0;
        int remain = 0;

        for (int i = 0; i < n; i++) {
            int current = petrol[i] - distance[i];

            if (current + remain < 0) {
                start = i + 1;
                remain = 0;
            } else {
                remain += current;
            }
        }
        return start;
    }
}
