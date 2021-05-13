package questions.Greedy;

import java.util.Arrays;
import java.util.Comparator;

class Item {
    int value;
    int weight;

    public Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}

class ItemComparator implements Comparator<Item> {
    @Override
    public int compare(Item a, Item b) {
        double i1 = (double) a.value / (double) a.weight;
        double i2 = (double) b.value / (double) b.weight;
        if (i1 < i2) {
            return 1;
        } else if (i1 > i2) {
            return -1;
        } else {
            return 0;
        }
    }
}

public class FractionalKnapsack {
    //    Q - https://www.geeksforgeeks.org/fractional-knapsack-problem/
    double fractionalKnapsack(int W, Item arr[], int n) {
        Arrays.sort(arr, new ItemComparator());
        double ans = 0;
        int currentWeight = 0;
        for (int i = 0; i < n; i++) {
            if (currentWeight + arr[i].weight <= W) {
                currentWeight += arr[i].weight;
                ans += arr[i].value;
            } else {
                int remaining = W - currentWeight;
                ans += ((double) arr[i].value / (double) arr[i].weight) * (double) remaining;
                break;
            }
        }
        return ans;
    }
}
