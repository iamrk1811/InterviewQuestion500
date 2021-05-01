package questions.Backtracking;

import questions.Graph.CreateUndirectedGraphWithWeight;
import questions.Graph.EdgeUndirectedGraphWithWeight;

import java.util.ArrayList;

public class FindIfThereIsAPathOfMoreThanKLengthFromASource {
    //    Q - https://www.geeksforgeeks.org/find-if-there-is-a-path-of-more-than-k-length-from-a-source/
    public boolean solve(ArrayList<EdgeUndirectedGraphWithWeight>[] graph, int source, int k) {
        boolean[] visited = new boolean[graph.length];
        visited[source] = true;
        if (isPossible(graph, source, k, visited)) return true;
        return false;
    }

    private boolean isPossible(ArrayList<EdgeUndirectedGraphWithWeight>[] graph, int source, int k, boolean[] visited) {
        if (k <= 0) return true;

        visited[source] = true;

        for (EdgeUndirectedGraphWithWeight edge : graph[source]) {
            int newNeighbor = edge.neighbor;
            int weight = edge.weight;
            if (visited[newNeighbor]) continue;
            if (weight >= k) return true;
            if (isPossible(graph, newNeighbor, k - weight, visited)) return true;
        }

        visited[source] = false;

        return false;
    }
}
