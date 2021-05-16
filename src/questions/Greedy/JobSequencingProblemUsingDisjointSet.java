package questions.Greedy;

import questions.UnionFInd.DisjointUnionSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class DisjointSet {
    int[] parent;
    int size;
    public DisjointSet(int n) {
        this.size = n;
        this.parent = new int[n + 1];
        makeSet();
    }
    void makeSet() {
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }
    public int find(int i) {
        if (parent[i] == i) return i;
        return parent[i] = find(parent[i]);
    }
    public void merge(int a, int b) {
        parent[b] = a;
    }
}

public class JobSequencingProblemUsingDisjointSet {
    static class Job implements Comparable<Job>{
        int id;
        int deadline;
        int profit;

        public Job(int id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }

        @Override
        public int compareTo(Job o) {
            if (this.profit > o.profit)  {
                return -1;
            } else if (this.profit < o.profit) {
                return 1;
            } else return 0;
        }
    }

    public void solve(ArrayList<Job> arr) {
//        Arrays.sort(arr);
        Collections.sort(arr);

        int maxDeadline = 0;

        for (Job job : arr) {
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }

        DisjointSet set = new DisjointSet(maxDeadline);

        for (Job job : arr) {
            int freeSlot = set.find(job.deadline);

            if (freeSlot > 0) {
                set.merge(set.find(freeSlot - 1), freeSlot);
                System.out.println((char) job.id);
            }
        }
    }
    public void test() {
        ArrayList<Job> arr=new ArrayList<Job>();
        arr.add(new Job('a',2,100));
        arr.add(new Job('b',1,19));
        arr.add(new Job('c',2,27));
        arr.add(new Job('d',1,25));
        arr.add(new Job('e',3,15));

        solve(arr);
    }
}
