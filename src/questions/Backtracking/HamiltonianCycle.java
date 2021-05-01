package questions.Backtracking;

import questions.Graph.EdgeUndirectedGraphWithWeight;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;

public class HamiltonianCycle {
//    Q - https://www.geeksforgeeks.org/hamiltonian-cycle-backtracking-6/
    public void solve(ArrayList<EdgeUndirectedGraphWithWeight>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            hamiltonianPath(graph, i, new HashSet<Integer>(), i, i + "->");
        }
    }
    private void hamiltonianPath(ArrayList<EdgeUndirectedGraphWithWeight>[] graph, int source, HashSet<Integer> visited, int oldSource, String path) {
        if (visited.size() ==  graph.length- 1) {
            for (EdgeUndirectedGraphWithWeight edge : graph[source]) {
                if (edge.neighbor == oldSource) {
                    System.out.println(path);
                    break;
                }
            }
            return;
        }
        visited.add(source);
        for (EdgeUndirectedGraphWithWeight edge : graph[source]) {
            if (!visited.contains(edge.neighbor)) {
                hamiltonianPath(graph, edge.neighbor, visited, oldSource, path + edge.neighbor + "->");
            }
        }
        visited.remove(source);
    }
}
